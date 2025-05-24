package mandelbrot;

import util.Complex;
import util.FractalColors;

import javax.swing.*;
import java.awt.*;

import static util.FractalColors.getColor;

public class Mandelbrot extends JPanel {
    private double minRE = -2.0;
    private double maxRE = 1.0;
    private double minIM = -1.5;
    private double maxIM = 1.5;

    private Complex[][] pixels;

    public Mandelbrot() {
        new MandelbrotWorker(this, minRE, maxRE, minIM, maxIM).execute();
    }

    public void setPixels(Complex[][] pixels){
        this.pixels = pixels;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (pixels == null) return;

            for (int x = 0; x < Main.WIDTH; x++) {
                for (int y = 0; y < Main.HEIGHT; y++) {
                    g.setColor(getColor(pixels[x][y].getIterations(), FractalColors.selectedPalette));
                    g.fillRect(x, y, 1, 1);
                    //g.drawLine(x, y, x, y);
                }
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


        MandelbrotWorker mandelbrotWorker = new MandelbrotWorker(this, minRE, maxRE, minIM, maxIM);
        mandelbrotWorker.execute();
    }
}
