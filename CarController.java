import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CarController {
    CarView frame;
    ArrayList<Car> cars = new ArrayList<>();
    WorkShop<Volvo240> volvoWorkshop = new WorkShop<>(300,30);
    public List<Car> getCars() {
        return cars;
    }
    public void repaintView() {
        frame.drawPanel.repaint();
    }
    ArrayList<Volvo240> loaded = new ArrayList<>();
        // Calls the gas method for each car once
        void gas(int amount) {
            double gas = ((double) amount) / 100;
            for (Car car : cars) {
                car.gas(gas);
                System.out.println(car.getCurrentSpeed());
            }
        }
        void brake(int amount) {
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
    }


