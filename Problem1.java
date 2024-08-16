//Problem 01: APCS Post Office
import java.util.Scanner;
import java.util.Arrays;
public class Problem01{

    // main method
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String[] packageData = new String[5];

        // take user input each dimension is set to a index of Str array 
        System.out.print("Enter the length, width, thickness, and weight (Lbs) of your package seperated by commas: ");
        for (int i = 0; i!=5; i++) {
            packageData[i] = input.nextLine();
            System.out.println("Package "+(i+1)+" Dimensions: "+packageData[i]);
        }
        
        double[] thePackage = convert(packageData[0]);
        double[] package2 = convert(packageData[1]);
        double[] package3 = convert(packageData[2]);
        double[] package4 = convert(packageData[3]);
        double[] package5 = convert(packageData[4]);

        if(large(package1)) {
            System.out.println("large Postcard");
        }
        else {
            System.out.println("Not a large Postcard");
        }

    }


    // convert method takes the indexes of package data splits it and returns a double array :D
    public static double[] convert(String packageData) {
         String[] strPackage = packageData.split(",");
         double[] doublePackage = new double[strPackage.length];
         for(int i=0; i<strPackage.length; i++){
             doublePackage[i] = Double.parseDouble(strPackage[i]);
         }
         return doublePackage;
    }

    // checks if mail is a package
    public static boolean packageCheck(double[] dimensions) {
        if(          !(regular(thePackage) )        ){

        }
        return false; 
    }

    // regular Post card method - works
    public static boolean regular(double[] dimensions) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        // length check
        if( (dimensions[0]>=3.5) && (dimensions[0]<=4.25) ) {
            check1 = true;
        }
        else{
            return false;
        }
        // height check
        if( (dimensions[1]>=3.5) && (dimensions[1]<=6) ){
            check2 = true;
        }
        else{
            return false;
        }
        // thickness check
        if( (dimensions[2]>=.007) && (dimensions[2]<=.016)  ){
            check3 = true;
        }
        else{
            return false;
        }
        // if all conditions are met then its a regular postcard
        if( (check1&&check2) && (check1&&check3) ){
            return true;
        }
        return false;
    }


    // large post card method 
    public static boolean large(double[] dimensions) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        // length check
        if( (dimensions[0]>4.25) && (dimensions[0]<6) ) {
            check1 = true;
        }
        else{
            return false;
        }
        // height check
        if( (dimensions[1]>=6) && (dimensions[1]<11.5) ){
            check2 = true;
        }
        else{
            return false;
        }
        // thickness check
        if( (dimensions[2]>=.007) && (dimensions[2]<=.016)  ){
            check3 = true;
        }
        else{
            return false;
        }
        // if all conditions are met then its a regular postcard
        if( (check1&&check2) && (check1&&check3) ){
            return true;
        }
        return false;
    }


    // envelope method
    public static boolean envelope(double[] dimensions) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        // length check
        if( (dimensions[0]>=3.5) && (dimensions[0]<=6.125) ) {
            check1 = true;
        }
        else{
            return false;
        }
        // height check
        if( (dimensions[1]>=5) && (dimensions[1]<=11.5) ){
            check2 = true;
        }
        else{
            return false;
        }
        // thickness check
        if( (dimensions[2]>.016) && (dimensions[2]<=.25)  ){
            check3 = true;
        }
        else{
            return false;
        }
        // if all conditions are met then its a regular postcard
        if( (check1&&check2) && (check1&&check3) ){
            return true;
        }
        return false;
    }

    // large envelope method
    public static boolean largeEnvelope(double[] dimensions) {
        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;
        // length check
        if( (dimensions[0]>6.125) && (dimensions[0]<24) ) {
            check1 = true;
        }
        else{
            return false;
        }
        // height check
        if( (dimensions[1]>=11) && (dimensions[1]<=18) ){
            check2 = true;
        }
        else{
            return false;
        }
        // thickness check
        if( (dimensions[2]>.25) && (dimensions[2]<=.5)  ){
            check3 = true;
        }
        else{
            return false;
        }
        // if all conditions are met then its a regular postcard
        if( (check1&&check2) && (check1&&check3) ){
            return true;
        }
        return false;
    }


    // package method
    public static double regularPackage(double[] dimensions) {
        return (dimensions[3])*(1.50*2);
    }

    // large package method
    public static double largePackage(double[] dimensions) {
        return (dimensions[3])*(1.75*2);
    }

}
