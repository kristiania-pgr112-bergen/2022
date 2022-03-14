package Playground.Canvas.plugins;

import Playground.Canvas.Window;

import java.awt.Color;


public class PGR112 extends Window.Canvas.Plugin {
    public void render(Window.Canvas canvas) {
        canvas.setColor(Color.RED);
        canvas.drawText("%dx%d%n".formatted(canvas.getWidth(), canvas.getHeight()), 64, canvas.getHeight() - 42);
        canvas.clearColor();
    }
}
