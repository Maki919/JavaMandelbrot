package util;

import mandelbrot.MandelbrotWorker;

import java.awt.*;

public class FractalColors {
    public static final Color[] palette0 = {
            new Color(66, 30, 15),
            new Color(45, 18, 20),
            new Color(25, 7, 26),
            new Color(17, 4, 36),
            new Color(9, 1, 47),
            new Color(6, 3, 60),
            new Color(4, 4, 73),
            new Color(2, 6, 86),
            new Color(0, 7, 100),
            new Color(6, 25, 119),
            new Color(12, 44, 138),
            new Color(18, 63, 157),
            new Color(24, 82, 177),
            new Color(40, 103, 193),
            new Color(57, 125, 209),
            new Color(95, 153, 219),
            new Color(134, 181, 229),
            new Color(172, 209, 238),
            new Color(211, 236, 248),
            new Color(226, 235, 220),
            new Color(241, 233, 191),
            new Color(245, 217, 143),
            new Color(248, 201, 95),
            new Color(252, 185, 48),
            new Color(255, 170, 0),
            new Color(229, 149, 0),
            new Color(204, 128, 0),
            new Color(179, 108, 0),
            new Color(153, 87, 0),
            new Color(129, 69, 1),
            new Color(106, 52, 3)
    };
    public static final Color[] palette1 = colorPaletteGenerator(200, Color.DARK_GRAY, Color.WHITE);
    public static final Color[] palette2 = {
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

    public static final Color[] palette3 = colorPaletteGenerator(200, Color.ORANGE, Color.GREEN);
    public static final Color[] palette4 = colorPaletteGenerator(200, new Color(40, 0, 73), new Color(11, 190, 0));
    public static final Color[] palette5 = colorPaletteGenerator(200, new Color(0, 7, 100), new Color(0, 255, 255));
    public static final Color[] palette6 = colorPaletteGenerator(200, new Color(30, 0, 60), new Color(255, 0, 255));

    public static Color[][] allPalettes = {
            palette0, palette1, palette2, palette3, palette4, palette5, palette6
    };
    public static Color[] selectedPalette = allPalettes[0];

    public static Color getColor(int iterations, Color[] selectedPalette) {
        if (iterations == MandelbrotWorker.maxIterations)
            return Color.BLACK;

        return selectedPalette[iterations % selectedPalette.length];
    }

    private static Color[] colorPaletteGenerator(int colorAmount, Color color1, Color color2) {
        Color[] colorPalette = new Color[colorAmount];

        for (int i = 0; i < colorAmount; i++) {
            float factor = i / (float) colorAmount;
            int r = (int) (color1.getRed() + (color2.getRed() - color1.getRed()) * factor);
            int g = (int) (color1.getGreen() + (color2.getGreen() - color1.getGreen()) * factor);
            int b = (int) (color1.getBlue() + (color2.getBlue() - color1.getBlue()) * factor);

            colorPalette[i] = new Color(r, g, b);
        }
        return colorPalette;
    }
}

