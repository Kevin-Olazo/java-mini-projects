package week02_entertainment_collection_system;

public class IndieGame extends VideoGame {
    private String studioName;
    private boolean isEarlyAccess;

    public IndieGame(String title, int releaseYear, double rating, String platform, boolean hasMultiplayer, double sizeInGB, String studioName, boolean isEarlyAccess) {
        super(title, releaseYear, rating, platform, hasMultiplayer, sizeInGB);
        this.studioName = studioName;
        this.isEarlyAccess = isEarlyAccess;
    }

    @Override
    public void play() {
        if (isEarlyAccess){
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

    public void supportDeveloper(){
        System.out.println("I support the developer");
    }
}
