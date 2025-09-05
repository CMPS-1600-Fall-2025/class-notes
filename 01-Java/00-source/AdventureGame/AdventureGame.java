public class AdventureGame {
    public static void main(String[] args){
        Character hero = new Hero("KeyChain", 100, 20);
        Character villain = new Villain("Door Knob", 200, 15);

        enterCombatLoop(hero, villain);
    }

    public static void enterCombatLoop(Character hero, Character villain) {
        while(true) {
            // hero attack the villian
            
            hero.takeTurn(villain);
            if(!villain.isAlive()) {
                System.out.printf("You won! Congrats!!!!!\n");
                break;
            }

            villain.takeTurn(hero);
            if(!hero.isAlive()) {
                System.out.printf("You lose! How sad :-(\n");
                break;
            }
        }
    }
}
