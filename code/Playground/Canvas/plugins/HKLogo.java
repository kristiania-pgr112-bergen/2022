package Playground.Canvas.plugins;

import Playground.Canvas.Window;

import java.awt.*;


public class HKLogo extends Window.Canvas.Plugin {
    public void render(Window.Canvas canvas) {
        canvas.drawImage("hk-logo.png", 1, 1);

        canvas.drawText(
                new Font("Consolas", Font.BOLD, 24),
                "PGR112",
                168, 108
        );

        canvas.onMouseClick(new Rectangle(1, 1, 256, 128), (context) -> {
            System.out.println("Mouse click on HKLogo!");

            return true;
        });
    }
}
