import util.Complex;

import javax.swing.*;

public class MandelbrotWorker extends SwingWorker<Complex[][], Void> {
    public static final double MIN_RE = -2.0;
    public static final double MAX_RE = 1.0;
    public static final double MIN_IM = -1.5;
    public static final double MAX_IM = 1.5;
    public static final int maxIterations = 1000;

    private final Mandelbrot panel;

    public MandelbrotWorker(Mandelbrot panel) {
        this.panel = panel;
    }
    @Override
    protected Complex[][] doInBackground() {
        Complex[][] pixels = new Complex[Main.WIDTH][Main.HEIGHT];
        for (int x = 0; x < Main.WIDTH; x++) {
            for (int y = 0; y < Main.HEIGHT; y++) {
                double real = MIN_RE + (x / (double) Main.WIDTH) * (MAX_RE - MIN_RE);
                double imag = MIN_IM + (y / (double) Main.HEIGHT) * (MAX_IM - MIN_IM);

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
