import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int m = scan.nextInt();
        int n = scan.nextInt();
        scan.nextLine(); // in order to skip current line
        Card card;
        Card cardSharp;
        Part part;
        ArrayList<Part> parts = new ArrayList<Part>();
        for (int i = 0; i < k; i++) {
            ArrayList<Card> cards = new ArrayList<Card>();
            String inputPart = scan.nextLine();

                String[] arrSplit = inputPart.split(" ");
                if(inputPart.equals("#")){
                    card = new Card(inputPart);
                    cards.add(card);
                }
                else {
                    cardSharp = new Card("#");
                    cards.add(cardSharp);
                    for (int j = 0; j < arrSplit.length; j++) {
                        card = new Card(arrSplit[j]);
                        cards.add(card);

                    }
                }

            part = new Part(cards);
            parts.add(part);
        }
        State initialState = new State(parts);
       // ProblemOne problemOne = new ProblemOne(initialState, n);
       // ProblemTwo problemTwo = new ProblemTwo(initialState, n);
       //ProblemThree problemThree = new ProblemThree(initialState, n);

    }
}