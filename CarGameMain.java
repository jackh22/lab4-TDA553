
import javax.swing.Timer;

public class CarGameMain {

    public static void main(String[] args) {

        CarController cc = new CarController();

        cc.cars.add(new Saab95());
        cc.cars.add(new Volvo240());
        cc.cars.add(new Scania());

        cc.frame = new CarView("CarSim 1.0", cc);

        int offset = 0;
        for(Car car: cc.cars){
            car.turnRight();
            car.setyPos(offset);
            offset += 100;
        }

        Timer timer = new Timer(50, new TimerListener(cc));
        timer.start();
    }
}

