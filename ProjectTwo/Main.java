import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
        // Ferdowsi
        ArrayList<String> unigramWordFerdowsi = new ArrayList<String>();
        ArrayList<String> biogramWordFerdowsi = new ArrayList<String>();
        Dictionary unigramFerdowsi = new Dictionary();
        Dictionary biogramFerdowsi = new Dictionary();

        // pass the path to the file as a parameter
        File file =
                new File("src/ferdowsi_train.txt");
        Scanner scan = new Scanner(file);


        while (scan.hasNextLine()) {
            unigramWordFerdowsi.add("<s>");
            String input = scan.nextLine();
            String[] arrSplit = input.split(" ");
            //Adding words to dictionary
            int i = 0;
            for (i = 0; i < arrSplit.length; i++) {
                unigramWordFerdowsi.add(arrSplit[i]);

                if (i == 0)
                    biogramWordFerdowsi.add("<s>" + " " + arrSplit[i]);
                else
                    biogramWordFerdowsi.add(arrSplit[i - 1] + " " + arrSplit[i]);
            }

            biogramWordFerdowsi.add(arrSplit[i - 1] + " " + "</s>");
            unigramWordFerdowsi.add("</s>");

        }


        //Unigram
        //removing words with less than twice occurrence & calculating occurrence of each word for unigram model
        for (int p = 0; p < unigramWordFerdowsi.size(); p++) {
            int counter = 0;
            for (int q = 0; q < unigramWordFerdowsi.size(); q++) {
                if (unigramWordFerdowsi.get(q).equals(unigramWordFerdowsi.get(p)))
                    counter++;
            }
            if (counter < 2) {
                String lessThanTwice = unigramWordFerdowsi.get(p);
                for (int l = p + 1; l < unigramWordFerdowsi.size(); l++) {
                    if (unigramWordFerdowsi.get(l).equals(lessThanTwice))
                        unigramWordFerdowsi.remove(l);
                }

            } else {
                String moreThanTwice = unigramWordFerdowsi.get(p);
                for (int l = p + 1; l < unigramWordFerdowsi.size(); l++) {
                    if (unigramWordFerdowsi.get(l).equals(moreThanTwice))
                        unigramWordFerdowsi.remove(l);
                }
                unigramFerdowsi.getWord().add(moreThanTwice);
                unigramFerdowsi.getOccurrence().add(counter);

            }

        }
        //unigram model probabilities
        for (int j = 0; j < unigramFerdowsi.getWord().size(); j++) {
            Double d1 = new Double(unigramFerdowsi.getOccurrence().get(j));
            Double d2 = new Double(unigramFerdowsi.getWord().size());
            double probability = d1 / d2;
            unigramFerdowsi.getProbability().add(probability);

        }


        //biogram
        //removing pair words with less than twice occurrence & calculating occurrence of each word for biogram model
        for (int p = 0; p < biogramWordFerdowsi.size(); p++) {
            int counter = 0;
            for (int q = 0; q < biogramWordFerdowsi.size(); q++) {
                if (biogramWordFerdowsi.get(q).equals(biogramWordFerdowsi.get(p)))
                    counter++;
            }
            if (counter < 2) {
                String lessThanTwice = biogramWordFerdowsi.get(p);
                for (int l = p + 1; l < biogramWordFerdowsi.size(); l++) {
                    if (biogramWordFerdowsi.get(l).equals(lessThanTwice))
                        biogramWordFerdowsi.remove(l);
                }

            } else {
                String moreThanTwice = biogramWordFerdowsi.get(p);
                for (int l = p + 1; l < biogramWordFerdowsi.size(); l++) {
                    if (biogramWordFerdowsi.get(l).equals(moreThanTwice))
                        biogramWordFerdowsi.remove(l);
                }
                biogramFerdowsi.getWord().add(moreThanTwice);
                biogramFerdowsi.getOccurrence().add(counter);

            }

        }
        //biogram model probabilities
        for (int j = 0; j < biogramFerdowsi.getWord().size(); j++) {
            Double d1 = new Double(biogramFerdowsi.getOccurrence().get(j));
            String[] split = biogramFerdowsi.getWord().get(j).split(" ");
            int index = unigramFerdowsi.getWord().indexOf(split[0]);
            Double d2 = new Double(unigramFerdowsi.getOccurrence().get(index));
            double probability = d1 / d2;
            biogramFerdowsi.getProbability().add(probability);
        }


        // Hafez
        ArrayList<String> unigramWordHafez = new ArrayList<String>();
        ArrayList<String> biogramWordHafez = new ArrayList<String>();
        Dictionary unigramHafez = new Dictionary();
        Dictionary biogramHafez = new Dictionary();

        // pass the path to the file as a parameter
        File file1 =
                new File("src/hafez_train.txt");
        Scanner scan1 = new Scanner(file1);


        while (scan1.hasNextLine()) {
            unigramWordHafez.add("<s>");
            String input = scan1.nextLine();
            String[] arrSplit = input.split(" ");
            //Adding words to dictionary
            int i = 0;
            for (i = 0; i < arrSplit.length; i++) {
                unigramWordHafez.add(arrSplit[i]);

                if (i == 0)
                    biogramWordHafez.add("<s>" + " " + arrSplit[i]);

                else
                    biogramWordHafez.add(arrSplit[i - 1] + " " + arrSplit[i]);
            }
            biogramWordHafez.add(arrSplit[i - 1] + " " + "</s>");
            unigramWordHafez.add("</s>");
        }


        //Unigram
        //removing words with less than twice occurrence & calculating occurrence of each word for unigram model
        for (int p = 0; p < unigramWordHafez.size(); p++) {
            int counter = 0;
            for (int q = 0; q < unigramWordHafez.size(); q++) {
                if (unigramWordHafez.get(q).equals(unigramWordHafez.get(p)))
                    counter++;
            }
            if (counter < 2) {
                String lessThanTwice = unigramWordHafez.get(p);
                for (int l = p + 1; l < unigramWordHafez.size(); l++) {
                    if (unigramWordHafez.get(l).equals(lessThanTwice))
                        unigramWordHafez.remove(l);
                }

            } else {
                String moreThanTwice = unigramWordHafez.get(p);
                for (int l = p + 1; l < unigramWordHafez.size(); l++) {
                    if (unigramWordHafez.get(l).equals(moreThanTwice))
                        unigramWordHafez.remove(l);
                }
                unigramHafez.getWord().add(moreThanTwice);
                unigramHafez.getOccurrence().add(counter);

            }

        }
        //unigram model probabilities
        for (int j = 0; j < unigramHafez.getWord().size(); j++) {
            Double d1 = new Double(unigramHafez.getOccurrence().get(j));
            Double d2 = new Double(unigramHafez.getWord().size());
            double probability = d1 / d2;
            unigramHafez.getProbability().add(probability);

        }

        //biogram
        //removing pair words with less than twice occurrence & calculating occurrence of each word for biogram model
        for (int p = 0; p < biogramWordHafez.size(); p++) {
            int counter = 0;
            for (int q = 0; q < biogramWordHafez.size(); q++) {
                if (biogramWordHafez.get(q).equals(biogramWordHafez.get(p)))
                    counter++;
            }
            if (counter < 2) {
                String lessThanTwice = biogramWordHafez.get(p);
                for (int l = p + 1; l < biogramWordHafez.size(); l++) {
                    if (biogramWordHafez.get(l).equals(lessThanTwice))
                        biogramWordHafez.remove(l);
                }

            } else {
                String moreThanTwice = biogramWordHafez.get(p);
                for (int l = p + 1; l < biogramWordHafez.size(); l++) {
                    if (biogramWordHafez.get(l).equals(moreThanTwice))
                        biogramWordHafez.remove(l);
                }
                biogramHafez.getWord().add(moreThanTwice);
                biogramHafez.getOccurrence().add(counter);

            }

        }
        //biogram model probabilities
        for (int j = 0; j < biogramHafez.getWord().size(); j++) {
            Double d1 = new Double(biogramHafez.getOccurrence().get(j));
            String[] split = biogramHafez.getWord().get(j).split(" ");
            int index = unigramHafez.getWord().indexOf(split[0]);
            Double d2 = new Double(unigramHafez.getOccurrence().get(index));
            double probability = d1 / d2;
            biogramHafez.getProbability().add(probability);
        }


        // Molavi
        ArrayList<String> unigramWordMolavi = new ArrayList<String>();
        ArrayList<String> biogramWordMolavi = new ArrayList<String>();
        Dictionary unigramMolavi = new Dictionary();
        Dictionary biogramMolavi = new Dictionary();

        // pass the path to the file as a parameter
        File file2 =
                new File("src/molavi_train.txt");
        Scanner scan2 = new Scanner(file2);

        while (scan2.hasNextLine()) {
            unigramWordMolavi.add("<s>");
            String input = scan2.nextLine();
            String[] arrSplit = input.split(" ");
            //Adding words to dictionary
            int i = 0;
            for (i = 0; i < arrSplit.length; i++) {
                unigramWordMolavi.add(arrSplit[i]);
                if (i == 0)
                    biogramWordMolavi.add("<s>" + " " + arrSplit[i]);

                else
                    biogramWordMolavi.add(arrSplit[i - 1] + " " + arrSplit[i]);
            }
            biogramWordMolavi.add(arrSplit[i - 1] + " " + "</s>");
            unigramWordMolavi.add("</s>");

        }


        //Unigram
        //removing words with less than twice occurrence & calculating occurrence of each word for unigram model
        for (int p = 0; p < unigramWordMolavi.size(); p++) {
            int counter = 0;
            for (int q = 0; q < unigramWordMolavi.size(); q++) {
                if (unigramWordMolavi.get(q).equals(unigramWordMolavi.get(p)))
                    counter++;
            }
            if (counter < 2) {
                String lessThanTwice = unigramWordMolavi.get(p);
                for (int l = p + 1; l < unigramWordMolavi.size(); l++) {
                    if (unigramWordMolavi.get(l).equals(lessThanTwice))
                        unigramWordMolavi.remove(l);
                }

            } else {
                String moreThanTwice = unigramWordMolavi.get(p);
                for (int l = p + 1; l < unigramWordMolavi.size(); l++) {
                    if (unigramWordMolavi.get(l).equals(moreThanTwice))
                        unigramWordMolavi.remove(l);
                }
                unigramMolavi.getWord().add(moreThanTwice);
                unigramMolavi.getOccurrence().add(counter);

            }

        }
        //unigram model probabilities
        for (int j = 0; j < unigramMolavi.getWord().size(); j++) {
            Double d1 = new Double(unigramMolavi.getOccurrence().get(j));
            Double d2 = new Double(unigramMolavi.getWord().size());
            double probability = d1 / d2;
            unigramMolavi.getProbability().add(probability);

        }

        //biogram
        //removing pair words with less than twice occurrence & calculating occurrence of each word for biogram model
        for (int p = 0; p < biogramWordMolavi.size(); p++) {
            int counter = 0;
            for (int q = 0; q < biogramWordMolavi.size(); q++) {
                if (biogramWordMolavi.get(q).equals(biogramWordMolavi.get(p)))
                    counter++;
            }
            if (counter < 2) {
                String lessThanTwice = biogramWordMolavi.get(p);
                for (int l = p + 1; l < biogramWordMolavi.size(); l++) {
                    if (biogramWordMolavi.get(l).equals(lessThanTwice))
                        biogramWordMolavi.remove(l);
                }

            } else {
                String moreThanTwice = biogramWordMolavi.get(p);
                for (int l = p + 1; l < biogramWordMolavi.size(); l++) {
                    if (biogramWordMolavi.get(l).equals(moreThanTwice))
                        biogramWordMolavi.remove(l);
                }
                biogramMolavi.getWord().add(moreThanTwice);
                biogramMolavi.getOccurrence().add(counter);

            }

        }
        //biogram model probabilities
        for (int j = 0; j < biogramMolavi.getWord().size(); j++) {
            Double d1 = new Double(biogramMolavi.getOccurrence().get(j));
            String[] split = biogramMolavi.getWord().get(j).split(" ");
            int index = unigramMolavi.getWord().indexOf(split[0]);
            Double d2 = new Double(unigramMolavi.getOccurrence().get(index));
            double probability = d1 / d2;
            biogramMolavi.getProbability().add(probability);
        }

        // Testing
        System.out.println("Enter epsilon: lambda1: lambda2: lambda3:");
        Scanner value = new Scanner(System.in);
        double epsilon = value.nextDouble();
        double lambda1 = value.nextDouble();
        double lambda2 = value.nextDouble();
        double lambda3 = value.nextDouble();
        File file3 =
                new File("src/test_file.txt");
        Scanner scan3 = new Scanner(file3);

        ArrayList<Test> tests = new ArrayList<Test>();
        while (scan3.hasNextLine()) {
            String input = scan3.nextLine();
            String[] initialArrSplit = input.split("\t");
            String[] arrSplit = initialArrSplit[1].split(" ");
            Test myTest = new Test(epsilon, lambda1, lambda2, lambda3, initialArrSplit[0]);
            myTest.getDictionaries().add(unigramFerdowsi);
            myTest.getDictionaries().add(biogramFerdowsi);
            myTest.getDictionaries().add(unigramHafez);
            myTest.getDictionaries().add(biogramHafez);
            myTest.getDictionaries().add(unigramMolavi);
            myTest.getDictionaries().add(biogramMolavi);
            myTest.getUnigramWord().add("<s>");
            //Adding words to Test Class
            int i = 0;
            for (i = 0; i < arrSplit.length; i++) {
                myTest.getUnigramWord().add(arrSplit[i]);

                if (i == 0)
                    myTest.getBiogramWord().add("<s>" + " " + arrSplit[i]);

                else
                    myTest.getBiogramWord().add(arrSplit[i - 1] + " " + arrSplit[i]);
            }

            myTest.getBiogramWord().add(arrSplit[i - 1] + " " + "</s>");
            myTest.getUnigramWord().add("</s>");
            tests.add(myTest);

        }

        double accuracyCounter = 0;
        double accuracy = 0;
        for(int k = 0;k < tests.size();k++){
            tests.get(k).probabilityCalculator();
            if(tests.get(k).getAnswer() == tests.get(k).getGuess()){
                accuracyCounter++;
            }
        }
        Double d = new Double(tests.size());
        accuracy = (accuracyCounter/tests.size()) * 100;
        System.out.println(accuracy + "%");



    }


    }


