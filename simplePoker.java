import java.util.Scanner; 
import java.util.Arrays; 
public class simplePoker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // creation of scanner for input
        System.out.print("Enter 5 cards as ints seperated by commas: ");  // user input 
        String userStr = input.nextLine(); 
        input.close(); 
        String[] strArray = userStr.split(",");  // convert the str to an array

        int[] userIntArray = new int[strArray.length];   // make a int[] that has same values as the og str[]
        for (int i = 0; i<strArray.length; i++) {
            userIntArray[i] = Integer.parseInt(strArray[i])-1;
        }
        System.out.print(rankCheck(userIntArray)); // call rankCheck and print out the best hand 
    }
    
    public static String[] makeCards() {  // method makes an array of cards 
        String[] cardSet = new String[52];
        int count = 0; 
        for(int i=1; i!=5; i++) {
            String currentSuit = ""; 
            if(i==1)
                currentSuit = "Diamonds";
            if(i==2)
                currentSuit = "Hearts";
            if(i==3)
                currentSuit = "Spades";
            if(i==4)
                currentSuit = "Clubs";
            for(int j=0; j<13; j++) {
                if(j==0)
                    cardSet[j+count] = "Ace of "+currentSuit; 
                if(j==10)
                    cardSet[j+count] = "Jack of "+currentSuit;
                if(j==11)
                    cardSet[j+count] = "Queen of "+currentSuit;
                if(j==12)
                    cardSet[j+count] = "King of "+currentSuit;
                if(j>1 && j<11)
                    cardSet[j+count-1] = (""+j)+" of "+currentSuit;
            }
            count+=13;
        }
        return cardSet; // this returns an array of poker cards 
    }  

    public static String rankCheck(int[] usersCards) { // method determines the highest aura move to beat the lvl 1 crook 😎
        String[] pokerCards = makeCards(); 
        String[] userCardsStr = new String[usersCards.length];  // users int choices become actual cards now 
        for(int i=0; i<userCardsStr.length; i++) {
            userCardsStr[i] = pokerCards[usersCards[i]]; 
        }
        System.out.println(Arrays.toString(userCardsStr));


        // pair/three of kind/four of a kind - works
        boolean pair = false;
        boolean threeOfAKind = false;
        int same = 0;
        for(int i = 0; i<5; i++) {
            if( (userCardsStr[0].substring(0,1)).equals((userCardsStr[i].substring(0,1))) ) { // checks if three of a kind 
                same++;
                if(same==2){
                    pair = true;
                }
                if(same==3){
                    threeOfAKind = true; 
                }
                if(same==4){
                    return "FOUR OF A KIND";
                }
            }
        }

        // two pairs - works
        boolean twoPairs = false;
        for(int i = 2; i<5; i++){
            if( (userCardsStr[1].substring(0,1)).equals((userCardsStr[i].substring(0,1))) && pair) {  // checks if TWO pears
                twoPairs = true;
            }
            if(i!=2){
                if( (userCardsStr[2].substring(0,1)).equals((userCardsStr[i].substring(0,1))) && pair) {  // checks if TWO pears
                    twoPairs = true;
                }
            }
        }

        // flush works
        boolean flush = false; 
        int cardsEqual = 0;
        for(int j=0; j<5; j++){ // loop compares the last word of each card and if theyre all the same then its a flush!
            String[] lastWordArray = userCardsStr[0].split(" "); 
            String firstSuit = lastWordArray[lastWordArray.length-1];
            String[] otherLastWordArray = userCardsStr[j].split(" "); 
            String otherSuits = otherLastWordArray[otherLastWordArray.length-1]; 
            
            if( firstSuit.equals(otherSuits) ){
                cardsEqual++;
            }
            if(cardsEqual==5){
                flush = true;
            }
        }

        // fuller house 
        if(pair && threeOfAKind){
            return "FULL HOUSE";
        }

        // return statementes
        if(flush){
            return "FlUSH OMG FLUSH AHHH!";
        }
        if(threeOfAKind){
            return "THREE OF A KIND!";
        }
        if(twoPairs){
            return "TWO PAIRS";
        }
        if(pair){
            return "PAIR";
        }
    return "None. Quit. You lost. Bro give up. You're about to get cooked.";
    }
}   // end of class scope