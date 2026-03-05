package CarGame.Model;


import java.util.ArrayList;
import java.util.List;

public class CarModel {

    private List<Car> cars = new ArrayList<>();
    private WorkShop<Volvo240> volvoWorkshop = new WorkShop<>(300, 30);
    private List<Volvo240> loaded = new ArrayList<>();

    private List<ModelObserver> observers = new ArrayList<>();

    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (ModelObserver o : observers) {
            o.modelUpdated();
        }
    }

    // =========================
    // Getters
    // =========================

    public List<Car> getCars() {
        return cars;
    }

    public WorkShop<Volvo240> getVolvoWorkshop() {
        return volvoWorkshop;
    }

    // =========================
    // Car controls
    // =========================

    public void gasAll(double amount) {
        for (Car car : cars) {
            car.gas(amount);
        }
        notifyObservers();
    }

    public void brakeAll(double amount) {
        for (Car car : cars) {
            car.brake(amount);
        }
        notifyObservers();
    }

    public void startAll() {
        for (Car car : cars) {
            car.startEngine();
        }
        notifyObservers();
    }

    public void stopAll() {
        for (Car car : cars) {
            car.stopEngine();
        }
        notifyObservers();
    }

    public void setTurboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
        notifyObservers();
    }

    public void setTurboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
        notifyObservers();
    }

    public void lowerBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).incAngle(1);
            }
            else if (car instanceof CarTransport) {
                ((CarTransport) car).lowerRamp();
            }
        }
        notifyObservers();
    }

    public void liftBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).decAngle(1);
            }
            else if (car instanceof CarTransport) {
                ((CarTransport) car).raiseRamp();
            }
        }
        notifyObservers();
    }

    // =========================
    // Add / Remove cars
    // =========================

    public void addCar() {
        int maxCars = 5;

        if (cars.size() < maxCars) {
            Car newCar = CarFactory.createRandomCar();

            int offset = cars.size() * 100;
            newCar.turnRight();
            newCar.setyPos(offset);

            cars.add(newCar);
        }

        notifyObservers();
    }

    public void removeCar() {
        if (!cars.isEmpty()) {
            cars.remove(cars.size() - 1);
        }
        notifyObservers();
    }

    // =========================
    // Game update (flyttad från TimerListener)
    // =========================

    public void update() {

        for (Car car : cars) {

            // Väggkollision
            if (car.getX() < 0 || car.getX() > 686) {
                car.turnLeft();
                car.turnLeft();
            }

            car.move();

            // Avstånd till verkstad
            double xdistance =
                    Math.abs(car.getX() - volvoWorkshop.getX());
            double ydistance =
                    Math.abs(car.getY() - volvoWorkshop.getY());

            if (0 < xdistance && xdistance < 101 &&
                    0 < ydistance && ydistance < 96) {

                if (car instanceof Volvo240) {

                    volvoWorkshop.LoadCars((Volvo240) car);
                    loaded.add((Volvo240) car);
                    car.setxPos(volvoWorkshop.getX());
                    car.setyPos(volvoWorkshop.getY());
                    car.stopEngine();
                }
                else{
                    car.turnLeft();
                    car.turnLeft();
                    car.move();
                }
            }
        }

        notifyObservers();
    }
}
