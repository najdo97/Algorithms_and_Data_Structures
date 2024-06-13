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
        if (first != null) {
            boolean flag = false;
            SLLNode<E> tmp = first;
            while (tmp.next != before) { // todo - uslovite se greshni
                if (tmp.next == before) {
                    SLLNode<E> ins = new SLLNode<>(o, before);
                    tmp.next = ins;
                    flag = true;
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


}

public class DeleteSLL {

    public static void change(SLL<Integer> list, int br) {

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
        System.out.println("damn");


    }
}
