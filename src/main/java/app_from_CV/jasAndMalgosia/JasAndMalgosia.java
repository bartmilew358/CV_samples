package app_from_CV.jasAndMalgosia;

import java.util.concurrent.CountDownLatch;

public class JasAndMalgosia {

    public static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        Thread jas;
        jas = new Thread(() -> {
            try {
                System.out.println("Jaś robi śniadanie.");
                Thread.sleep(5000);
                System.out.println("Jaś zjadł i klasycznie zostawił talerz na stole.");
                System.out.println("Jaś walczy z prysznicem.");
                Thread.sleep(3000);
                System.out.println("Jaś skończył się myć.");
                System.out.println("Jaś się ubiera na paradę równości.");
                Thread.sleep(1000);
                System.out.println("Jaś się ubrał ale jednak pomylił daty. Parady dziś nie ma wiec wychodzi tak ubrany do pracy.");
                System.out.println("Jaś idzie po zakupy do sklepu ze zdrową żywnością.");
                Thread.sleep(15000);
                System.out.println("Jaś wrócił z zakupów.");
                System.out.println("Jaś gra na konsoli w symulator tindera.");
                Thread.sleep(5000);
                System.out.println("Jaś wygrał i skończył.");
                JasAndMalgosia.countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        );

        Thread malgosia;
        malgosia = new Thread(() -> {
            try {
                System.out.println("Małgosia idzie biegać rano jak każdy.");
                Thread.sleep(6000);
                System.out.println("Małgosia skończyła biegać i udostępniła wynik na endomondo.");
                System.out.println("Małgosia się podmywa");
                Thread.sleep(2000);
                System.out.println("Małgosia się ogarneła.");
                System.out.println("Małgosia robi iphhonem zdjęcie śniadania.");
                Thread.sleep(1000);
                System.out.println("Małgosia już wybrała filtry i skończyła śniadanie.");
                System.out.println("Małgosia ora wsyzstkich domowników problemem, że nie ma co ubrać.");
                Thread.sleep(1000);
                System.out.println("Małgosia się ubrała.");
                System.out.println("Gosia spotyka się z koleżanką (dziwe).");
                Thread.sleep(25000);
                System.out.println("Gosia wróciła i robi afere na chacie o nieumyty talerz.");
                JasAndMalgosia.countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        );

        jas.start();
        malgosia.start();

//        jas.join();
//        malgosia.join();

        // jak się skońńczy coundawn u Jasia to odejmie 1 i potem jak się skończy countdawn u Małgosi to też odejmie 1 i ak bedzie zero to await i wyjazd.
        countDownLatch.await();
        System.out.println("KONIEC DNIA. ELO SZLAUFY.");
    }
}