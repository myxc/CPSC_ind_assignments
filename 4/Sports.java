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
    }

    /** Sets selection of user
    */
    public void setSelection(char charToBeSet)
    {
        selection = charToBeSet;
    }

    /** returns selection of user
     * @return selection the character indicating the driving mode the user wants
    */
    public char getSelection()
    {
        return selection;
    }

    /** Displays options that the user has with the car
    */
    public void displayOptions()
    {
        System.out.println("=== Sports car driving options ===");
         if (isOverheated())
             System.out.println("WARNING: car is overheated.");
         System.out.println("(c)ool off"); //doesn't consume any fuel
         System.out.println("(d)rive normally");
         System.out.println("(q)uit simulation");
         System.out.print("Enter selection: ");
    }

    /** Indicates whether the car is overheated
     * bool indicates whether the car is overheated
    */
    public boolean isOverheated()
    {
        if (overheated == true)
            return true;
        else
            return false;
    }

    /** returns a corresponding number of moves or move code based on car's conditions and user indication
    */
    public int processOption(char selection)
    {//if there is gas then the options will matter. 
        if (isEmpty() == false)
        {
            if (selection == 'q')
            {
                return 78; //code indicating user quit
            }
            else if (selection == 'c')
            {
                overheated = false;//cooling down can be done any time and doesn't use fuel
                return 0;
            }
            else if (selection == 'd' && overheated == false)
            {
                return 4; //car can move 4 km if not overheated and regular driving mode
            }
            else if (selection == 'd' && overheated == true)
            {
                return 1; //car can move 1km if overheated in reg driving mode
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

    /** returns the move code
    */
    public int move()
    {
        return processOption(selection);//selection is updated in the game file based on the user's inputs in keyboard
        //the selection is checked against the existing possibilities which already display the corresponding number of moves.
    }
    
    /** Sets condition of car i.e. if it is overheated
     * @param value indicating track condition
    */
    public void setCarConditions(int value)
    {
        if (value == 2)
        {
            overheated = true;
        }
    }

    /** Consumes fuel for corresponding move code
    */
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