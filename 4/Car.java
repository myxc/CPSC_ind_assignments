/** 
 * Car.java: The parent class for all car models. <br>
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
//if car runs out of fuel then it stops in place until race is over, 
//if all cars run out of fuel then game is over.
//Appearance of car: "V" for SUV and "P" for sports car
// name of car is whatever.
//fuelLevel is fuel units remaining in car.
public abstract class Car
{
    // public static boolean empty = false;
    public static final int DEFAULT_FUELLEVEL = 60;
    private char appearance;
    private String name;
    private int fuelLevel;
    
    /** Constructor: initilize the appearance and fuel level
     * @param letter The symbol representing the car
     * @param fuel The intial fuel level
    */
    public Car(char anAppearance, String carName)
    {
        if (anAppearance == 'V' || anAppearance == 'P')
        {appearance = anAppearance;
                name = carName;
                fuelLevel = DEFAULT_FUELLEVEL;}
        else
            System.out.println("The appearance is invalid");
    }
    
    /** Get the fuel level.
     * @return The current fuel level
     */
    public int getFuelLevel()
    {
        return fuelLevel;
    }

    /** Constructor: initilize the appearance and fuel level
     * @param num number to set fuel level to
    */
    public void setFuelLevel(int num)
    {
        fuelLevel = num;
    }

    /** Check whether the fuel is empty.
     * @return True, if the tank is empty.  Otherise, false.
     */
    public boolean isEmpty()
    {
        if (getAppearance() == 'V')
        {
            if (fuelLevel < 6)
                return true;
            else
                return false;
        }
        else
        {
            if (fuelLevel < 4)
                return true;
            else
                return false;
        }
        
    }

    /** Consume fuel by reducing fuel level.
     * @param amount The amount of fuel to consume.
     */
    public abstract void consumeFuel();
    

    /** Get the appearance of a car
     * @return The symbol representing the car
     */
    public final char getAppearance()
    {
        return appearance;
    }
    
    /** Constructor: initilize the appearance and fuel level
     * @return name and fuel remaining
    */
    public final String toString() 
    {
        return name + ": " + fuelLevel;
    }

    /** Constructor: initilize the appearance and fuel level
     * @param val value corresponding to weather condition that affects car
    */
    public abstract void setCarConditions(int val);

    /** Constructor: initilize the appearance and fuel level
     * @param character indicating the selection made by user
    */
    public abstract void setSelection(char ch);
    
    /** An abstract method move() to be defined by specific car model
     * @return The number of moves the car makes.
     */
    public abstract int move ();

    /** Display the options for this car.
     */
    public abstract void displayOptions();
    
    /** Process the option provided by players
     * @param option The option provided by players.
     * @return The distance traveled in this move.
     */
    public abstract int processOption(char option);

}