public class AdventureGame {
    public static void main(String[] args){
        Hero hero = new Hero("KeyChain", 100, 20);
        Villain villain = new Villain("Door Knob", 200, 15);

        enterCombatLoop(hero, villain);
    }

    public static void enterCombatLoop(Hero hero, Villain villain) {
        while(true) {
            // hero attack the villian
            
            hero.attack(villain);
            if(!villain.isAlive()) {
                System.out.printf("You won! Congrats!!!!!\n");
                break;
            }

            villain.attack(hero);
            if(!hero.isAlive()) {
                System.out.printf("You lose! How sad :-(\n");
                break;
            }
        }
    }
}
