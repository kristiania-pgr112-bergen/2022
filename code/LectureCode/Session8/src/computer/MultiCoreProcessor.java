package LectureCode.Session8.src.computer;

public class MultiCoreProcessor extends Processor{
    public MultiCoreProcessor(String model) {
        super(model);
    }
    @Override
    public String toString() {
        return String.format("I am a multicore CPU processor with model = %s", model);
    }
}
