package Tasks.playground;

import Playground.Sandbox.Launcher;

import java.util.ArrayList;
import java.util.Arrays;

public class TaskRunner {
    public static void task(String name) {
        Launcher.run(640, 480, new ArrayList<>(
                Arrays.stream(new String[] { "Tasks.playground." + name }).toList()
        ), true);
    }
}
