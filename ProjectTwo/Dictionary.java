import java.util.ArrayList;

public class Dictionary {
    public ArrayList<String> word;
    public ArrayList<Double> probability;
    public ArrayList<Integer> occurrence;

    public Dictionary(){
    this.word = new ArrayList<String>();
    this.probability = new ArrayList<Double>();
    this.occurrence = new ArrayList<Integer>();
    }

    public void setWord(ArrayList<String> word) {
        this.word = word;
    }

    public ArrayList<String> getWord() {
        return word;
    }

    public void setProbability(ArrayList<Double> probability) {
        this.probability = probability;
    }

    public ArrayList<Double> getProbability() {
        return probability;
    }

    public void setOccurrence(ArrayList<Integer> occurrence) {
        this.occurrence = occurrence;
    }

    public ArrayList<Integer> getOccurrence() {
        return occurrence;
    }
}
