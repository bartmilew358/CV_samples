package app_from_CV.quiz;

import java.util.ArrayList;

public class ZadaniaQuizowe {
    String pytanie;
    ArrayList<String> odpowiedzi;

    public ZadaniaQuizowe(String pytanie, ArrayList<String> odpowiedzi) {
        this.pytanie = pytanie;
        this.odpowiedzi = odpowiedzi;
    }

    public String getPytanie() {
        return pytanie;
    }

    public ArrayList<String> getOdpowiedzi() {
        return odpowiedzi;
    }

    @Override
    public String toString() {
        return "ZadaniaQuizowe{" +
                "pytanie='" + pytanie + '\'' +
                ", odpowiedzi=" + odpowiedzi +
                '}';
    }
}
