package Life;
public interface LifeForm
{
    boolean die();
    boolean reproduce();
    String[] SPECIES = {"Rabbit", "Wolf", "Bear"};
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