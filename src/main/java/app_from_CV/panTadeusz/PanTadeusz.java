package app_from_CV.panTadeusz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PanTadeusz {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src\\main\\resources\\pan-tadeusz.txt");
        Scanner scanner = new Scanner(file);

        HashMap<String, Integer> numberOfWords = new HashMap<String, Integer>();

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();
            String[] s = line.split(" ");

            for (String s1 : s) {

                String s33 = s1.replaceAll("[()/\\\\|+{}&,;:<>#\\[\\]]+", " ")
                        .replaceAll("\\p{Space}+", " ")
                        .replaceAll("[^\\p{Alnum}\\p{Space}]", "")
                        .toLowerCase()
                        .trim();

//                String s2 = s1.replace(" ", "");
//                String s3 = s2.replace(",", "");
//                String s4 = s3.replace(".", "");
//                String s5 = s4.replace("-", "");
//                String s6 = s5.replace(";", "");
//                String s7 = s6.replace("=", "");
//                String s8 = s7.replace("?", "");
//                String s9 = s8.replace("—", "");
//                String s10 = s9.replace("!", "");
//                String s11 = s10.replace("/", "");
//                String s12 = s11.replace("@", "");
//                String s13 = s12.replace("#", "");
//                String s14 = s13.replace("$", "");
//                String s15 = s14.replace("%", "");
//                String s16 = s15.replace("^", "");
//                String s17 = s16.replace("&", "");
//                String s18 = s17.replace("*", "");
//                String s19 = s18.replace("(", "");
//                String s20 = s19.replace(")", "");
//                String s21 = s20.replace("+", "");
//                String s22 = s21.replace("-", "");
//                String s23 = s22.replace("|", "");
//                String s24 = s23.replace(":", "");
//                String s25 = s24.replace("|", "");
//                String s26 = s25.replace("\\", "");
//                String s27 = s26.replace("…", "");
//                String s28 = s27.replace("»", "");
//                String s29 = s28.replace("«", "");
//                String s30 = s29.replace("«…", "");
//                String s31 = s30.replace("  ", "");
//                String s32 = s31.toLowerCase();
//                String s33 = s32.trim();

                if (s33.isEmpty()) {
                    continue;
                }

                if (numberOfWords.containsKey(s33)) {
                    numberOfWords.put(s33, numberOfWords.get(s33) + 1);
                } else {
                    numberOfWords.put(s33, 1);
                }
            }
        }

        ValueComparator bvc = new ValueComparator(numberOfWords);
        TreeMap<String, Integer> sorted_map = new TreeMap<>(bvc);
        sorted_map.putAll(numberOfWords);
        System.out.println(sorted_map);
        System.out.println("Liczba wyrazów: " + sorted_map.size());

        // TODO: 16.06.2019
//        int counterOfSingleWord = 0;
//         zliczanie słów które wystąpiły tylko raz
        
//        for (int i = 0; i < numberOfWords.size(); i++) {
//            if (numberOfWords.containsValue(numberOfWords.get(i)) == 1) {
//                counterOfSingleWord++;
//            }
//        }
//
//        System.out.println("Ilość słów pojedynczych: " + counterOfSingleWord);
        
    }

    static class ValueComparator implements Comparator<String> {
        Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}