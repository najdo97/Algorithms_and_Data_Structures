//Нека се дадени две еднострано поврзани
//листи чии јазли се сортирани во растечки
//редослед. Да се напише функција која ќе ги
//спои двете листи во една така што
//резултантната листа да е сортирана.
//Сортирањето е подредување со слевање.


public class Main {
    public static void main(String[] args){
        SLL<String> lista1 = new SLL<String>();
        lista1.insertLast("Ana");lista1.insertLast("Bojana");lista1.insertLast("Dejan");
        SLL<String> lista2 = new SLL<String>();
        lista2.insertLast("Andrijana");lista2.insertLast("Biljana");lista2.insertLast("Darko");

        JoinSortedLists<String> js = new JoinSortedLists<String>();
        System.out.println(js.join(lista1, lista2));

    }
}