//Problem 02: Cell Data
import java.util.Scanner;
import java.util.Arrays;
public class Problem02{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        // take the first 3 inputs to store the cell data
        String[] XYZ = new String[3]; // [0] = x,  [1] = y,  [2] = z
        for (int i = 0; i <3; i++) {
            System.out.print("Enter Cell Data: ");
            XYZ[i] = input.nextLine().toUpperCase();
        }
        // the next 6 lines of input are for operations
        String operation = "";
        for (int i = 0; i < 6; i++) {
            System.out.print("Enter Cell Operation"+(i+1)+" : ");
            operation = input.nextLine().toUpperCase();
            System.out.println(operator(XYZ, operation));
        }
    }


    // divides cell into 2 cells 
    public static String divide(String cellChoice) {
        String cell1 = cellChoice.substring(0,4)+cellChoice.substring(0,4);
        String cell2 = cellChoice.substring(4)+cellChoice.substring(4);
        return cell1+" and "+cell2;
    }


    // ADDn
    public static String add(String cellChoice, int n) {
        int m = cellChoice.length()-n;
        String firstBit = cellChoice.substring(0,(n));
        return firstBit+cellChoice.substring(0,m);
    }


    // SUBTRACTn
    public static String subtract(String cellChoice, int n) {
        String lastBit = cellChoice.substring(cellChoice.length()-n);
        String missingFirstBit = cellChoice.substring(n);
        String sortedLastBit = alphabetize(lastBit);
        return missingFirstBit+sortedLastBit;
    }

    // UNION
    public static String union(String cell1, String cell2) {
        // final 4 bits of cell 1
        String lastBits =  alphabetize(cell1.substring(4)) ;
        // first 4 bits of cell2
        String firstBits = alphabetize(cell2.substring(0,4));
        return lastBits+firstBits;
    }

    // INTERSECT
    public static String intersect(String cell1, String cell2) {
        String part1 = alphabetize(cell1.substring(0,2)+cell1.substring(6));
        String part2 = alphabetize(cell2.substring(0,2)+cell2.substring(6));
        return part1+part2;
    }
    

    // sorts a str alphabetically by assigning it to an array and sorting it! 
    public static String alphabetize(String word) {
        String[] wordArray = new String[word.length()];
        for (int i = 0; i<word.length(); i++) {
            wordArray[i] = ""+word.charAt(i);
        }
        Arrays.sort(wordArray);
        String sortedWord = "";        
        for (int i = 0; i <word.length(); i++) {
            sortedWord+=wordArray[i];
        }
        return sortedWord;
    }
    
    public static String operator(String[] letters, String userInput) {
        String[] inputArray = userInput.split(" ");
        String cell1 = "";
        String cell2 = "";

        // reading array from back to start
        for (int i = (inputArray.length-1); i>=0; i--) {
            
            if(inputArray[i].contains("ADD")) {
                cell2 = inputArray[i+1];
                if(cell2.equals("X")) {
                    cell2 = letters[0];
                }
                if(cell2.equals("Y")){
                    cell2 = letters[1];
                }
                if(cell2.equals("Z")) {
                    cell2 = letters[2];
                }
                int n = Integer.parseInt(""+(inputArray[i].charAt(inputArray[i].length()-1)));
                cell2 = add(cell2, n);
            }


            if(inputArray[i].contains("SUB")) {
                cell2 = inputArray[i+1];
                if(cell2.equals("X")) {
                    cell2 = letters[0];
                }
                if(cell2.equals("Y")){
                    cell2 = letters[1];
                }
                if(cell2.equals("Z")) {
                    cell2 = letters[2];
                }
                int n = Integer.parseInt(""+(inputArray[i].charAt(inputArray[i].length()-1)));
                cell2 = subtract(cell2, n);
            }


            if(inputArray[i].contains("UNI")) {
                // this is done when there are no other operations
                if(inputArray.length==3){
                    if(inputArray[1].equals("X")) {
                        cell1 = letters[0];
                    }
                    if(inputArray[1].equals("Y")) {
                        cell1 = letters[1];
                    }
                    if(inputArray[1].equals("Z")) {
                        cell1 = letters[2];
                    }

                    if(inputArray[2].equals("X")) {
                        cell2 = letters[0];
                    }
                    if(inputArray[2].equals("Y")) {
                        cell2 = letters[1];
                    }
                    if(inputArray[2].equals("Z")) {
                        cell2 = letters[2];
                    }
                    cell1 = union(cell1, cell2);
                }
                // this is done when there is other operations performed
                else{
                    cell1 = union(cell1, cell2);
                }
            }

            if(inputArray[i].contains("INT")) {
                // this is done when there are no other operations
                if(inputArray.length==3){
                    if(inputArray[1].equals("X")) {
                        cell1 = letters[0];
                    }
                    if(inputArray[1].equals("Y")) {
                        cell1 = letters[1];
                    }
                    if(inputArray[1].equals("Z")) {
                        cell1 = letters[2];
                    }

                    if(inputArray[2].equals("X")) {
                        cell2 = letters[0];
                    }
                    if(inputArray[2].equals("Y")) {
                        cell2 = letters[1];
                    }
                    if(inputArray[2].equals("Z")) {
                        cell2 = letters[2];
                    }
                    cell1 = intersect(cell1, cell2);
                }
                // this is done when there is other operations performed
                else{
                    cell1 = intersect(cell1, cell2);
                }
            }

            if(inputArray[i].contains("DIV")) {
                cell1 = inputArray[i+1];
                if(cell1.equals("X")) {
                    cell2 = letters[0];
                }
                if(cell1.equals("Y")){
                    cell2 = letters[1];
                }
                if(cell1.equals("Z")) {
                    cell2 = letters[2];
                }
                cell2 = divide(cell2); 
            }

        }




    }
}