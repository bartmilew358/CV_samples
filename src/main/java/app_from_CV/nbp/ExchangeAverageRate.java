package app_from_CV.nbp;

public class ExchangeAverageRate {
    String table;
    String currency;
    String code;
    AverageRate[] rates;

    public ExchangeAverageRate(String table, String currency, String code, AverageRate[] rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public AverageRate[] getRates() {
        return rates;
    }
}
