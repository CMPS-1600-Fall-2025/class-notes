public class PoisonPotion extends Potion {
    private int damage;

    public PoisonPotion(int damage) {
        super("Poision potion");
        this.damage = damage;
    }

    @Override
    public void takePotion(Character c) {
        c.becomePoisoned(damage); // the poison damage
    }
    
}
