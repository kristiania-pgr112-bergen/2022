package Playground.Canvas;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Launcher {
    public static final boolean promptSize = false;

    public static final Dimension windowSize = new Dimension(
            1280,
            1024
    );

    static final JFrame frame = new JFrame("Playground Canvas PGR112");

    public static void main(String[] args) {
        int width = Launcher.windowSize.width;
        int height = Launcher.windowSize.height;

        if (Launcher.promptSize) {
            Scanner input = new Scanner(System.in);

            System.out.printf("Width[%d]:", Launcher.windowSize.width);
            try {
                width = Integer.parseInt(input.nextLine());
            } catch (Exception ignored) {
            }

            System.out.printf("Height[%d]:", Launcher.windowSize.height);
            try {
                height = Integer.parseInt(input.nextLine());
            } catch (Exception ignored) {
            }

            input.close();
        }

        Launcher.run(width, height);

    }

    public static void run(int width, int height) {
        Launcher.run(width, height, null, false);
    }

    public static void run(ArrayList<String> loadOrder) {
        Launcher.run(Launcher.windowSize.width, Launcher.windowSize.height, loadOrder, false);
    }

    public static void run(int width, int height, ArrayList<String> loadOrder) {

    }

    public static void run(int width, int height, ArrayList<String> loadOrder, boolean external) {
        SwingUtilities.invokeLater(() -> {
            Window window = new Window(Launcher.frame, width, height, loadOrder);

            window.initialize(loadOrder != null, external);
        });
    }
}
