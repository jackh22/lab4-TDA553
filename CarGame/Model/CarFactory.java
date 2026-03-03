package CarGame.Model;

import CarGame.Controller.CarController;

import java.util.Random;

public class CarFactory {
    public static Car createRandomCar() {
        Random random = new Random();
        int choice = random.nextInt(3);

        switch (choice) {
            case 0:
                return new Volvo240();
            case 1:
                return new Saab95();
            case 2:
                return new Scania();
        }
        return null;
    }
}
