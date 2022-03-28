package Tasks.playground.create;

import Tasks.playground.TaskRunner;

import Playground.Sandbox.Canvas;

import java.awt.Point;


/**
 *  Task00Example
 *
 *  1) Draw a circle with radius 50 in the center of the screen
 *
 *  2) Draw a horizontal and vertical line, splitting the circle into 4 parts
 *
 *  3) Draw diagonal lines, splitting the circle into 8 parts now
 *
 */
public class Task00Example extends Canvas.Plugin {

    public static void main(String[] args) {
        TaskRunner.task("create.Task00Example");
    }

    public void render(Canvas canvas) {
        //# 1
        Point center = canvas.getCenterPoint();
        int radius = 50;

        canvas.drawCircle(center, radius);

        //# 2
        canvas.drawLine(center.x - radius, center.y, center.x + radius, center.y);
        canvas.drawLine(center.x, center.y - radius, center.x, center.y + radius);

        //# 3
        double quarterPI = Math.PI / 4.0;

        canvas.drawLine(
                center.x + (int)(Math.cos(quarterPI*5)*radius),
                center.y + (int)(Math.sin(quarterPI*5)*radius),

                center.x + (int)(Math.cos(quarterPI)*radius),
                center.y + (int)(Math.sin(quarterPI)*radius)
        );

        canvas.drawLine(
                center.x + (int)(Math.cos(quarterPI*7)*radius),
                center.y + (int)(Math.sin(quarterPI*7)*radius),

                center.x + (int)(Math.cos(quarterPI*3)*radius),
                center.y + (int)(Math.sin(quarterPI*3)*radius)
        );

        // To see why we need to use .cos() and .sin() from trigonometry above,
        // try uncommenting and run just the below lines

        // canvas.drawLine(center.x - radius, center.y - radius, center.x + radius, center.y + radius);
        // canvas.drawLine(center.x + radius, center.y - radius, center.x - radius, center.y + radius);


    }
}
