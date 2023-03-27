package at.htl.features;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class TestRunner {
        @Karate.Test
        Karate testAll() {
            return Karate.run("classpath:at/htl/features");
        }
}
