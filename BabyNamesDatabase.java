import java.util.ArrayList;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.IOException;
import java.util.Collections;
/**
 * Write a description of class BabyNameDatabase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BabyNamesDatabase
{
    // instance variables - replace the example below with your own
    private ArrayList<BabyName> list;

    /**
     * Constructor for objects of class BabyNameDatabase
     */
    public BabyNamesDatabase()
    {
        // initialise instance variables
        list = new ArrayList<BabyName>();
    }

    public void readBabyNameData(String filename){
        // Read the full set of data from a text file
        try{ 
            // open the text file and use a Scanner to read the text
            FileInputStream fileByteStream = new FileInputStream(filename);
            Scanner scnr = new Scanner(fileByteStream);
            scnr.useDelimiter("[,\r\n]+");

            // keep reading as long as there is more data
            while(scnr.hasNext()) {
                // reads each element of the record
                String name = scnr.next();
                String gender = scnr.next();
                // TO DO: read the count and year
                int count = scnr.nextInt();
                int year = scnr.nextInt();
                // TO DO: assign true/false to boolean isFemale based on
                // the gender String
                boolean isFemale = false;
                if(gender.equals("F")){
                    isFemale = true;
                }
                // instantiates an object of the BabyName class
                BabyName babyName = new BabyName(name, isFemale, count, year); 
                // TO DO: add to the ArrayList the babyName created above
                list.add(babyName);
            }
            fileByteStream.close();
        }
        catch(IOException e) {
            System.out.println("Failed to read the data file: " + filename);
        }
    }

    public int countAllNames(){
        return list.size();
    }

    public int countAllGirls(){
        int result = 0;
        for(BabyName b : list){
            if(b.isFemale()){
                result += b.getCount();
            }
        }
        return result;
    }

    public int countAllBoys(){
        int result = 0;
        for(BabyName b : list){
            if(!b.isFemale()){
                result += b.getCount();
            }
        }
        return result;
    }

    public ArrayList<BabyName> searchForYear(int year){
        ArrayList<BabyName> result = new ArrayList<BabyName>();
        for(BabyName b : list){
            if(b.getYear() == year){
                result.add(b);
            }
        }
        return result;
    }

    public BabyName mostPopularGirl(int year){
        BabyName result = null;
        int max = 0;
        for(BabyName b : list){
            if(b.getYear() == year && b.isFemale()){
                if(b.getCount() > max){
                    max = b.getCount();
                    result = b;
                }
            }
        }
        return result;
    }

    public BabyName mostPopularBoy(int year){
        BabyName result = null;
        int max = 0;
        for(BabyName b : list){
            if(b.getYear() == year && !b.isFemale()){
                if(b.getCount() > max){
                    max = b.getCount();
                    result = b;
                }
            }
        }
        return result;
    }

    public ArrayList<BabyName> searchForName(String name){

        ArrayList<BabyName> result = new ArrayList<BabyName>();
        for(BabyName b : list){
            if(b.getName().equalsIgnoreCase(name)){
                result.add(b);
            }
        }
        return result;
    }

    public ArrayList<BabyName> topTenNames(int year){
        ArrayList<BabyName> allData = new ArrayList<BabyName>();
        for( BabyName b : list){
            if(b.getYear() == year){
                allData.add(b);
            }
        }
        Collections.sort(allData);
        ArrayList<BabyName> result = new ArrayList<BabyName>();
        int counter = 0;
        for(BabyName b : allData){
            result.add(b);
            counter++;
            if(counter == 10){
                break;
            }
        }
        return result;
    }
}
