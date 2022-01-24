package Tasks.step5.src;

public class DebugClassConstructor {
    double value;

    DebugClassConstructor() {
        this.setRandomValue();
    }

    void setRandomValue() {
        this.value = Math.random();
    }

    public static void main(String[] args) {
        DebugClassConstructor instance = new DebugClassConstructor();
    }
}

/*
    Task: Debugger

    Put a breakpoint on line 15 and start debugging the main method.

    Use "Step Into" to go through each step.

    How would you roughly explain the different 6 steps it takes? Keep it as simple and short as possible.
*/
