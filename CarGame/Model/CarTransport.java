package CarGame.Model;

import java.awt.*;
import java.util.ArrayList;
import static java.lang.Math.abs;
public class CarTransport extends Truck {
    @Override
    public double speedFactor() {
        return 0;
    }
    public CarTransport() {
        super(2, 380, 0, Color.blue, "CarGame.Model.CarTransport", 0, 0, "NORTH");
    }
    public static final int Max_cars = 5;
    ArrayList<Car> carList = new ArrayList<>(5);
    public void raiseRamp() {
        if (isMoving()) {
            throw new IllegalArgumentException("The transport is moving");
        } else {
            isRampUp = true;
        }
    }
    public void lowerRamp() {
        if (isMoving()) {
            throw new IllegalArgumentException("The transport is moving");
        } else {
            isRampUp = false;
        }
    }
    @Override
    public void move() {
        super.move();
        for (Car car : carList) {
            car.setDirection(getDirection());
            car.setxPos(getX());
            car.setyPos(getY());
        }
    }
    @Override
    public void turnLeft() {
        super.turnLeft();
        for (Car car : carList) {
            car.setDirection(getDirection());
        }
    }
    @Override
    public void turnRight() {
    super.turnRight();
        for(Car car :carList) {
        car.setDirection(getDirection());
        }
    }
    public void load(Car cars){
        double X = abs(getX()- cars.getX());
        double Y = abs(getY()- cars.getY());
        if(X <= 2 && Y <= 2 && !isRampUp && carList.size() < Max_cars) {
            if(!(cars instanceof CarTransport) || cars.getEnginePower() < 500) {
                carList.add(cars);
                cars.stopEngine();
                cars.setDirection(getDirection());
                cars.setxPos(getX());
                cars.setyPos(getY());
            }
            else{
                throw new IllegalArgumentException("Can't load");
            }
        }
        else{
            throw new IllegalArgumentException("Can't load");
        }
    }
    public void unLoad() {
        int index = carList.size() -1;
        if (!isRampUp && carList.size() > 0) {
            carList.remove(index);
        }
        else{
            throw new IllegalArgumentException("Can't unlodad");
        }
    }
}

