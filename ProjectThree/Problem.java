import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem {
    private Node initialNode;
    private ArrayList<Node> explored;
    private LinkedList<Node> frontier;

    public Problem(Node initialNode){
        this.initialNode = initialNode;
        this.explored = new ArrayList<Node>();
        this.frontier = new LinkedList<Node>();
        this.backtracking(this.initialNode);
    }

    public void setInitialNode(Node initialNode) {
        this.initialNode = initialNode;
    }

    public Node getInitialNode() {
        return initialNode;
    }

    public void setFrontier(LinkedList<Node> frontier) {
        this.frontier = frontier;
    }

    public Queue<Node> getFrontier() {
        return frontier;
    }

    public void setExplored(ArrayList<Node> explored) {
        this.explored = explored;
    }

    public ArrayList<Node> getExplored() {
        return explored;
    }

    private boolean backtracking(Node initialNode){
    this.frontier.add(initialNode);
    this.frontier.poll();
    this.initialNode.action();
    this.explored.add(initialNode);
    for(int i = 0;i < initialNode.getChildren().size();i++){
        this.frontier.add(initialNode.getChildren().get(i));
    }
    while (!this.frontier.isEmpty()){
        Node myNode = this.frontier.poll();

        //Testing
        System.out.printf("State: ");
        System.out.println();
        for (int h = 0; h < myNode.getState().getLocations().size(); h++) {
            System.out.printf("%s%s ", myNode.getState().getLocations().get(h).getNumber(), myNode.getState().getLocations().get(h).getColor());

            if((h + 1) % myNode.getState().getN() == 0 && (h + 1) / myNode.getState().getN() + 1 > 0)
                System.out.println();
        }


        if (myNode.goalTest()){
            System.out.println("Goal State");
            return true; //Found goal
        }


        this.explored.add(myNode);
        int place = myNode.action();


        int counter = 0;
         //Constraints checking
         if(myNode.getState().getLocations().get(place).getColor().equals("#") && myNode.getState().getLocations().get(place).getColorConstraints().isEmpty())
              counter++;
        if(myNode.getState().getLocations().get(place).getNumber().equals("*") && myNode.getState().getLocations().get(place).getNumberConstraints().isEmpty())
             counter++;



        if(counter == 0)
        for (int m = myNode.getChildren().size() - 1; m >= 0; m--) {
            if(!this.frontier.contains(myNode.getChildren().get(m)) && !this.explored.contains(myNode.getChildren().get(m)))
                this.frontier.addFirst(myNode.getChildren().get(m));
        }
        counter = 0;


    }
        System.out.printf("Goal State Not Found");
        return false;


    }



    }

