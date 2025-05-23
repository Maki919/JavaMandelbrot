import util.Complex;

import javax.swing.*;
import java.awt.*;

public class Mandelbrot extends JPanel {

    private Complex[][] pixels;

    public Mandelbrot() {
        MandelbrotWorker mandelbrotWorker = new MandelbrotWorker(this);
        mandelbrotWorker.execute();
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
                    g.setColor(getColor(pixels[x][y].getIterations()));
                    g.fillRect(x, y, 2, 2);
                }
            }

    }

//    private Color getColor(int iterations){
//        if (iterations == MandelbrotWorker.maxIterations)
//            return Color.BLACK;
//
//        float hue = (float) iterations / MandelbrotWorker.maxIterations;
//        return Color.getHSBColor(hue, 1.0f, 1.0f);
//    }
    private static final Color[] palette = {
            new Color(66, 30, 15),
            new Color(25, 7, 26),
            new Color(9, 1, 47),
            new Color(4, 4, 73),
            new Color(0, 7, 100),
            new Color(12, 44, 138),
            new Color(24, 82, 177),
            new Color(57, 125, 209),
            new Color(134, 181, 229),
            new Color(211, 236, 248),
            new Color(241, 233, 191),
            new Color(248, 201, 95),
            new Color(255, 170, 0),
            new Color(204, 128, 0),
            new Color(153, 87, 0),
            new Color(106, 52, 3)
    };

    private Color getColor(int iterations) {
        if (iterations == MandelbrotWorker.maxIterations) return Color.BLACK;
        return palette[iterations % palette.length];
    }
}
