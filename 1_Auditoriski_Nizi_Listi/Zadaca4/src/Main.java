//Нека се дадени две еднострано поврзани
//листи чии јазли се сортирани во растечки
//редослед. Да се напише функција која ќе ги
//спои двете листи во една така што
//резултантната листа да е сортирана.
//Сортирањето е подредување со слевање.


class SLLNode<E> {
    protected E value;
    protected SLLNode<E> next;

    SLLNode(E value, SLLNode<E> next) {
        this.value = value;
        this.next = next;
    }
}

class SLL<E> {
    protected SLLNode<E> head;

    public void insertLast(E value) {

        SLLNode<E> tmp = head;
        if (head == null) {
            SLLNode<E> insert = new SLLNode<>(value, null);
            head = insert;
        } else {
            while (tmp != null) {
                if (tmp.next == null) {
                    SLLNode<E> insert = new SLLNode<>(value, null);
                    tmp.next = insert;
                    break;
                }
                tmp = tmp.next;
            }
        }
    }

    @Override
    public String toString() {
        String lista = "";

        SLLNode<E> tmp = head;
        while (tmp != null) {
            if (tmp.next == null) {
                lista += tmp.value;
            } else {
                lista += tmp.value + "->";
            }
            tmp = tmp.next;
        }

        return lista;
    }

    public SLLNode<E> getHead() {
        return this.head;
    }
}

class JoinSortedLists<E extends Comparable<E>> {
    public void join(SLL<E> lista1, SLL<E> lista2) {

        SLLNode<E> prva = lista1.getHead();
        SLLNode<E> vtora = lista2.getHead();
        SLLNode<E> rezultat = null;


        while (prva != null || vtora != null) {

            if (prva.value.compareTo(vtora.value) < 0) {
                rezultat = vtora;

                rezultat = rezultat.next;
                vtora=vtora.next;
            } else {
                rezultat = prva;

                rezultat = rezultat.next;
                prva=prva.next;
            }

        }
    }
}

public class Main {
    public static void main(String[] args) {
        SLL<String> lista1 = new SLL<String>();
        lista1.insertLast("Ana");
        lista1.insertLast("Bojana");
        lista1.insertLast("Dejan");
        SLL<String> lista2 = new SLL<String>();
        lista2.insertLast("Andrijana");
        lista2.insertLast("Biljana");
        lista2.insertLast("Darko");

        JoinSortedLists<String> js = new JoinSortedLists<String>();
        System.out.println(js.join(lista1, lista2));


        System.out.println("Lista 1: " + lista1.toString());
        System.out.println("Lista 2: " + lista2.toString());
    }
}