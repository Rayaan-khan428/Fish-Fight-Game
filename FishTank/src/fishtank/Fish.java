/**
 * Programmer Name: Rayaan Khan
 * Date: 2020-10-22
 * Project: FishTank
 * Class: Fish
 * Description: Creates a fish object that stores name, size, and state of being
 */
package fishtank;
import java.util.Random; // import for randomBoolean
import static java.lang.System.out; // shorten output statement

public class Fish {
    
    public Random randomBoolean = new Random(); // generate random boolean
    
    // fields
    private String name; // name of the fish
    private int size; // representation of how large the fish is (1-10)
    private boolean alive; // true if the fish is alive, false if it is dead
    private String fishState; // to print out if it is alive or not

    // no-arg constructer (default)
    public Fish() {
       alive = true; // default state alive
       fishState = "alive"; // ^^
       size = 0; // default size is 0
       name = null; // no name by default
    }
    
    // arg constructer: user initializes these variables when they create an obj
    public Fish(String n, int s, boolean a) {
        name = n;
        size = s;
        alive = a;
        fishState = "alive";
    }
    
    // mutators   
    // Assigns a value to 'n' field
    public void setName(String n) {
        name = n;
    }
    
    // Assigns a value to 's' field
    public void setSize(int s) {
        size = s;
    }

    // Assigns a value to 'a' field
    public void setAlive (boolean a) {
        alive = a;
    }
    
    // accessors 
    // Returns the name field 
    public String getName() {
        return name;
    }

    // Returns the size field   
    public int getSize() {
        return size;
    }

    //Returns the alive field  
    public boolean getAlive () {    
        return alive;
    }
    
    /**
     * Method name: toString
     * Description: returns string with information
     * @return str // string with the print statement
     */
    @Override                                                                 
    public String toString() {
        String str; // holds print statement
        if (alive == false)
            fishState = "dead"; 
        str = (name + " is " + size + "cm and is " + fishState);
        return str;
    }

    /**
     * Method name: toString
     * Description: returns string with information
     * @return print statement // the string with the print statement
     */
//    @Override                                                                 
//    public String toString() {
//        if (alive == false)
//            fishState = "dead"; 
//
//        return (name + " is " + size + "cm and is " + fishState);
//    }

    /* 
    ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    This is more effient but I was not sure what you would want to put in the
    return method header so I put in something a bit less efficient!
    */
    
    /**
     * Method Name: fight
     * Description: Method compares both fish sizes to determine who stays alive
     * and who dies
     * @param enemy  // fish #2 
     */
    public void Fight (Fish enemy) {
        
        /*
        Compares the sizes of both fishes the bigger won wins, smaller one dies
        and if they are both the same size a random fish is picked to win
        */
        if (size > enemy.size) {  // enemy is smaller size
            out.println(name + " has won the fight!");
            enemy.setAlive(false); // sets fish state to dead
            size += 1; // increase size
            setAlive(true); // sets fish state to alive
        }
        
        else if (enemy.size > size){ // enemy is greater size
            out.println(enemy.name + " has won the fight!");
            enemy.setAlive(true); // sets fish state to alive
            enemy.size += 1; // increase size
            setAlive(false); // sets fish state to dead
        }
        
        else { // both are equal
            
            enemy.setAlive(randomBoolean.nextBoolean()); // random boolean
            if (enemy.alive == true) { // enemy alive is true
                out.println(enemy.name + " has won the fight!");
                enemy.size += 1; // increase size
                setAlive(false); // fish dead
            }
            else {  // enemy alive is false
                out.println(name + " has won the fight!");
                size += 1; // increase size
                enemy.setAlive(false); // enemy dead
            } // else statement ends
        } // conditional ends
    } // method ends
} // class ends
