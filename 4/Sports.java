/** 
 * Sport.java: The sport car can drive in two modes: regular and overheated <br>
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
//starts with 60 units of fuel
//regular mode travels 4km per round consuming 2 units of fuel per km
//overheated mode travels 1km per round consumin 4 units fuel per km
import java.util.Scanner;
public class Sports extends Car
{
    public static final int CONSUMPTION_RATE = 2;
    public static final int OVERHEATED_RATE = 4;
    public static final int REGULAR_DISTANCE = 4;
    public static final int OVERHEATED_DISTANCE = 1;
    private boolean overheated = false;
    private char selection;
    
    /** Display the options for this car.km
     */
    public Sports()
    {
        super('P', "Sports");
        char appearance;
        String name;
        int fuelLevel;
    }

    public void setSelection(char charToBeSet)
    {
        selection = charToBeSet;
    }

    public char getSelection()
    {
        return selection;
    }

    public void displayOptions()
    {
        System.out.println("=== Sportscar driving options ===");
         if (isOverheated())
             System.out.println("WARNING: car is overheated.");
         System.out.println("(c)ool off"); //doesn't consume any fuel
         System.out.println("(d)rive normally");
         System.out.println("(q)uit simulation");
         System.out.print("Enter selection: ");
    }

    public boolean isOverheated()
    {
        if (overheated == true)
            return true;
        else
            return false;
    }

    public int processOption(char selection)
    {//if there is gas then the options will matter. 
        if (isEmpty() == false)
        {
            if (selection == 'q')
            {
                return 78;
            }
            else if (selection == 'c')
            {
                overheated = false;//cooling down can be done any time and doesn't use fuel
                return 0;
            }
            else if (selection == 'd' && overheated == false)
            {
                return 4;
            }
            else if (selection == 'd' && overheated == true)
            {
                return 1;
            }
            else
                return 22;
        }
        else if (selection == 'q')
            {
                return 78;//no gas but chose to quit the game
            }
        else   
            return 99;   //means out of gas         
    }

    public int move()
    {
        return processOption(selection);//selection is updated in the game file based on the user's inputs in keyboard
        //the selection is checked against the existing possibilities which already display the corresponding number of moves.
    }
    
    public void setCarConditions(int value)
    {
        if (value == 2)
        {
            overheated = true;
        }
        else
            System.out.println("not heatwave");
    }

    public void consumeFuel()
    {
        if (getFuelLevel() > 0)
        {
            if (move() == 4)
                setFuelLevel(getFuelLevel() - 8);
            if (move() == 1)
                setFuelLevel(getFuelLevel() - 4);
        }
    }
}