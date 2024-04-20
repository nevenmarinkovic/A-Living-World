import Life.Creature;
import Life.World;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        World world = new World();
        Scanner scan = new Scanner(System.in);
        int keepPlaying = 1;
        int yearCount = 0;
        while(keepPlaying == 1)
        {
            System.out.println("It is year " + yearCount + " in our simulation...");
            //Each round, there is a 20% chance a singular creature will be spontaneously created
            Random random = new Random();
            if(random.nextInt(11) > 8)
            {
                world.createCreature();
            }

            //See if any creatures can reproduce
            world.reproduceCreatures();

            //Increase all of the surviving creature's age by 1
            world.increaseAge();

            //Print out the number of survivors
            world.printCreatures();

            //Ask if the user wants to see another year of the simulation or not
            System.out.println("\nWould you like to continue on in this simulation? Enter 1/0:");
            keepPlaying = scan.nextInt();
            yearCount++;
            
        }
    }
}
