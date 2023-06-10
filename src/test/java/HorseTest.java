import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class HorseTest {

    Horse horse;

    @BeforeEach
    public void init() {
        horse = new Horse("Pegas", 3.0, 15.0);
    }

    @Test
    public void nullName() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 1, 1));
    }

    @Test
    public void nullNameErrorMessage() {
        try {
            new Horse(null, 1, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null.", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\n\t"})
    public void nameIsBlank(String name) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 1, 1));
        assertEquals("Name cannot be blank.", illegalArgumentException.getMessage());
    }

    @Test
    public void negativeSpeed() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Pegas", -1, 1));
    }

    @Test
    public void negativeSpeedErrorMessage() {
        try {
            new Horse("Pegas", -1, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Speed cannot be negative.", e.getMessage());
        }
    }

    @Test
    public void negativeDistance() {
        assertThrows(IllegalArgumentException.class, () -> new Horse("Pegas", 1, -1));
    }

    @Test
    public void negativeDistanceErrorMessage() {
        try {
            new Horse("Pegas", 1, -1);
        } catch (IllegalArgumentException e) {
            assertEquals("Distance cannot be negative.", e.getMessage());
        }
    }
    @Test
    void getName() throws NoSuchFieldException, IllegalAccessException {
        Field name = Horse.class.getDeclaredField("name");
        name.setAccessible(true);
        String getName = (String) name.get(horse);
        assertEquals("Pegas", getName);
//        System.out.println();
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

    @Disabled
    @Test
    void move() {
        try (MockedStatic<Horse> mockedStatic = Mockito.mockStatic(Horse.class)) {
            new Horse("Pegas", 11,23).move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }

    }
}