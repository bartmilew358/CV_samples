package app_from_CV.nbp;


public class AverageRate {
    String no;
    String effectiveDate;
    double mid;

    public AverageRate(String no, String effectiveDate, double mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public double getMid() {
        return mid;
    }

}
