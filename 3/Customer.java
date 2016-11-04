
/*********************************************************
* Last Name: YU
* First Name: XUECHENG
* Student ID: 10124641
* Course: CPSC 233
* Tutorial Section: T03
* Assignment: 3
*********************************************************/
public class Customer {

    public static final int MAX_ACCOUNTS = 5;

    private String firstName;
    private String lastName;
    private int customerID;
    private BankAccount[] accounts;
    private int numAccounts;
    private static int nextCustomerID = 1;
    /**
     * This is a constructor that initializes a customer object.
     * @param string for first name of customer
     * @param string for last name of customer
    */
    public Customer (String first, String last)
    {
        customerID = nextCustomerID;
        numAccounts = 0;
        nextCustomerID++;
        accounts = new BankAccount[MAX_ACCOUNTS];
        firstName = first;
        lastName = last;
    }
    
    /**
     * Copy method that copies over data fields of the param object into the object invoking this method.
     * @param Customer class object that you are planning on copying the data fields of
    */
    public void copy (Customer copyFrom)
    {
        firstName = copyFrom.firstName;
        lastName = copyFrom.lastName;
        customerID = copyFrom.customerID;
        accounts = copyFrom.accounts;
        numAccounts = copyFrom.numAccounts;
    }

    /**
     * @param BankAccount object which will be added into the array of bankaccounts called accounts
     * @return true or false based on whether the add was successful, fails and returns false if the account already exists
     *         or the array of bankaccounts is full and already contains 5 accounts.
    */
    public boolean addAccount (BankAccount newAccount)
    {
        if (numAccounts < MAX_ACCOUNTS)
        {
            for (int i = 0; i < numAccounts; i++)
            {
                if (accounts[i].equals(newAccount))
                {
                    return false;
                }
            }
            accounts[numAccounts] = newAccount;
            numAccounts++;
            return true;
        }
        return false;
    }
    
    /**
     * @param account number for the account to be removed from the accounts array, and then subsequent accounts in array are shifted up.
     * @return true or false depending on success of removal, returns false is the account doesn't exist in the accounts array.
    */
    public boolean removeAccount (int accountNum)
    {
        for (int i = 0; i < numAccounts; i++)
        {
            if (accounts[i].getAccountNumber() == accountNum)//you found the matching account number in array
            {
                for (int x = i; x < (numAccounts - 1); x++) //iterate from this account number.
                {
                    accounts[x] = new BankAccount(accounts[x + 1]);//replaces info in the account with the account after it
                }
                accounts[numAccounts - 1] = null;
                numAccounts--;//decrement numAccounts to anticipate removal of the account
                nextCustomerID--; //decrement counter to anticipate removal of the account
                return true;
            }
            else 
                continue;
        }
        return false;
    }
    /**
     * @return returns the accounts array
    */
    public BankAccount[] getAccounts ()
    {
        return accounts;
    }
    
    /**
     * @return returns the customer name as a string
    */
    public String getName ()
    {
        String name = firstName + " " + lastName;
        return name;
    }
    
    /**
     * @return returns the customer ID
    */
    public int getCustomerID ()
    {
        return customerID;
    }
    
    /**
     * @return returns customer information in a string.
    */
    public String toString()
    {
        String info = firstName + " " + lastName + ", " + customerID + "\n";
        for (int i = 0; i < numAccounts; i++)
        {
            info += accounts[i].toString() + "\n";
        }
        return info;
    }

    /**
     * @return returns my personal student ID
    */
    public static String getID() 
    {
    return "10124641"; // Your student ID here.
    }
}