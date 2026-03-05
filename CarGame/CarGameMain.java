package CarGame;

import CarGame.Controller.CarController;
import CarGame.Controller.TimerListener;
import CarGame.Model.CarModel;
import CarGame.View.*;

import javax.swing.Timer;

public class CarGameMain {
    public static void main(String[] args) {
        CarModel cm = new CarModel();
        CarController cc = new CarController(cm);
        CarView frame = new CarView("CarSim 1.0", cc);
        cm.addObserver(frame.drawPanel);
        Timer timer = new Timer(50, new TimerListener(cc));
        timer.start();
    }
}

