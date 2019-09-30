package app_from_CV.primeNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class primeNumbers  {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        long start = System.currentTimeMillis();

        File file = new File("src\\main\\resources\\numbers.txt");
        Scanner scanner = new Scanner(file);

        ArrayList<Long> list = new ArrayList<>();
        while (scanner.hasNextLong()) {
            long numberToCheckIsPrime = scanner.nextLong();
            list.add(numberToCheckIsPrime);
        }

        final AtomicInteger count = new AtomicInteger(0);
        for (int i = 0; i < list.size(); i++) {
            int finalI = i;
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    if (isPrimeNumber(list.get(finalI))) {
                        count.incrementAndGet();
                    }
                }
            });
        }

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);

        System.out.println(count);

        long stop = System.currentTimeMillis();
        System.out.println("Czas akcji = " + (stop - start));
    }

    public static boolean isPrimeNumber(long number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}