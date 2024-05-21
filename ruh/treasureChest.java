package ruh;
/*
There is a treasure chest with 1 million dollars. 
The chest has a 6-digit combination lock that opens under the following conditions: 
the first digit should be equal to the third digit. *
the second digit should be even, *
the sum of the fourth, fifth and sixth digits should be divisible by 7. 
Write a program that reads one 6-digit positive integer and checks whether the input number opens the chest or not. 
The output should be YES if the chest opens and NO otherwise. Assume that the input is a positive number between 100000 and 999999.
*/
import java.util.Scanner;

// start of class 
    public class treasureChest{

// start of main method
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // takes user input 
    System.out.print("Enter the code: ");
    String userCode = input.nextLine(); 
    input.close(); 

    // the method returns if the code the user enters works  
    System.out.println(doesChestOpen(userCode));
}
// end of main method 


// method checks if chest opens
public static String doesChestOpen(String code) {

    // this string returns if it works
    String works = "YES";

    // this string returns if it doesnt work 
    String notWorks = "NO";

    // the users input gets split into individual ints 
    int digit1 = Integer.parseInt(code.charAt(0)+"");
    int digit2 = Integer.parseInt(code.charAt(1)+"");
    int digit3 = Integer.parseInt(code.charAt(2)+"");
    int digit4 = Integer.parseInt(code.charAt(3)+"");
    int digit5 = Integer.parseInt(code.charAt(4)+"");
    int digit6 = Integer.parseInt(code.charAt(5)+"");
    
    // sum of digits 4, 5, and 6
    int sum = digit4+digit5+digit6;

    // both have to be true for the chest to open
    boolean firstCheck = false;
    boolean secondCheck = false;

    // if statement checks if the first and third digits are equal and if the second digit is even 
    if( (digit1==digit3) && ((digit2%2)==0) ) {
        firstCheck = true;
    }

    // if statement checks if their sum is divisible by 7
    if( sum%7==0 ) {
        secondCheck = true;
    }

    // if both checks are true then the code works 
    if(firstCheck&&secondCheck) {
        return works;
    }
    else{
        return notWorks; 
    }
}
// end of this method 

}