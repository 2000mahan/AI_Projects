import java.util.ArrayList;

public class Node {
    private State state;
    private Node parent;
    private ArrayList<Node> children;

    public Node(State state){
    this.state = state;
    this.children = new ArrayList<Node>();
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }
    public int action(){

        for(int k = 0;k < this.state.getLocations().size();k++){
            if(!this.state.getLocations().get(k).getColor().equals("#") && this.state.getLocations().get(k).getNumber().equals("*")) {
                state.setColorConstraints(k);
            }
            if(this.state.getLocations().get(k).getColor().equals("#") && !this.state.getLocations().get(k).getNumber().equals("*"))
                state.setNumberConstraints(k);
            if(!this.state.getLocations().get(k).getColor().equals("#") && !this.state.getLocations().get(k).getNumber().equals("*")) {
                state.setColorConstraints(k);
                state.setNumberConstraints(k);
                state.setNumberAndColorConstraints(k);
            }
        }
      int selectedVariable = this.state.MRVHeuristic();
      Location variable;
      variable = this.state.getLocations().get(this.state.MRVHeuristic());
        if(!variable.getColor().equals("#") && variable.getNumber().equals("*")){
            Node node1 = null;
            for(int l = 0;l < this.getState().getLocations().get(this.state.MRVHeuristic()).getNumberConstraints().size();l++) {
                node1 = this.createNode();
                node1.getState().getLocations().get(this.state.MRVHeuristic()).setNumber(node1.getState().getLocations().get(this.state.MRVHeuristic()).getNumberConstraints().get(l));
                node1.getState().getLocations().get(this.state.MRVHeuristic()).setNumberConstraints(null);
                this.children.add(node1);
                node1.state.setNumberConstraints(this.state.MRVHeuristic());
                node1.state.setNumberAndColorConstraints(this.state.MRVHeuristic());
            }
        }

        if(variable.getColor().equals("#") && !variable.getNumber().equals("*")){
            Node node2 = null;
            for(int m = 0;m < this.getState().getLocations().get(this.state.MRVHeuristic()).getColorConstraints().size();m++) {
                node2 = this.createNode();
                node2.getState().getLocations().get(this.state.MRVHeuristic()).setColor(node2.getState().getLocations().get(this.state.MRVHeuristic()).getColorConstraints().get(m));
                node2.getState().getLocations().get(this.state.MRVHeuristic()).setColorConstraints(null);
                this.children.add(node2);
                node2.state.setColorConstraints(this.state.MRVHeuristic());
                node2.state.setNumberAndColorConstraints(this.state.MRVHeuristic());
            }
        }

        if(variable.getColor().equals("#") && variable.getNumber().equals("*")) {
            Node node3 = null;
            for (int n = 0; n < this.getState().getLocations().get(this.state.MRVHeuristic()).getColorConstraints().size(); n++) {
                    node3 = this.createNode();
                    node3.getState().getLocations().get(this.state.MRVHeuristic()).setColor(node3.getState().getLocations().get(this.state.MRVHeuristic()).getColorConstraints().get(n));
                    node3.getState().getLocations().get(this.state.MRVHeuristic()).setColorConstraints(null);
                    this.children.add(node3);
                    node3.state.setColorConstraints(this.state.MRVHeuristic());

                }

            for (int p = 0; p < this.getState().getLocations().get(this.state.MRVHeuristic()).getNumberConstraints().size(); p++){
                    node3 = this.createNode();
                    node3.getState().getLocations().get(this.state.MRVHeuristic()).setNumber(node3.getState().getLocations().get(this.state.MRVHeuristic()).getNumberConstraints().get(p));
                    node3.getState().getLocations().get(this.state.MRVHeuristic()).setNumberConstraints(null);
                    this.children.add(node3);
                    node3.state.setNumberConstraints(this.state.MRVHeuristic());
                }
        }
       // System.out.println(this.state.MRVHeuristic());
         return this.state.MRVHeuristic();

    }
    public boolean goalTest(){
        int locationCounter = 0;
    for(int i = 0;i < this.state.getLocations().size();i++){
      if(!this.state.getLocations().get(i).getNumber().equals("*") && !this.state.getLocations().get(i).getColor().equals("#")){
        locationCounter++;
      }
    }

    if (locationCounter == this.state.getLocations().size())
        return true;
    else
        return false;

    }

    public Node createNode(){
        ArrayList<Location> newLocations = new ArrayList<Location>();
        Location newLocation;
        Location oldLocation;
        for(int i = 0;i < this.state.getLocations().size();i++){
            oldLocation = this.state.getLocations().get(i);
            newLocation = new Location(this.state.getLocations().get(i).getLocation());
            newLocation.setColor(oldLocation.getColor());
            newLocation.setLocation(oldLocation.getLocation());
            newLocation.setNumber(oldLocation.getNumber());
            if(oldLocation.getColorConstraints() != null)
            for(int p = 0;p < oldLocation.getColorConstraints().size();p++){
                newLocation.getColorConstraints().add(oldLocation.getColorConstraints().get(p));
            }
            else
                newLocation.setColorConstraints(null);

            if(oldLocation.getNumberConstraints() != null)
            for(int q = 0;q < oldLocation.getNumberConstraints().size();q++){
                newLocation.getNumberConstraints().add(oldLocation.getNumberConstraints().get(q));
            }
            else
                newLocation.setNumberConstraints(null);

            newLocations.add(newLocation);
        }
        State newState = new State(newLocations);
        newState.setN(this.state.getN());
        newState.setProblemColor(this.state.getProblemColor());
        Node child = new Node(newState);
        return child;

    }

}
