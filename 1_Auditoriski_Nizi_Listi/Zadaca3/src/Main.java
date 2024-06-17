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
    }
}