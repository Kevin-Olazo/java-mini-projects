package week02_entertainment_collection_system.test;

import week02_entertainment_collection_system.VideoGame;

public class VideoGameTest {
    public static void main(String[] args) {

        VideoGame vg1 = new VideoGame("COD", 2025, 6, "PS5",true, 120);
        VideoGame vg2 = new VideoGame("DOTA 2", 2022, 9, "PC",true, 30);
        VideoGame vg3 = new VideoGame("DOTA 2", 2022, 9, "PC",false, 30);


        System.out.println(vg1.calculateValue());
        System.out.println(vg2.calculateValue());
        System.out.println(vg3.calculateValue());
    }
}
