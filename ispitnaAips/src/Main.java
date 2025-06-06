import java.util.*;


interface Stack<E> {
    // Elementi na stekot se objekti od proizvolen tip.
    // Metodi za pristap:

    public boolean isEmpty();
    // Vrakja true ako i samo ako stekot e prazen.

    public E peek();
    // Go vrakja elementot na vrvot od stekot.

    // Metodi za transformacija:
    public void clear();
    // Go prazni stekot.

    public void push(E x);
    // Go dodava x na vrvot na stekot.

    public E pop();
    // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}


class LinkedStack<E> implements Stack<E> {
    // top e link do prviot jazol ednostrano-povrzanata lista koja sodrzi gi elementite na stekot .
    private SLLNode<E> top;
    int size;

    public LinkedStack() {
        // Konstrukcija na nov, prazen stek.
        top = null;
        size = 0;
    }

    public String toString() {
        SLLNode<E> current = top;
        StringBuilder s = new StringBuilder();
        while (current != null) {
            s.append(current.element);
            s.append(" ");
            current = current.succ;
        }
        return s.toString();
    }

    public boolean isEmpty() {
        // Vrakja true ako i samo ako stekot e prazen.
        return (top == null);
    }

    public void clear() {
        // Go prazni stekot.
        top = null;
        size = 0;
    }

    public E peek() {
        // Go vrakja elementot na vrvot od stekot.
        if (top == null)
            throw new NoSuchElementException();
        return top.element;
    }

    public void push(E x) {
        // Go dodava x na vrvot na stekot.
        top = new SLLNode<E>(x, top);
        size++;
    }

    public int size() {
        // Ja vrakja dolzinata na stekot.
        return size;
    }

    public E pop() {
        // Go otstranuva i vrakja elementot shto e na vrvot na stekot.
        if (top == null)
            throw new NoSuchElementException();
        E topElem = top.element;
        size--;
        top = top.succ;
        return topElem;
    }

}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();      //todo - bigest problem

        LinkedStack<String> stack = new LinkedStack<>();
        boolean answer = true;

        while (sc.hasNextLine()) {

            String input = sc.nextLine().trim();

            if (input.isBlank()) {        //todo - ako e prazna linijata, kraj na ciklusot
                break;
            }

            if (!stack.isEmpty()) {

                if (stack.peek().equals("\\begin{section}")) {

                    if (
                            input.equals("\\end{subsection}") ||
                                    input.equals("\\end{subsubsection}") ||
                                    input.equals("\\end{text}") ||
                                    !input.startsWith("\\")
                    ) {
                        answer = false;
                        break;
                    }
                } else if (stack.peek().equals("\\begin{subsection}")) {

                    if (
                            input.equals("\\begin{section}") ||
                                    input.equals("\\end{section}") ||
                                    input.equals("\\end{subsubsection}") ||
                                    input.equals("\\end{text}") ||
                                    !input.startsWith("\\")
                    ) {
                        answer = false;
                        break;
                    }

                } else if (stack.peek().equals("\\begin{subsubsection}")) {
                    if (
                            input.equals("\\begin{section}") ||
                                    input.equals("\\end{section}") ||
                                    input.equals("\\begin{subsection}") ||
                                    input.equals("\\end{subsection}") ||
                                    input.equals("\\end{text}") ||
                                    !input.startsWith("\\")
                    ) {
                        answer = false;
                        break;
                    }


                } else if (stack.peek().equals("\\begin{text}")) {
                    if (
                            input.equals("\\begin{section}") ||
                                    input.equals("\\end{section}") ||
                                    input.equals("\\begin{subsection}") ||
                                    input.equals("\\end{subsection}") ||
                                    input.equals("\\begin{subsubsection}") ||
                                    input.equals("\\end{subsubsection}")
                    ) {
                        answer = false;
                        break;
                    }
                }
            }

            if (input.startsWith("\\end") && stack.isEmpty()) {         //todo - ako pocneme da vnesuvame prvicno \end{...} elementi
                answer = false;
                break;
            }

            if (input.startsWith("\\end")) {
                if (!stack.peek().startsWith("\\")) {
                    if (!stack.isEmpty()) {
                        stack.pop();            //ako e tekst
                    } else {
                        answer = false;
                        break;
                    }
                }
                if (!stack.isEmpty()) {
                    stack.pop();        // ako e obicen tak
                } else {
                    {
                        answer = false;
                        break;
                    }
                }
            } else stack.push(input);

        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        System.out.println(answer);
    }
}

//  \begin{section}
//    \begin{subsection}
//        \begin{subsubsection}
//            \begin{text}
//             \end{text}
//        \end{subsubsection}
//    \end{subsection}
//\end{section}
//--------------------------------------------------------------------------------------------------------------------


//5
//\begin{section}
//\begin{text}
//text
//\end{text}
//\end{section}

//TRUE
//------------------------------------------------------------------------------------------------------------------


//4
//\begin{section}
//\begin{text}
//text
//\end{text}

//FALSE
//----------------------------------------------------------


//9
//\begin{section}
//\begin{subsection}
//\begin{subsubsection}
//\begin{text}
//text
//\end{text}
//\end{subsubsection}
//\end{subsection}
//\end{section}

//TRUE
//--------------------------------------------------------------


//15
//\begin{section}
//\begin{subsection}
//\begin{subsubsection}
//\begin{text}
//text
//\end{text}
//\end{subsubsection}
//\begin{text}
//text
//\end{text}
//\end{subsection}
//\begin{text}
//text
//\end{text}
//\end{section}
//TRUE
//--------------------------------------------------------------


//14
//\begin{section}
//\begin{subsection}
//\begin{subsubsection}
//\begin{text}
//text
//\end{text}
//\end{subsubsection}
//\begin{text}
//text
//\end{text}
//\end{subsection}
//\begin{text}
//text
//\end{text}
//FALSE
//--------------------------------------------------------------


//9
//\end{text}
//\end{subsubsection}
//\begin{text}
//text
//\end{text}
//\end{subsection}
//\begin{text}
//text
//\end{text}
//FALSE

//--------------------------------------------------------------
