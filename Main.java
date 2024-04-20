import Life.Creature;
import Life.World;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        World world = new World();
        Scanner scan = new Scanner(System.in);
        int keepPlaying = 1;
        int yearCount = 0;
        boolean yearOfDeath = false;
        while(keepPlaying == 1)
        {
            System.out.println("It is year " + yearCount + " in our simulation...");
            //Each round, there is a 30% chance a creature will be spontaneously created
            Random random = new Random();
            if(random.nextInt(11) > 7)
            {
                world.createCreature();
            }

            //Spawn age elixir into the world. Age elixir increases a creatures age by 2, also increasing the chances that creature will be able to reproduce
            world.spawnAgeElixir();

            //If the year count is under 7, no deaths are possible. This is included so that creatures have a better chance of surviving
            if(yearCount > 7)
            {
                world.reaper();
            }

            //See if any creatures can reproduce
            world.reproduceCreatures();

            //Increase all of the surviving creature's age by 1
            world.increaseAge();

            //Print out the number of survivors
            world.printCreatures();

            System.out.println("\nThere are " + world.getAlivePopulation() + " alive creatures in our world");
            System.out.println("There are " + world.getDeadPopulation() + " dead creatures in our world");

            //Ask if the user wants to see another year of the simulation or not
            System.out.println("\nWould you like to continue on in this simulation? Enter 1/0:");
            keepPlaying = scan.nextInt();
            yearCount++;
            
        }
    }
}
