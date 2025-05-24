package mandelbrot;

import util.Complex;
import util.FractalColors;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MandelbrotWorker extends SwingWorker<BufferedImage, Void> {
    public static final int maxIterations = 1000;

    private final double minRE, maxRE, minIM, maxIM;
    private final Mandelbrot panel;

    public MandelbrotWorker(Mandelbrot panel, double minRE, double maxRE, double minIM, double maxIM) {
        this.panel = panel;
        this.minRE = minRE;
        this.maxRE = maxRE;
        this.minIM = minIM;
        this.maxIM = maxIM;
    }
    @Override
    protected BufferedImage doInBackground() {
        int imageScaleFactor = 1;
        int screenW = panel.getWidth() * imageScaleFactor;
        int screenH = panel.getHeight() * imageScaleFactor;
        BufferedImage image = new BufferedImage(screenW, screenH, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < screenW; x++) {
            for (int y = 0; y < screenH; y++) {
                double real = minRE + (x / (double) screenW) * (maxRE - minRE);
                double imag = minIM + (y / (double) screenH) * (maxIM - minIM);

                Complex z = new Complex(0, 0);
                Complex pixel = new Complex(real, imag);

                int iterations = 0;
                while (z.abs() < 2 && iterations < maxIterations) {
                    z = z.mul(z).add(pixel);
                    iterations++;
                }
                Color iterationColor = FractalColors.getColor(iterations, FractalColors.selectedPalette);
                image.setRGB(x, y, iterationColor.getRGB());
            }
        }
        return image;
    }

    @Override
    protected void done() {
        super.done();
        try {
            BufferedImage result = get();
            panel.setImage(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
