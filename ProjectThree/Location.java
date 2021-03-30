import java.util.ArrayList;

public class Location {
    private String color;
    private String location;
    private String number;
    private ArrayList<String> colorConstraints;
    private ArrayList<String> numberConstraints;
    public Location(String location){
        this.location = location;
        this.createLocation(location);
        colorConstraints = new ArrayList<String>();
        numberConstraints = new ArrayList<String>();

    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setColorConstraints(ArrayList<String> colorConstraints) {
        this.colorConstraints = colorConstraints;
    }

    public ArrayList<String> getColorConstraints() {
        return colorConstraints;
    }

    public void setNumberConstraints(ArrayList<String> numberConstraints) {
        this.numberConstraints = numberConstraints;
    }

    public ArrayList<String> getNumberConstraints() {
        return numberConstraints;
    }

    private void createLocation(String location){
        this.color = location.substring(location.length() - 1);
          String numberAsString = location.substring(0, location.length() - 1);
           this.number = numberAsString;
           this.location = this.number + this.color;
        }

}
