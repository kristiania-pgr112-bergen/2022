package Playground.Sandbox.plugins;

import Playground.Sandbox.Canvas;

import java.awt.Color;


public class PGR112 extends Canvas.Plugin {
    public void render(Canvas canvas) {
        canvas.setColor(Color.RED);
        canvas.drawText("%dx%d%n".formatted(canvas.getWidth(), canvas.getHeight()), 64, canvas.getHeight() - 42);
        canvas.clearColor();
    }
}
