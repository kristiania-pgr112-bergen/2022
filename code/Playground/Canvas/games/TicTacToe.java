package Playground.Canvas.games;

import Playground.Canvas.Launcher;
import Playground.Canvas.Window;

import java.awt.*;
import java.util.ArrayList;

public class TicTacToe extends Window.Canvas.Plugin {

    public static void main(String[] args) {
        ArrayList<String> plugins = new ArrayList<>();

        plugins.add("plugins.HKLogo");
        plugins.add("games.TicTacToe");

        Launcher.run(plugins);
    }

    //# Adjust size of board here
    static final float size = 3.0f;

    static final int slots = (int)(Math.pow(TicTacToe.size, 2));
    static final int turns = TicTacToe.slots + 1;

    enum GridSlot {
        EMPTY,
        CROSS,
        CIRCLE
    }

    static GridSlot[] board = new GridSlot[TicTacToe.slots];
    static int player = 0;
    static int turn = 1;

    @Override
    public void render(Window.Canvas canvas) {
        Point center = canvas.getCenterPoint();
        Dimension size = new Dimension(450, 450);

        Dimension slotSize = new Dimension(
                (int)(size.width/TicTacToe.size),
                (int)(size.height/TicTacToe.size)
        );

        canvas.drawRectangle(center, size);

        Point upperLeft = new Point(
                (int)(center.x - (size.width/2.0d)),
                (int)(center.y - (size.height/2.0d))
        );

        for (int i = 1; i < TicTacToe.size; i ++) {
            // horizontal
            canvas.drawLine(
                    upperLeft.x,
                    upperLeft.y + slotSize.height*i,
                    upperLeft.x + size.width,
                    upperLeft.y + slotSize.height*i
            );

            // vertical
            canvas.drawLine(
                    upperLeft.x + slotSize.height*i,
                    upperLeft.y,
                    upperLeft.x + slotSize.height*i,
                    upperLeft.y + size.height
            );
        }

        canvas.drawText(
                new Font("Arial", Font.BOLD, 24),
                "Turn %d".formatted(TicTacToe.turn),
                0.5f, 0.15f
        );

        if (TicTacToe.turn < TicTacToe.turns) {
            canvas.drawText(
                    new Font("Arial", Font.BOLD, 24),
                    "Player %s".formatted(TicTacToe.player == 0 ? "One" : "Two"),
                    0.5f, 0.2f
            );
        }

        for (int i = 0; i < TicTacToe.turns - 1; i ++) {
            int x = i % (int)(TicTacToe.size);
            int y = (int)(i/TicTacToe.size);

            Rectangle clickArea = new Rectangle(
                    upperLeft.x + (slotSize.width * x),
                    upperLeft.y + (slotSize.height * y),
                    slotSize.width,
                    slotSize.height
            );

            if (TicTacToe.board[i] == null) {
                TicTacToe.board[i] = GridSlot.EMPTY;
            }
            else {
                if (TicTacToe.board[i] == GridSlot.CROSS) {
                    canvas.drawCross(
                            clickArea.x + (int)(slotSize.width/2.0d),
                            clickArea.y + (int)(slotSize.height/2.0d),
                            (int)(slotSize.width/2.0d)
                    );
                }
                else if (TicTacToe.board[i] == GridSlot.CIRCLE) {
                    canvas.drawCircle(
                            clickArea.x + (int)(slotSize.width/2.0d),
                            clickArea.y + (int)(slotSize.height/2.0d),
                            (int)(slotSize.width/2.2d)
                    );
                }
            }

            if (TicTacToe.turn >= TicTacToe.turns) {
                canvas.drawText(new Font("Arial", Font.BOLD, 21), "No more turns! Who won?", 0.5f, 0.8f);
            }

            int index = i;
            canvas.onMouseClick(
                    clickArea, (click) -> {
                        if (TicTacToe.turn >= TicTacToe.turns) {
                            return false;
                        }

                        if (TicTacToe.board[index] == GridSlot.EMPTY) {
                            TicTacToe.board[index] = TicTacToe.player == 0 ? GridSlot.CROSS : GridSlot.CIRCLE;

                            TicTacToe.player = (TicTacToe.player + 1) % 2;
                            TicTacToe.turn++;

                            canvas.redraw();
                        }

                        return true;
                    }
            );
        }
    }
}
