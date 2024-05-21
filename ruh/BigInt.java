package ruh;
import java.util.*;
import java.math.BigInteger; 
public class BigInt{

    // Start of main method 
    public static void main(String[] args){

        // creation of scanner 
        Scanner input = new Scanner(System.in);

        // creation of BIG int 
        BigInteger userNum = new BigInteger("0");

        // user input 
        System.out.print("Enter a num bellow 10000: ");
        int userInt = input.nextInt();
        input.close();

        // setting their int to a big int
        userNum = BigInteger.valueOf(userInt);

        // method checks if the user entered a lychrel num 
        System.out.println(isLychrel(userNum));
    }
    // end of main method 




    // start of lychrel num method 
    public static String isLychrel(BigInteger num) {
        String notPal = "Your Number is a Lychrel Number!";

        // check till they are (well max 50)
        for(int i=0; i<50; i++) {
            num = num.add(reverse(num));
            if(isPalindrome(num) || isPalindrome(num)){
                String palString = "Your number is a palindrome after "+(i+"")+" iterations  - Palindrome Number: "+(num+"");
                return palString;
            }
        }
        
        return notPal; 
    } 
    // end of lychrel num method 




    // start of reverse method 
    public static BigInteger reverse(BigInteger num) {
        BigInteger bigZero = BigInteger.valueOf(0);
        BigInteger bigTen = BigInteger.valueOf(10);

        BigInteger reversedNum = bigZero;
         // jere we basically just reverse the  number
        for(; !(num.equals(bigZero)); num=num.divide(bigTen) ){
            BigInteger remainder = num.mod(bigTen);
            reversedNum = reversedNum.multiply(bigTen).add(remainder);
        }

        /* 
        sloppy mess omg
        while( !( ogNum.equals(bigZero) ) ) {
            BigInteger crumbs = num.mod(BigInteger.valueOf(10));
            reversedNum = (reversedNum.multiply(BigInteger.valueOf(10))).add(crumbs);
            num = num.divide(BigInteger.valueOf(10));
        }
         */
        return reversedNum;
    }
    // end of reverse method 




    // start of is palindrome method 
    public static boolean isPalindrome(BigInteger num1) {
        // num 1 & 2 is the numbers being compared
        return num1.equals(reverse(num1)); 
    }
    // end of is palindrome method 
}

