package Life;
public interface LifeForm
{
    //All lifeforms have to be able to die and reproduce. I included a list of species for the sake of this simulation
    boolean die();
    boolean reproduce();
    String[] SPECIES = {"Rabbit", "Wolf", "Bear"};

    //These enum behaviors are not utilized in this assignment. Maybe in the future
    enum deathCause
    {
        STARVED,
        EATEN,
        KILLED_BY_AGE
    }
    enum moodFeeling
    {
        HAPPY,
        SAD,
        FRUSTRATED,
        HUNGRY,
        TIRED,
        ESTATIC,
        SCARED
    }

}