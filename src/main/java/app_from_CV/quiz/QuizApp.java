package app_from_CV.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizApp {

    public static void main(String[] args) throws FileNotFoundException {

        File folder = new File("src\\main\\resources\\");
        File[] files = folder.listFiles();

        ArrayList<String> listaKategorii = new ArrayList<>();

        for (File file : files) {
            listaKategorii.add(file.getName().substring(0, file.getName().length()-4));
        }

        System.out.println("Lista kategorii: ");
        for (int i = 0; i < listaKategorii.size(); i++) {
            System.out.println((i + 1) + ". " + listaKategorii.get(i));
        }

        System.out.println("Wybierz kategorie: ");
        Scanner numerKategorii = new Scanner(System.in);
        Integer nazwa_pliku = numerKategorii.nextInt();

        File file = new File("src\\main\\resources\\" + listaKategorii.get(nazwa_pliku-1) + ".txt");

        Scanner scanner = new Scanner(file);

        ArrayList<ZadaniaQuizowe> zadaniaQuizowe = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String pytanie = scanner.nextLine();
            String ilosc_odpowiedz = scanner.nextLine();
            int iloscOdpowidziInt = Integer.parseInt(ilosc_odpowiedz);
            ArrayList<String> odpowiedzi = new ArrayList<>();

            for(int i = 0; i < iloscOdpowidziInt; i++) {

                String odpowiedz = scanner.nextLine();
                odpowiedzi.add(odpowiedz);
            }
            ZadaniaQuizowe zad = new ZadaniaQuizowe(pytanie, odpowiedzi);
            zadaniaQuizowe.add(zad);
        }

        System.out.println("Wybrałeś kategorię " + listaKategorii.get(nazwa_pliku-1));

//        System.out.println("Lista pytań i odpowiedzi: ");
//        System.out.println(zadaniaQuizowe.toString());

        System.out.println("Ilośc pytań w kategorii: " + zadaniaQuizowe.size());
        System.out.println("Pytanie: ");
        Collections.shuffle(zadaniaQuizowe);

        System.out.println("Teraz odpowiesz na 10 pytań: ");

        int wynik = 0;

        for (int i = 0; i < 10; i++) {

            ArrayList<String> odpowiedziDoMieszania = new ArrayList<>();

            System.out.println(zadaniaQuizowe.get(i).getPytanie());

            String poprawnaOdpowiedz = zadaniaQuizowe.get(i).getOdpowiedzi().get(0);

            odpowiedziDoMieszania.addAll(zadaniaQuizowe.get(i).getOdpowiedzi());

            Collections.shuffle(odpowiedziDoMieszania);
            for (int z = 0; z < odpowiedziDoMieszania.size(); z++){
                System.out.println("     " + (z + 1) + ". " + odpowiedziDoMieszania.get(z));
            }

            Scanner twojaOdpowiedz = new Scanner(System.in);
            Integer twojaodpowiedz_int = twojaOdpowiedz.nextInt();

            if (poprawnaOdpowiedz.equals(odpowiedziDoMieszania.get(twojaodpowiedz_int - 1))){
                wynik++;
                System.out.println("Twoja odpowiedź jest poprawna. Aktualnie masz " + wynik + "pkt.");
            } else {
                System.out.println("Twoja odpowiedź jest błędna. Poprawna odpowiedź to: " + poprawnaOdpowiedz);
            }
            System.out.println("==================================================================================");
        }

        System.out.println("Utrzeliłeś " + wynik + " / 10 pkt.");
//        System.out.println(zadaniaQuizowe.toString());
    }
}
