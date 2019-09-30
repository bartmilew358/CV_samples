package app_from_CV.nbp;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;

public class NbpApp {

    public static void main(String[] args) throws IOException {

        //Zadanie domowe
        getExchangeAverageRateOfCurrencyAndShowValueOfZloty("USD", 100);
        getExchangeAverageRateOfCurrencyAndShowValueOfZloty("EUR", 100);
        getExchangeAverageRateOfCurrencyAndShowValueOfZloty("GBP", 100);
        getExchangeAverageRateOfCurrencyAndShowValueOfZloty("CHF", 100);

        //Zadanie domowe dodatkowe
        howMuchWeEarnInOneMonthOnCourseOfCurrencyWhenWeInvestValueInPLN("USD", 100);
        howMuchWeEarnInOneMonthOnCourseOfCurrencyWhenWeInvestValueInPLN("EUR", 100);
        howMuchWeEarnInOneMonthOnCourseOfCurrencyWhenWeInvestValueInPLN("GBP", 100);
        howMuchWeEarnInOneMonthOnCourseOfCurrencyWhenWeInvestValueInPLN("CHF", 100);
            }

    public static void getExchangeAverageRateOfCurrencyAndShowValueOfZloty(String currency, double valuePLN) throws IOException {

        StringBuilder sb = getJson(currency, "a", String.valueOf(LocalDate.now()));
        Gson gson = new Gson();
        ExchangeAverageRate exchangeAverageRate = gson.fromJson(sb.toString(), ExchangeAverageRate.class);

        System.out.println("Notowania walut z dnia: " + LocalDate.now());
        System.out.println();
        System.out.println(currency + " = " + exchangeAverageRate.getRates()[0].getMid() + " zł ");
        System.out.println(valuePLN + " zł jest warte " + round(valuePLN / exchangeAverageRate.getRates()[0].getMid()) + " " + currency);
        System.out.println();
    }

    private static StringBuilder getJson(String currency, String tableFromNbp, String date) throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/" + tableFromNbp + "/" + currency +"/" + date + "/?format=json");
        return getStringBuilder(url);
    }

    private static double getCurrencyAskValue(String currency, String tableFromNbp, String date) throws IOException {

        StringBuilder sb = getJson(currency, "c", date);
        Gson gson = new Gson();
        ExchangeSellAndBuyRate exchangeSellAndBuyRate = gson.fromJson(sb.toString(), ExchangeSellAndBuyRate.class);
        return exchangeSellAndBuyRate.getRates()[0].getAsk();
    }

    private static void howMuchWeEarnInOneMonthOnCourseOfCurrencyWhenWeInvestValueInPLN(String currency, double valuePLN) throws IOException {

        double differenceBetweenCoursesOfCurrency =
        getCurrencyAskValue(currency, "c", String.valueOf(LocalDate.now().
                minusDays(valueOfCorrectDateToGetCurrencyValueFrom30DaysAgo())))
                - getCurrencyAskValue(currency, "c", String.valueOf(LocalDate.now()));

        System.out.println("Przy zakupie miesiąc temu " + currency + " za " + valuePLN + " zł, zysk wynosi "
                + round(differenceBetweenCoursesOfCurrency * valuePLN) + " zł");
    }

    private static StringBuilder getStringBuilder(URL url) throws IOException {
        final URLConnection urlConnection = url.openConnection();
        final BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()));
        String inputLine;
        StringBuilder sb = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }
        in.close();
        return sb;
    }

    public static int valueOfCorrectDateToGetCurrencyValueFrom30DaysAgo(){
        int valueOfCorrectDate;

        if (LocalDate.now().minusMonths(1).getDayOfWeek().getValue() == 6){
            valueOfCorrectDate = LocalDate.now().minusMonths(1).minusDays(1).getDayOfWeek().getValue();
        } else {
            if (LocalDate.now().minusMonths(1).getDayOfWeek().getValue() == 7){
                valueOfCorrectDate = LocalDate.now().minusMonths(1).minusDays(2).getDayOfWeek().getValue();
            } else {
                valueOfCorrectDate = LocalDate.now().minusMonths(1).getDayOfWeek().getValue();
            }
        }
        return valueOfCorrectDate;
    }

    public static double round (double value){
        value *= 10000;
        value = Math.round(value);
        value /= 10000;
        return value;
    }
}
