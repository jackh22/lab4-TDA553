package CarGame.Controller;
import CarGame.Model.*;
import CarGame.View.*;
import java.util.ArrayList;
import java.util.List;

public class CarController {

    private CarModel model;

    public CarController(CarModel model) {
        this.model = model;
    }


    public void gas(int amount) {
        double gas = amount / 100.0;
        model.gasAll(gas);
    }

    public void brake(int amount) {
        double brake = amount / 100.0;
        model.brakeAll(brake);
    }

    public void startAll() {
        model.startAll();
    }

    public void stopAll() {
        model.stopAll();
    }

    public void setTurboOn() {
        model.setTurboOn();
    }

    public void setTurboOff() {
        model.setTurboOff();
    }

    public void liftBed() {
        model.liftBed();
    }

    public void lowerBed() {
        model.lowerBed();
    }

    public void addCar() {
        model.addCar();
    }

    public void removeCar() {
        model.removeCar();
    }

    public void update() {
        model.update();
    }

    public CarModel getModel() {
        return model;
    }
}


