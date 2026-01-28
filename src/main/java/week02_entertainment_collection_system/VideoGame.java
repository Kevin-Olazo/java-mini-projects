package week02_entertainment_collection_system;

import java.time.LocalDate;

public class VideoGame extends Entertainment {
    private String platform;
    private boolean hasMultiplayer;
    private double sizeInGB;

    public VideoGame(String title, int releaseYear, double rating, String platform, boolean hasMultiplayer, double sizeInGB) {
        super(title, releaseYear, rating);
        this.platform = platform;
        this.hasMultiplayer = hasMultiplayer;
        this.sizeInGB = sizeInGB;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public boolean isHasMultiplayer() {
        return hasMultiplayer;
    }

    public void setHasMultiplayer(boolean hasMultiplayer) {
        this.hasMultiplayer = hasMultiplayer;
    }

    public double getSizeInGB() {
        return sizeInGB;
    }

    public void setSizeInGB(double sizeInGB) {
        this.sizeInGB = sizeInGB;
    }

    @Override
    public void play() {
        System.out.println("Launching " + getTitle() + " on " + platform);
    }

    @Override
    public double calculateValue() {
        double basePrice = 0;
        int actualYear = LocalDate.now().getYear();

        // Si salió hace <2 años, precio base es 60
        if (actualYear - getReleaseYear() <= 2) {
            basePrice = 60.00;
        } else if (actualYear - getReleaseYear() > 2) {
            int rest = ((actualYear - getReleaseYear()) - 2) * 10;
            basePrice = 60.00 - rest;
        }

        if (hasMultiplayer) {
            basePrice += 20;
        }

        return basePrice;

    }

    public boolean requiresUpdate() {
        return sizeInGB > 50;

    }
}
