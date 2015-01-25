package projects;

import java.io.IOException;

/**
 * Created by jbelo on 1/25/15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        MyBenchmark myBenchmark = new MyBenchmark();
        myBenchmark.setup();
        myBenchmark.testMethod();
    }
}
