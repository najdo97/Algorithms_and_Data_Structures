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

    public void deleteList() {
        this.first = null;
    }

    public SLL(SLLNode<E> node) {
        this.first = node;
    }

    public SLLNode<E> getFirst() {
        return first;
    }

    @Override
    public String toString() {
        String niza = new String();
        SLLNode<E> tmp = first;
        if (first == null) {

            return "Prazna lista!!!";
        }
        niza += tmp.value;
        while (tmp.next != null) {
            tmp = tmp.next;
            niza += "->" + tmp.value;

        }
        return niza;
    }

    public void insertFirst(E o) {

        SLLNode<E> tmp = new SLLNode<E>(o, this.first);
        this.first = tmp;

    }

    public void insertAfter(E o, SLLNode<E> after) {

        if (after == null) {
            System.out.println("Dadeniot jazol e null");
        } else {
            SLLNode<E> tmp = first;
            boolean flag = false;
            while (tmp.next != null) {

                if (tmp == after) {
                    SLLNode<E> ins = new SLLNode<>(o, tmp.next);
                    tmp.next = ins;
                    flag = true;
                }

                tmp = tmp.next;
            }
            if (!flag) {
                System.out.println("Baraniot jazol ne e vo listata.");
            }
        }
    }

    public void insertLast(E o) {
        if (this.first != null) {
            SLLNode<E> tmp = first;
            while (tmp != null) {

                if (tmp.next == null) {
                    tmp.next = new SLLNode<E>(o, null);
                    break;
                }
                tmp = tmp.next;
            }
        } else {
            insertFirst(o);
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        System.out.println("VLEGUVA ");
        if (first != null) {
            boolean flag = false;
            SLLNode<E> tmp = first;

            if (first == before) {
                insertFirst(o);
            }

            while (tmp.next != null) {
                if (tmp.next == before) {
                    SLLNode<E> ins = new SLLNode<>(o, before);
                    tmp.next = ins;
                    flag = true;
                    break;
                }
                tmp = tmp.next;
            }
            if (flag) {
                System.out.println("Elementot ne postoi vo nizata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void deleteFirst() {
        SLLNode<E> tmp = first.next;
        this.first = tmp;
    }

    public void deleteNode(SLLNode<E> node) {
        SLLNode<E> tmp = first;


        while (tmp.next != null) {

            if (tmp.next == node) {
                tmp.next = tmp.next.next;
            }

            tmp = tmp.next;
        }
    }
}

public class DeleteSLL {

    public static void change(SLL<Integer> list, int br) {
        int brojac = 0;
        //boolean flag=false;
        SLLNode<Integer> node = list.getFirst();

        while (node.next != null) {
            if (node.value == br) {
                brojac++;

                //  System.out.println("Vleguva vo while- change");
            }
            node = node.next;
        }

        if ((brojac % 2) != 0) {
        //    System.out.println("Vleguva vo if - change");

            node = list.getFirst();
            while (node.next != null) {
                if (node.value == br) {
                    list.insertBefore(br, node);
                   // break;
                }
                node = node.next;
            }


        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int n, broj;
        SLL<Integer> list1 = new SLL<Integer>();
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            list1.insertLast(scan.nextInt());
        }
        int br = scan.nextInt();
        change(list1, br);
        System.out.println(list1);


    }
}
