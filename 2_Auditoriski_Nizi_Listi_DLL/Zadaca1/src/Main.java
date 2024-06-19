//Да се напише програма за произволна двојно
//поврзана листа во која ќе се исфрлат сите јазли што
//се повторуваат. Дополнително секој јазол на оваа
//листа покрај објектот, содржи и дополнителна
//информација: бројот на повторувања на дадениот
//јазел.


class DLLNode<E> {

    protected DLLNode<E> previous;
    protected E value;
    protected int brPovtoruvanja;
    protected DLLNode<E> next;

    DLLNode(E value, DLLNode<E> previous, DLLNode<E> next) {

        this.value = value;
        this.previous = previous;
        this.next = next;
        brPovtoruvanja = 0;
    }

}

class DLL<E> {

    protected DLLNode<E> head;
    protected DLLNode<E> tail;

    DLL() {
        this.head = null;
        this.tail = null;
    }

    void insertFirst(E value) {
        DLLNode<E> insert = new DLLNode<E>(value, null, head);
        if (head == null) {
            tail = insert;
        } else {
            head.previous = insert;
        }
        head = insert;              //we must use head = insert ------->  'head = head.previous' is WRONG - head will always stay null !
    }

    void insertLast(E value) {

        if (head == null) {
            insertFirst(value);
        } else {
            DLLNode<E> insert = new DLLNode<E>(value, tail, null);
            tail.next = insert;
            tail = insert;
        }

    }

    @Override
    public String toString() {
        String lista = "";

        DLLNode<E> tmp = head;
        while (tmp != null) {

            if (tmp.next != null) {
                lista += tmp.value + "(" + tmp.brPovtoruvanja + ")" + "->";
            } else {
                lista += tmp.value + "(" + tmp.brPovtoruvanja + ")";
            }
            tmp = tmp.next;
        }
        return lista;
    }

    DLLNode<E> getHead() {
        return this.head;
    }

    void deleteHead() {

        head.next.previous = null;
        head = head.next;
    }

    void deleteTail() {

        tail.previous.next = null;
        tail = tail.previous;
    }

    void deleteNode(DLLNode<E> node) {

        if (node == head) {
            deleteHead();
            return;
        }
        if (node == tail) {
            deleteTail();
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;

    }

    void deleteAllDuplicates(DLLNode<E> node) {
        DLLNode<E> tmp = node.next;
        while (tmp != null) {

            if (tmp.value.equals(node.value)) {
                deleteNode(tmp);
                node.brPovtoruvanja++;
            }

            tmp = tmp.next;
        }
    }

    void izvadiDupliIPrebroj() {
        DLLNode<E> tmp = this.head;
        while (tmp != null) {
            deleteAllDuplicates(tmp);
            tmp = tmp.next;
        }
    }


//    boolean isDuplicate(DLL<E> nova, E value) {
//
//        DLLNode<E> tmp = nova.getHead();
//        while (tmp != null) {
//
//            if (tmp.value == value) {
//                return true;
//            }
//            tmp = tmp.next;
//        }
//
//        return false;
//    }
//
//    void izvadiDupliIPrebroj() {
//        DLLNode<E> tmp = this.head;
//        DLL<E> nova = new DLL<E>();
//        while (tmp != null) {
//
//            if (!isDuplicate(nova, tmp.value)) {
//                nova.insertLast(tmp.value);
//            }
//            tmp = tmp.next;
//        }
//
//        this.head = nova.head;
//        this.tail = nova.tail;
//    }
}

public class Main {
    public static void main(String[] args) {

        DLL<Integer> lista = new DLL<Integer>();

        lista.insertLast(4);
        lista.insertLast(9);
        lista.insertLast(4);
        lista.insertLast(4);
        lista.insertLast(5);
        lista.insertLast(8);
        lista.insertLast(9);

        System.out.println("Listata pred otstranuvanje i prebrojuvanje na duplite elementi:");
        System.out.println(lista.toString());

        lista.izvadiDupliIPrebroj();

        System.out.println("Listata po otstranuvanje i prebrojuvanje na duplite elementi:");
        System.out.println(lista.toString());
    }
}