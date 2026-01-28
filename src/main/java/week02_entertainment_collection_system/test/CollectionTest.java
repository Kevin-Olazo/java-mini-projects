package week02_entertainment_collection_system.test;

import week02_entertainment_collection_system.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        List<Entertainment> list = new ArrayList<>();

        Movie movie1 = new Movie("Movie", 2021, 7.8, "4K", true, 187, "Christopher Nolan", "Action");

        Series series1 = new Series("Breaking Bad", 2013, 9.8,"1080p", false, 55, 5, 10);

        AAAGame aaagame1 = new AAAGame("Elden ring", 2022, 8.9, "PC", true, 98, "FROM SOFTWARE", true);

        IndieGame indiegame1 = new IndieGame("Celeste", 2019, 7.5, "Switch", false, 12, "OK Games", true);
        IndieGame indiegame2 = new IndieGame("Celeste", 2020, 7.5, "PC", false, 11, "OK Games", false);
        IndieGame indiegame3 = new IndieGame("Hollow Knight", 2018, 7.9, "Switch", false, 18, "Team Cherry", false);

        list.add(movie1);
        list.add(series1);
        list.add(aaagame1);
        list.add(indiegame1);
        list.add(indiegame2);
        list.add(indiegame3);


        for (Entertainment e : list){
            System.out.println("\n=== Item ===");
            System.out.println(e.toString());
            e.play();
            System.out.println(e.getTitle() + ": $" + e.calculateValue());
        }

        System.out.println(indiegame1.equals(indiegame2));
        System.out.println(indiegame1.hashCode() == indiegame2.hashCode());
    }
}
