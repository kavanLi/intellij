package pers.kavan.li;

import com.sun.glass.ui.Size;
import sun.applet.Main;

/**
 * Created by Ritchie in 19:35 2017/12/19.
 */
public class MyArray {

    private Object[] value;

    private int size;

    public MyArray() {
        this(16);
    }

    public MyArray(int size) {
        value = new Object[size];
    }

    public void add(Object o) {
        if (size >= value.length) {
            int newCapacity = value.length * 2;
            Object[] newList = new Object[newCapacity];

            for (int i = 0; i < value.length; i++) {
                newList[i] = value[i];
            }

            value = newList;
        }
        value[size] = o;
        size++;
    }

    public Object get(int index) throws Exception {

        if (index < 0 || index > size - 1) {
            throw new Exception();
        }

        return value[index];
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray();
        myArray.add("asdf");
        myArray.add(new Dragon());
        myArray.add(new Dog());

        System.out.println(myArray.get(2));

    }
}
