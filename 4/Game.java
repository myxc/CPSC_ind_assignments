/** 
 * Game.java: The track for the car race <br>
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
import java.util.Scanner;
import java.util.Random;

/**
 * Check if game_over counter == 1 or displays round number (starts with round counter at 1)
 * Start of turns loop i.e. while (game_over counter != 1) with nested for loop of for i = 0; i < CARS; i++; to iterate between cars
 * Then the track condition is randomized and displayed
 * Track is then rendered
 * Car 1's fuel level is checked and then it either displays "=== SUV driving options ===" or "=== Skipping SUV (out of fuel) ===" which continues to the iteration
 * Car 1 enters selection, if the selection is "q", then increment game_over counter to true and immediately breaks out of for loop
 * Displays the number of moves (km's) for that selection (checks whether max move (25) - current position is greater than move value, if so, it moves the max amount, else, it moves the required amount.)
 * Displays remaining fuel in tank after that move
 * End of nested for loop
 * Checks if game_over counter == 1 and display message. Alternatively, it increments the turn counter.
 * Hard code to add 1 SUV and 1 sports car every time. 
 * Fuel will never be a negative value if it runs negative then it won't move for that turn.
 * Even if it moves less than the total amount possible for the round, subtract fuel as though it moved the full amount (i.e. for finish line)
 * 
 *
 * SUV and Sports classes have move which checks if empty, and consumes fuel
*/
public class Game
{
	// private static int round_number = 1;
    public static Scanner keyboard = new Scanner(System.in);
    public static char selection = 'j';
    public static int round_number = 1;
    public static void main(String [] args)
    {
        Track raceTrack = new Track();//make track
        raceTrack.setCars();//populate the cars array with suv and sports
        Random randomNumber = new Random(Long.parseLong(args[0]));
        while (raceTrack.getStatus() == false) //while loop for the rounds
        {
            raceTrack.print_round(round_number); //prints round number or game over
            round_number++;// increments the round number for the next loop
            int randomNum = randomNumber.nextInt(3);
            if (randomNum == 0)
                raceTrack.setCondition(0);
            else if (randomNum == 1)
                raceTrack.setCondition(1);
            else 
                raceTrack.setCondition(2); //Sets the condition of the track for that round
            raceTrack.display();//dsplays the current track with position of each car

            if (raceTrack.getStatus() == false) //if game isn't over
            {
                for (int i = 0; i < 2; i++) //for loop to cycle between the two cars
                {
                    //update the car based on track conditions
                    switch(raceTrack.getCondition())
                    {
                    case BLIZZARD:
                        raceTrack.cars[i].setCarConditions(1);
                        break;
                    case HEATWAVE:
                        raceTrack.cars[i].setCarConditions(2);
                        break;
                    default:
                        raceTrack.cars[i].setCarConditions(3);

                    }

                    if (raceTrack.cars[0].isEmpty() && i == 0)//no gas then let the next car move
                    {
                        raceTrack.moveCar1(99);
                        continue;
                    }
                    else if (raceTrack.cars[1].isEmpty() && i == 1) //no then the for loop ends for this iteration
                    {
                        raceTrack.moveCar2(99);
                        continue;
                    }
                    raceTrack.cars[i].displayOptions(); //display options available for that car
                    selection = keyboard.next().charAt(0); //get user input
                    raceTrack.cars[i].setSelection(selection); //set user input for that car
                    if (i == 0) //hard coded for SUV in spot 0
                    {
                        raceTrack.moveCar1(raceTrack.cars[i].move()); //skips if car has no gas, updates finished and updates status.
                         if (raceTrack.getStatus() == true) //if they quit then finished is true
                        {
                            raceTrack.print_round(round_number);
                            raceTrack.display();
                            break;//breaks loop and other car doesn't get a turn.
                        }
                        raceTrack.cars[i].consumeFuel(); //consume fuel
                        System.out.println(raceTrack.cars[i].toString());//output how much fuel is left for the car
                    }
                    else //same thing for the second car
                    {
                        raceTrack.moveCar2(raceTrack.cars[i].move());//skips the car if it has run out of gas.
                         if (raceTrack.getStatus() == true) //if they quit then finished is true
                        {
                            raceTrack.print_round(round_number);
                            raceTrack.display();
                            break;
                        }
                        raceTrack.cars[i].consumeFuel();
                        System.out.println(raceTrack.cars[i].toString());//process selection should take care of consuming fuel if there is any fuel
                    }
                }
                raceTrack.updateStatus(); //check if game has ended
                if (raceTrack.getStatus() == true) //if game ended then print game over etc.
                {
                    raceTrack.print_round(round_number);
                    raceTrack.display();
                    break;
                }
            }
            else //if game is already over and somehow it entered this loop
                break; //stop the loop
        }    
    }
}