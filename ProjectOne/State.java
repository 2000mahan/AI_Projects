import java.util.ArrayList;

public class State {
    private ArrayList<Part> state;

    public State (ArrayList state){
        this.state  = new ArrayList<Part>(state);

    }

    public void setState(ArrayList<Part> state) {
        this.state = state;
    }

    public ArrayList<Part> getState() {
        return state;
    }
}
