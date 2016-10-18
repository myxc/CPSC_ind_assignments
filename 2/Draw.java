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
 * Draw.java: Draw class that can create rectangles, left triangles and right triangles using any character
*/
public class Draw
{
  
  int count;
  /** 
   * @param ch any character, used to create the rectangle
   * @param width how wide the rectangle is
   * @param height how high the rectangle is
  */ 
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
  /** 
   * @param ch any character used to create the triangle
   * @param height the height of the triangle
  */
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
  /** 
   * @param ch any character used to create the triangle
   * @param height the height of the triangle
  */
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
  /**
   * @return returns the count which is the number of characters used to create the shape
  */
  public int displayCounts()
  {
    return count;
  }
  /**
   * @return returns my personal student ID
  */
  public static String getID() 
  {
    return "10124641"; // Your student ID here.
  }

}