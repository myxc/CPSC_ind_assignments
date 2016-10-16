/*********************************************************
* Last Name: YU
* First Name: XUECHENG
* Student ID: 10124641
* Course: CPSC 233
* Tutorial Section: T03
* Assignment: 2
*
* User inputs a 4 digit binary value and program outputs 
* actual number that the binary value represents.
*********************************************************/
import java.util.Scanner;
public class TwoNumbers
{

  //initializing private instance variables
  private int num1;
  private int num2;

  //constructor to initialize both values as 0
  TwoNumbers()
  {
    num1 = 0;
    num2 = 0;
  }

  //public methods
  public int getFirstNum()
  {
    return num1;
  }

  public int getSecondNum()
  {
    return num2;
  }

  public boolean setFirstNum(int num)
  {
    if (num <= 29)
    {
      num1 = num;
      return true;
    }
    else
      {return false;}
  }

  public boolean setSecondNum(int num)
  {
    if (num <= 29)
    {
      num2 = num;
      return true;
    }
    else
      return false;
  }

  public boolean checkSum(int sum)
  {
    int sum_of_numbers = num1 + num2;
    if (sum_of_numbers == sum)
    {
      return true;
    }
    else
      return false;
  }

  public boolean equals(TwoNumbers object)
  {
    if ((num1 == object.getFirstNum() || num1 == object.getSecondNum()) && (num2 == object.getSecondNum() || num2 == object.getFirstNum()))
    {
      return true;
    }
    else 
      return false;
  }

  public static String getID() 
  {
    return "10124641"; // Your student ID here.
  }

}

