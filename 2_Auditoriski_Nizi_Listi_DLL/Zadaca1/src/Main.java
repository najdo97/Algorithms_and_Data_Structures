//Да се напише програма за произволна двојно
//поврзана листа во која ќе се исфрлат сите јазли што
//се повторуваат. Дополнително секој јазол на оваа
//листа покрај објектот, содржи и дополнителна
//информација: бројот на повторувања на дадениот
//јазел.


class DLLNode<E> {
    protected E value;
    protected int br_povtoruvanja;

    protected DLLNode<E> next;
    protected DLLNode<E> previous;

    public DLLNode() {

        this.value = null;
        this.next = null;
        this.previous = null;
        br_povtoruvanja = 0;
    }

    public DLLNode(E value, DLLNode<E> next, DLLNode<E> previous) {

        this.value = value;
        this.next = next;
        this.previous = previous;
        //this.br_povtoruvanja++;
    }
}

class DLL<E> {
    protected DLLNode<E> head;
    protected DLLNode<E> tail;

    public DLL() {
        head = new DLLNode<>();
        tail = new DLLNode<>();
    }

    public void insertLast(E value) {
        if (head == null) {
            DLLNode<E> insert = new DLLNode<E>(value, tail, null);

            head=insert;

            tail.previous = head;
            tail.next=null;
        }else{

            tail.next=new DLLNode<>(value,null,tail);

        }

    }

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