public class Card {
    private String color;
    private String card;
    private int number;

    public Card(String card){
        this.card = card;
        this.createCard(card);

    }
    public Card(){

    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getCard() {
        return card;
    }
    private void createCard(String card){
        this.color = card.substring(card.length() - 1);
        if(!card.equals("#")) {
            String numberAsString = card.substring(0, card.length() - 1);
            this.number = Integer.parseInt(numberAsString);
        }

    }
}
