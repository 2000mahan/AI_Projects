import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ProblemTwo {
    private Node initialNode;
    private LinkedList<Node> frontier;
    private int cardNum;
    private int limit;
    public ProblemTwo(State initialState, int cardNum) {
        this.limit = 0;
        this.initialNode = new Node(initialState, null, cardNum);
        this.frontier = new LinkedList<Node>();
        this.IDS(this.initialNode);
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

    public boolean IDS(Node node) {
        this.limit = 0;
        while (true) {
            node.setNodeDepth(0);
            this.frontier.add(node);
            while (!this.frontier.isEmpty()){
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

                myNode.action();
                for (int m = myNode.getChildrenNode().size() - 1; m >= 0; m--) {
                    if(myNode.getChildrenNode().get(m).getNodeDepth() != this.limit) {
                        this.frontier.addFirst(myNode.getChildrenNode().get(m));
                        this.frontier.get(0).setNodeDepth(myNode.getNodeDepth() + 1);
                    }
                }

            }
            this.limit++;
        }


    }
}
