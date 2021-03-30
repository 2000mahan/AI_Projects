import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        scan.nextLine(); // in order to skip current line
        Location location;
        State state;
        ArrayList<String> inputColor = new ArrayList<String>();
            String problemColor = scan.nextLine();
            String[] arrSplitColor = problemColor.split(" ");
            for (int j = 0; j < arrSplitColor.length; j++)
                inputColor.add(arrSplitColor[j]);
             Color color = new Color(inputColor);


        ArrayList<Location> locations = new ArrayList<Location>();
        for (int i = 0; i < n; i++) {
            String inputPart = scan.nextLine();
            String[] arrSplit = inputPart.split(" ");
            for (int j = 0; j < arrSplit.length; j++) {
                location = new Location(arrSplit[j]);
                if (location.getColor().equals("#")) {
                    for(int w = 0;w < color.getColor().size();w++){
                        location.getColorConstraints().add(color.getColor().get(w));
                    }
                }
                else
                    location.setColorConstraints(null);

                if (location.getNumber().equals("*")) {
                    ArrayList<String> numbers = new ArrayList<String>();
                    for (int o = 1; o <= n; o++) {
                        String integer = Integer.toString(o);
                        numbers.add(integer);
                    }
                    location.setNumberConstraints(numbers);
                }
                else
                    location.setNumberConstraints(null);

                locations.add(location);

            }
        }

            state = new State(locations);
                    state.setN(n);
                    state.setProblemColor(color);
                    for(int k = 0;k < locations.size();k++){
                        if(!locations.get(k).getColor().equals("#") && locations.get(k).getNumber().equals("*")) {
                            state.setColorConstraints(k);
                        }
                        if(locations.get(k).getColor().equals("#") && !locations.get(k).getNumber().equals("*"))
                            state.setNumberConstraints(k);
                        if(!locations.get(k).getColor().equals("#") && !locations.get(k).getNumber().equals("*")) {
                            state.setColorConstraints(k);
                            state.setNumberConstraints(k);
                            state.setNumberAndColorConstraints(k);
                        }
                    }

             Node initialNode = new Node(state);
                 //   for(int i = 0; i < state.getLocations().size();i++){
                   //     System.out.println(state.getLocations().get(i).getNumberConstraints());
                     //  System.out.println(state.getLocations().get(i).getColorConstraints());
                       // System.out.println("hi");

                   // }


             Problem problem = new Problem(initialNode);


    }
}