package mandelbrot;

import util.Complex;

import javax.swing.*;

public class MandelbrotWorker extends SwingWorker<Complex[][], Void> {
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
    protected Complex[][] doInBackground() {
        Complex[][] pixels = new Complex[Main.WIDTH][Main.HEIGHT];
        for (int x = 0; x < Main.WIDTH; x++) {
            for (int y = 0; y < Main.HEIGHT; y++) {
                double real = minRE + (x / (double) Main.WIDTH) * (maxRE - minRE);
                double imag = minIM + (y / (double) Main.HEIGHT) * (maxIM - minIM);

                Complex z = new Complex(0, 0);
                Complex c = new Complex(real, imag);

                int iterations = 0;
                while (z.abs() < 2 && iterations < maxIterations) {
                    z = z.mul(z).add(c);
                    iterations++;
                }
                c.setIterations(iterations);
                pixels[x][y] = c;
            }
        }
        return pixels;
    }

    @Override
    protected void done() {
        super.done();
        try {
            Complex[][] result = get();
            panel.setPixels(result);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
