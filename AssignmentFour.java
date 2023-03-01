//package assignment4_000848909
import java.util.Random;
import java.util.Scanner;

/**
 * Driver program
 */
public class Main {
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        //read in the number of dice
        Scanner sc = new Scanner(System.in);
        System.out.print("How many dice? ");
        int num = Integer.parseInt(sc.nextLine());
        //declare the array and read in the sides
        int sides[] = new int[num];
        System.out.print("Enter the number of sides of each die: ");
        String values[] = sc.nextLine().split(" ");
        //convert to integer array
        for(int i = 0; i < values.length; i++){
            sides[i] = Integer.parseInt(values[i].trim());
        }

        //create the collection and print it
        DiceCollection collection = new DiceCollection(sides);
        System.out.println(collection);
        boolean done = false;
        //loop until user quits
        while (!done){
            //print menu
            System.out.print("1=roll once, 2=roll 100000 times, 3=quit: ");
            num = Integer.parseInt(sc.nextLine());
            //process input
            switch (num){
                case 1:
                    //roll once and print the collection
                    collection.roll(1);
                    System.out.println(collection);
                    break;
                case 2:
                    //roll 100000 times and display the histogram
                    collection.roll(100000);;
                    collection.histogram();
                    break;
                case 3:
                    //quit
                    done = true;
                    break;

            }
        }

    }
}


/**
 * Class representing a collection of die
 */
class DiceCollection {
    /**
     * Array holding the actual dice
     */
    private Die dice[];
    /**
     * Array to hold each bucket and it's count of occurences
     */
    private int rolls[];

    /**
     * constructor to initialize the die
     * @param counts
     */
    public DiceCollection(int counts[]) {
        //initialize the dice array
        dice = new Die[counts.length];
        //set all the die with approrpiate sizes
        for(int i = 0; i < dice.length; i++){
            dice[i] = new Die(counts[i]);
        }
    }

    /**
     * Get maximum possible roll
     * @return
     */
    public int getMaxRoll(){
        int sum = 0;
        //add up all the maximum values
        for(int i = 0; i < dice.length; i++){
            sum+=dice[i].getMax();
        }
        return sum;
    }

    /**
     * Minimum roll is if each rolled 1
     * @return
     */
    public int getMinRoll(){
        return dice.length;
    }

    /**
     * get current sum of faces
     * @return
     */
    public int currentSum(){
        int sum = 0;
        //sum up all current faces
        for(int i = 0; i < dice.length; i++){
            sum+=dice[i].getNum();
        }
        return sum;
    }

    /**
     * roll all dice a certain number of times
     * @param times
     */
    public void roll(int times){
        //initialize the buckets
        rolls = new int[getMaxRoll()-getMinRoll()+1];

        //for each round
        for(int i = 0; i < times; i++){
            for(Die d: dice) d.roll(); //roll all the dice
            int val = currentSum() - getMinRoll(); //get the current roll value and subtract min to get array index
            rolls[val]++; //increment the array index
        }
    }

    /**
     * Strign representation of a collection
     * @return
     */
    public String toString(){
        //initialize the string
        String str = "Dice Collection: ";

        //append all die information
        for(Die d: dice){
            str+=d.toString()+" ";
        }
        //append min max, and current information
        str+="\n";
        str+="Min="+getMinRoll()+" Max="+getMaxRoll()+" Current="+currentSum();
        return str;
    }

    /**
     * Draw histogram
     */
    public void histogram(){
        //get the maximum and minimum values
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int d: rolls){
            if(d < min)
                min = d;
            if(d > max)
                max = d;
        }

        //split into 15 max steps
        double step = (max-min)/15.0;
        if((max-min) < 15)
            step = 1;

        //go through all buckets
        for(int i = 0; i < rolls.length; i++){
            //skip if 0
            if(rolls[i] == 0) continue;
            //print the bucket data
            System.out.printf("%2d: %5d ", (i+getMinRoll()), rolls[i]);
            //print asterisk for it's size
            for(double j = 0; j < rolls[i]; j+=step){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

/**
 * Class to represent die information
 */
class Die {
    /**
     * Current face
     */
    private int num;
    /**
     * Maximum possible roll
     */
    private final int max;

    /**
     * Constructor to take in max possible roll
     * @param max
     */
    public Die(int max) {
        this.max = max;
        //get random roll
        roll();
    }

    /**
     * getter for the current face
     * @return
     */
    public int getNum() {
        return num;
    }

    /**
     * getter for max possible roll
     * @return
     */
    public int getMax() {
        return max;
    }

    /**
     * generate random roll in given range
     */
    public void roll(){
        //use random generator
        Random random = new Random();
        //get the random value
        num = random.nextInt(max)+1;
    }

    /**
     * String representation of the die
     * @return
     */
    public String toString(){
        return "d"+max+"="+num;
    }
}

