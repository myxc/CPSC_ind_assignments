/** 
 * Track.java: The track for the car race <br>
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

public class Track
{
    public static final int TRACK_SIZE = 25;
    public static final int MAX_CARS = 2;
    public static enum TrackCondition {HEATWAVE, BLIZZARD, NORMAL};
    
    public Car[] cars = {new SUV(), new Sports()};
    private int[] locations;
    private TrackCondition condition;
    private boolean finished;
    //Blizzard: SUV doesn't run unless in AWD. Sports car drives regular
    //Heat wave: Sports car is automatically in overheated mode until the driver cools car off by stopping for a round, SUV drives regular.
    //

    /** Create the track and place the car at the beginning of a track to start the race.
     * cars are hard coded because according to TA there's no case where cars are in different orders or anything.
     */
    public Track()
    {
        cars = new Car[MAX_CARS];
        locations = new int[MAX_CARS];
        for (int i = 0; i < MAX_CARS; i++)
        {
            cars[i] = null;
            locations[i] = 0;
        }
        condition = TrackCondition.NORMAL;
        finished = false;
    }

    /** Sets car array with actual cars
    */
    public void setCars()
    {
        cars[0] = new SUV(); //Car 1 is SUV, car 2 is Sports Car
        cars[1] = new Sports();
    }

    /** returns weather condition
     * @return condition weather condition
    */
    public TrackCondition getCondition()
    {
        return condition;
    }

    /** sets the weather condition according to random algo
    */
    public void setCondition(int trackCond)
    {
        if (trackCond == 0)
        {
            condition = TrackCondition.BLIZZARD;
        }
        else if (trackCond == 1)
        {
            condition = TrackCondition.HEATWAVE;
        }
        else
            condition = TrackCondition.NORMAL;
    }

    /** returns status of game
     * @return status of the game true for finished game and false otherwise
    */
    public boolean getStatus()
    {
        return finished;
    }

    /** Updates the status of the game based on whether cars reached finish line this round or if they quit
    */
    public void updateStatus()
    {
        if (locations[0] == 24 || locations[1] == 24) //if either of them reaches then checkWin returns true
        {
            finished = true;
        }
            
        else if(cars[0].move() == 99 && cars[1].move() == 99)
        {
            finished = true;
        }
    }

    /** prints the round number or game over if the game is finished
     * @param round number which increments each round
    */
    public void print_round(int round_number)
    {
     if (finished == false)
     {
         System.out.println("========== Round " + round_number + "==========");
     }
     else 
     {
         System.out.println("========== Game Over ==========");
     }   
    }

    /** Moves the first car which is assumed to be and hard coded as SUV as TA indicated it will be
     * @param km to move the car
    */
    public void moveCar1(int num_km)
    {//this method updates the location of the car, and if the user quit then it updates finished token.
        if (num_km == 78)
        {
            finished = true;
        }
        else if (num_km == 99)
        {
            System.out.println("=== Skipping SUV (out of fuel) ===");
        }
        else if (locations[0] + num_km > 24)
        {
            System.out.println("Move: " + num_km);
            locations[0] = 24;
        }
        else
        {
            System.out.println("Move: " + num_km);
            locations[0] += num_km;
        }
    }

    /** Moves the second car which is assumed to be and hard coded as Sports car as TA indicated it will be
     * @param km to move the car
    */
    public void moveCar2(int num_km)
    {
        if (num_km == 78)
        {
            finished = true;
        }
        else if (num_km == 99)
        {
            System.out.println("=== Skipping Sports (out of fuel) ===");
        }
        else if (locations[1] + num_km > 24)
        {
            System.out.println("Move: " + num_km);
            locations[1] = 24;
        }
        else
        {
            System.out.println("Move: " + num_km);
            locations[1] += num_km;
        }
            
    }

    /** Displays the track with a numbered grid.  The car will appeart in the grid reflecting its current location.
     */
    public void display()
    {
        // Display track condition
        System.out.print("Track condition: ");
        switch (condition)
        {
            case BLIZZARD:
                System.out.println ("blizzard");
                break;
            case HEATWAVE:
                System.out.println ("heatwave");
                break;
            case NORMAL:
                System.out.println ("normal");
                break;
            default:
                System.out.println ("unknown");
        }

        // Compile each part the track for display
        char label = 'A';
        String trackLabel = "";
        String separator = "";
        String grid = "";
        grid += "|";
        for (int i = 0; i < TRACK_SIZE; i++)
        {
            for (int j = 0; j < MAX_CARS; j++)
            {
                trackLabel += " ";
                separator += "-";
                if (i == locations[j])
                    grid += cars[j].getAppearance();
                else
                    grid += " ";
            }
            trackLabel += label;
            separator += "-";
            label += 1;  
            grid += "|";         
        }
        //grid += "|";
     
        // Display the track
        System.out.println(trackLabel);
        System.out.println(separator);
        System.out.println(grid);
        System.out.println(separator);
        
    }
}