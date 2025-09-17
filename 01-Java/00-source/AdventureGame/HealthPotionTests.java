import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class HealthPotionTests {
    @BeforeEach
    void setup() {

    }

    @Test
    void testHealthPotion() {
        // apply a health potion to character
        // verify that their health has increased correctly
        Character c = new Hero("Test Character", 100, 10);
        Potion healthPotion = new HealthPotion(10);
        assertEquals(100, c.getHP());
        healthPotion.takePotion(c);
        assertEquals(110, c.getHP());
    }

}
