package CarGame.Model;

import java.util.ArrayList;
import java.util.List;
public class WorkShop<T extends Car> {
    public int x;
    public int y;
    public WorkShop(int x, int y){
        this.x = x;
        this.y = y;
    }
    public WorkShop(){}
    private List<T> carsInWorkshop = new ArrayList<>();
    public void LoadCars(T car){
        carsInWorkshop.add(car);
        System.out.println("CarGame.Model.Car loaded");
    }
    public T removeCar(){
        return carsInWorkshop.remove(0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}