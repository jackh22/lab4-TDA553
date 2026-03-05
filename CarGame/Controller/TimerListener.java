package CarGame.Controller;

import CarGame.Model.Car;
import CarGame.Model.Volvo240;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {

    private CarController controller;

    public TimerListener(CarController controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        controller.update();
    }
}