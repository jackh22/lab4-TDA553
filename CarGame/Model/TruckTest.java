package CarGame.Model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TruckTest {
    @Test
    public void testDrive() {
        Scania truck = new Scania();
        truck.incAngle(20);
        truck.decAngle(20);
        truck.startEngine();
    }


    @Test
    public void loadTest() {
        Saab95 saab = new Saab95();
        Scania scania = new Scania();
        CarTransport tran = new CarTransport();
        tran.raiseRamp();
        tran.startEngine();
        tran.stopEngine();

        tran.lowerRamp();

        tran.load(saab);
        tran.load(scania);
        tran.raiseRamp();
        tran.move();
        tran.turnLeft();
        tran.move();
        tran.stopEngine();
        tran.lowerRamp();
        tran.unLoad();
        assertEquals(scania.getX(), tran.getX());
    }


    @Test
    public void testScania() {
        Scania scania = new Scania();
        scania.incAngle(20);
        scania.decAngle(20);
        scania.move();
        scania.startEngine();

    }


    @Test
    public void loadRangeTest(){
        Saab95 saab = new Saab95();
        CarTransport tran = new CarTransport();
        tran.lowerRamp();
        saab.startEngine();


        saab.stopEngine();
        tran.load(saab);
    }
}


