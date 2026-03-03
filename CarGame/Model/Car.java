package CarGame.Model;

import java.awt.*;


public abstract class Car implements Movable{
    public Car(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double xPos, double yPos, String direction){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.xPos = xPos;
        this.yPos = yPos;
        this.direction = direction;
    }
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName;
    private double xPos = 0;
    private double yPos = 0;

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    private String direction = "NORTH";

    @Override
    public void move(){
    switch (direction){
        case "NORTH":
            yPos += this.currentSpeed;
            break;
        case "WEST":
            xPos -= this.currentSpeed;
            break;
        case "SOUTH":
            yPos -= this.currentSpeed;
            break;
        case "EAST":
            xPos += this.currentSpeed;
            break;
        }

    }

    @Override
    public void turnLeft(){
    switch (direction){
        case "NORTH":
            direction = "WEST";
            break;
        case "WEST":
            direction = "SOUTH";
            break;
        case "SOUTH":
            direction = "EAST";
            break;
        case "EAST":
            direction = "NORTH";
            break;

    }

    }
    @Override
    public void turnRight(){
        switch (direction) {
            case "NORTH":
                direction = "EAST";
                break;
            case "WEST":
                direction = "NORTH";
                break;
            case "SOUTH":
                direction = "WEST";
                break;
            case "EAST":
                direction = "SOUTH";
                break;
        }

    }


    abstract public double speedFactor();


    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    public String getDirection(){return this.direction;}



    public void gas(double amount){
        if(amount > 1 || amount < 0){
            throw new IllegalArgumentException("Number must be a integer between 0 and 1");
        }
        else{
            incrementSpeed(amount);
        }
    }

    public void brake(double amount){
        if(amount > 1 || amount < 0){
            throw new IllegalArgumentException("Number must be a integer between 0 and 1");
        }
        else {
            decrementSpeed(amount);
        }
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getY(){
        return this.yPos;
    }
    public double getX(){
        return this.xPos;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setDirection(String D){direction = D;}

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }


}
