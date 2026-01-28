package week02_entertainment_collection_system.test;

import week02_entertainment_collection_system.*;

import java.util.ArrayList;
import java.util.List;

public class EntertainmentTest {
    public static void main(String[] args) {

        List<Entertainment> entertainmentList = new ArrayList<>();

        VideoGame vg1 = new VideoGame("COD", 2025, 6, "PS5", true, 120);
        VideoGame vg2 = new VideoGame("DOTA 2", 2011, 8, "PC", true, 30);
        VideoGame vg3 = new VideoGame("Devil May Cry", 2015, 7, "PC", false, 60);


        System.out.println("======= VIDEO GAMES =======\n");

        System.out.println(vg1.calculateValue());
        System.out.println(vg2.calculateValue());
        System.out.println(vg3.calculateValue());


        System.out.println("======= INDIE GAMES =======\n");

        IndieGame indgame1 = new IndieGame("Celeste", 2023, 8, "Switch", false, 15, "Ubisoft", true);

        System.out.println(indgame1.calculateValue());
        indgame1.play();

        System.out.println("\n======= MOVIES =======\n");

        Movie movie1 = new Movie("Harry Potter", 2002, 8, "4K", false, 198, "David Yates", "Fantasy");
        Movie movie2 = new Movie("Inception", 2016, 9, "4K", false, 220, "Christopher Nolan", "Sci-fi");
        Movie movie3 = new Movie("Fast and Furious", 2020, 7, "1080p", true, 168, "Vin-Diesel", "Action");

        movie1.play();
        System.out.println(" ");
        movie2.play();
        System.out.println(" ");
        movie3.play();

        System.out.println("\n======= SERIES =======\n");

        Series ser1 = new Series("Breaking Bad", 2013, 9.9, "4K", false, 60, 5, 10);
        Series ser2 = new Series("Game of thrones", 2016, 8.8, "4K", false, 60, 8, 12);
        Series ser3 = new Series("I.T Crowd", 2014, 7.6, "720p", true, 60, 3, 8);

        ser1.play();
        System.out.println(" ");
        ser2.play();
        System.out.println(" ");
        ser3.play();

        entertainmentList.add(vg1);
        entertainmentList.add(vg2);
        entertainmentList.add(vg3);

        entertainmentList.add(indgame1);

        entertainmentList.add(movie1);
        entertainmentList.add(movie2);
        entertainmentList.add(movie3);

        entertainmentList.add(ser1);
        entertainmentList.add(ser2);
        entertainmentList.add(ser3);


        for (Entertainment e : entertainmentList) {
            System.out.println(e.getInfo());
            System.out.println(e.calculateValue());
        }


    }
}
