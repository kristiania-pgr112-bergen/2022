package LectureCode.Session8.src.computer;

import java.util.Optional;

public class Main {
    public static void main(String args[]) {
        Computer computer = new Computer(new StandardProcessor("Intel Core i9-12900K Processor DirectX 12.00"),
                new Memory("DDR4-2933", "4G"));
        computer.setSoundCard(new SoundCard("Asus Xonar AE"));
        Optional<SoundCard> soundCard = computer.getSoundCard();
        soundCard.ifPresent(SoundCard -> SoundCard.printMe());
        System.out.println(computer.getProcessor().toString());

    }
}
