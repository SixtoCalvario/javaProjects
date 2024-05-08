import java.util.Scanner; 
import java.math.BigInteger; 
public class Lychrel{

    // Start of main method 
    public static void main(){
        // creation of scanner 
        Scanner input = new Scanner(System.in);
        // creation of BIG int 
        BigInteger A;
        // user input 
        System.out.print("Enter a num bellow 10,000: ");
        int userInt = input.nextInt();
        // setting their int to a big int
        A = BigInteger.valueOf(userInt);
    }
    // end of main method 


    // start of lychrel num method 
    public static String isLychrel(BigInteger num){
        
        // for loop iterates 50 times 
        for(int i=0; i<50; i++){

        }
    } 
    // end of lychrel num method 
}