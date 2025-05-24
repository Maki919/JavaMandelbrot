package mandelbrot;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Mandelbrot extends JPanel {
    private double minRE = -2.0;
    private double maxRE = 1.0;
    private double minIM = -1.5;
    private double maxIM = 1.5;

    private BufferedImage image;

    public Mandelbrot() {
        setSize(1000,1000);
        new MandelbrotWorker(this, minRE, maxRE, minIM, maxIM).execute();
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
    }


    public void zoom(int mouseX, int mouseY) {
        double reRange = maxRE - minRE;
        double imRange = maxIM - minIM;

        double reCenter = minRE + (mouseX / (double) Main.WIDTH) * reRange;
        double imCenter = minIM + (mouseY / (double) Main.HEIGHT) * imRange;

        double zoom = 0.5;
        reRange = reRange * zoom;
        imRange = imRange * zoom;

        minRE = reCenter - (reRange / 2);
        maxRE = reCenter + (reRange / 2);
        minIM = imCenter - (imRange / 2);
        maxIM = imCenter + (imRange / 2);


        executeMandelbrotWorker();
    }
    public void executeMandelbrotWorker(){
        MandelbrotWorker mandelbrotWorker = new MandelbrotWorker(this, minRE, maxRE, minIM, maxIM);
        mandelbrotWorker.execute();
    }
}
