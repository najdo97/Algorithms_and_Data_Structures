
//Нека се дадени две низи, кои треба да бидат со иста големина.
// Да се напише функција која ќе прави промени во двете низи така што
// доколку на дадена позиција тие имаат еднакви елементи, истите треба да се избришат и во двете низи.

import java.util.ArrayList;


class ChangeArrays<E> {

    public void compareAndChangeArrays(ArrayList<Integer> niza3, ArrayList<Integer> niza4) {

        if (niza3.size() != niza4.size()) {
            System.out.println("Nizite ne se so ista dolzina");
        } else {
            int size = niza3.size();

            for (int i = 0; i < size; i++) {
                if (niza3.get(i).equals(niza4.get(i))) {
                    niza3.remove(i);
                    niza4.remove(i);
                    size--;
                }
            }
        }
    }

}

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> niza3 = new ArrayList<Integer>(3);

        niza3.add(10);
        niza3.add(13);
        niza3.add(7);

        ArrayList<Integer> niza4 = new ArrayList<Integer>(3);

        niza4.add(5);
        niza4.add(13);
        niza4.add(3);


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

