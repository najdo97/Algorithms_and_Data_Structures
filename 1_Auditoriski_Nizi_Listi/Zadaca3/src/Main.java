//Да се напише функција што ги превртува сите
//врски во еднострано поврзана листа.

//input:
//  2->7->4->11->18->15->null

//output:
//  15->18->11->4->7->2

class SLLNode<E> {
    protected E value;
    protected SLLNode<E> next;

    public SLLNode(E value, SLLNode<E> next) {
        this.value = value;
        this.next = next;
    }
}

class SLL<E> {
    private SLLNode<String> first;

    public SLL() {
        this.first = null;
    }

    public void insertLast(String zbor) {
        if (first == null) {
            SLLNode<String> insert = new SLLNode<String>(zbor, null);

            first = insert;
        } else {
            SLLNode<String> tmp = first;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            SLLNode<String> insert = new SLLNode<String>(zbor, null);
            tmp.next = insert;
        }
    }

    public String toString() {

        SLLNode<String> tmp = first;
        String lista = tmp.value;
        tmp = tmp.next;
        while (tmp != null) {

            lista += "->" + tmp.value;
            tmp = tmp.next;
        }

        return lista;
    }

    public void mirror() {
        if (this.first != null) {

            SLLNode<String> prev = null;
            SLLNode<String> curr = first;
            SLLNode<String> next = null;


            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            first = prev;

        } else {
            System.out.println("Listata e prazna");
        }

    }

    //Problem 1: Reverse a Singly Linked List
    //Description: Given the head of a singly linked list, reverse the list, and return the reversed list.

    //Example:
    //Input: 1 -> 2 -> 3 -> 4 -> 5 -> NULL
    //Output: 5 -> 4 -> 3 -> 2 -> 1 -> NULL
    public SLLNode<String> reverseList(SLLNode<String> head) {


        if (head == null) {
            System.out.println("Listata e prazna");
        } else {

            SLLNode<String> previous = null;
            SLLNode<String> current = head;
            SLLNode<String> next = null;

            while (current != null) {

                next = current.next;
                current.next = previous;

                previous = current;
                current = next;

            }
            head = previous;
        }

        return head;
    }

    public SLLNode<String> getHead() {
        return this.first;
    }

    public void reverseInbetween(int m, int n) {
        if (first != null) {

            if (m == n || first == null) {
                System.out.println("Listata e prazna ili m i n se isti");
                return;
            } else {

                SLLNode<String> previous = null;
                SLLNode<String> current = first;
                SLLNode<String> next = null;

                SLLNode<String> before = null;

                for (int i = 1; i < m - 1; i++) {

                }


            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SLL<String> lista = new SLL<String>();
        lista.insertLast("ovaa");
        lista.insertLast("lista");
        lista.insertLast("kje");
        lista.insertLast("bide");
        lista.insertLast("prevrtena");
        System.out.println("Listata pred da bide prevrtena: " + lista.toString());
        lista.mirror();
        System.out.println("Listata otkako e prevrtena: " + lista.toString());

        //todo - ChatGPT primer -> 1
        SLLNode<String> pom = lista.reverseList(lista.getHead());
        System.out.print("Listata otkako e prevrtena po vtor pat: ");

        while (pom != null) {
            if (pom.next == null) {
                System.out.print(pom.value);
                pom = pom.next;
                continue;
            }
            System.out.print(pom.value + "->");
            pom = pom.next;
        }

        System.out.println();
        //todo - ChatGPT primer -> 2
        //Description: Reverse a singly linked list from position m to n. Do it in one-pass.

        //Example:
        //Input: 1 -> 2 -> 3 -> 4 -> 5 -> NULL, m = 2, n = 4
        //Output: 1 -> 4 -> 3 -> 2 -> 5 -> NULL
        int m = 2, n = 4;

        lista.reverseInbetween(m, n);
        System.out.println("Prevrtena lista od od m od n clen: " + lista.toString());

    }
}