import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> niza3 = new ArrayList<Integer>(3);

        niza3.add(10);
        niza3.add(13);
        niza3.add(7);

        ArrayList<Integer> niza4 = new ArrayList<Integer>(3);

        niza3.add(5);
        niza3.add(13);
        niza3.add(3);


        System.out.println("Nizite pred primenuvanjeto na funkcijata: ");
        System.out.println(niza3.toString());
        System.out.println(niza4.toString());

        ChangeArrays<Integer> pom2 = new ChangeArrays<Integer>();
        pom2.compareAndChangeArrays(niza3, niza4);

        System.out.println("Nizite po primenuvanjeto na funkcijata: ");
        System.out.println(niza3.toString());
        System.out.println(niza4.toString());


    }
}

