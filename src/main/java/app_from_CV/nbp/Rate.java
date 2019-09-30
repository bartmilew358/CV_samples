package app_from_CV.nbp;

public class Rate {
    String no;
    String effectiveDate;
    double bid;
    double ask;

    public Rate(String no, String effectiveDate, double bid, double ask) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.bid = bid;
        this.ask = ask;
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }
}
