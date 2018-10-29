package indi.kavan.li;

/**
 * Created by Ritchie in 14:16 2017/12/24.
 */
public class SxtLinkedList {
    private Node1 first;
    private Node1 last;

    private int size;

    public void add(Object obj) {
        Node1 n = new Node1();

        if (first == null) {
            n.setPrevious(null);
            n.setObj(obj);
            n.setNext(null);

            first = n;
            last = n;
        } else {
            //直接往last节点后增加新的节点
            n.setPrevious(last);
            n.setObj(obj);
            n.setNext(null);

            last.setNext(n);

            last = n;
        }
        size++;
    }

    public int size() {
        return size;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object get(int index) {   //2
        rangeCheck(index);

        // 0 1 2 3 4
        Node1 temp = node(index);
        if (temp != null) {
            return temp.obj;
        }
        return null;
    }

    public Node1 node(int index) {
        Node1 temp = null;
        if (first != null) {
            if (index < (size >> 1)) {
                temp = first;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
            } else {
                temp = last;
                for (int i = size - 1; i > index; i--) {
                    temp = temp.previous;
                }
            }

        }
//		LinkedList l;
        return temp;
    }


    public void remove(int index) {
        Node1 temp = node(index);

        if (temp != null) {
            Node1 up = temp.previous;
            Node1 down = temp.next;
            up.next = down;
            down.previous = up;
            size--;
        }

    }

    public void add(int index, Object obj) {
        Node1 temp = node(index);

        Node1 newNode1 = new Node1();
        newNode1.obj = obj;

        if (temp != null) {
            Node1 up = temp.previous;
            up.next = newNode1;
            newNode1.previous = up;

            newNode1.next = temp;
            temp.previous = newNode1;

            size++;
        }
    }


    public static void main(String[] args) {
        SxtLinkedList list = new SxtLinkedList();
        list.add("aaa");
        list.add("bbb");
//		list.add(1,"BBBB");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
//		list.remove(1);
        System.out.println(list.get(3));
    }


}

class Node1 {
    Node1 previous;   //上一个节点
    Object obj;
    Node1 next;        //下一个节点

    public Node1() {
    }

    public Node1(Node1 previous, Object obj, Node1 next) {
        super();
        this.previous = previous;
        this.obj = obj;
        this.next = next;
    }

    public Node1 getPrevious() {
        return previous;
    }

    public void setPrevious(Node1 previous) {
        this.previous = previous;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node1 getNext() {
        return next;
    }

    public void setNext(Node1 next) {
        this.next = next;
    }


}