/*********************************************************
* Last Name: YU
* First Name: XUECHENG
* Student ID: 10124641
* Course: CPSC 233
* Tutorial Section: T03
* Assignment: 1
*
* Program prompts for gender, weight, height, age then 
* computes number of calories expended. Unit conversion 
* required.
*********************************************************/
import java.util.Scanner;

public class Calories
{
	public static final double LBTOKG = 0.45359237;
	public static final double INCHTOCM = 2.54;
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter your gender (male or female): ");
		String gender = keyboard.nextLine();
		System.out.print("Please enter your weight (in lb): ");
		double lbWeight = keyboard.nextDouble();
		System.out.print("Please enter your height (in inch): ");
		double inHeight = keyboard.nextDouble();
		System.out.print("Please enter your age (in year): ");
		int age = keyboard.nextInt();
		double calories;
		if (gender.equals("male"))
		{
			calories = (10 * lbWeight * LBTOKG) + (6.25 * inHeight * INCHTOCM) - (5 * age) + 5;  
			System.out.println("You calories used per day is " + calories + ".");
		}	
		else if (gender.equals("female"))
		{
			calories = (10 * lbWeight * LBTOKG) + (6.25 * inHeight * INCHTOCM) - (5 * age) - 161;  
			System.out.println("You calories used per day is " + calories + ".");
		}
	}
	public static String getID() 
  {
	  return "10124641"; // Your student ID here.
  }  
}