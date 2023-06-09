import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    Horse horse;

    @BeforeEach
    public void init() {
        horse = new Horse("Pegas", 3.0, 15.0);
    }

    @Test
    void getName() {
        String name = horse.getName();
        assertEquals("Pegas", name);
    }

    @Test
    void getSpeed() {
        double speed = horse.getSpeed();
        assertEquals(3.0, speed);
    }

    @Test
    void getDistance() {
        double distance = horse.getDistance();
        assertEquals(15.0, distance);

        Horse horse1 = new Horse("Dragon", 5.0);
        double distance1 = horse1.getDistance();
        assertEquals(0, distance1);
    }

    @Test
    void move() {
    }
}