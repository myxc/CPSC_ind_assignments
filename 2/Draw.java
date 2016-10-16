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
public class Draw
{
  
  int count;

  public void drawRectangle(char ch, int width, int height)
  {
    int count = 0;
    for (int i = 0; i < height; i++)
    {
      for (int j = 0; j < width; j++)
      {
        System.out.print(ch);
        count += 1;
      }
      System.out.println("");
    }
  }

  public void drawLeftTriangle(char ch, int height)
  {
    int count = 0;

    for (int i = height; i > 0; i--)
    {
      for (int j = 0; j < i; j++)
      {
        System.out.print(ch);
        count += 1;
      }
      System.out.println("");
    }
  }

  public void drawRightTriangle(char ch, int height)
  {
    int count = 0;

    for (int i = 1; i <= height; i++)
    {
      for (int j = i; j < height; j++)
      {
        System.out.print(" ");
      }
      for (int k = 1; k <= i; k++)
      {
        System.out.print(ch);
        count += 1;
      }
      System.out.println("");
    }
  }

  public int displayCounts()
  {
    return count;
  }

  public static String getID() 
  {
    return "10124641"; // Your student ID here.
  }

}