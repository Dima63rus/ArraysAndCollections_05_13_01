import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
/*
        ���� �������:
           ��������� ����������� � ������ �������� � ����������.
        ��� ����� �������
           1. �������� ��������� ���������� ������������� ������� � ������ ������ ��������� � ����������:
             	������ ��������� �� ArrayList,
             	�������� ������� �� �������������� ArrayList,
             	������� � HashSet,
             	������� � TreeSet.
           2. �������� � �������� ������������ ������� ������ ������.
                ������ ������ ����������� ������:
                ����� ���������: ����� ������/�� ������, ����� ����� 34��
                �������� �����: ����� ������/�� ������, ����� ����� 34��
                ����� � HashSet: ����� ������/�� ������, ����� ����� 34��
                ����� � TreeSet: ����� ������/�� ������, ����� ����� 34��
           3. �������� � ����� ������, ����� ����� � ����� �������, � ����� � ����� ���������.
*/
        //��������� ������������� ArrayList �������� = 2���
        ArrayList<String> ltArrayList = setArrayList();

//        Scanner loScanner = new Scanner(System.in);
//        System.out.println("������� ������������� ����� � ������� A001AA01 �� ��������: 01 - 10");
        String lvNumberAuto = "A001AA01"; //Test

//        for (; ; ) {
        //����� ���������
        searchSimple(ltArrayList, lvNumberAuto);

        //�������� �����
        //����� � HashSet
        //����� � TreeSet
//        }
    }

    private static ArrayList<String> setArrayList() {
        ArrayList<String> rtArrayList = new ArrayList<>();

        //������������� ������ ����
        String[] ltAlphabet = {"C", "M", "T", "B", "A", "P", "O", "H", "E", "Y"};
        Arrays.sort(ltAlphabet);

        //������������� ������ ����
        String[] ltDigitsFirst = new String[1000];
        for (int i = 0; i < ltDigitsFirst.length; i++) {
            if (i < 100) {
                ltDigitsFirst[i] = String.format("%03d", i + 1);
            } else {
                ltDigitsFirst[i] = String.valueOf(i + 1);
            }
        }

        //������������� ������ ���� - ������
        String[] ltDigitsRegion = new String[200];
        for (int i = 0; i < ltDigitsRegion.length; i++) {
            if (i < 100) {
                ltDigitsRegion[i] = String.format("%02d", i + 1);
            } else {
                ltDigitsRegion[i] = String.valueOf(i + 1);
            }
        }

        //��������� �������� ������
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

    /* ����� ��������� */
    private static void searchSimple(ArrayList<String> itArrayList,
                                     String ivNumberAuto) {
        long lvStart = System.nanoTime();
        if (itArrayList.contains(ivNumberAuto)) {
            long lvDuration = System.nanoTime() - lvStart;
            System.out.println("����� ���������: " + ivNumberAuto + " ������, ����� ����� " + lvDuration);
        } else {
            System.out.println("����� ���������: " + ivNumberAuto + " �� ������");
        }
    }
}