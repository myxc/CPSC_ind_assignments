/** 
 * TwoNumbersTest.java:  The driver class for the TwoNumbers class.
 * @version CPSC 233
 * @Author Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */

public class TwoNumbersTest{
    // testing creation
    public static boolean test1(){
        TwoNumbers numbers = new TwoNumbers();
        return (numbers.getFirstNum() == 0) && (numbers.getSecondNum() == 0);
    }

    // testing setFirstNum()
    public static boolean test2() {
        TwoNumbers numbers = new TwoNumbers();
        boolean success = numbers.setFirstNum(1);
        return success && (numbers.getFirstNum() == 1) && (numbers.getSecondNum() == 0);
    }
    
    public static boolean test4() {
        TwoNumbers numbers = new TwoNumbers();
        boolean success = numbers.setFirstNum(30);
        return !success && (numbers.getFirstNum() == 0) && (numbers.getSecondNum() == 0);
    }
    
    // testing setSecondNum()
    public static boolean test6() {
        TwoNumbers numbers = new TwoNumbers();
        boolean success = numbers.setSecondNum(1);
        return success && (numbers.getFirstNum() == 0) && (numbers.getSecondNum() == 1);
    }
    
    public static boolean test8() {
        TwoNumbers numbers = new TwoNumbers();
        boolean success = numbers.setSecondNum(30);
        return !success && (numbers.getFirstNum() == 0) && (numbers.getSecondNum() == 0);
    }

    // testing checkSum()
    public static boolean test10() {
        TwoNumbers numbers = new TwoNumbers();
        return numbers.checkSum(0);
    }
    
    public static boolean test11() {
        TwoNumbers numbers = new TwoNumbers();
        return !numbers.checkSum(1);
    }
    
    // testing equals()
    public static boolean test14() {
        TwoNumbers numbers1 = new TwoNumbers();
        numbers1.setFirstNum(1);
        numbers1.setSecondNum(4);
        
        TwoNumbers numbers2 = new TwoNumbers();
        numbers2.setFirstNum(1);
        numbers2.setSecondNum(4);
        
        return numbers1.equals(numbers2);
    }
    
    public static boolean test15() {
        TwoNumbers numbers1 = new TwoNumbers();
        numbers1.setFirstNum(1);
        numbers1.setSecondNum(4);
        
        TwoNumbers numbers2 = new TwoNumbers();
        numbers2.setFirstNum(4);
        numbers2.setSecondNum(1);
        
        return numbers1.equals(numbers2);
    }
    
    public static void main(String[] args){
        String result = "";
        
        System.out.print("Test 1: ");
        result = test1() ? "pass." : "failed.";
        System.out.println(result);
    
        System.out.print("Test 2: ");
        result = test2() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 4: ");
        result = test4() ? "pass." : "failed.";
        System.out.println(result);
    
        System.out.print("Test 6: ");
        result = test6() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 8: ");
        result = test8() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 10: ");
        result = test10() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 11: ");
        result = test11() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 14: ");
        result = test14() ? "pass." : "failed.";
        System.out.println(result);

        System.out.print("Test 15: ");
        result = test15() ? "pass." : "failed.";
        System.out.println(result);
    }
}