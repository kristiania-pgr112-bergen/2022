package Playground.Sandbox.plugins;

import Playground.Sandbox.Canvas;

import java.awt.Rectangle;


public class HKLogo extends Canvas.Plugin {

    private static int counter = 0;

    public void render(Canvas canvas) {
        canvas.drawImage("hk-logo.png", 1, 1);

        canvas.drawText(
                "PGR112 (%d)".formatted(HKLogo.counter),
                124, 104,
                Canvas.Anchor.LEFT
        );

        canvas.onMouseClick(new Rectangle(1, 1, 256, 128), (click) -> {
            HKLogo.counter ++;

            canvas.redraw();

            return true;
        });
    }
}
