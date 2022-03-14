package Playground.Canvas.plugins;

import Playground.Canvas.Window;

import java.awt.*;


public class HKLogo extends Window.Canvas.Plugin {

    private static int counter = 0;

    public void render(Window.Canvas canvas) {
        canvas.drawImage("hk-logo.png", 1, 1);

        canvas.drawText(
                "PGR112 (%d)".formatted(HKLogo.counter),
                124, 104,
                Window.Canvas.Anchor.LEFT
        );

        canvas.onMouseClick(new Rectangle(1, 1, 256, 128), (click) -> {
            HKLogo.counter ++;

            canvas.redraw();

            return true;
        });
    }
}
