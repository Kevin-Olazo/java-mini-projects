package week02_entertainment_collection_system;

import java.util.Objects;

public class IndieGame extends VideoGame {
    private String studioName;
    private boolean isEarlyAccess;

    public IndieGame(String title, int releaseYear, double rating, String platform, boolean hasMultiplayer, double sizeInGB, String studioName, boolean isEarlyAccess) {
        super(title, releaseYear, rating, platform, hasMultiplayer, sizeInGB);
        this.studioName = studioName;
        this.isEarlyAccess = isEarlyAccess;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public boolean isEarlyAccess() {
        return isEarlyAccess;
    }

    public void setEarlyAccess(boolean earlyAccess) {
        isEarlyAccess = earlyAccess;
    }

    public void supportDeveloper() {
        System.out.println("I support the developer");
    }

    @Override
    public void play() {
        if (isEarlyAccess) {
            System.out.println("Early Access");
        }
        super.play();
    }

    @Override
    public double calculateValue() {
        if (isEarlyAccess) {
            return super.calculateValue() - 12.00;
        }

        return super.calculateValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof IndieGame ind)){
            return false;
        }

        return Objects.equals(title, ind.title) && Objects.equals(studioName, ind.studioName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, studioName);
    }
}
