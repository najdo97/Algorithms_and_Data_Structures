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
    public SLL<E> join(SLL<E> lista1, SLL<E> lista2) {

        SLLNode<E> prva = lista1.getHead();
        SLLNode<E> vtora = lista2.getHead();
        SLL<E> rezultat = new SLL<E>();


        while (prva != null && vtora != null) {

            if (prva.value.compareTo(vtora.value) < 0) {
                rezultat.insertLast(prva.value);

                prva = prva.next;
            } else {
                rezultat.insertLast(vtora.value);

                vtora = vtora.next;
            }
        }

        if (prva != null) {
            while (prva != null) {
                rezultat.insertLast(prva.value);

                prva = prva.next;
            }
        } else if (vtora != null) {
            while (vtora != null) {
                rezultat.insertLast(vtora.value);

                vtora = vtora.next;
            }
        }

        return rezultat;
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

        SLL<Integer> lista3=new SLL<Integer>();

        lista3.insertLast(5);
        lista3.insertLast(6);
        lista3.insertLast(8);

        SLL<Integer> lista4=new SLL<Integer>();

        lista4.insertLast(2);
        lista4.insertLast(7);
        lista4.insertLast(11);

        System.out.println(lista3.toString());
        System.out.println(lista4.toString());

        JoinSortedLists<Integer>nova=new JoinSortedLists<>();
        System.out.println(nova.join(lista3,lista4));

    }
}