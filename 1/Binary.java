/*********************************************************
* Last Name: YU
* First Name: XUECHENG
* Student ID: 10124641
* Course: CPSC 233
* Tutorial Section: T03
* Assignment: 1
*
* User inputs a 4 digit binary value and program outputs 
* actual number that the binary value represents.
*********************************************************/
import java.util.Scanner;
public class Binary
{
  public static void main(String[] args)
  {
    
    System.out.print("Enter a 4-digit binary: ");
    Scanner keyboard = new Scanner(System.in);
    int binary = keyboard.nextInt();
    int pThree = binary / 1000; 
    int pTwo = (binary % 1000) / 100; 
    int pZero = binary % 10;
    int pOne = (binary % 100) / 10;
    int decimalValue = (int)Math.pow(2,0) * pZero + (int)Math.pow(2,1) * pOne + (int)Math.pow(2,2) * pTwo + (int)Math.pow(2,3) * pThree;
    System.out.println("Decimal value: " + decimalValue);
  }
  public static String getID() 
  {
    return "10124641"; // Your student ID here.
  }
}

