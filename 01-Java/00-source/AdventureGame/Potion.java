abstract public class Potion {
    private String name;

    public Potion(String name) {
        this.name = name;
    }

    abstract public void takePotion(Character other);
}
