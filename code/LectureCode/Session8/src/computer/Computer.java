package LectureCode.Session8.src.computer;

import java.util.Optional;

public class Computer {
    /**
    Creating HAS-A relationship with Processor, Memory, SoundCard class
    */
    private Processor processor;
    private Memory memory;
    private SoundCard soundCard;

    // standard getters/setters/constructors

    public Computer(Processor processor, Memory memory) {
        this.processor = processor;
        this.memory = memory;
    }

    public void setSoundCard(SoundCard soundCard) {
        this.soundCard = soundCard;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Optional<SoundCard> getSoundCard() {
        return Optional.ofNullable(soundCard);
    }
}
