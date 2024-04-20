public class Creature implements LifeForm{
    String name;
    String species;
    int age;
    deathCause cause;
    moodFeeling mood;
    int cod; //Chance of death
    int cor; //Chance of reproduction
    
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

    public Creature(String n, String s, int cd, int cr)
    {
        name = n;
        species = s;
        cod = cd;
        cor = cr;
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

}
