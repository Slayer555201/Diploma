package Diploma;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {

    public static Result runTest(final Class<?> clazz) {
        final JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.addListener(new TextListener(System.out));

        return jUnitCore.run(clazz);
    }
}
