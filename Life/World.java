package Life;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class World  
{
    public ArrayList<Creature> creatures = new ArrayList<>();
    private ArrayList<String> names;
    public void createCreature()
    {
        Random random = new Random();
        String name = names.get(random.nextInt(names.size()));
        int speciesNum = random.nextInt(3);
        Creature c = new Creature(name, speciesNum);
        creatures.add(c);
    }

    public World()
    {
        nameGenerator();

    }

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

    public void printNames()
    {
        for(int i = 0; i < 5; i++)
        {
            System.out.println(names.get(i));
        }
    }

    public void printcreatures()
    {
        for(int i = 0; i < creatures.size(); i++)
        {
            creatures.get(i).creatureInfo();
        }
    }

}
