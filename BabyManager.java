import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Write a description of class BabyManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BabyManager
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        BabyNamesDatabase dataBase = new BabyNamesDatabase();
        Scanner scnr = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat ("###,###,###");

        dataBase.readBabyNameData("BabyNames.csv");

        System.out.println("* Testing BabyNamesDatabase Class *");

        System.out.println("* Testing countAllNames *");
        System.out.println("All Names Count: " + 
            fmt.format(dataBase.countAllNames()));

        System.out.println("* Testing countAllGirls *");
        System.out.println("All Girls Names Count: " + 
            fmt.format(dataBase.countAllGirls()));

        System.out.println("* Testing countAllBoys *");
        System.out.println("All Boys Names Count: " + 
            fmt.format(dataBase.countAllBoys()));

        System.out.println("* Testing searchForYear *");
        int year = scnr.nextInt();
        ArrayList<BabyName> searchForYear = dataBase.searchForYear(year);
        for(BabyName b: searchForYear){
            System.out.println(b);
        }

        System.out.println("* Testing mostPopularGirl *");
        int year1 = scnr.nextInt();
        BabyName mostPopularGirl = dataBase.mostPopularGirl(year1);
        System.out.println(mostPopularGirl);

        System.out.println("* Testing mostPopularBoy *");
        int year2 = scnr.nextInt();
        BabyName mostPopularBoy = dataBase.mostPopularBoy(year2);
        System.out.println(mostPopularBoy);

        System.out.println("* Testing searchForName*");
        String name = scnr.next();
        ArrayList<BabyName> searchForName = dataBase.searchForName(name);
        for( BabyName x : searchForName){
            System.out.println(x);
        }

        System.out.println("* Testing topTenNames *");
        int year3 = scnr.nextInt();
        ArrayList<BabyName> coolList = dataBase.topTenNames(year3);
        for( BabyName b : coolList){
            System.out.println(b);
        }
    }
}
