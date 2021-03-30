import javax.swing.*;
import java.util.ArrayList;

public class Node {
    private State currentState;
    private State parent;
    private int wholeCards;
    private ArrayList<State> children;
    private ArrayList<Node> childrenNode;
    private int nodeDepth;
    private int heuristic;
    private int cost;
    private int total;

    public Node(State currentState, State parent, int wholeCards) {
        this.currentState = currentState;
        this.parent = parent;
        children = new ArrayList<State>();
        childrenNode = new ArrayList<Node>();
        this.wholeCards = wholeCards;
        this.heuristic = 0;
        this.evaluationFunction();
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setParent(State parent) {
        this.parent = parent;
    }

    public State getParent() {
        return parent;
    }

    public void setChildren(ArrayList<State> children) {
        this.children = children;
    }

    public ArrayList<State> getChildren() {
        return children;
    }

    private void Strategy(int partNumber) {
        int numberOfCards = this.currentState.getState().get(partNumber).getCards().size();
        Card lastCard;
        if (numberOfCards != 1)
            lastCard = this.currentState.getState().get(partNumber).getCards().get(numberOfCards - 1);
        else
            lastCard = null;
        if (numberOfCards != 1)
            for (int m = 0; m < this.currentState.getState().size(); m++) {
                int numberOFCardsInPart = this.currentState.getState().get(m).getCards().size();
                if (numberOFCardsInPart != 1) {
                    Card lastCardInPart = this.currentState.getState().get(m).getCards().get(numberOFCardsInPart - 1);
                    if (m != partNumber) {
                        if (lastCard.getNumber() < lastCardInPart.getNumber()) {
                            State child = new State(this.createChild().getState());
                            child.getState().get(m).getCards().add(child.getState().get(partNumber).getCards().get(numberOfCards - 1));
                            child.getState().get(partNumber).getCards().remove(numberOfCards - 1);
                            this.children.add(child);


                        }
                    }
                }
                else {
                   Card lastCardInPart = this.currentState.getState().get(m).getCards().get(numberOFCardsInPart - 1);
                    State child = new State(this.createChild().getState());
                    child.getState().get(m).getCards().add(child.getState().get(partNumber).getCards().get(numberOfCards - 1));
                    child.getState().get(partNumber).getCards().remove(numberOfCards - 1);
                    this.children.add(child);

                }

            }
    }
    public void action() {
        for (int i = 0; i < this.currentState.getState().size(); i++)
            this.Strategy(i);
                this.creatChildNode();
                this.evaluationFunction();
                for(int o = 0;o < this.childrenNode.size();o++){
                    this.getChildrenNode().get(o).setNodeDepth(this.nodeDepth + 1);
                    this.childrenNode.get(o).evaluationFunction();
                }
    }

    private State createChild() {
        ArrayList<Part> parts = new ArrayList<Part>();
        for (int i = 0; i < this.currentState.getState().size(); i++) {
            ArrayList<Card> cards = new ArrayList<Card>();
            for (int j = 0; j < this.currentState.getState().get(i).getCards().size(); j++) {
                Card card = new Card();
                card = this.currentState.getState().get(i).getCards().get(j);
                cards.add(card);
            }
            Part part = new Part(cards);
            parts.add(part);

        }
        State child = new State(parts);
        return child;
    }

    public boolean goalTest() {
        int firstCondition = 1;
        int secondCondition = 1;
        int thirdCondition = 0;
        int fourthCondition = 0;
        int fifthCondition = 0;
        int sixthCondition = 0;
        int includingCard = 0;
        for (int i = 0; i < this.currentState.getState().size(); i++) {
            if (this.currentState.getState().get(i).getCards().size() != 1){
                includingCard++;
                for (int j = 1; j < this.currentState.getState().get(i).getCards().size() - 1; j++) {
                    if (this.currentState.getState().get(i).getCards().get(j).getColor().equals(this.currentState.getState().get(i).getCards().get(j + 1).getColor()))
                        firstCondition++;
                    if (this.currentState.getState().get(i).getCards().get(j).getNumber() - this.currentState.getState().get(i).getCards().get(j + 1).getNumber() > 0)
                        secondCondition++;

                }
        }

            if(firstCondition == this.currentState.getState().get(i).getCards().size() - 1 && secondCondition == this.currentState.getState().get(i).getCards().size() - 1)
            thirdCondition++;
            firstCondition = 1;
            secondCondition = 1;

        }
        if(thirdCondition == includingCard)
          fourthCondition = 1;
        for (int n = 0; n < this.currentState.getState().size(); n++){
            if(this.currentState.getState().get(n).getCards().size() - 1 == this.wholeCards || this.currentState.getState().get(n).getCards().size() == 1)
                fifthCondition++;

        }
        if(this.currentState.getState().size() == fifthCondition)
        sixthCondition = 1;

    if (fourthCondition == 1 && sixthCondition == 1)
        return true;
    else
        return false;



    }

    private void creatChildNode(){
        int numberOfChildren = this.children.size();
        ArrayList<Node> myChildrenNode = new ArrayList<Node>();
        for(int i = 0; i < numberOfChildren;i++){
            Node childNode = new Node(this.children.get(i),this.currentState, this.wholeCards);
            myChildrenNode.add(childNode);
        }
            this.childrenNode = myChildrenNode;

    }

    public void setChildrenNode(ArrayList<Node> childrenNode) {
        this.childrenNode = childrenNode;
    }

    public ArrayList<Node> getChildrenNode() {
        return childrenNode;
    }

    public void setNodeDepth(int nodeDepth) {
        this.nodeDepth = nodeDepth;
    }

    public int getNodeDepth() {
        return nodeDepth;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public int getWholeCards() {
        return wholeCards;
    }

    public void setWholeCards(int wholeCards) {
        this.wholeCards = wholeCards;
    }
    public void evaluationFunction(){
        this.heuristic = 0;
        this.cost = this.nodeDepth;
        for(int g = 0;g < this.nodeDepth;g++){
            this.cost = this.cost + g;
        }
        for(int p = 0;p < this.currentState.getState().size();p++){
            if(this.currentState.getState().get(p).getCards().size() == 1 || this.currentState.getState().get(p).getCards().size() == 2){
                this.heuristic = this.heuristic + 0;
            }
            else
            for(int q = 1;q < this.currentState.getState().get(p).getCards().size() - 1;q++){
               int lastElement = this.currentState.getState().get(p).getCards().size() - 1;
                 if(!this.currentState.getState().get(p).getCards().get(q).getColor().equals(this.currentState.getState().get(p).getCards().get(q + 1).getColor())){
                     this.heuristic = this.heuristic + (lastElement - q);   // Heuristic

                 }
            }

        }
        this.total = this.cost + this.heuristic;


    }
}