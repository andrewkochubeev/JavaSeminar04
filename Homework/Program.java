package Homework;

import java.util.LinkedList;

/**
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который
 * вернет “перевернутый” список.
 */
public class Program {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int size = (int) (Math.random() * 6 + 10);
        for (int i = 0; i < size; i++) {
            linkedList.add((int) (Math.random() * 21 - 10));
        }
        System.out.println("Исходный список: " + linkedList);
        System.out.println("Перевернутый список: " + reverse(linkedList));
    }

    static LinkedList<Integer> reverse(LinkedList<Integer> lnkLst) {
        LinkedList<Integer> outLnkLst = new LinkedList<>();
        int length = lnkLst.size();
        for (int i = 0; i < length; i++) {
            outLnkLst.add(lnkLst.removeLast());
        }

        return outLnkLst;
    }
}