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

        SLLNode<E> tmp = new SLLNode<>(o, this.first);
        this.first = tmp;

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
        }else{
            insertFirst(o);
        }
    }

    public void insertBefore() {

    }

    public void insertAfter() {

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
