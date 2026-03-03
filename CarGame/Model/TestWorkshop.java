package CarGame.Model;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestWorkshop {
    @Test
    public void testType(){
        WorkShop<Car> saab = new WorkShop<>();
        Saab95 saab95 = new Saab95();
        saab.LoadCars(saab95);
        Volvo240 volvo = new Volvo240();
        saab.LoadCars(volvo);
        saab.removeCar();
    }
    @Test
    public void failTest(){
        WorkShop<Truck> truck = new WorkShop<>();
        Volvo240 volvo = new Volvo240();
        Scania scania = new Scania();
    }
}
