import java.util.Scanner;
import java.text.DecimalFormat;


public class Assignment2Q2 {

	  public static void main( String [] args )
	  {
	    double weight_pounds;      // declare weight in pounds
	    double height_inches;      // declare height in inches
	    final double kg_per_pound = 0.45359237;    // conversion factor for kg per pound
	    final double meter_per_inch = 0.0254;      // conversion factor for meter per inch
	    DecimalFormat df = new DecimalFormat("0.00");     // create number format for 2 decimal place
	    double BMI;    //declare BMI
	     

	    // Use a Scanner to input integer values
	    Scanner input = new Scanner( System.in );
	    System.out.println( "\n" );
	    System.out.print( "Please enter your weight in pounds: " );
	    weight_pounds = input.nextDouble();     // Input weight in pounds
	    System.out.print( "Please enter your height in inches:¡¡" );
	    height_inches = input.nextDouble();     // Input height in inches

	    // Calculate the BMI for user
	    BMI = (weight_pounds * kg_per_pound)/((height_inches * meter_per_inch) * (height_inches * meter_per_inch));
	          
	    // Output using System.out.println()
	    System.out.println("Your BMI is " + df.format(BMI));
	    System.out.println( "\nBMI information");
	    System.out.println("Underweight: less than 18.5");
	    System.out.println("Normal: 18.5 - 24.9");
	    System.out.println("Overweight: 25 - 29.9");
	    System.out.println("Obese: 30 or greater\n");
	    
	  }
}
