/*********************************************************
* Last Name: YU
* First Name: XUECHENG
* Student ID: 10124641
* Course: CPSC 233
* Tutorial Section: T03
* Assignment: 1
*
* Takes 4 digits entered and the outputs each digit on a
* separate line.
*********************************************************/
import java.util.Scanner;
public class Digits
{
  public static void main(String[] args)
  {
    
    System.out.print("Enter a 4-digit integer: ");
    Scanner keyboard = new Scanner(System.in);
    int fourDigitNum = keyboard.nextInt();
    int thousands = fourDigitNum / 1000; 
    int hundreds = (fourDigitNum % 1000) / 100; 
    int ones = fourDigitNum % 10;
    int tens = (fourDigitNum % 100) / 10; 
    System.out.println(thousands);
    System.out.println(hundreds);
    System.out.println(tens);
    System.out.println(ones);
  }
  public static String getID() 
  {
    return "10124641"; // Your student ID here.
  }
}

