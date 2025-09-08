public class HealthPotion extends Potion {
    private int points;

    public HealthPotion(int points) {
        super("Health potion");
        this.points = points;
    }

    @Override
    public void takePotion(Character c) {
        c.modifyHealth(points); // add points to characters health
    }
    
}
