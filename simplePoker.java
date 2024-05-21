import java.util.Scanner; 
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
    
    // method makes an array of cards 
    public static String[] makeCards() {
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

            for(int j=0; j<13; j++) {
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
            }
            count+=13;
        }
        return cardSet; 
    }  

    // method checks the aura level of the cards and determines the highest aura move to beat the lvl 1 crook 😎😎😎
    public static String rankCheck(int[] usersCards) {
        String[] pokerCards = makeCards(); 
        String[] userCardsStr = new String[usersCards.length];  // users int choices become actual cards now 
        for(int i=0; i<userCardsStr.length; i++) {
            userCardsStr[i] = pokerCards[usersCards[i]]; 
        }

        // checks for pair, twoPairs, toak and four of a kind 
        boolean pair = false;
        boolean twoPairs = false;
        boolean threeOfAKind = false; 
        for(int i=1; i<5; i++){
            if( (userCardsStr[0].substring(0,1)).equals((userCardsStr[i].substring(0,1)))){ // checks if pair 
                pair=true;
                if( (userCardsStr[1].substring(0,1)).equals((userCardsStr[i].substring(0,1)))){  // checks if TWO pears
                    twoPairs = true;
                    if((userCardsStr[2].substring(0,1)).equals((userCardsStr[i].substring(0,1)))) { // checks if three of a kind 
                        threeOfAKind = true;
                        if((userCardsStr[3].substring(0,1)).equals((userCardsStr[i].substring(0,1)))){ // checks if four of a kind 
                            return "FOUR OF A KIND";
                        }
                    }
                }
            }
        }

        // checks for flush 
        boolean flush = false; 
        int cardsEqual = 0;
        for(int i=0; i<5; i++){ // loop compares the last word of each card and if theyre all the same then its a flush!
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

        // checks for full house by well I mean its self explanitory i think 
        if(pair && threeOfAKind){
            return "FULL HOUSE";
        }

        // return statementes
        return "none.";
    } 

}   // end of class scope

/*
                     __QQ
      the rat.      (_)_">
                    _)    
*/