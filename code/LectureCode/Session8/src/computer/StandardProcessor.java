package LectureCode.Session8.src.computer;

public class StandardProcessor extends Processor {

    public StandardProcessor(String model) {
        super(model);
    }
    @Override
    public String toString() {
        return String.format("I am a standard CPU processor with model = %s", model);
    }
}
