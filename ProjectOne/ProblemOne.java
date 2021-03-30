import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProblemOne {
    private Node initialNode;
    private ArrayList<Node> explored;
    private Queue<Node> frontier;
    private int cardNum;
    public ProblemOne(State initialState, int cardNum) {
        this.initialNode = new Node(initialState, null, cardNum);
        this.explored = new ArrayList<Node>();
        this.frontier = new LinkedList<Node>();
        this.BFS(this.initialNode);
    }

    public void setExplored(ArrayList<Node> explored) {
        this.explored = explored;
    }

    public ArrayList<Node> getExplored() {
        return explored;
    }

    public void setFrontier(Queue<Node> frontier) {
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

    public boolean BFS(Node node) {
        this.frontier.add(node);
        this.frontier.poll();
        node.action();
        int childrenNumber = node.getChildrenNode().size();
        for (int m = 0; m < childrenNumber; m++) {
            this.frontier.add(node.getChildrenNode().get(m));
        }
        this.explored.add(node);
        while (!this.frontier.isEmpty()) {
            Node myNode = this.frontier.poll();

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

            this.explored.add(myNode);
            myNode.action();
            for (int m = 0; m < myNode.getChildrenNode().size(); m++) {
                if(!this.frontier.contains(myNode.getChildrenNode().get(m)) && !this.explored.contains(myNode.getChildrenNode().get(m)))
                this.frontier.add(myNode.getChildrenNode().get(m));
            }
        }

            return false;

    }

}