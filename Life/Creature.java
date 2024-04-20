package Life;
import java.util.*;
//import Life.LifeForm.deathCause;
//import Life.LifeForm.moodFeeling;

public class Creature implements LifeForm{
    String name;
    String species;
    int age;
    deathCause cause;
    moodFeeling mood;
    double cod = 0.05; //Chance of death
    double cor = .1; //Chance of reproduction
    
    public void causeOfDeath(int i)
    {
        
        cause = deathCause.values()[i];
        System.out.println(name + " was " + cause + ".");
    }

    public boolean die()
    {
        if(age < 5)
        {
            if(cod > 25)
            { 
                return false;
            }
        }
        else if(age < 10)
        {
            if(cod > 75)
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

    //If a creature is under the age of 5, it cannot reproduce. If its above 5 years old, it has a 10 percent chance of reproducing
    public boolean reproduce()
    {
        Random random = new Random();
        if(age < 5)
        {
            return false;
        }
        //Ten percent chance of reproducing
        else if(random.nextInt(11) <= 9)
        {
            return false;
        }
        return true;

    }

    public void mood(int i)
    {
        mood = moodFeeling.values()[i];
        System.out.println(name + " is feeling " + mood + ".");
    }

    public void creatureInfo()
    {
        System.out.println(name + " is a " + species + " who is " + age + " years old.");
    }

    //Update the creatures age
    public void oneYear()
    {
        age += 1;
    }

}
