import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class State {
    private ArrayList<Location> locations;
    private ArrayList<Integer> locationSum;
    private int n;
    private Color problemColor;

    public State(ArrayList locations) {
        this.locations = new ArrayList<Location>(locations);

    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setProblemColor(Color problemColor) {
        this.problemColor = problemColor;
    }

    public Color getProblemColor() {
        return problemColor;
    }



    public void setColorConstraints(int place) {
        int mod = place % this.n;
        int quotient = place / this.n;
        String color;
        int specialCases = 0;
        color = this.locations.get(place).getColor();
        if (mod == 0 && quotient == 0) {

            if (!(color.equals("#")) && this.locations.get(place + 1).getColor().equals("#")) {
                this.locations.get(place + 1).getColorConstraints().remove(color);
            }

            if (!(color.equals("#")) && this.locations.get(place + this.n).getColor().equals("#")) {
                this.locations.get(place + this.n).getColorConstraints().remove(color);
            }
            specialCases++;

        }


        if (mod == (this.n - 1) && quotient == 0) {

            if (!(color.equals("#")) && this.locations.get(place - 1).getColor().equals("#")) {
                this.locations.get(place - 1).getColorConstraints().remove(color);
            }

            if (!(color.equals("#")) && this.locations.get(place + this.n).getColor().equals("#")) {
                this.locations.get(place + this.n).getColorConstraints().remove(color);
            }
            specialCases++;
        }


        if (mod == 0 && quotient == (this.n - 1)) {

            if (!(color.equals("#")) && this.locations.get(place + 1).getColor().equals("#")) {
                this.locations.get(place + 1).getColorConstraints().remove(color);
            }

            if (!(color.equals("#")) && this.locations.get(place - this.n).getColor().equals("#")) {
                this.locations.get(place - this.n).getColorConstraints().remove(color);
            }
            specialCases++;

        }

        if (mod == (this.n - 1) && quotient == (this.n - 1)) {

            if (!(color.equals("#")) && this.locations.get(place - 1).getColor().equals("#")) {
                this.locations.get(place - 1).getColorConstraints().remove(color);
            }

            if (!(color.equals("#")) && this.locations.get(place - this.n).getColor().equals("#")) {
                this.locations.get(place - this.n).getColorConstraints().remove(color);
            }
            specialCases++;

        }

        if (mod == 0 && (quotient != 0 && quotient != (this.n - 1))) {

            if (!(color.equals("#")) && this.locations.get(place + 1).getColor().equals("#")) {
                this.locations.get(place + 1).getColorConstraints().remove(color);
            }

            if (!(color.equals("#")) && this.locations.get(place + this.n).getColor().equals("#")) {
                this.locations.get(place + this.n).getColorConstraints().remove(color);
            }

            if (!(color.equals("#")) && this.locations.get(place - this.n).getColor().equals("#")) {
                this.locations.get(place - this.n).getColorConstraints().remove(color);
            }
            specialCases++;

        }

        if (mod == (this.n - 1) && (quotient != 0 && quotient != (this.n - 1))) {

            if (!(color.equals("#")) && this.locations.get(place - 1).getColor().equals("#")) {
                this.locations.get(place - 1).getColorConstraints().remove(color);
            }

            if (!(color.equals("#")) && this.locations.get(place + this.n).getColor().equals("#")) {
                this.locations.get(place + this.n).getColorConstraints().remove(color);
            }

            if (!(color.equals("#")) && this.locations.get(place - this.n).getColor().equals("#")) {
                this.locations.get(place - this.n).getColorConstraints().remove(color);
            }
            specialCases++;

        }


        if (specialCases == 0) {
            mod = place % this.n;
            if(mod != 0)
            if (!(color.equals("#")) && this.locations.get(place - 1).getColor().equals("#")) {
                this.locations.get(place - 1).getColorConstraints().remove(color);
            }
            if(mod != (this.n - 1))
            if (!(color.equals("#")) && this.locations.get(place + 1).getColor().equals("#")) {
                this.locations.get(place + 1).getColorConstraints().remove(color);
            }
            if(!(place + this.n > this.locations.size()))
            if (!(color.equals("#")) && this.locations.get(place + this.n).getColor().equals("#")) {
                this.locations.get(place + this.n).getColorConstraints().remove(color);
            }

            if(!(place - this.n < 0))
            if (!(color.equals("#")) && this.locations.get(place - this.n).getColor().equals("#")) {
                this.locations.get(place - this.n).getColorConstraints().remove(color);
            }

        }

    }

    public void setNumberConstraints(int place) {
        int mod = place % this.n;
        int quotient = place / this.n;
        String number;
        int specialCases = 0;
        int columnHead = place - mod;
        int rowHead = place - (quotient * this.n);

        for (int i = rowHead; i <= (rowHead + ((this.n - 1) * this.n)); i = i + this.n) {
            if (this.locations.get(i).getNumber().equals("*")) {
                this.locations.get(i).getNumberConstraints().remove(this.locations.get(place).getNumber());
            }

        }

        for (int i = columnHead; i < (columnHead + this.n); i++) {
            if (this.locations.get(i).getNumber().equals("*")) {
                this.locations.get(i).getNumberConstraints().remove(this.locations.get(place).getNumber());
            }

        }
    }

    public void setNumberAndColorConstraints(int place) {
        int mod = place % this.n;
        int quotient = place / this.n;
        int specialCases = 0;
        if (!locations.get(place).getNumber().equals("*") && !locations.get(place).getColor().equals("#")) {
            if (mod == 0 && quotient == 0) {
                specialCases++;
                if (!locations.get(place + 1).getColor().equals("#") && locations.get(place + 1).getNumber().equals("*")) {

                    if (this.problemColor.getColor().indexOf(locations.get(place + 1).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y < this.locations.get(place + 1).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place + 1).getNumberConstraints().get(y)))
                            this.locations.get(place + 1).getNumberConstraints().remove(y);

                        }

                    }

                    if (this.problemColor.getColor().indexOf(locations.get(place + 1).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y <  this.locations.get(place + 1).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place + 1).getNumberConstraints().get(y)))
                            this.locations.get(place + 1).getNumberConstraints().remove(y);
                        }

                    }
                }

                if (locations.get(place + 1).getColor().equals("#") && !locations.get(place + 1).getNumber().equals("*")) {
                    if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place + 1).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                            if(this.locations.get(place + 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place + 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place + 1).getColorConstraints().remove(index);
                            }
                            }
                    }

                    if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place + 1).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                            if(this.locations.get(place + 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                               int index = this.locations.get(place + 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place + 1).getColorConstraints().remove(index);

                            }
                        }

                    }
                }


                /////
                if (!locations.get(place + this.n).getColor().equals("#") && locations.get(place + this.n).getNumber().equals("*")) {

                    if (this.problemColor.getColor().indexOf(locations.get(place + this.n).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y < this.locations.get(place + this.n).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place + this.n).getNumberConstraints().get(y)))
                                this.locations.get(place + this.n).getNumberConstraints().remove(y);

                        }

                    }

                    if (this.problemColor.getColor().indexOf(locations.get(place + this.n).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y <  this.locations.get(place + this.n).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place + this.n).getNumberConstraints().get(y)))
                                this.locations.get(place + this.n).getNumberConstraints().remove(y);
                        }

                    }
                }

                if (locations.get(place + this.n).getColor().equals("#") && !locations.get(place + this.n).getNumber().equals("*")) {
                    if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place + this.n).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                            if(this.locations.get(place + this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place + this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place + this.n).getColorConstraints().remove(index);
                            }
                        }
                    }

                    if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place + this.n).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                            if(this.locations.get(place + this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place + this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place + this.n).getColorConstraints().remove(index);

                            }
                        }

                    }
                }

            }


            if (mod == 0 && quotient == (this.n - 1)) {
                specialCases++;
                if (!locations.get(place + 1).getColor().equals("#") && locations.get(place + 1).getNumber().equals("*")) {

                    if (this.problemColor.getColor().indexOf(locations.get(place + 1).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y < this.locations.get(place + 1).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place + 1).getNumberConstraints().get(y)))
                                this.locations.get(place + 1).getNumberConstraints().remove(y);

                        }

                    }

                    if (this.problemColor.getColor().indexOf(locations.get(place + 1).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y <  this.locations.get(place + 1).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place + 1).getNumberConstraints().get(y)))
                                this.locations.get(place + 1).getNumberConstraints().remove(y);
                        }

                    }
                }

                if (locations.get(place + 1).getColor().equals("#") && !locations.get(place + 1).getNumber().equals("*")) {
                    if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place + 1).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                            if(this.locations.get(place + 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place + 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place + 1).getColorConstraints().remove(index);
                            }
                        }
                    }

                    if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place + 1).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                            if(this.locations.get(place + 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place + 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place + 1).getColorConstraints().remove(index);

                            }
                        }

                    }
                }


                /////
                if (!locations.get(place - this.n).getColor().equals("#") && locations.get(place - this.n).getNumber().equals("*")) {

                    if (this.problemColor.getColor().indexOf(locations.get(place - this.n).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y < this.locations.get(place - this.n).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place - this.n).getNumberConstraints().get(y)))
                                this.locations.get(place - this.n).getNumberConstraints().remove(y);

                        }

                    }

                    if (this.problemColor.getColor().indexOf(locations.get(place - this.n).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y <  this.locations.get(place - this.n).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place - this.n).getNumberConstraints().get(y)))
                                this.locations.get(place - this.n).getNumberConstraints().remove(y);
                        }

                    }
                }

                if (locations.get(place - this.n).getColor().equals("#") && !locations.get(place - this.n).getNumber().equals("*")) {
                    if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place - this.n).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                            if(this.locations.get(place - this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place - this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place - this.n).getColorConstraints().remove(index);
                            }
                        }
                    }

                    if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place - this.n).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                            if(this.locations.get(place - this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place - this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place - this.n).getColorConstraints().remove(index);

                            }
                        }

                    }
                }


            }


            if (mod == (this.n - 1) && quotient == 0) {
                specialCases++;
                if (!locations.get(place - 1).getColor().equals("#") && locations.get(place - 1).getNumber().equals("*")) {

                    if (this.problemColor.getColor().indexOf(locations.get(place - 1).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y < this.locations.get(place - 1).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place - 1).getNumberConstraints().get(y)))
                                this.locations.get(place - 1).getNumberConstraints().remove(y);

                        }

                    }

                    if (this.problemColor.getColor().indexOf(locations.get(place - 1).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y <  this.locations.get(place - 1).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place - 1).getNumberConstraints().get(y)))
                                this.locations.get(place - 1).getNumberConstraints().remove(y);
                        }

                    }
                }

                if (locations.get(place - 1).getColor().equals("#") && !locations.get(place - 1).getNumber().equals("*")) {
                    if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place - 1).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                            if(this.locations.get(place - 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place - 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place - 1).getColorConstraints().remove(index);
                            }
                        }
                    }

                    if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place - 1).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                            if(this.locations.get(place - 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place - 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place - 1).getColorConstraints().remove(index);

                            }
                        }

                    }
                }

                if (!locations.get(place + this.n).getColor().equals("#") && locations.get(place + this.n).getNumber().equals("*")) {

                    if (this.problemColor.getColor().indexOf(locations.get(place + this.n).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y < this.locations.get(place + this.n).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place + this.n).getNumberConstraints().get(y)))
                                this.locations.get(place + this.n).getNumberConstraints().remove(y);

                        }

                    }

                    if (this.problemColor.getColor().indexOf(locations.get(place + this.n).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y <  this.locations.get(place + this.n).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place + this.n).getNumberConstraints().get(y)))
                                this.locations.get(place + this.n).getNumberConstraints().remove(y);
                        }

                    }
                }

                if (locations.get(place + this.n).getColor().equals("#") && !locations.get(place + this.n).getNumber().equals("*")) {
                    if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place + this.n).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                            if(this.locations.get(place + this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place + this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place + this.n).getColorConstraints().remove(index);
                            }
                        }
                    }

                    if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place + this.n).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                            if(this.locations.get(place + this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place + this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place + this.n).getColorConstraints().remove(index);

                            }
                        }

                    }
                }


            }


            if (mod == (this.n - 1) && quotient == (this.n - 1)) {
                specialCases++;
                if (!locations.get(place - 1).getColor().equals("#") && locations.get(place - 1).getNumber().equals("*")) {

                    if (this.problemColor.getColor().indexOf(locations.get(place - 1).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y < this.locations.get(place - 1).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place - 1).getNumberConstraints().get(y)))
                                this.locations.get(place - 1).getNumberConstraints().remove(y);

                        }

                    }

                    if (this.problemColor.getColor().indexOf(locations.get(place - 1).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y <  this.locations.get(place - 1).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place - 1).getNumberConstraints().get(y)))
                                this.locations.get(place - 1).getNumberConstraints().remove(y);
                        }

                    }
                }

                if (locations.get(place - 1).getColor().equals("#") && !locations.get(place - 1).getNumber().equals("*")) {
                    if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place - 1).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                            if(this.locations.get(place - 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place - 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place - 1).getColorConstraints().remove(index);
                            }
                        }
                    }

                    if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place - 1).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                            if(this.locations.get(place - 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place - 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place - 1).getColorConstraints().remove(index);

                            }
                        }

                    }
                }

                if (!locations.get(place - this.n).getColor().equals("#") && locations.get(place - this.n).getNumber().equals("*")) {

                    if (this.problemColor.getColor().indexOf(locations.get(place - this.n).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y < this.locations.get(place - this.n).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place - this.n).getNumberConstraints().get(y)))
                                this.locations.get(place - this.n).getNumberConstraints().remove(y);

                        }

                    }

                    if (this.problemColor.getColor().indexOf(locations.get(place - this.n).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                        for (int y = 0; y <  this.locations.get(place - this.n).getNumberConstraints().size(); y++) {
                            if(Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place - this.n).getNumberConstraints().get(y)))
                                this.locations.get(place - this.n).getNumberConstraints().remove(y);
                        }

                    }
                }

                if (locations.get(place - this.n).getColor().equals("#") && !locations.get(place - this.n).getNumber().equals("*")) {
                    if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place - this.n).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                            if(this.locations.get(place - this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place - this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place - this.n).getColorConstraints().remove(index);
                            }
                        }
                    }

                    if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place - this.n).getNumber())) {
                        for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                            if(this.locations.get(place - this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                int index = this.locations.get(place - this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                this.locations.get(place - this.n).getColorConstraints().remove(index);

                            }
                        }

                    }
                }


            }


            if (specialCases == 0) {
                if (mod != 0) {
                    if (!locations.get(place - 1).getColor().equals("#") && locations.get(place - 1).getNumber().equals("*")) {

                        if (this.problemColor.getColor().indexOf(locations.get(place - 1).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                            for (int y = 0; y < this.locations.get(place - 1).getNumberConstraints().size(); y++) {
                                if (Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place - 1).getNumberConstraints().get(y)))
                                    this.locations.get(place - 1).getNumberConstraints().remove(y);

                            }

                        }

                        if (this.problemColor.getColor().indexOf(locations.get(place - 1).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                            for (int y = 0; y < this.locations.get(place - 1).getNumberConstraints().size(); y++) {
                                if (Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place - 1).getNumberConstraints().get(y)))
                                    this.locations.get(place - 1).getNumberConstraints().remove(y);
                            }

                        }
                    }

                    if (locations.get(place - 1).getColor().equals("#") && !locations.get(place - 1).getNumber().equals("*")) {
                        if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place - 1).getNumber())) {
                            for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                                if(this.locations.get(place - 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                    int index = this.locations.get(place - 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                    this.locations.get(place - 1).getColorConstraints().remove(index);
                                }
                            }
                        }

                        if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place - 1).getNumber())) {
                            for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                                if(this.locations.get(place - 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                    int index = this.locations.get(place - 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                    this.locations.get(place - 1).getColorConstraints().remove(index);

                                }
                            }

                        }
                    }
                }
                if (!(place - this.n < 0)) {
                    if (!locations.get(place - this.n).getColor().equals("#") && locations.get(place - this.n).getNumber().equals("*")) {

                        if (this.problemColor.getColor().indexOf(locations.get(place - this.n).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                            for (int y = 0; y < this.locations.get(place - this.n).getNumberConstraints().size(); y++) {
                                if (Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place - this.n).getNumberConstraints().get(y)))
                                    this.locations.get(place - this.n).getNumberConstraints().remove(y);

                            }

                        }

                        if (this.problemColor.getColor().indexOf(locations.get(place - this.n).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                            for (int y = 0; y < this.locations.get(place - this.n).getNumberConstraints().size(); y++) {
                                if (Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place - this.n).getNumberConstraints().get(y)))
                                    this.locations.get(place - this.n).getNumberConstraints().remove(y);
                            }

                        }
                    }

                    if (locations.get(place - this.n).getColor().equals("#") && !locations.get(place - this.n).getNumber().equals("*")) {
                        if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place - this.n).getNumber())) {
                            for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                                if(this.locations.get(place - this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                    int index = this.locations.get(place - this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                    this.locations.get(place - this.n).getColorConstraints().remove(index);
                                }
                            }
                        }

                        if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place - this.n).getNumber())) {
                            for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                                if(this.locations.get(place - this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                    int index = this.locations.get(place - this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                    this.locations.get(place - this.n).getColorConstraints().remove(index);

                                }
                            }

                        }
                    }
                }
                if (mod != (this.n - 1)) {
                    if (!locations.get(place + 1).getColor().equals("#") && locations.get(place + 1).getNumber().equals("*")) {

                        if (this.problemColor.getColor().indexOf(locations.get(place + 1).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                            for (int y = 0; y < this.locations.get(place + 1).getNumberConstraints().size(); y++) {
                                if (Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place + 1).getNumberConstraints().get(y)))
                                    this.locations.get(place + 1).getNumberConstraints().remove(y);

                            }

                        }

                        if (this.problemColor.getColor().indexOf(locations.get(place + 1).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                            for (int y = 0; y < this.locations.get(place + 1).getNumberConstraints().size(); y++) {
                                if (Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place + 1).getNumberConstraints().get(y)))
                                    this.locations.get(place + 1).getNumberConstraints().remove(y);
                            }

                        }
                    }

                    if (locations.get(place + 1).getColor().equals("#") && !locations.get(place + 1).getNumber().equals("*")) {
                        if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place + 1).getNumber())) {
                            for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                                if(this.locations.get(place + 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                    int index = this.locations.get(place + 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                    this.locations.get(place + 1).getColorConstraints().remove(index);
                                }
                            }
                        }

                        if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place + 1).getNumber())) {
                            for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                                if(this.locations.get(place + 1).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                    int index = this.locations.get(place + 1).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                    this.locations.get(place + 1).getColorConstraints().remove(index);

                                }
                            }

                        }
                    }
                }


                /////
                if (!(place + this.n > this.locations.size())){
                    if (!locations.get(place + this.n).getColor().equals("#") && locations.get(place + this.n).getNumber().equals("*")) {

                        if (this.problemColor.getColor().indexOf(locations.get(place + this.n).getColor()) > this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                            for (int y = 0; y < this.locations.get(place + this.n).getNumberConstraints().size(); y++) {
                                if (Integer.parseInt(this.locations.get(place).getNumber()) <= Integer.parseInt(this.locations.get(place + this.n).getNumberConstraints().get(y)))
                                    this.locations.get(place + this.n).getNumberConstraints().remove(y);

                            }

                        }

                        if (this.problemColor.getColor().indexOf(locations.get(place + this.n).getColor()) < this.problemColor.getColor().indexOf(locations.get(place).getColor())) {
                            for (int y = 0; y < this.locations.get(place + this.n).getNumberConstraints().size(); y++) {
                                if (Integer.parseInt(this.locations.get(place).getNumber()) >= Integer.parseInt(this.locations.get(place + this.n).getNumberConstraints().get(y)))
                                    this.locations.get(place + this.n).getNumberConstraints().remove(y);
                            }

                        }
                    }

                    if (locations.get(place + this.n).getColor().equals("#") && !locations.get(place + this.n).getNumber().equals("*")) {
                        if (Integer.parseInt(locations.get(place).getNumber()) > Integer.parseInt(locations.get(place + this.n).getNumber())) {
                            for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y >= 0; y--) {
                                if(this.locations.get(place + this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                    int index = this.locations.get(place + this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                    this.locations.get(place + this.n).getColorConstraints().remove(index);
                                }
                            }
                        }

                        if (Integer.parseInt(locations.get(place).getNumber()) < Integer.parseInt(locations.get(place + this.n).getNumber())) {
                            for (int y = this.problemColor.getColor().indexOf(this.locations.get(place).getColor()); y < this.problemColor.getColor().size(); y++) {
                                if(this.locations.get(place + this.n).getColorConstraints().contains(this.problemColor.getColor().get(y))) {
                                    int index = this.locations.get(place + this.n).getColorConstraints().indexOf(this.problemColor.getColor().get(y));
                                    this.locations.get(place + this.n).getColorConstraints().remove(index);

                                }
                            }

                        }
                    }
            }

            }


        }
    }


    public int MRVHeuristic() {
        int minConstraints = 0;
        int numberOfConstraints = 0;
        Location selectedLocation = null;
        int i = 0;
        for (i = 0; i < this.locations.size(); i++) {
            if (this.locations.get(i).getColor().equals("#") || this.locations.get(i).getNumber().equals("*")) {
                selectedLocation = this.locations.get(i);

                if (this.locations.get(i).getNumberConstraints() != null && this.locations.get(i).getColorConstraints() != null)
                    minConstraints = this.locations.get(i).getColorConstraints().size() + this.locations.get(i).getNumberConstraints().size();

                if (this.locations.get(i).getNumberConstraints() == null && this.locations.get(i).getColorConstraints() != null)
                    minConstraints = this.locations.get(i).getColorConstraints().size();

                if (this.locations.get(i).getNumberConstraints() != null && this.locations.get(i).getColorConstraints() == null)
                    minConstraints = this.locations.get(i).getNumberConstraints().size();

            break;

            }
        }

                    for (int j = i; j < this.locations.size(); j++) {

                        if (this.locations.get(j).getColor().equals("#") || this.locations.get(j).getNumber().equals("*")) {

                            if (this.locations.get(j).getColorConstraints() != null && this.locations.get(j).getNumberConstraints() != null)
                                numberOfConstraints = this.locations.get(j).getColorConstraints().size() + this.locations.get(j).getNumberConstraints().size();

                            if (this.locations.get(j).getColorConstraints() == null && this.locations.get(j).getNumberConstraints() != null)
                                numberOfConstraints = this.locations.get(j).getNumberConstraints().size();

                            if (this.locations.get(j).getColorConstraints() != null && this.locations.get(j).getNumberConstraints() == null)
                                numberOfConstraints = this.locations.get(j).getColorConstraints().size();

                            if (minConstraints > numberOfConstraints) {
                                selectedLocation = this.locations.get(j);
                                minConstraints = numberOfConstraints;
                            }
                        }

                        }

                  ArrayList<Integer> equalLocations = new ArrayList<Integer>();
                    int constraints = 0;
                    for(int k = 0;k < this.locations.size();k++){
                        if (this.locations.get(k).getColor().equals("#") || this.locations.get(k).getNumber().equals("*")) {

                            if (this.locations.get(k).getNumberConstraints() != null && this.locations.get(k).getColorConstraints() != null)
                                constraints = this.locations.get(k).getColorConstraints().size() + this.locations.get(k).getNumberConstraints().size();

                            if (this.locations.get(k).getNumberConstraints() == null && this.locations.get(k).getColorConstraints() != null)
                                constraints = this.locations.get(k).getColorConstraints().size();

                            if (this.locations.get(k).getNumberConstraints() != null && this.locations.get(k).getColorConstraints() == null)
                                constraints = this.locations.get(k).getNumberConstraints().size();


                            if(minConstraints == constraints)
                                equalLocations.add(k);
                        }

                    }




        ArrayList <Integer> degree = new ArrayList<Integer>();

        for (int u = 0; u < equalLocations.size(); u++) {
            degree.add(degreeHueristic(equalLocations.get(u)));
        }


        int minIndex = degree.indexOf(Collections.min(degree));

        //System.out.println(equalLocations.get(minIndex));

        return equalLocations.get(minIndex);

    }

    public int degreeHueristic(int place) {
        int mod = place % this.n;
        int quotient = place / this.n;
        String color;
        int specialCases = 0;
        int neighbours = 0;
        if (mod == 0 && quotient == 0) {
            specialCases++;
            if (this.locations.get(place + 1).getColor().equals("#") || this.locations.get(place + 1).getNumber().equals("*")) {
                neighbours++;
            }
            if (this.locations.get(place + this.n).getColor().equals("#") || this.locations.get(place + this.n).getNumber().equals("*")) {
                neighbours++;
            }

        }

        if (mod == 0 && quotient == (this.n - 1)) {
            specialCases++;
            if (this.locations.get(place + 1).getColor().equals("#") || this.locations.get(place + 1).getNumber().equals("*")) {
                neighbours++;
            }

            if (this.locations.get(place - this.n).getColor().equals("#") || this.locations.get(place - this.n).getNumber().equals("*")) {
                neighbours++;
            }

        }

        if (mod == (this.n - 1) && quotient == 0){
            specialCases++;
        if (this.locations.get(place - 1).getColor().equals("#") || this.locations.get(place - 1).getNumber().equals("*")){
            neighbours++;

            }
        if (this.locations.get(place + this.n).getColor().equals("#") || this.locations.get(place + this.n).getNumber().equals("*")) {
                neighbours++;
            }


        }

        if (mod == (this.n - 1) && quotient == (this.n - 1)){
            specialCases++;
            if (this.locations.get(place - 1).getColor().equals("#") || this.locations.get(place - 1).getNumber().equals("*")){
                neighbours++;

            }

            if (this.locations.get(place - this.n).getColor().equals("#") || this.locations.get(place - this.n).getNumber().equals("*")) {
                neighbours++;
            }

        }

        if(specialCases == 0){
            if(mod != 0)
            if (this.locations.get(place - 1).getColor().equals("#") || this.locations.get(place - 1).getNumber().equals("*")){
                neighbours++;

            }
            if(!(place - this.n < 0)) {
                if (this.locations.get(place - this.n).getColor().equals("#") || this.locations.get(place - this.n).getNumber().equals("*")) {
                    neighbours++;
                }
            }
            if(mod != (this.n - 1))
            if (this.locations.get(place + 1).getColor().equals("#") || this.locations.get(place + 1).getNumber().equals("*")) {
                neighbours++;
            }
            if(!(place + this.n > this.locations.size()))
            if (this.locations.get(place + this.n).getColor().equals("#") || this.locations.get(place + this.n).getNumber().equals("*")) {
                neighbours++;
            }


        }
        return neighbours;
    }

}
