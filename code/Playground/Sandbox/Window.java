package Playground.Sandbox;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import Playground.Sandbox.Canvas;

public class Window extends JPanel {
    public static final String folderPath = "code/Playground/Sandbox/";
    public static final String classPackage = Window.class.getPackageName();


    public static Font defaultFont = new Font(
            "Consolas",
            Font.PLAIN,
            24
    );

    public static Color defaultTextColor = Color.BLACK;

    public static Color defaultBackgroundColor = Color.WHITE;

    public static void setDefaultFont(Font font) {
        Window.defaultFont = font;
    }

    public static void setDefaultTextColor(Color color) {
        Window.defaultTextColor = color;
    }

    Canvas canvas;
    ArrayList<String> order;
    HashMap<String, Canvas.Plugin> plugins = new HashMap<>();

    boolean animated = false;
    int fps = 20;

    @Override
    public void paint(Graphics graphics) {
        this.canvas.setGraphics((Graphics2D) graphics);

        this.canvas.graphics.setBackground(Window.defaultBackgroundColor);
        this.canvas.clear();

        // System.out.printf("Rendering %d plugins ...%n", this.order.size());

        for (String pluginName : this.order) {
            // System.out.printf("Processing class[%s]-plugin ...%n", plugin);
            this.plugins.get(pluginName).render(this.canvas);
        }
    }

    public Window(JFrame frame, int width, int height, ArrayList<String> pluginOrder) {
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);

        this.canvas = new Canvas(
                this,
                frame.getContentPane().getWidth(),
                frame.getContentPane().getHeight()
        );
        this.order = new ArrayList<>();

        if (pluginOrder != null) {
            this.order.addAll(pluginOrder);
        }

        this.addMouseListener(new Canvas.CanvasMouseListener(this.canvas));
    }

    Window(JFrame frame, int width, int height) {
        this(frame, width, height, null);
    }

    public void initialize() {
        this.initialize(true, false);
    }

    public void initialize(boolean loadOrderOnly, boolean external) {
        Dimension canvasSize = new Dimension(this.canvas.getWidth(), this.canvas.getHeight());

        if (loadOrderOnly) {
            for (String pluginName : this.order) {
                try {
                    String pkg = "%s%s".formatted(external ? "" : Window.classPackage + '.', pluginName);

                    Class<?> cls = Class.forName(
                            pkg,
                            false,
                            this.getClass().getClassLoader()
                    );

                    Object plugin = cls.getDeclaredConstructor().newInstance();

                    System.out.printf("Initializing class[%s] plugin%n", pluginName);

                    this.plugins.put(pluginName, (Canvas.Plugin) plugin);

                    try {
                        Method setup = plugin.getClass().getMethod("setup");

                        try {
                            System.out.printf("Invoking setup for class[%s] plugin", pluginName);
                            setup.invoke(plugin, canvasSize);
                        }
                        catch (InvocationTargetException e) { e.printStackTrace(); }
                    } catch (NoSuchMethodException ignored) { }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            try {
                File folder = new File("%splugins".formatted(Window.folderPath));
                File loadOrder = new File("%s.plugins".formatted(Window.folderPath));
                Scanner scanner = new Scanner(loadOrder);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    this.order.add(line);
                    this.plugins.put(line, null);
                }

                for (final File file : Objects.requireNonNull(folder.listFiles())) {
                    if (file.isFile()) {
                        String fileName = file.getName();

                        if (fileName.endsWith(".java")) {
                            String className = fileName.substring(0, fileName.length() - 5);

                            Class<?> cls = Class.forName(
                                    "%s.plugins.%s".formatted(classPackage, className),
                                    false,
                                    this.getClass().getClassLoader()
                            );

                            Object plugin = cls.getDeclaredConstructor().newInstance();

                            System.out.printf("Initializing class[%s] plugin%n", className);

                            if (this.order.contains(className)) {
                                this.plugins.replace(className, (Canvas.Plugin) plugin);
                            } else {
                                this.order.add(className);
                                this.plugins.put(className, (Canvas.Plugin) plugin);
                            }

                            try {
                                Method setup = plugin.getClass().getMethod("setup");

                                try {
                                    System.out.printf("Processing setup for %s plugin%n", className);
                                    setup.invoke(plugin, canvasSize);
                                }
                                catch (InvocationTargetException e) { e.printStackTrace(); }

                            } catch (NoSuchMethodException ignored) { }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    void setAnimated(boolean state) {
        this.animated = state;
    }
}
