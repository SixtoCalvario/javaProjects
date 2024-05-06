import java.util.Scanner;
public class Quotes {

    public static void main(String[] args) {
        // takes pixar quote
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Pixar quote: ");
        String quote = input.nextLine().toUpperCase();
        input.close();
        System.out.println(wordCount(quote));
        letterOccurances(quote);
    }


    // determines amount of words in quote
    public static String wordCount(String str) {
        
        // splits data into array counts items in array and you get words count
        String[] quoteArray = str.split(" "); 
        int words = quoteArray.length; 
        String wordCount = "There are "+words+" words";
        return wordCount;
    }


    // determines the amount of times a letter occurs
    public static void letterOccurances(String str) {
        
        // splits quote into an array bc its easier for me at least 
        String[] quoteArray = str.split(" ");


        // Array of Alphabet, 
        String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int[] letterOccurancesArray = new int[alphabet.length];
        

        // for loop gets us to look at 1 word within the sentence
        for(int i=0; i<quoteArray.length; i++) {
            String currentWord = quoteArray[i];

            // for loop counts the amount of times a letter occurs within that one word
            for(int j=0; j<currentWord.length(); j++) {

                // looking at one letter within one word
                String currentLetter = currentWord.charAt(j)+"";

                // we get the amount of times a letter occurs 
                int timesLetterOccured = currentWord.length()-currentWord.replaceAll(currentLetter, "").length() ;
                
                // adds the number of times it occurs into our int array
                for(int k=0; k<alphabet.length; k++) {
                    if(currentLetter.equals(alphabet[k])){
                        letterOccurancesArray[k] += timesLetterOccured;
                    }
                }
            }

        }
        
        for(int i=0; i<alphabet.length; i++) {
            if(letterOccurancesArray[i]!=0) {
                System.out.println(letterOccurancesArray[i]+" "+alphabet[i]);
            }
        }

    }
}
