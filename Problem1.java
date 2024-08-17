//Problem 01: APCS Post Office
import java.util.Scanner;
import java.util.Arrays;
public class Problem01{
    // main method
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] packageData = new String[1];

        // take user input each dimension is set to a index of Str array 
        System.out.println("Enter the length, width, thickness, and weight (Lbs) of your package seperated by commas: ");
        int runs = 0;
        while(runs<5){
            System.out.println("---------------------------------");
            System.out.print("Enter Data: ");
            packageData[0] = input.nextLine();
            System.out.println("Package "+(runs+1)+" Dimensions: "+packageData[0]);
            double[] thePackage = convert(packageData[0]);
            if(price(thePackage)==0){
                System.out.println("UNMAILABLE");
            }
            else{
                System.out.printf("Package "+(runs+1)+" Cost: $%.2f",(price(thePackage)));
                System.out.println("");
            }
            runs++;
        }
    }


    // convert method takes the indexes of packageData splits it and returns a double array :D
    public static double[] convert(String packageData) {
         String[] strPackage = packageData.split(",");
         double[] doublePackage = new double[strPackage.length];
         for(int i=0; i<strPackage.length; i++){
             doublePackage[i] = Double.parseDouble(strPackage[i]);
         }
         return doublePackage;
    }


    // regular Post card method
    public static double regular(double[] dimensions) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        // length check
        if( (dimensions[0]>=3.5) && (dimensions[0]<=4.25) ) {
            check1 = true;
        }
        else{
            return 0;
        }
        // height check
        if( (dimensions[1]>=3.5) && (dimensions[1]<=6) ){
            check2 = true;
        }
        else{
            return 0;
        }
        // thickness check
        if( (dimensions[2]>=.007) && (dimensions[2]<=.016)  ){
            check3 = true;
        }
        else{
            return 0;
        }
        // if all conditions are met then its a regular postcard
        if( (check1&&check2) && (check1&&check3) ){
            double groups = 0;
            double daValue = dimensions[3];
            while(daValue>0){
                daValue-= 0.0625;
                groups++;
            }
            return  groups*0.2;
        }
        return 0;
    }


    // large post card method 
    public static double large(double[] dimensions) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        // length check
        if( (dimensions[0]>4.25) && (dimensions[0]<6) ) {
            check1 = true;
        }
        else{
            return 0;
        }
        // height check
        if( (dimensions[1]>=6) && (dimensions[1]<11.5) ){
            check2 = true;
        }
        else{
            return 0;
        }
        // thickness check
        if( (dimensions[2]>=.007) && (dimensions[2]<=.016)  ){
            check3 = true;
        }
        else{
            return 0;
        }
        // if all conditions are met then its a large postcard
        if( (check1&&check2) && (check1&&check3) ){
            double groups = 0;
            double daValue = dimensions[3];
            while(daValue>0){
                daValue-=0.0625;
                groups++;
            }
            return  groups*.3;
        }
        return 0;
    }


    // envelope method
    public static double envelope(double[] dimensions) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        // length check
        if( (dimensions[0]>=3.5) && (dimensions[0]<=6.125) ) {
            check1 = true;
        }
        else{
            return 0;
        }
        // height check
        if( (dimensions[1]>=5) && (dimensions[1]<=11.5) ){
            check2 = true;
        }
        else{
            return 0;
        }
        // thickness check
        if( (dimensions[2]>.016) && (dimensions[2]<.25)  ){
            check3 = true;
        }
        else{
            return 0;
        }
        // if all conditions are met then its a envelope 
        if( (check1&&check2) && (check1&&check3) ) {
            double groups = 0;
            double daValue = dimensions[3];
            while(daValue>0){
                daValue-=0.0625;
                groups++;
            }
            return  groups*.47;
        }
        return 0;
    }

    // large envelope method
    public static double largeEnvelope(double[] dimensions) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        // length check
        if( (dimensions[0]>6.125) && (dimensions[0]<24) ) {
            check1 = true;
        }
        else{
            return 0;
        }
        // height check
        if( (dimensions[1]>=11) && (dimensions[1]<=18) ){
            check2 = true;
        }
        else{
            return 0;
        }
        // thickness check
        if( (dimensions[2]>=.25) && (dimensions[2]<=.5)  ){
            check3 = true;
        }
        else{
            return 0;
        }
        // if all conditions are met then its a large envelope
        if( (check1&&check2) && (check1&&check3) ){
            double groups = 0;
            double daValue = dimensions[3];
            while(daValue>0){
                daValue-=.0625;
                groups++;
            }
            return  groups*.56;
        }
        
        return 0;
}


    public static double packageCheck(double[] dimensions){
        double numberPolice = 0;
        for (int i = 0; i <dimensions.length; i++) {
            numberPolice =dimensions[i];
            if (numberPolice<=0) {
                return 0;
            }
        }
        double measurements = dimensions[0]+(dimensions[1]+dimensions[1]+dimensions[2]+dimensions[2]);
        // checks for package
        if(measurements<=84){
            double value = dimensions[3];
            double groups = 0;
            while(value>0){
                value-=0.5;
                groups++;
            }
            return groups*1.50;
        }
        // checks for large package
        if( 84<=measurements && measurements<130 ){
            double largeValue = dimensions[3];
            double wolfPACK = 0;
            while(largeValue>0){
                largeValue-=.5;
                wolfPACK++;
            }
            return wolfPACK*1.75;
        } 
        return 0;
    }

    public static double price(double[] packageInfo) {
        if(regular(packageInfo) !=0 ) {
            return regular(packageInfo);
        }
        if(large(packageInfo)!=0) {
            return large(packageInfo);
        }
        if(envelope(packageInfo)!=0) {
            return envelope(packageInfo);
        }
        if(largeEnvelope(packageInfo)!=0) {
            return largeEnvelope(packageInfo);
        }
        if(packageCheck(packageInfo)!=0) {
            return packageCheck(packageInfo);
        }
        return 0.0;
    }

}