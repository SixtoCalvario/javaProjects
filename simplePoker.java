import java.util.Scanner;
import java.util.Arrays; 
public class simplePoker {
    public static void main(String[] args) {  // start of main method
        Scanner input = new Scanner(System.in); // creation of scanner for input
        System.out.print("Enter 5 cards as ints seperated by commas: ");  // user input 
        String userStr = input.nextLine(); 
        input.close(); 

        String[] strArray = userStr.split(",");    // convert the str to an array
        
        int[] userIntArray = new int[strArray.length];   // make a int[] that has same values as str[]
        for (int i = 0; i<strArray.length; i++) {
            userIntArray[i] = Integer.parseInt(strArray[i])-1;
        }
        String[] cardsArray = makeCards(); 
        System.out.println(Arrays.toString(cardsArray));
        rankCheck(userIntArray); 

    }  // end of main method 
    

    public static String[] makeCards() {  // card method goes here
        String[] cardSet = new String[52];
        int count = 0; 

        for(int i=1; i!=5; i++) {
            String currentSuit = ""; 
            if(i==1){
                currentSuit = "Diamonds";
            }
            if(i==2){
                currentSuit = "Hearts";
            }
            if(i==3){
                currentSuit = "Spades";
            }

            if(i==4) {
                currentSuit = "Clubs";
            }

            for(int j=0; j<13; j++) {   // start of for loop j
                if(j==0) {
                    cardSet[j+count] = "Ace of "+currentSuit; 
                }
                if(j==10) {
                    cardSet[j+count] = "Jack of "+currentSuit;
                }  
                if(j==11) {
                    cardSet[j+count] = "Queen of "+currentSuit;
                }
                if(j==12) {
                    cardSet[j+count] = "King of "+currentSuit;
                }
                if(j>1 && j<11) {
                    cardSet[j+count-1] = (""+j)+" of "+currentSuit;
                }
            } // outside loop j
            count+=13;
        } // outside of loop i 
            // RETURNS ARRAY OF CARDS!
            return cardSet; 
    }    // end of card method 
    

    
    public static void rankCheck(int[] usersCards) {
        String[] pokerCards = makeCards(); 
        String[] userCardsStr = new String[usersCards.length];  // users int choices become actual cards now 
        
        for(int i=0; i<userCardsStr.length; i++) {
            userCardsStr[i] = pokerCards[usersCards[i]]; 
        }
        System.out.print(Arrays.toString(userCardsStr));

        // rank check section
        boolean pair = false;
        boolean twoPairs = false;
        boolean threeOfAKind = false; 
        for(int i=1; i<5; i++){
            if( (userCardsStr[0].substring(0,1)).equals((userCardsStr[i].substring(0,1)))){
                pair=true;
                if( (userCardsStr[1].substring(0,1)).equals((userCardsStr[i].substring(0,1)))){
                    twoPairs = true;
                    if((userCardsStr[2].substring(0,1)).equals((userCardsStr[i].substring(0,1)))) {
                        threeOfAKind = true;
                    }
                }
            }
        }
        
        boolean flush = false;
        int cardsEqual = 0;
        for(int i=0; i<5; i++){
            String[] lastWordArray = userCardsStr[0].split(" "); 
            String firstSuit = lastWordArray[lastWordArray.length-1];

            String[] otherLastWordArray = userCardsStr[i].split(" "); 
            String otherSuits = otherLastWordArray[otherLastWordArray.length-1];
            
            if( firstSuit.equals(otherSuits) ){
                cardsEqual++;
            }
            if(cardsEqual==5){
                flush = true;
            }
        }

        if(flush){
            System.out.println(flush);
        }
        // end of rank check section 


    }   // outside the scope of i loop 


}   // end of class scope