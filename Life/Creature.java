package Life;
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

    public Creature(String n, int s)
    {
        name = n;
        species = SPECIES[s];
        age = 0;
    }

    public boolean reproduce()
    {
        if(age < 5)
        {
            return false;
        }
        else if(cor < 95)
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

}
