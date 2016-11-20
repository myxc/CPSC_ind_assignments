/** 
 * SUV.java: The SUV can drive in two modes: regular and AWD <br>
  * @version CPSC 233
 */
/*********************************************************
* Last Name: YU
* First Name: XUECHENG
* Student ID: 10124641
* Course: CPSC 233
* Tutorial Section: T03
* Assignment: 4
*********************************************************/
 //AWD mode travels 2km per round and consumes 4 units fuel per km
//regular mode travels 3km per round and consumes 2 units of fuel per km
//starts with 60 units of fuel
import java.util.Scanner;
public class SUV extends Car
{
    public static final int CONSUMPTION_RATE = 2;
    public static final int AWD_RATE = 4;
    public static final int REGULAR_DISTANCE = 3;
    public static final int AWD_DISTANCE = 2;
    public boolean blizzard = false;
    private char selection;//updated through the game file's keyboard input

    /** Changes the selection var to reflect user's selection
     * @param character from user input
     */
    public void setSelection(char charToBeSet)
    {
        selection = charToBeSet;//to make a choice user needs to update the selection var through keyboard input, and then it will be used to processoption nad move.
    }

    /** Constructor to create a suv class based on car's constructor
    */
    public SUV()
    {
        super('V', "SUV");
    }

    /** Displays options avaiable to the user for the round
    */
    public void displayOptions()
    {
        System.out.println("=== SUV driving options ===");
        System.out.println("(a)ll wheel drive mode");
        System.out.println("(d)rive normally");//consumes fuel regardless of whether or not it moves
        System.out.println("(q)uit simulation");
        System.out.print("Enter selection: ");
    }

    /** Boolean reflecting whether or not the car is in a blizzard
     * @return the true/false value blizzard
    */
    public boolean inBlizzard()
    { //in track check the weather and then adjust the car.
            return blizzard;
    }

    /** Processes user selection to return a selection code
     * @param selection indicated by user input
     * @return int code corresponding with user selection
    */
    public int processOption(char selection)
    {//if there is gas then the options will matter. 
        if (isEmpty() == false)
        {
            if (selection == 'q')
            {
                return 78;//code for user quit
            }
            else if (selection == 'a')
            {
                return 2;//km in awd mode
            }
            else if (selection == 'd' && blizzard == false)
            {
                return 3;//move km in drive without blizzard
            }
            else if (selection == 'd' && blizzard == true)
            {
                return 0;//move km in drive in blizzard
            }
            else 
                return 22;//random code that will never be used
        }
        else if (selection == 'q')
            {
                return 78;//no gas but chose to quit the game
            }
        else 
        {
            // empty = true;
            return 99;
        }  
    }

    /** returns the move code made by the car based on conditions and user choice
     * @return int code for moving the car
    */
    public int move()
    {
        return processOption(selection); //selection is updated in the game file based on the user's inputs in keyboard
        //the selection is checked against the existing possibilities which already display the corresponding number of moves.
    }

    /** Sets the conditions for the car i.e. whether it is in a blizzard
     * @param value correspodning with track condition
    */
    public void setCarConditions(int value)
    {
        if (value == 1)
        {
            blizzard = true;
        }
        else
            blizzard = false;
    }

    /** Consumes fuel correspdonign with mode code
    */
    public void consumeFuel()
    {
        if (getFuelLevel() > 0)
        {
            if (move() == 2)
                setFuelLevel(getFuelLevel() - 8);
            if (move() == 3)
                setFuelLevel(getFuelLevel() - 6);
            if (move() == 0)
                setFuelLevel(getFuelLevel() - 6);
        }
    }
    
}