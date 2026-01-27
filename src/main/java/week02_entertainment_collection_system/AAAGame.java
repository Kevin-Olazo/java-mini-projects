package week02_entertainment_collection_system;

public class AAAGame extends VideoGame {
    private String publisher;
    private boolean hasDLC;

    public AAAGame(String title, int releaseYear, double rating, String platform, boolean hasMultiplayer, double sizeInGB, String publisher, boolean hasDLC) {
        super(title, releaseYear, rating, platform, hasMultiplayer, sizeInGB);
        this.publisher = publisher;
        this.hasDLC = hasDLC;
    }

    @Override
    public void play() {
        System.out.println("Kojima Productions presents: ");
        super.play();
    }

    @Override
    public double calculateValue() {
        if (!hasDLC) {
            return super.calculateValue();

        }
        return super.calculateValue() + 14.90;

    }

    public String checkDLCAvailable() {
        if (!hasDLC) {
            return "No DLC Available";

        } else {
            return "DLC Available";
        }
    }
}
