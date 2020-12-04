public class Upgrade{
    String level, currency, amt;

    Upgrade(String Level, String Currency, String Amt){
        level = Level;
        currency = Currency;
        amt = Amt;
    }

    public String getLevel(){
        return level;
    }

    public String getCurrency(){
        return currency;
    }

    public String getAmt(){
        return amt;
    }

}