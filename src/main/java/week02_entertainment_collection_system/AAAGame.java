package week02_entertainment_collection_system;

public class AAAGame extends VideoGame {
    private String publisher;
    private boolean hasDLC;

    public AAAGame(String title, int releaseYear, double rating, String platform, boolean hasMultiplayer, double sizeInGB, String publisher, boolean hasDLC) {
        super(title, releaseYear, rating, platform, hasMultiplayer, sizeInGB);
        this.publisher = publisher;
        this.hasDLC = hasDLC;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isHasDLC() {
        return hasDLC;
    }

    public void setHasDLC(boolean hasDLC) {
        this.hasDLC = hasDLC;
    }

    @Override
    public void play() {
        System.out.println(publisher + " Productions presents: ");
        super.play();
    }

    @Override
    public double calculateValue() {
        return hasDLC ? super.calculateValue() + 14.90 : super.calculateValue();
    }

    public String checkDLCAvailable() {
        return hasDLC ? "DLC Available" : "No DLC Available";
    }
}
