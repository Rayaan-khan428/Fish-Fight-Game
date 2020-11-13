/**
 * Programmer Name: Rayaan Khan
 * Date: 2020-10-22
 * Project: FishTank.java
 * Program Name: Fish Tank
 */

package fishtank;
import java.util.Scanner; // accept input
import java.util.Random;  // random number generator
import static java.lang.System.out; // shorten output statement

public class FishTank {
    
    static public Scanner scanS = new Scanner(System.in); // Global Str Scanner
    static public Scanner scanN = new Scanner(System.in); // Global Num Scanner    
    static public Random randomNumbers = new Random(); // Global Num Generator
    
    public static void main(String[] args) throws InterruptedException {
        
        Fish[] fishObj = new Fish[5]; // initailzes instance of 5 fishes
        
        out.println("\nPlease describe the 5 fish in your fish tank\n");
        
        /*
        This for loop initializes the array which collects name, size, and
        state of being, it stores info into object it does that until we have 5 
        fish in the database
        */
        for (int i = 0; i < fishObj.length; i++)
            fishObj[i] = getData(i);
        
        printNames(fishObj); // prints list of Fish
        fishFight(fishObj); // calls method to fight!
        printNames(fishObj); // prints list of Fish
    }
    
    /**
     * Method Name: getData
     * Description: The method gathers the initial information and stores it 
     * into an array, it stores name, and size, and sets each one to living
     * @param i // to keep count next to fish #
     * @return name // name of fish
     * @return size // size of fish
     * @return alive // state of being of fish                                  
     */
    public static Fish getData(int i) {
                
        boolean errorTrap; // for error trapping
        boolean alive = true; // is alive by default                                
        String name; // fish name
        int size = 0; // fish size
        i++; // adds one so it does not show 0 in output (user friendliness)
                       
        out.print("\nwhat is the name of fish #" + i + "--> ");
        name = scanS.nextLine(); // storing name
  
        do { // error trapping
            errorTrap = false; // resets to avoid infinity loop
            try { 
                // if user enters string rather than an integer it shows no error
                out.print("\nWhat is the size of " + name + "? (1-10) --> ");
                size = scanN.nextInt(); // storing size
            } catch (java.util.InputMismatchException e) {
                System.out.println("\nPlease enter integer: "
                        + "for example enter '1' not 'one'");
                String soak = scanN.nextLine(); // take string out of the buffer 
                errorTrap = true; // loop shall repeat again
            }
            
            if (errorTrap != true && size > 10 || errorTrap != true && size <= 0) {
                System.out.println("\nplease enter a number between 1 and 10");
                errorTrap = true;
            }
        } while (errorTrap == true); // error trap ends
        
        return new Fish(name, size, alive); // stores variables in new Fish obj
    } // method ends
    
    /**
     * Method Name: fishFight
     * Description: this field prints out the fish fighting and says who won
     * as well as prints out the updated list of fishes
     * @param fishObj // array where the data is stored
     * @throws java.lang.InterruptedException // to add delays in output
     */
    public static void fishFight (Fish[] fishObj) throws InterruptedException {
        
        int firstF = randomNumbers.nextInt(5); // generate random num 1-5
        int secondF = randomNumbers.nextInt(5); // generate random num 1-5
        
        // if both are equal it will reshuffle untill the #'s are unique
        while (firstF == secondF) 
            secondF = randomNumbers.nextInt(5); 

        // print statement
        Thread.sleep(3000); // wait 2 seconds
        out.println("\nOh no! " + fishObj[firstF].getName()
                + " is fighting " + fishObj[secondF].getName());
        Thread.sleep(1000); // wait one second
        
        // calls method from Fish Class (starts fight)
        fishObj[firstF].Fight(fishObj[secondF]); 
    } // method ends
    
    /**
     * Method Name: printNames
     * Description: This method when called prints out the list of all the fish
     * with their sizes and state of being
     * @param fishObj // array where the data is stored
     * @throws InterruptedException 
     */
    public static void printNames (Fish[] fishObj) throws InterruptedException {
        out.println("\nYour tank is filled with the following fish: ");
        
        for (Fish fishObj1 : fishObj) {
            Thread.sleep(150); // wait 0.15 seconds
            out.println(fishObj1.toString()); // prints sizes and states
        } // loop ends
    } // method ends
} // class ends
