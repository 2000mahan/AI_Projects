import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Test {
    private ArrayList<String> unigramWord;
    private ArrayList<String> biogramWord;
    private ArrayList<Dictionary> dictionaries;
    private ArrayList<Double> probability;
    private int poet;
    private double epsilon;
    private double lambda1;
    private double lambda2;
    private double lambda3;
    private int answer;
    private int guess;
    private double finalResult1;
    private double finalResult2;
    private double finalResult3;

    public Test(double epsilon, double lambda1, double lambda2, double lambda3, String answer){
    this.unigramWord = new ArrayList<String>();
    this.biogramWord = new ArrayList<String>();
    this.dictionaries = new ArrayList<Dictionary>();
    this.probability = new ArrayList<Double>();
    this.epsilon = epsilon;
    this.lambda1 = lambda1;
    this.lambda2 = lambda2;
    this.lambda3 = lambda3;
    this.answer = Integer.parseInt(answer);
    this.finalResult1 = 0;
    this.finalResult2 = 0;
    this.finalResult3 = 0;


    }

    public void setUnigramWord(ArrayList<String> unigramWord) {
        this.unigramWord = unigramWord;
    }

    public ArrayList<String> getUnigramWord() {
        return unigramWord;
    }

    public void setBiogramWord(ArrayList<String> biogramWord) {
        this.biogramWord = biogramWord;
    }

    public ArrayList<String> getBiogramWord() {
        return biogramWord;
    }

    public void setDictionaries(ArrayList<Dictionary> dictionaries) {
        this.dictionaries = dictionaries;
    }

    public ArrayList<Dictionary> getDictionaries() {
        return dictionaries;
    }

    public void setPoet(int poet) {
        this.poet = poet;
    }

    public int getPoet() {
        return poet;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setLambda1(double lambda1) {
        this.lambda1 = lambda1;
    }

    public double getLambda1() {
        return lambda1;
    }

    public void setLambda2(double lambda2) {
        this.lambda2 = lambda2;
    }

    public double getLambda2() {
        return lambda2;
    }

    public void setLambda3(double lambda3) {
        this.lambda3 = lambda3;
    }

    public double getLambda3() {
        return lambda3;
    }

    public void setProbability(ArrayList<Double> probability) {
        this.probability = probability;
    }

    public ArrayList<Double> getProbability() {
        return probability;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getGuess() {
        return guess;
    }

    public void probabilityCalculator(){
        ArrayList<Double> probability1 = new ArrayList<Double>();
        ArrayList<Double> probability2 = new ArrayList<Double>();
        ArrayList<Double> probability3 = new ArrayList<Double>();
        // Ferdowsi
    for(int i = 0;i < this.getBiogramWord().size();i++){
        int foundProductOne = 0;
        int foundProductTwo = 0;
        double productOne = 0;
        double productTwo = 0;
        double productThree = this.epsilon * this.lambda1;
        double finalProduct = 0;
          String[] arrSplit  = this.getBiogramWord().get(i).split(" ");

                if(this.dictionaries.get(1).getWord().contains(this.getBiogramWord().get(i))){
                   int place = this.dictionaries.get(1).getWord().indexOf(this.getBiogramWord().get(i));
                   productOne = this.dictionaries.get(1).getProbability().get(place) * this.lambda3;
                    foundProductOne = 1;

                }

                if(this.dictionaries.get(0).getWord().contains(arrSplit[1])){
                    int place = this.dictionaries.get(0).getWord().indexOf(arrSplit[1]);
                    productTwo = this.dictionaries.get(0).getProbability().get(place) * this.lambda2;
                    foundProductTwo = 1;
                }




        if(foundProductOne == 0)
            productOne = 0 * this.lambda3;

        if(foundProductTwo == 0)
            productTwo = 0 * this.lambda2;

        finalProduct = productOne + productTwo + productThree;
        probability1.add(finalProduct);

    }
    finalResult1 = 1;
    for(int p = 0;p < probability1.size();p++){
        finalResult1 *= probability1.get(p);
    }

    this.probability.add(finalResult1);
    // Hafez
        for(int i = 0;i < this.getBiogramWord().size();i++){
            int foundProductOne = 0;
            int foundProductTwo = 0;
            double productOne = 0;
            double productTwo = 0;
            double productThree = this.epsilon * this.lambda1;
            double finalProduct = 0;
            String[] arrSplit  = this.getBiogramWord().get(i).split(" ");


            if(this.dictionaries.get(3).getWord().contains(this.getBiogramWord().get(i))){
                int place = this.dictionaries.get(3).getWord().indexOf(this.getBiogramWord().get(i));
                productOne = this.dictionaries.get(3).getProbability().get(place) * this.lambda3;
                foundProductOne = 1;

            }

            if(this.dictionaries.get(2).getWord().contains(arrSplit[1])){
                int place = this.dictionaries.get(2).getWord().indexOf(arrSplit[1]);
                productTwo = this.dictionaries.get(2).getProbability().get(place) * this.lambda2;
                foundProductTwo = 1;
            }



            if(foundProductOne == 0)
                productOne = 0 * this.lambda3;

            if(foundProductTwo == 0)
                productTwo = 0 * this.lambda2;

            finalProduct = productOne + productTwo + productThree;
            probability2.add(finalProduct);

        }
        finalResult2 = 1;
        for(int p = 0;p < probability2.size();p++){
            finalResult2 *= probability2.get(p);
        }
        this.probability.add(finalResult2);
    // Molavi
        for(int i = 0;i < this.getBiogramWord().size();i++){
            int foundProductOne = 0;
            int foundProductTwo = 0;
            double productOne = 0;
            double productTwo = 0;
            double productThree = this.epsilon * this.lambda1;
            double finalProduct = 0;
            String[] arrSplit  = this.getBiogramWord().get(i).split(" ");

            if(this.dictionaries.get(5).getWord().contains(this.getBiogramWord().get(i))){
                int place = this.dictionaries.get(5).getWord().indexOf(this.getBiogramWord().get(i));
                productOne = this.dictionaries.get(5).getProbability().get(place) * this.lambda3;
                foundProductOne = 1;

            }

            if(this.dictionaries.get(4).getWord().contains(arrSplit[1])){
                int place = this.dictionaries.get(4).getWord().indexOf(arrSplit[1]);
                productTwo = this.dictionaries.get(4).getProbability().get(place) * this.lambda2;
                foundProductTwo = 1;
            }


            if(foundProductOne == 0)
                productOne = 0 * this.lambda3;

            if(foundProductTwo == 0)
                productTwo = 0 * this.lambda2;

            finalProduct = productOne + productTwo + productThree;
            probability3.add(finalProduct);

        }
        finalResult3 = 1;
        for(int p = 0;p < probability3.size();p++){
            finalResult3 *= probability3.get(p);
        }
        this.probability.add(finalResult3);

        this.compare();
    }

    private void compare(){
        int index = this.probability.indexOf(Collections.max(this.probability));
        this.guess = index + 1;
    }

}

