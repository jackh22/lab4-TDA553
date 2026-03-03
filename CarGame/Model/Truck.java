package CarGame.Model;

import java.awt.*;

public abstract class Truck extends Car{
    public Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double xPos, double yPos, String direction){
        super(nrDoors,enginePower,currentSpeed,color,modelName,xPos,yPos,direction);
    }
    protected boolean isRampUp = true;
    @Override
    public void move(){
        if (isRampUp){
            super.move();        }
        /*

        else{
            throw new IllegalArgumentException("Cant drive with ramp down");
        }


         */
    }
    public boolean isMoving(){
        return getCurrentSpeed() > 0;
    }
    @Override
    public void startEngine() {
        if (isRampUp) {
            super.startEngine();
        }
        /*

        else {
            throw new IllegalArgumentException("Cant drive with ramp down");
        }

         */
    }
    @Override
    public void incrementSpeed(double amount){
        if (isRampUp){
            setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
        }
        /*
        else{
            throw new IllegalArgumentException("Can't increase speed while the flak is down");

        }
         */
    }
}
