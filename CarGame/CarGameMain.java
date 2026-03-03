package CarGame;

import CarGame.Controller.CarController;
import CarGame.View.*;
import CarGame.Model.*;
import javax.swing.Timer;

public class CarGameMain {

    public static void main(String[] args) {
        CarController cc = new CarController();
        cc.frame = new CarView("CarSim 1.0", cc);
        Timer timer = new Timer(50, new TimerListener(cc));
        timer.start();
    }
}

