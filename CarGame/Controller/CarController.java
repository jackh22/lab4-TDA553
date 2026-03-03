package CarGame.Controller;
import CarGame.Model.*;
import CarGame.View.*;
import java.util.ArrayList;
import java.util.List;

public class CarController {
    private List<ModelObserver> observers = new ArrayList<>();

    public void addObserver(ModelObserver observer) {
        observers.add(observer);
    }
    public void notifyObservers() {
        for (ModelObserver o : observers) {
            o.modelUpdated();
        }
    }



    public CarView frame;
    public ArrayList<Car> cars = new ArrayList<>();
    public WorkShop<Volvo240> volvoWorkshop = new WorkShop<>(300,30);
    public List<Car> getCars() {
        return cars;
    }
    public void repaintView() {
        frame.drawPanel.repaint();
    }
    public ArrayList<Volvo240> loaded = new ArrayList<>();
        // Calls the gas method for each car once
        public void gas(int amount) {
            double gas = ((double) amount) / 100;
            for (Car car : cars) {
                car.gas(gas);
                System.out.println(car.getCurrentSpeed());
            }
        }
        public void brake(int amount) {
            double gas = ((double) amount) / 100;
            for (Car car : cars) {
                car.brake(gas);
                System.out.println(car.getCurrentSpeed());
            }
        }

        public void setTurboOn() {
            for (Car car : cars) {
                if (car instanceof Saab95) {
                    ((Saab95) car).setTurboOn();
                }
            }
        }

        public void setTurboOff() {
            for (Car car : cars) {
                if (car instanceof Saab95) {
                    ((Saab95) car).setTurboOff();
                }
            }
        }


        public void lowerBed() {
            for (Car car : cars) {
                if (car instanceof Scania) {
                    ((Scania) car).incAngle(1);
                    System.out.println(((Scania) car).getAngle());
                } else if (car instanceof CarTransport) {
                    ((CarTransport) car).lowerRamp();
                }

            }
        }
        public void liftBed() {
            for (Car car : cars) {
                if (car instanceof Scania) {
                    ((Scania) car).decAngle(1);
                } else if (car instanceof CarTransport) {
                    ((CarTransport) car).raiseRamp();
                }
            }
        }

        public void startAll() {
            for (Car car : cars) {
                car.startEngine();
            }
        }

        public void stopAll() {
            for (Car car : cars) {
                car.stopEngine();
            }
        }

        public void addCar(){
            int maxCars = 5;
            if (cars.size() < maxCars) {
                Car newCar = CarFactory.createRandomCar();
                int offset = 0;
                for(Car bil: cars){
                    offset += 100;
                }
                newCar.turnRight();
                newCar.setyPos(offset);
                cars.add(newCar);
                //notifyObservers();
            }
        }

        public void removeCar(){
            if (!cars.isEmpty()){

                cars.remove(cars.size()-1);
                //notifyObservers();
            }
        }
    }


