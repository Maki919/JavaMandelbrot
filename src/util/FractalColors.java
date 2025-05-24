package util;

import mandelbrot.MandelbrotWorker;

import java.awt.*;

public class FractalColors {
    private static final Color[] palette = {
            new Color(255, 255, 255),  // Weiß (schnell divergiert)
            new Color(200, 200, 255),
            new Color(150, 150, 255),
            new Color(100, 100, 255),
            new Color(50, 50, 150),
            new Color(20, 20, 100),
            new Color(0, 0, 50)        // Dunkelblau (langsam divergiert)
    };

    private static final Color[] palette0 = {
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
    private static final Color[] palette2 = {
            new Color(45, 20, 10),
            new Color(75, 30, 10),
            new Color(110, 45, 15),
            new Color(150, 70, 20),
            new Color(190, 95, 25),
            new Color(220, 120, 35),
            new Color(245, 160, 50),
            new Color(255, 195, 80),
            new Color(255, 215, 110),
            new Color(255, 230, 140)
    };

    private static final Color[] palette3 = colorPaletteGenerator(200, Color.ORANGE, Color.GREEN);
    private static final Color[] palette4 = colorPaletteGenerator(150, new Color(40, 0, 73), new Color(42, 70, 40));
    private static final Color[] palette5 = colorPaletteGenerator(200, new Color(0, 7, 100), new Color(0, 255, 255));
    private static final Color[] palette6 = colorPaletteGenerator(200, new Color(30, 0, 60), new Color(255, 0, 255));


    public static Color[] selectedPalette = palette5;
    public static Color getColor(int iterations, Color[] selectedPalette) {
        if (iterations == MandelbrotWorker.maxIterations)
            return Color.BLACK;

        return selectedPalette[iterations % selectedPalette.length];
    }

    private static Color[] colorPaletteGenerator(int colorAmount, Color color1, Color color2) {
        Color[] colorPalette = new Color[colorAmount];

        for (int i = 0; i < colorAmount; i++){
            float factor = i / (float) colorAmount;
            int r = (int) (color1.getRed() + (color2.getRed() - color1.getRed()) * factor);
            int g = (int) (color1.getGreen() + (color2.getGreen() - color1.getGreen()) * factor);
            int b = (int) (color1.getBlue() + (color2.getBlue() - color1.getBlue()) * factor);

            colorPalette[i] = new Color(r, g, b);
        }
        return colorPalette;
    }
}
