import java.util.ArrayList;

public class Part {
    private ArrayList<Card> cards;

    public Part(ArrayList cards){
        this.cards = new ArrayList<Card>(cards);
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }



}
