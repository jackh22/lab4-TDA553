package CarGame.Model;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
@Test
public void testConstructor(){
    Saab95 car = new Saab95();
    assertEquals(2,car.getNrDoors());
    assertEquals(125,car.getEnginePower());
    }

    @Test
    public void testCurrentSpeed(){
        Saab95 car = new Saab95();
        car.stopEngine();
        assertEquals(0,car.getCurrentSpeed());
        car.startEngine();
        assertEquals(0.1,car.getCurrentSpeed());
    }

    @ParameterizedTest
    @CsvSource({
            "NORTH, LEFT, WEST",
            "WEST, LEFT, SOUTH",
            "SOUTH, LEFT, EAST",
            "EAST, LEFT, NORTH",
            "NORTH, RIGHT, EAST",
            "EAST, RIGHT, SOUTH",
            "SOUTH, RIGHT, WEST",
            "WEST, RIGHT, NORTH"
    })
    void turnLeftRightWorks(String startDirection, String turn, String expectedDirection) {
        Saab95 car = new Saab95();
        car.setDirection(startDirection);

        if (turn.equals("LEFT")) {
            car.turnLeft();
        } else {
            car.turnRight();
        }
        assertEquals(expectedDirection, car.getDirection());
    }
    @Test
    public void gasTest(){
        Saab95 car = new Saab95();
        double speed_before = car.getCurrentSpeed();
        car.gas(1);
        assertTrue(car.getCurrentSpeed() >= speed_before);
    }
    @Test
    public void breakTest(){
        Saab95 car = new Saab95();
        car.gas(1);
        car.gas(1);
        double speed_before = car.getCurrentSpeed();
        car.brake(0.5);
        assertTrue(car.getCurrentSpeed() <= speed_before);
    }

    @Test
    public void TestTurbo(){
        Saab95 car1 = new Saab95();
        Saab95 car2 = new Saab95();
        car1.setTurboOn();
        car1.gas(1);
        car2.setTurboOff();
        car2.gas(1);
        assertTrue(car1.getCurrentSpeed() > car2.getCurrentSpeed());
    }
    @Test
    public void testMove(){
        Saab95 car = new Saab95();
        car.startEngine();
        car.move();
        assertEquals(0.1, car.getY());
        car.turnRight();
        car.turnRight();
        car.move();
        assertEquals(0,car.getY());
        car.turnRight();
        car.move();
        assertEquals(-0.1,car.getX());
    }
}
