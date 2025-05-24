package mandelbrot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main extends JFrame {
    public static int WIDTH = 1000;
    public static int HEIGHT = 1000;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Swing Mandelbrot");
            frame.setSize(WIDTH, HEIGHT);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            Mandelbrot mandelbrot = new Mandelbrot();
            frame.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    mandelbrot.zoom(e.getX(), e.getY());
                }
            });
            frame.add(mandelbrot);

            frame.setVisible(true);
        });
    }
}