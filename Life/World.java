package Life;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class World  
{
    public ArrayList<Creature> creatures = new ArrayList<>();
    public ArrayList<Creature> deadCreatures = new ArrayList<>();
    private ArrayList<String> names;

    //This function creates a new creature with a random name from the name.txt file. It also passes in a random number between 0-2 to determine
    //the species of the new creature
    public void createCreature()
    {
        Random random = new Random();
        String name = names.get(random.nextInt(names.size()));
        int speciesNum = random.nextInt(3);
        Creature c = new Creature(name, speciesNum);
        creatures.add(c);
    }

    //When a new world is created, read in the list of future creature names
    public World()
    {
        nameGenerator();
    }


    //This function accesses the name.txt file and stores each name in our names array list
    private void nameGenerator()
    {
        names = new ArrayList<String>();
        try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\nemar\\OneDrive\\Documents\\GitHub\\A-Living-World\\Life\\name.txt")))
        {
            String line;
            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                for(String part: parts)
                {
                    names.add(part.trim());
                }
            }
        }
        catch (IOException e)
        {
        e.printStackTrace();
        }

    } 

    //Print each living creature's info
    public void printCreatures()
    {
        for(int i = 0; i < creatures.size(); i++)
        {
            creatures.get(i).creatureInfo();
        }
    }

    //Add 1 age to each creature. Called after each round of the simulation
    public void increaseAge()
    {
        for(int i = 0; i < creatures.size(); i++)
        {
            creatures.get(i).oneYear();
        }
    }

    //Loop through our living creatures and see if any of them can reproduce
    public void reproduceCreatures()
    {
        for(int i = 0; i < creatures.size(); i++)
        {
            Creature current = creatures.get(i);
            boolean rep = current.reproduce();
            //If this creature can reproduce, create a new creature of the same species
            if(rep)
            {
                String s = current.getSpecies();
                Random random = new Random();
                String name = names.get(random.nextInt(names.size()));
                Creature c = new Creature(name, s);
                creatures.add(c);
            }
        }
    }

}
