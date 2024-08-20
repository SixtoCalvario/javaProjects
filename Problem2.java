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
    public static String theDivider(String[] letters, int cellChoice) {
        String cell1 = (letters[cellChoice]).substring(0,4)+(letters[cellChoice]).substring(0,4);
        String cell2 = (letters[cellChoice]).substring(4)+(letters[cellChoice]).substring(4);
        return cell1+" and "+cell2;
    }


    // ADDn
    public static String add(String[] letters, int n, int cellChoice) {
        int m = ((letters[cellChoice]).length())-n;
        String firstBit = (letters[cellChoice]).substring(0,(n));
        return firstBit+(letters[cellChoice]).substring(0,m);
    }


    // SUBTRACTn
    public static String subtract(String[] letters, int n, int cellChoice) {
        String cell = (letters[cellChoice]);
        String lastBit = cell.substring(cell.length()-n);
        String missingFirstBit = cell.substring(n);
        String sortedLastBit = alphabetize(lastBit);
        return missingFirstBit+sortedLastBit;
    }

    // UNION
    public static String union(String[] letters, int cellChoice1, int cellChoice2) {
        String cell1 = letters[cellChoice1];
        String cell2 = letters[cellChoice2]; 
        // final 4 bits of cell 1
        String lastBits =  alphabetize(cell1.substring(4)) ;
        // first 4 bits of cell2
        String firstBits = alphabetize(cell2.substring(0,4));
        return lastBits+firstBits;

    }

    // INTERSECT
    public static String intersect(String[] letters, int cellChoice1, int cellChoice2) {
        String cell1 = letters[cellChoice1];
        String cell2 = letters[cellChoice2];
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
        
        if( (inputArray.length) == 2 ) {
            return subOperator(inputArray[0], inputArray[1]);
        }


        for (int i = (inputArray.length-1); i>=0; i--) {
            // if 


        }




    }

    public static String subOperator(String action, String cell1, String cell2) {
        int n = 0;
        if (action.length == 4) {
            n = Integer.parseInt((""+action.charAt(3)));
            if(action.contains("ADD")){
                return
            }
            if(action.contains("SUB")){

            }

        }


    }


}