package Playground.Canvas.examples;

import Playground.Canvas.Launcher;
import Playground.Canvas.Window;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DeckOfCards extends Window.Canvas.Plugin {
    //# Launcher that only loads this plugin
    public static void main(String[] args) {
        ArrayList<String> plugins = new ArrayList<>();

        plugins.add("Playground.Canvas.examples.DeckOfCards");

        Launcher.run(1200, 900, plugins, true);
    }

    //# State
    static Deck deck = new Deck();

    //# Render
    @Override
    public void render(Window.Canvas canvas) {
        Card card = DeckOfCards.deck.cards.get(1);

        Point center = canvas.getCenterPoint();

        Dimension outputSize = new Dimension(
                (Card.size.width * 13) + 7*12,
                (Card.size.height * 4) + 7*3
        );

        canvas.drawRectangle(center, outputSize);

        for (int i = 0; i < DeckOfCards.deck.cards.size(); i ++) {
            this.renderCard(
                    canvas,
                    DeckOfCards.deck.cards.get(i + 1),
                    new Point(
                            (center.x - (int)(outputSize.width/2.0d)) + ((Card.size.width + 7) * (i  % (13))),
                            (center.y - (int)(outputSize.height/2.0d)) + ((Card.size.height + 7) * ((int)((i + 1) / 13.0d) % 4))
                    )
            );
        }
    }

    void renderCard(Window.Canvas canvas, Card card, Point point) {
        float[] scale = Window.Canvas.getAnchorDisplacement(Window.Canvas.Anchor.TOP_LEFT);

        Point upperLeft = new Point(0, Card.size.height + 1);
        Point cardPosition = new Point(
                point.x - (int)(Card.size.width * scale[0]),
                point.y - (int)(Card.size.height * scale[1])
        );

        Rectangle part = new Rectangle(
                upperLeft.x + ((Card.size.width  + 1) * (card.getValue() - 1)),
                upperLeft.y + ((Card.size.height + 1) * (card.getSuitValue() - 1)),
                Card.size.width, Card.size.height
        );

        System.out.println(part);

        canvas.drawImagePart(
                "playing-cards.png",
                cardPosition,
                part,
                Window.Canvas.Anchor.TOP_LEFT
        );

        canvas.drawRectangle(cardPosition, Card.size, Window.Canvas.Anchor.TOP_LEFT);
    }

    static class Deck {
        HashMap<Integer, Card> cards = new HashMap<>();

        private Deck() {
            int color = 26;
            int suit = 13;

            Card.Color[] colors = Card.Color.values();
            Card.Value[] values = Card.Value.values();
            Card.Suit[] suits = Card.Suit.values();

            int cards = 52;

            for (int i = 0; i < cards; i ++) {
                Card card = new Card(
                        values[-(i % values.length) * -1],
                        colors[((i + 1) / color) % colors.length],
                        suits[((i + 1) / suit) %  suits.length]
                );

                this.cards.put(i + 1, card);

                // System.out.printf("%s %s %s%n", card.value, card.color, card.suit);
            }
        }

        static Deck create() {
            return new Deck();
        }
    }

    static class Card {
        Card.Color color;
        Card.Suit suit;
        Card.Value value;

        static Dimension size = new Dimension(64, 88);

        Card(Card.Value value, Card.Color color, Card.Suit suit) {
            this.color = color;
            this.suit = suit;
            this.value = value;
        }

        int getValue() {
            switch(this.value) {
                case Ace    -> { return 1; }
                case Two    -> { return 2; }
                case Three  -> { return 3; }
                case Four   -> { return 4; }
                case Five   -> { return 5; }
                case Six    -> { return 6; }
                case Seven  -> { return 7; }
                case Eight  -> { return 8; }
                case Nine   -> { return 9; }
                case Ten    -> { return 10;}
                case Jack   -> { return 11;}
                case Queen  -> { return 12;}
                case King   -> { return 13;}
                default     -> { return 0; }
            }
        }

        int getSuitValue() {
            switch (this.suit) {
                case Clubs      -> { return 1; }
                case Spades     -> { return 2; }
                case Hearts     -> { return 3; }
                case Diamonds   -> { return 4; }
                default         -> { return 0; }
            }
        }

        int getColorValue() {
            switch (this.color) {
                case Black  -> { return 1; }
                case Red    -> { return 2; }
                default     -> { return 0;}
            }
        }

        enum Color {
            Black,
            Red
        }

        enum Suit {
            Clubs,
            Spades,
            Hearts,
            Diamonds
        }

        enum Value {
            Ace,
            Two,
            Three,
            Four,
            Five,
            Six,
            Seven,
            Eight,
            Nine,
            Ten,
            Jack,
            Queen,
            King
        }
    }
}
