//Да се напише функција којашто за дадена
//еднострано поврзана листа од цели броеви ќе
//го врати бројот на парни елементи во истата.

import java.util.Scanner;

class SLLNode<E> {

    protected E value;
    protected SLLNode<E> next;

    public SLLNode(E value, SLLNode<E> next) {
        this.value = value;
        this.next = next;
    }


}

class SLL<E> {
    private SLLNode<E> first;

    public SLL() {
        this.first = null;
    }

    public void insertLast(int value) {

        if (first == null) {
            SLLNode insert = new SLLNode(value, null);
            first = insert;
        } else {
            SLLNode tmp = first;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            if (tmp.next == null) {
                SLLNode insert = new SLLNode(value, null);
                tmp.next = insert;
            }
        }
    }

    public SLLNode<E> getFirst() {
        return first;
    }


}

public class Main {
    public static int evenNumbers(SLL<Integer> list) {

        int num_even = 0;
        SLLNode<Integer> tmp = list.getFirst();
        while (tmp.next != null) {

            if ((tmp.value % 2) == 0) {
                num_even++;
            }
            tmp = tmp.next;
        }
        if ((tmp.value % 2) == 0) {
            num_even++;
        }

        return num_even;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Vnesete go brojot na elementi vo listata:");
        int n = sc.nextInt();

        SLL<Integer> list = new SLL<>();
        System.out.println("Vnesete gi elementite na listata (celi broevi):");
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }

        System.out.println("Brojot na parni elementi vo vnesenata lista e: " + evenNumbers(list));
    }
}