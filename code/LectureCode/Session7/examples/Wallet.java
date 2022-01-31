package LectureCode.Session7.examples;

import java.util.ArrayList;

public class Wallet {
    ArrayList<ContactCard> cards = new ArrayList<>();

    void addCard(ContactCard card) {
        this.cards.add(card);
    }

    void printContactInfo() {
        System.out.println("Contact Info:");
        for (ContactCard card : this.cards) {
            System.out.printf(
                    "+ Name: %s%n-- Email: %s%n-- Phone: (+47) %s%n",
                    card.getName(),
                    card.getEmail(),
                    card.getPhoneNumber() <= 0 ? "????????" : card.getPhoneNumber()
            );
        }
    }

    public static void main(String[] args) {
        Wallet wallet = new Wallet();

        ContactCard marcus = new ContactCard(
        "Marcus",
        "marcusalexander.dahl@kristiania.no",
        0
        );

        ContactCard yuan = new ContactCard(
        "Yuan",
        "yuan.lin@kristiania.no",
        0
        );

        ContactCard school = new ContactCard(
        "Høyskolen Kristiania",
        "studier@kristiania.no",
        22_59_60_00
        );

        wallet.addCard(school);
        wallet.addCard(yuan);
        wallet.addCard(marcus);

        wallet.printContactInfo();
    }
}

class ContactCard {
    private String name;
    private final String email;
    private final long phone;

    ContactCard(String name, String email, long phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public long getPhoneNumber() {
        return this.phone;
    }
}
