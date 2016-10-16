/** 
 * DrawTest.java:  The driver class for the Draw class.
 * @version CPSC 233
 * @Author Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

import java.io.*;

public class DrawTest
{
    public static void test1 ()
    {
        Draw drawer = new Draw();
        drawer.drawRectangle('?', 5, 3);
    }

    public static void test3 ()
    {
        Draw drawer = new Draw();
        drawer.drawLeftTriangle('*', 2);
    }

    public static void test5 ()
    {
        Draw drawer = new Draw();
        drawer.drawRightTriangle('$', 4);
    }

    public static void test7 ()
    {
        Draw drawer = new Draw();
        drawer.drawRectangle('?', 5, 3);
        drawer.drawLeftTriangle('*', 2);
        drawer.drawRightTriangle('$', 4);
        drawer.displayCounts();
    }
    
    public static void main(String [] args) throws Exception
    {
        System.out.println("Test 1:");
        test1();
        System.out.println("Test 3:");
        test3();
        System.out.println("Test 5:");
        test5();
        System.out.println("Test 7:");
        test7();
    }
}
