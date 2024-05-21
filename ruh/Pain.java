import java.math.BigInteger;
import java.util.Scanner;

public class Pain {
    
    // Start of main method 
    public static void main(String[] args){

        // creation of scanner 
        Scanner input = new Scanner(System.in);

        // creation of BIG int 
        BigInteger userNum = new BigInteger("0");

        // user input 
        System.out.print("Enter a num bellow 10,000: ");
        int userInt = input.nextInt();
        input.close();

        // setting their int to a big int
        userNum = BigInteger.valueOf(userInt);

        // method checks if the user entered a lychrel num 
        reverse(userNum);
    }
    // end of main method 


    // start of lychrel num method 
    //public static String isLychrel(BigInteger num) {
        

   //} 
    // end of lychrel num method 

    // start of reverse method 
    public static String reverse(BigInteger numBeingReversed) {
        // connvert big int to a str
        int num1 = numBeingReversed.intValue();
        String num1Str = num1+"";

        // find the length so we can use it for a array
        int numLength = num1Str.length();
        
        // create a big int array 
        BigInteger[] bigArray = new BigInteger[numLength];

        // each int value gets assigned a big int array index
        for(int i=0; i<bigArray.length; i++) {
            bigArray[i] = BigInteger.valueOf(Integer.parseInt((num1Str.charAt(i)+"")));
        }

        // reverse cursed technique 
        BigInteger[] reversedArray = new BigInteger[numLength];
        for(int i=0; i<bigArray.length; i++) {
            reversedArray[numLength-1] = bigArray[i];
            numLength--;
        }

        String reverseString = "";
        for(int i=0; i<bigArray.length;i++){
            reverseString = reversedArray[i]+"";
        } 
        return reverseString;
    }
    // end of reverse method 

}
