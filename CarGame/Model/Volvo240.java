package CarGame.Model;

import java.awt.*;
public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;
    public Volvo240(){
        super(4,100,0,Color.black,"CarGame.Model.Volvo240",0,0,"NORTH");
    }
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
