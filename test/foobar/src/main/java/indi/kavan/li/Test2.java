package indi.kavan.li;

import java.util.*;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.beans.binding.ObjectExpression;
import pers.kavan.li.Dragon;
import sun.rmi.runtime.Log;

/**
 * Created by Ritchie in 17:59 2017/12/23.
 */


public class Test2 {

    public static <T> void sort(Object[] arr, Comparator <T> com) {
        //从大到小排序 降序
        boolean sorted = true;
        int len = arr.length;
        for (int j = 0; j < len - 1; j++) { //趟数
            sorted = true; //假定有序
            for (int i = 0; i < len - 1 - j; i++) { //次数
                if (com.compare((T) arr[i], (T) arr[i + 1]) < 0) {
                    Object temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    sorted = false; //假定失败
                }
            }
            if (sorted) { //减少趟数
                break;
            }
        }
    }


    public static void sort(Comparable[] objects) {
        boolean sorted = true;
        int len = objects.length;
        for (int j = 0; j < len - 1; j++) { //趟数
            sorted = true; //假定有序
            for (int i = 0; i < len - 1 - j; i++) { //次数
                if (objects[i].compareTo(objects[i + 1]) < 0) {
                    Comparable temp = objects[i];
                    objects[i] = objects[i + 1];
                    objects[i + 1] = temp;
                    sorted = false; //假定失败
                }
            }
            if (sorted) { //减少趟数
                break;
            }
        }

        //System.out.println(Arrays.toString(objects));
        System.out.println(objects[0].toString());
    }

    public static <T extends Comparable> void sort(List <T> list) {
        Object[] comparable = (Object[]) list.toArray();

        for (int i = 0; i < list.size(); i++) {
            list.set(i, (T) comparable[i]);
        }
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }

    public static void main(String[] args) {
        List <String> list = new ArrayList <>();
        list.add("a");
        list.add("b");
        list.add("c");
        sort(list);


        //Date[] dates = new Date[3];
        //dates[0] = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        //dates[1] = new Date(System.currentTimeMillis() + 2000 * 60 * 60);
        //dates[2] = new Date(System.currentTimeMillis() + 3000 * 60 * 60);
        //String[] strings = {"sdf", "sadff3", "sdfg"};
        //Comparable[] objects = strings;
        //
        //sort(objects);

        //for (String s1 : stringSet) {

        //    System.out.println(s1);
        //}

        //Iterator <String> iterator = stringSet.iterator();
        //while (iterator.hasNext()) {
        //    String s1 = iterator.next();
        //    System.out.println(s1);
        //}

        //    Map<String, Letter> map = new HashMap <>();
        //
        //    String statement = "is is is In Bethlehem, Jesus was born is is is of the Virgin Mary. He was born, " +
        //            "not by the will of man, but by the gift of the love of God our Father," +
        //            " who \"so loved the world that he gave his only-begotten Son, " +
        //            "that whoever believes in him should not perish but have eternal life\" (Jn 3:16).";
        //
        //    String[] strings = statement.split(" ");
        //
        //    Letter letter = null;
        //    for (String temp : strings) {
        //
        //
        //        if (!map.containsKey(temp)) {
        //            letter = new Letter();
        //            letter.setCount(1);
        //            map.put(temp, letter);
        //        } else {
        //            map.get(temp).add();
        //            map.put(temp, map.get(temp));
        //        }
        //
        //    }
        //
        //    Set<String> stringSet = map.keySet();
        //    for (String key : stringSet) {
        //        System.out.println(key);
        //        //Letter letter1 = map.get(key);
        //        //System.out.println(key + "   " + letter1.getCount());
        //    }
    }

}

class Letter {
    private int count;

    public Letter() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void add() {
        count++;
    }
}