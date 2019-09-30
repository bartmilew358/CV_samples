package app_from_CV.detectLanguage;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.errors.APIError;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class detectLanguage {
    public static void main(String[] args) throws FileNotFoundException, APIError {
        DetectLanguage.apiKey = "6b58dc6c1e43de57335d3347b6a28430";

        File folder = new File("C:\\language_files\\");
        File[] files = folder.listFiles();

        for (File file : files) {
            String language = howIsThatLanguage(String.valueOf(file));
            System.out.println("Plik: " + file.getName() + " jest w języku: " + language);
        }

//        System.out.println(howIsThatLanguage("C:\\language_files\\chunichi.txt"));
//        System.out.println(howIsThatLanguage("C:\\language_files\\focus-1.txt"));
//        System.out.println(howIsThatLanguage("C:\\language_files\\focus-2.txt"));
//        System.out.println(howIsThatLanguage("C:\\language_files\\la-vanguardia.txt"));
//        System.out.println(howIsThatLanguage("C:\\language_files\\publico.txt"));
//        System.out.println(howIsThatLanguage("C:\\language_files\\zeit.txt"));

//        CountryCode cc = CountryCode.getByCode("JP");
//        System.out.println("Country name = " + cc.getName());

    }

    public static String howIsThatLanguage (String filename) throws APIError, FileNotFoundException {

        FileReader fileReader = new FileReader(filename);
        Scanner scanner = new Scanner(fileReader);
        StringBuilder textFile = new StringBuilder();
        String line = "";

        while(scanner.hasNextLine()){
            line = scanner.nextLine();
//            System.out.println(line);
            textFile.append(line);
        }

//        System.out.println(textFile.toString());

        String language = DetectLanguage.simpleDetect(textFile.toString());
         return language;

    }
}


