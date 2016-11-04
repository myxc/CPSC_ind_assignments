/** 
 * CustomerTest.java:  The driver class for the Customer class.
 * @version CPSC 233
 * @Author Mea Wang
 * Copyright (c) 2016. All rights reserved.
 */
 
public class CustomerTest {
        
    private static int customerCounter = 0;
    
    public static boolean test1(){
        System.out.println("Test1: create a customer");
        Customer c = new Customer("Alice", "Smith");
        customerCounter++;
        return c.getName().equals("Alice Smith") && customerCounter == c.getCustomerID();
    }
    
    public static boolean test2() {
        System.out.println("Test2: create two customers");
        Customer c1 = new Customer("Alice", "Smith");
        Customer c2 = new Customer("Bob", "Simpson");
        customerCounter += 2;
        return c1.getName().equals("Alice Smith") && (customerCounter - 1) == c1.getCustomerID()
            && c2.getName().equals("Bob Simpson") && (customerCounter) == c2.getCustomerID();
    }
    
    public static boolean test4() {
        System.out.println("Test4: copy a customer");
        Customer c1 = new Customer("Alice", "Smith");
        Customer c2 = new Customer("Bob", "Simpson");
        c1.copy(c2);
        customerCounter += 2;
        return c1.getName().equals("Bob Simpson") && (customerCounter) == c1.getCustomerID()
            && c2.getName().equals("Bob Simpson") && (customerCounter) == c2.getCustomerID()
            && c1 != c2;
    }
    
    public static boolean test5() {
        System.out.println("Test5: add an account to a customer.");
        BankAccount b = new BankAccount();
        Customer c1 = new Customer("Alice", "Smith");
        customerCounter ++;
        if (!c1.addAccount(b))
            return false;
        
        return c1.toString().equals("Alice Smith, " + c1.getCustomerID() + "\n" + b.toString() + "\n");
    }
        
    public static boolean test7() {
        System.out.println("Test7: add six accounts to a customer, the last one should be dropped.");
        BankAccount[] accounts = new BankAccount[Customer.MAX_ACCOUNTS];
        accounts[0] = new BankAccount();
        accounts[1] = new BankAccount(10);
        accounts[2] = new BankAccount(15);
        accounts[3] = new BankAccount(20);
        accounts[4] = new BankAccount(25);
        Customer c1 = new Customer("Alice", "Smith");
        customerCounter ++;
        for (int i = 0; i < Customer.MAX_ACCOUNTS; i++)
        {
            if (!c1.addAccount(accounts[i]))
                return false;
        }
        if (c1.addAccount(new BankAccount(30)))
            return false;
        
        String expected = "Alice Smith, " + c1.getCustomerID() + "\n";
        for (int i = 0; i < Customer.MAX_ACCOUNTS; i++)
        {
            expected += accounts[i].toString() + "\n";
        }
        return c1.toString().equals(expected);
    }
    
    public static boolean test9() {
        System.out.println("Test9: copy a customer, include accounts");
        BankAccount b1 = new BankAccount(100);
        Customer c1 = new Customer("Alice", "Smith");
        if (!c1.addAccount(b1))
            return false;

        BankAccount b2 = new BankAccount(50);
        Customer c2 = new Customer("Bob", "Simpson");
        if (!c2.addAccount(b2))
            return false;

        c1.copy(c2);
        customerCounter += 2;
        
        String expected = "Bob Simpson, " + c2.getCustomerID() + "\n";
        expected += b2.toString() + "\n";
         
        if (!c1.toString().equals(expected))
            return false;
        if (!c2.toString().equals(expected))
            return false;
        if (c1 == c2)
            return false;
        BankAccount[] c1Accounts = c1.getAccounts();
        BankAccount[] c2Accounts = c2.getAccounts();
        for (int i = 0; i < Customer.MAX_ACCOUNTS - 1; i++)
        {
            if (c1Accounts[i] == c2Accounts[i])
                return false;
        }
        
        return true;
    }
    
    
    public static boolean test11() {
        System.out.println("Test11: add and remove accounts");
        BankAccount[] accounts = new BankAccount[Customer.MAX_ACCOUNTS];
        accounts[0] = new BankAccount();
        accounts[1] = new BankAccount(10);
        accounts[2] = new BankAccount(15);
        accounts[3] = new BankAccount(20);
        accounts[4] = new BankAccount(25);
        Customer c1 = new Customer("Alice", "Smith");
        customerCounter ++;
        for (int i = 0; i < Customer.MAX_ACCOUNTS; i++)
        {
            if (!c1.addAccount(accounts[i]))
                return false;
        }
        if (!c1.removeAccount(accounts[4].getAccountNumber()))
            return false;
        
        BankAccount b1 = new BankAccount(30);
        if (!c1.addAccount(b1))
            return false;
        
        String expected = "Alice Smith, " + c1.getCustomerID() + "\n";
        for (int i = 0; i < Customer.MAX_ACCOUNTS - 1; i++)
        {
            expected += accounts[i].toString() + "\n";
        }
        expected += b1.toString() + "\n";
        
        return c1.toString().equals(expected);
    }
    
    public static boolean test12() {
        System.out.println("Test12: add and remove accounts");
        BankAccount[] accounts = new BankAccount[Customer.MAX_ACCOUNTS];
        accounts[0] = new BankAccount();
        accounts[1] = new BankAccount(10);
        accounts[2] = new BankAccount(15);
        accounts[3] = new BankAccount(20);
        accounts[4] = new BankAccount(25);
        Customer c1 = new Customer("Alice", "Smith");
        customerCounter ++;
        for (int i = 0; i < Customer.MAX_ACCOUNTS; i++)
        {
            if (!c1.addAccount(accounts[i]))
                return false;
        }
        if (!c1.removeAccount(accounts[2].getAccountNumber()))
            return false;
            
        BankAccount b1 = new BankAccount(30);
        if (!c1.addAccount(b1))
            return false;
        
        String expected = "Alice Smith, " + c1.getCustomerID() + "\n";
        expected += accounts[0].toString() + "\n";
        expected += accounts[1].toString() + "\n";
        expected += accounts[3].toString() + "\n";
        expected += accounts[4].toString() + "\n";
        expected += b1.toString() + "\n";
        
        return c1.toString().equals(expected);
     }
    

    public static void main(String[] args) {
        String result = "";
        //System.out.print("Test 1: ");
        result = test1() ? "pass." : "failed.";
        System.out.println(result);
    
        //System.out.print("Test 2: ");
        result = test2() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 4: ");
        result = test4() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 5: ");
        result = test5() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 7: ");
        result = test7() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 9: ");
        result = test9() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 11: ");
        result = test11() ? "pass." : "failed.";
        System.out.println(result);

        //System.out.print("Test 12: ");
        result = test12() ? "pass." : "failed.";
        System.out.println(result);
    }
}