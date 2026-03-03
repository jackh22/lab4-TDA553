import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {

    private CarController controller;

    public TimerListener(CarController controller) {
        this.controller = controller;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for (Car car : controller.cars) {

            if (car.getX() >= 0 && car.getX() <= 686) {

                if (controller.loaded.contains(car)) {
                    car.setxPos(controller.volvoWorkshop.getX());
                    car.setyPos(controller.volvoWorkshop.getY());
                    car.stopEngine();
                }
                car.move();
            } else {
                car.turnLeft();
                car.turnLeft();
                car.move();
            }
            double xdistance =
                    Math.abs(car.getX() - controller.volvoWorkshop.getX());
            double ydistance =
                    Math.abs(car.getY() - controller.volvoWorkshop.getY());
            if (0 < xdistance && xdistance < 101 &&
                    0 < ydistance && ydistance < 96) {

                if (car instanceof Volvo240) {
                    controller.volvoWorkshop.LoadCars((Volvo240) car);
                    controller.loaded.add((Volvo240) car);
                } else {
                    car.turnLeft();
                    car.turnLeft();
                }
            }
        }

        controller.frame.drawPanel.repaint();
    }
}