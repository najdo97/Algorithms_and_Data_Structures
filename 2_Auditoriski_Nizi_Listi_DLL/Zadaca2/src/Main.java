

class DLLNode<E> {
    protected DLLNode<E> previous;
    protected E value;
    protected DLLNode<E> next;

    DLLNode(E value, DLLNode<E> previous, DLLNode<E> next) {

        this.value = value;
        this.previous = previous;
        this.next = next;
    }
}

class DLL<E> {

    protected DLLNode<E> head;
    protected DLLNode<E> tail;

    DLL() {
        head = null;
        tail = null;
    }

    void insertFirst(E value) {
        DLLNode<E> insert = new DLLNode<>(value, null, head);
        if (head == null) {
            tail = insert;
        } else {
            head.previous = insert;
        }
        head = insert;
    }

    void insertLast(E value) {
        if (head == null) {
            insertFirst(value);
        } else {
            DLLNode<E> insert = new DLLNode<>(value, tail, null);
            tail.next = insert;
            tail = insert;
        }
    }

    void mirror() {
        DLLNode<E> current = this.head;
        DLLNode<E> tmp = null;
        tail = head;
        while (current != null) {
            tmp = current.previous;
            current.previous = current.next;
            current.next = tmp;
            current = current.previous;
        }
        if (tmp != null && tmp.previous != null) { //ova e da se spreci EDGE case koga listata ima 0 ili 1 clen
            head = tmp.previous;                    //tmp.previous ->posleden clen ....... tmp -> pretposleden clen
        }

        //ako nizata e od 1 clen ili 0 clenovi, head ne se menja !
    }

    @Override
    public String toString() {
        DLLNode<E> tmp = this.head;
        String lista = "";
        while (tmp != null) {
            if (tmp.next != null) {
                lista += tmp.value + "->";
            } else {
                lista += tmp.value;
            }
            tmp = tmp.next;
        }
        return lista;
    }


}

public class Main {
    public static void main(String[] args) {
        DLL<String> lista = new DLL<String>();
        lista.insertLast("ovaa");
        lista.insertLast("lista");
        lista.insertLast("kje");
        lista.insertLast("bide");
        lista.insertLast("prevrtena");
        System.out.println("Listata pred da bide prevrtena: " + lista.toString());
        lista.mirror();
        System.out.println("Listata otkako e prevrtena: " + lista.toString());

    }
}