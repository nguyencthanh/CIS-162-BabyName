import java.text.DecimalFormat;
/**
 * Write a description of class BabyName here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BabyName implements Comparable
{
    // instance variables - replace the example below with your own
    private String name;
    private boolean gender;
    private int babyCount;
    private int year;
    DecimalFormat fmt = new DecimalFormat ("###,###,###");

    /**
     * Constructor for objects of class BabyName
     */
    public BabyName(String n, boolean g, int c, int y)
    {
        // initialise instance variables
        name = n;
        gender = g;
        babyCount = c;
        year = y;
    }

    public boolean isFemale(){
        return gender;
    }

    public String getName(){
        return name;
    }

    public int getCount(){
        return babyCount;
    }

    public int getYear(){
        return year;
    }

    public String toString(){
        if(isFemale()){
            return fmt.format(babyCount) + " girls named " + name + " in " + year; 
        }
        else{
            return fmt.format(babyCount) + " boys named " + name + " in " + year;
        }
    }

    public int compareTo(Object other){
        BabyName b = (BabyName) other;
        return (b.babyCount - babyCount);
    }

}
