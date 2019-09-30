package app_from_CV.nbp;

public class ExchangeSellAndBuyRate {

    String table;
    String currency;
    String code;
    Rate[] rates;

    public ExchangeSellAndBuyRate(String table, String currency, String code, Rate[] rates) {
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

    public Rate[] getRates() {
        return rates;
    }
}
