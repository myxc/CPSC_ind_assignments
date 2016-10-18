/*********************************************************
* Last Name: YU
* First Name: XUECHENG
* Student ID: 10124641
* Course: CPSC 233
* Tutorial Section: T03
* Assignment: 2
*********************************************************/
import java.util.Scanner;
/**
 * TwoNumbers.java: TwoNumbers class manipulates two number instance variables
*/
public class TwoNumbers
{
  /**
   * instantialize two private instance variables.
  */
  private int num1;
  private int num2;
  /**
   * Default constructor to initialize the two variables with value of 0.
  */
  TwoNumbers()
  {
    num1 = 0;
    num2 = 0;
  }
  /**
   * @return returns the value of the first number
  */
  public int getFirstNum()
  {
    return num1;
  }
  /**
   * @return returns the value of the second number
  */
  public int getSecondNum()
  {
    return num2;
  }
  /**
   * @param num a number between 0 and 29, which will be the new value of the first number variable
   * @return returns true if the assignment went through (num was between 0 and 29) and false otherwise
  */
  public boolean setFirstNum(int num)
  {
    if ((num <= 29) && (num >= 0))
    {
      num1 = num;
      return true;
    }
    else
      {return false;}
  }
  /**
   * @param num a number between 0 and 29, which will be the new value of the second number variable
   * @return returns true if the assignment went through (num was between 0 and 29) and false otherwise
  */
  public boolean setSecondNum(int num)
  {
    if ((num <= 29) && (num >= 0))
    {
      num2 = num;
      return true;
    }
    else
      return false;
  }
  /**
   * @param sum the sum specified which the method checks the actual sum of the two number variables against
   * @return returns true if the actual number variables sum to the specified sum value and false otherwise
  */
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
  /**
   * @param object An object of class TwoNumbers, which has its variables and values
   * @return true if the object the method is called on and the argument have the same values the two number variables.
  */
  public boolean equals(TwoNumbers object)
  {
    if ((num1 == object.getFirstNum() || num1 == object.getSecondNum()) && (num2 == object.getSecondNum() || num2 == object.getFirstNum()))
    {
      return true;
    }
    else 
      return false;
  }
  /**
   * @return returns my personal student ID
  */
  public static String getID() 
  {
    return "10124641"; // Your student ID here.
  }

}

