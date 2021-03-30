import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProblemThree {
    private Node initialNode;
    private ArrayList<Node> explored;
    private LinkedList<Node> frontier;
    private int cardNum;
    public ProblemThree(State initialState, int cardNum) {
        this.initialNode = new Node(initialState, null, cardNum);
        this.explored = new ArrayList<Node>();
        this.frontier = new LinkedList<Node>();
        this.AStar(this.initialNode);
    }

    public void setExplored(ArrayList<Node> explored) {
        this.explored = explored;
    }

    public ArrayList<Node> getExplored() {
        return explored;
    }

    public void setFrontier(LinkedList<Node> frontier) {
        this.frontier = frontier;
    }

    public Queue<Node> getFrontier() {
        return frontier;
    }

    public void setInitialNode(Node initialNode) {
        this.initialNode = initialNode;
    }

    public Node getInitialNode() {
        return initialNode;
    }

    public boolean AStar(Node node) {
            node.setNodeDepth(0);
            this.frontier.add(node);
            while (!this.frontier.isEmpty()){
                Node myNode = this.frontier.getFirst();
                for(int w = 0;w < this.frontier.size();w++){
                if(myNode.getTotal() > this.frontier.get(w).getTotal())
                myNode = this.frontier.get(w);
                }
                this.frontier.remove(myNode);
                this.explored.add(myNode);
                //Testing
                System.out.printf("State : ");
                System.out.println();
                for(int j = 0;j < initialNode.getCurrentState().getState().size();j++) {
                    if(myNode.getCurrentState().getState().get(j).getCards().size() != 1)
                        for(int n = 1;n < myNode.getCurrentState().getState().get(j).getCards().size();n++) {
                            System.out.print( myNode.getCurrentState().getState().get(j).getCards().get(n).getCard());
                            System.out.printf(" ");
                        }
                    else {
                        System.out.print( myNode.getCurrentState().getState().get(j).getCards().get(0).getCard());
                        System.out.printf(" ");
                    }
                    System.out.println();

                }
                //Testing


                if (myNode.goalTest())
                    return true; //Found goal
                myNode.action();
                for (int m = 0; m < myNode.getChildrenNode().size(); m++) {
                    if(!this.explored.contains(myNode.getChildrenNode().get(m)))
                    this.frontier.add(myNode.getChildrenNode().get(m));

                }


            }
        return false;
        }



    }

