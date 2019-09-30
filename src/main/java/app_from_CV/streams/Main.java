package app_from_CV.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {



//        1) Wszystkie nazwiska o długości co najwyżej 4 znaków, zapisane wielkimi literami

        List<String> list = DataCollections.getSurnames().stream()
                .filter(s -> s.length() <= 4)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

//        System.out.println(list);


//        2) Wszystkie nazwiska zaczynające się na literę 'B'

        List<String> list2 = DataCollections.getSurnames().stream()
                .filter(nazwisko -> nazwisko.startsWith("B"))
                .collect(Collectors.toList());

//        System.out.println(list2);

//        3) Początkowe trzy litery wszystkich nazwisk, bez powtórzeń, z małych liter

        Set<String> list3 = DataCollections.getSurnames().stream()
                .map(s -> s.toLowerCase().substring(0,3))
                .collect(Collectors.toSet());

//        System.out.println(list3);

//        4) 10 najdłuższych nazwisk, posortowanych malejąco według długości

        List<String> list4 = DataCollections.getSurnames().stream()
                .sorted((o1, o2) -> o2.length() - o1.length()).limit(10)
                .collect(Collectors.toList());

//        List<String> list4 = DataCollections.getSurnames().stream()
//                .sorted(new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        return o2.length() - o1.length();
//                    }
//                }).limit(10)
//                .collect(Collectors.toList());

//        System.out.println(list4);

//        4*) Obsłuż miejsca "ex aequo"
//        5) 20 najkrótszych nazwisk, posortowanych według ostatniej litery

        List<String> list5 = DataCollections.getSurnames().stream()
                .map(nazwisko -> new StringBuilder(nazwisko).reverse().toString())
                .sorted()
                .map(nazwisko -> new StringBuilder(nazwisko).reverse().toString())
                .sorted(Comparator.comparingInt(String::length))
                .limit(20)
                .collect(Collectors.toList());

        System.out.println(list5);

//        6) Odwróć kolejność liter we wszystkich nazwiskach i pozstaw jedynie te, które mają literę 'A' wsród pierwszych trzech liter (odwróconego nazwiska)

        List<String> list6 = DataCollections.getSurnames().stream()
                .map(nazwisko -> new StringBuilder(nazwisko).reverse().toString())
                .filter(nazwisko -> nazwisko.substring(0,3).contains("A"))
                .collect(Collectors.toList());

//        System.out.println(list6);

//        7) Policz, ile jest nazwisk zaczynających się na każdą z liter alfabetu (rezultat jako Map<Character, Integer>)
//        8*) Jaka litera pojawia się najcześciej we wszystkich nazwiskach?
//
//        Liczby:
//        1) Ile jest liczb parzystych?

        long ileParzystych = DataCollections.getNumbers(100_000).stream()
                .filter(liczba -> liczba % 2 == 0)
                .count();

//        System.out.println(ileParzystych);


//        2) Ile jest liczb pięciocyfrowych?

        long ilePieciocyfrowych = DataCollections.getNumbers(100_000).stream()
                .filter(liczba -> liczba >= 10_000 && liczba < 100_000)
                .count();

//        System.out.println(ilePieciocyfrowych);

//        3) Jaka jest największa i najmniejsza liczba?

        Optional<Integer> min = DataCollections.getNumbers(100_000).stream()
                .min(Integer::compareTo);

        Optional<Integer> max = DataCollections.getNumbers(100_000).stream()
                .max(Integer::compareTo);

        System.out.println(min);
        System.out.println(max);


//        4) Jaka jest różnica między największa a najmniejszą liczbą?
//        5) Jaka jest średnia wszystkich liczb?
//                6*) Jaka jest mediana wszystkich liczb?
//                7*) Jaka cyfra pojawia się najczęściej we wszystkcih liczbach?
//        8*) Ile jest wystąpień każdej cyfry (rezultat jako Map<Integer, Integer> z kluczami od 0 do 9)
//        9) Wypisz wszystkie liczby pierwsze, posortowane rosnąco
//
//        Lorem ipsum:
//        1) Ile jest wszystkich słów?
//        2) Ile słów zaczyna się na literę 'D'?
//                3) Policz, ile jest słów o danej długości (Map<Integer, Integer>)
//        4) Jaka litera pojawia się narzadziej?
//                5*) Ile jest słów, które posiadają dwie identyczne litery obok siebie (np. 'g' w "debugger")?
//        6**) Ile jest słów, które są palindromami?



    }
}
