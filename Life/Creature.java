package Life;
import java.util.*;

public class Creature implements LifeForm{
    String name;
    String species;
    int age;
    deathCause cause;
    moodFeeling mood;

    
    //This function prints out an animals cause of death. Not utilized in this assignment
    public void causeOfDeath(int i)
    {
        cause = deathCause.values()[i];
        System.out.println(name + " was " + cause + ".");
    }

    public boolean die()
    {
        Random random = new Random();
        //Creatures under the age of 5 have a 95% chance of living
        if(age < 5)
        {
            if(random.nextInt(101) > 5)
            { 
                return false;
            }
        }
        //Creatures between 5-10 have a 70% chance of living
        else if(age < 11)
        {
            if(random.nextInt(101) > 30)
            {
                return false;
            }
        }
        else
        {
            //Creatures over 10 have a 20% chance of living
            if(random.nextInt(101) > 80)
            {
                return false;
            }
        }
        return true;
                   
    }

    //This constructor is used for spontaneous creature development
    public Creature(String n, int s)
    {
        name = n;
        species = SPECIES[s];
        age = 0;
    }

    //This constructor is used when a creature reproduces. This ensures that a creature of the same species is produced
    public Creature(String n, String s)
    {
        name = n;
        species = s;
        age = 0;
    }

    //Returns the species of the current creature
    public String getSpecies()
    {
        return species;
    }

    //If a creature is under the age of 5, it cannot reproduce. If its above 5 years old, it has a 20 percent chance of reproducing
    public boolean reproduce()
    {
        Random random = new Random();
        if(age < 5)
        {
            return false;
        }
        //Twenty percent chance of reproducing
        else if(random.nextInt(11) < 9)
        {
            return false;
        }
        return true;

    }

    //Function to print a creatures mood. Not utilized in this assignment, maybe in the future.
    public void mood(int i)
    {
        mood = moodFeeling.values()[i];
        System.out.println(name + " is feeling " + mood + ".");
    }

    //Print out the creature's info
    public void creatureInfo()
    {
        System.out.println(name + " is a " + species + " who is " + age + " years old.");
    }

    //Update the creatures age (used if a creature survives a year)
    public void oneYear()
    {
        age += 1;
    }

    //Elixir bumps up a creatures age by 2
    public void elixirEnhancement()
    {
        age += 2;
    }


}
