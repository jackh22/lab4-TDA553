package CarGame.View;
import CarGame.Model.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel implements ModelObserver{
    ArrayList<Car> cars = new ArrayList<>();
    WorkShop<Volvo240> volvoWorkshop = new WorkShop<>();
    private CarModel model;
    DrawPanel(int x, int y, CarModel model){
        this.model = model;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cars = cars;
        this.volvoWorkshop = volvoWorkshop;

        try {
            // You can remove the "CarGame.View.pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("CarGame.Model.Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: CarGame.View.pics -> MOVE *.jpg to CarGame.View.pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            Saab95Image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            ScaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage Saab95Image;
    BufferedImage ScaniaImage;
    // To keep track of a single car's position


    public Point volvoPoint = new Point();

    BufferedImage volvoWorkshopImage;

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Car car: model.getCars()){
            if (car instanceof Volvo240) {
                g.drawImage(volvoImage, (int)car.getX(), (int)car.getY(), null);
            }
            else if (car instanceof Saab95) {
                g.drawImage(Saab95Image, (int)car.getX(), (int)car.getY(), null);
            }
            else if (car instanceof Scania) {
                g.drawImage(ScaniaImage, (int)car.getX(), (int)car.getY(), null);
            }

        }


        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, (int) model.getVolvoWorkshop().getX(), (int) model.getVolvoWorkshop().getY(), null);
    }
    @Override
    public void modelUpdated(){
        repaint();
    }
}
