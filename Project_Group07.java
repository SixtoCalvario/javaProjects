//Initial file setup: 
import java.util.Scanner;
public class Project_Group07 {
    
    public static void main(String[] args) {
        //Main Code: 
        Scanner reader = new Scanner(System.in);
        //Input: 
        //Looping the problem 5 times, for 5 inputs: 
        for(int loop = 0; loop<5; loop++){
            System.out.print("Enter in your input: ");
            String s = reader.nextLine();
            //User Array: 
            String [] userInput = new String[s.split("/").length]; 
            userInput = s.split("/");
            //The users word:
            String word = userInput[userInput.length-1]; 
            //Answer for later: 
            String answer = "";
            for(int i=0; i<userInput.length; i++){
                //The shift amount for the first 4 operations: 
                String shift1 = ""+(userInput[i].charAt(userInput[i].length()-1));
                //Condition to call the appropriate method: 
                if(userInput[i].contains("LS-")){
                    answer = leftShift(word, shift1);
                }
                if(userInput[i].contains("RS-")){
                    answer = rightShift(word, shift1);
                }
                if(userInput[i].contains("LC-")){
                    answer = leftCircle(word, shift1);
                }
                if(userInput[i].contains("RC-")){
                    answer = rightCircle(word, shift1);
                }
                if(userInput[i].contains("MC-")){
                    //The starting position for the last 2 operations: 
                    String sPos = ""+(userInput[i].charAt(userInput[i].indexOf("-")+1));
                    //The length for the last 2 operations: 
                    String length = ""+(userInput[i].charAt(userInput[i].indexOf("-")+2));
                    //The shift for the MC-SLXD operation: 
                    String shift2 = ""+(userInput[i].charAt(userInput[i].indexOf("-")+3));
                    //The direction for the MC-SLXD operation: 
                    String direction = shift1;
                    answer = subCircle(word, sPos, length, shift2, direction);
                }
                if(userInput[i].contains("REV-")){
                    //The starting position for the last 2 operations:
                    String sPos = ""+(userInput[i].charAt(userInput[i].indexOf("-")+1));
                    //The length for the last 2 operations: 
                    String length = ""+(userInput[i].charAt(userInput[i].indexOf("-")+2));
                    answer = reverse(word, sPos, length);
                }
                word = answer;
            }
            //OUTPUT: 
            //FINAL ANSWER: 
            System.out.println("Reuslt: "+answer);
        } // end of main loop
        
    } // end of main method
    
    public static String leftShift(String userWord, String shiftAmount) {
        // shift amount gets parsed into an int 
        int shift = Integer.parseInt(shiftAmount);
        // the new string holds the non deleted data 
        String newString = userWord.substring(shift);
        // #'s are added at the end to represent how many were shifted out 
        for(int i = newString.length(); i<userWord.length(); i++){
            newString+="#";
        }
        return newString; 
        
    }
    
    public static String rightShift(String userWord, String shiftAmount) {
        // shift amount gets parsed into an int
        int shift = Integer.parseInt(shiftAmount); 
        String newString = "";
        //The subShift holds the value of the string that's going to be shifted
        String subShift = userWord.substring(0,userWord.length()-shift);
        for(int i=0; i<shift; i++) {
            newString+="#";
        }
        //Adding the #'s to the subShift
        newString += subShift;
        return newString; 
    }
    
    public static String leftCircle(String userWord, String shiftAmount){
        // shift amount gets parsed into an int
        int shift = Integer.parseInt(shiftAmount); 
        // new String takes the end of the og string makes it the new start
        String newString = userWord.substring(shift);
        // end of new String is added to the beginning of the users word
        newString+=userWord.substring(0,shift);
        return newString; 
    }
    
    public static String rightCircle(String userWord, String shiftAmount){
        //shift amount gets parsed into an int
        int shift = Integer.parseInt(shiftAmount);
        //new String holds the value of the rightmost x characters and adds them to the beginning characters
        String newString = userWord.substring(userWord.length()-shift) + userWord.substring(0,userWord.length()-shift);
        return newString;
    }
    
    public static String subCircle(String userWord, String startPos, String sLength, String shiftAmount, String direction){
        //Variables:
        int pos = Integer.parseInt(startPos);
        int length = Integer.parseInt(sLength);
        int shift = Integer.parseInt(shiftAmount);
        //Arrays for storage: 
        String userChars = userWord.substring((pos-1), (pos-1)+length);
        String [] chars = userChars.split("");
        String [] lastChars = new String[chars.length];
        String newString = "";
        //Right
        String holder;
        int change; 
        if(direction.equals("R")){
            //Shifting the values: 
            for(int i=0; i<chars.length; i++){
                if((i+shift)<chars.length){
                    lastChars[i+shift]=chars[i];
                }
                else{
                    change = (i+shift)-chars.length;
                    lastChars[change]=chars[i];
                }
            }
            //Converting userChars back into a string: 
            userChars = "";
            for(int i=0; i<lastChars.length; i++){
                userChars+=lastChars[i];
            }
            //Reuslt: 
            newString = userWord.substring(0,(pos-1)) + userChars + userWord.substring(((pos-1)+length));
        }
        //Line separating Right vs. Left: 
        //Left
        else{
            //Shifting the values: 
            for(int i = 0; i<chars.length; i++){
                    if(i-shift==0){
                        lastChars[0]=chars[i];
                    }
                    else if(i>shift){
                        lastChars[(i-shift)]=chars[i];
                    }
                    else{
                        lastChars[(chars.length - (Math.abs((i-shift))))]=chars[i];
                    }
            }
            //Converting userChars back into a string: 
            userChars = "";
            for(int i=0; i<lastChars.length; i++){
                userChars+=lastChars[i];
            }
            //Result: 
            newString = userWord.substring(0,(pos-1)) + userChars + userWord.substring((pos-1)+length);
        }
        return newString;
    }
    
    public static String reverse(String userWord, String startPos, String sLength) {
        // startPos and sLength get parsed to ints 
         int beginning = Integer.parseInt(startPos);
         int length = Integer.parseInt(sLength); 
         
        // takes the section that will be reversed
         String nonReversedSection = userWord.substring(beginning-1,(beginning+length-1));
         String reversedSection = "";
        // loop reverses the section 
         for(int i=length; i>0; i--) {
             reversedSection+=""+(nonReversedSection.charAt(i-1));
         }
        // part 1 holds the beginning of the String and the reversed part
         String part1 = userWord.substring(0,beginning-1)+reversedSection;
        // part 2 holds end of the String; 
         String part2 = userWord.substring(part1.length());

         String newString = part1+part2; 
        return newString;
    }
    
} // end of class




