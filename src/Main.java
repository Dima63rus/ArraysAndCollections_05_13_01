import java.util.*;

public class Main {
    public static void main(String[] args) {
/*
        Цель задания:
           Научиться сортировать и искать элементы в коллекциях.
        Что нужно сделать
           1. Напишите генератор «красивых» автомобильных номеров и методы поиска элементов в коллекциях:
             	прямым перебором по ArrayList,
             	бинарным поиском по сортированному ArrayList,
             	поиском в HashSet,
             	поиском в TreeSet.
           2. Измерьте и сравните длительность каждого метода поиска.
                Формат вывода результатов поиска:
                Поиск перебором: номер найден/не найден, поиск занял 34нс
                Бинарный поиск: номер найден/не найден, поиск занял 34нс
                Поиск в HashSet: номер найден/не найден, поиск занял 34нс
                Поиск в TreeSet: номер найден/не найден, поиск занял 34нс
           3. Напишите в форме ответа, какой поиск — самый быстрый, а какой — самый медленный.
*/
        //Заполнить сортированный ArrayList номерами = 2млн
        ArrayList<String> ltArrayList = setArrayList();

        //Добавить наш массив в TreeSet
        TreeSet<String> ltTreeSet = new TreeSet<>(ltArrayList);

        //Добавить наш массив в TreeSet
        HashSet<String> ltHashSet = new HashSet<>(ltArrayList);

        Scanner loScanner = new Scanner(System.in);

        for (; ; ) {
            System.out.println("Введите автомобильный красивый номер в формате A001AA01 из регионов: 01 - 02");
            String lvNumberAuto = loScanner.nextLine();

            //Поиск перебором
            searchSimple(ltArrayList, lvNumberAuto);

            //Бинарный поиск
            searchBinary(ltArrayList, lvNumberAuto);

            //Поиск в TreeSet
            searchTreeSet(ltTreeSet, lvNumberAuto);

            //Поиск в HashSet
            searchHashSet(ltHashSet, lvNumberAuto);
        }
    }

    private static ArrayList<String> setArrayList() {
        ArrayList<String> rtArrayList = new ArrayList<>();

        //Сортированный массив букв
        String[] ltAlphabet = {"C", "M", "T", "B", "A", "P", "O", "H", "E", "Y"};
        Arrays.sort(ltAlphabet);

        //Сортированный массив цифр
        String[] ltDigitsFirst = new String[1000];
        for (int i = 0; i < ltDigitsFirst.length; i++) {
            if (i < 100) {
                ltDigitsFirst[i] = String.format("%03d", i + 1);
            } else {
                ltDigitsFirst[i] = String.valueOf(i + 1);
            }
        }

        //Сортированный массив цифр - регион
        String[] ltDigitsRegion = new String[200];
        for (int i = 0; i < ltDigitsRegion.length; i++) {
            if (i < 100) {
                ltDigitsRegion[i] = String.format("%02d", i + 1);
            } else {
                ltDigitsRegion[i] = String.valueOf(i + 1);
            }
        }

        //Генерация номерных знаков
        for (int m = 0; m < ltDigitsRegion.length; m++) {
            if (m == 2) {
                return rtArrayList;
            }
            for (int i = 0; i < ltAlphabet.length; i++) {
                for (int j = 0; j < ltDigitsFirst.length; j++) {
                    for (int k = 0; k < ltAlphabet.length; k++) {
                        for (int l = 0; l < ltAlphabet.length; l++) {
                            rtArrayList.add(ltAlphabet[i] + ltDigitsFirst[j] + ltAlphabet[k] + ltAlphabet[l] + ltDigitsRegion[m]);
                        }
                    }
                }
            }
        }
        return rtArrayList;
    }

    /* Поиск перебором */
    private static void searchSimple(ArrayList<String> itArrayList,
                                     String ivNumberAuto) {
        long lvStart = System.nanoTime();
        if (itArrayList.contains(ivNumberAuto)) {
            long lvDuration = System.nanoTime() - lvStart;
            System.out.println("Поиск перебором: " + ivNumberAuto + " найден, поиск занял " + lvDuration);
        } else {
            System.out.println("Поиск перебором: " + ivNumberAuto + " не найден");
        }
    }

    private static void searchBinary(ArrayList<String> itArrayList,
                                     String ivNumberAuto) {

        long lvStart = System.nanoTime();
        int lvIndex = Collections.binarySearch(itArrayList, ivNumberAuto);
        if (lvIndex >= 0) {
            long lvDuration = System.nanoTime() - lvStart;
            System.out.println("Бинарный поиск: " + ivNumberAuto + " найден, поиск занял " + lvDuration);
        } else {
            System.out.println("Бинарный поиск: " + ivNumberAuto + " не найден");
        }
    }

    private static void searchTreeSet(TreeSet<String> itTreeSet,
                                      String ivNumberAuto) {
        long lvStart = System.nanoTime();
        if (itTreeSet.contains(ivNumberAuto)) {
            long lvDuration = System.nanoTime() - lvStart;
            System.out.println("Поиск TreeSet: " + ivNumberAuto + " найден, поиск занял " + lvDuration);
        } else {
            System.out.println("Поиск TreeSet: " + ivNumberAuto + " не найден");
        }
    }

    private static void searchHashSet(HashSet<String> itHashSet,
                                      String ivNumberAuto) {
        long lvStart = System.nanoTime();
        if (itHashSet.contains(ivNumberAuto)) {
            long lvDuration = System.nanoTime() - lvStart;
            System.out.println("Поиск HashSet: " + ivNumberAuto + " найден, поиск занял " + lvDuration);
        } else {
            System.out.println("Поиск HashSet: " + ivNumberAuto + " не найден");
        }
    }
}