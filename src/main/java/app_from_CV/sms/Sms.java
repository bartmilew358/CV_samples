package app_from_CV.sms;

public class Sms {

    public static void main(String[] args) {

        String sms_in_raw = "Dzisiaj jest sobota, imieniny kota.";
        String sms_in = sms_in_raw.trim();

        String tabString[] = sms_in.split(" ");
        String temp = null;
        
        for (int i = 0; i < tabString.length; i++) {
            temp += tabString[i];
        }

        int lenghtCounter = 0;

        for (int i = 0; i < tabString.length; i++) {

            tabString[i] = tabString[i].substring(0,1).toUpperCase() + tabString[i].substring(1).toLowerCase();
            System.out.print(tabString[i]);
            lenghtCounter = lenghtCounter + tabString[i].length();

        }
        System.out.println();
        System.out.println("Długość sms = " + lenghtCounter);

        int numerOfSms = (lenghtCounter / 160) + 1;
        System.out.println("Liczba wysłąnych smsów: " + numerOfSms);
    }
}
