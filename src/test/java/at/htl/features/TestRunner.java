package at.htl.features;

import com.intuit.karate.junit5.Karate;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class TestRunner {
    @Karate.Test
    Karate testAll() {
        return Karate.run("book").relativeTo(getClass());
    }

    @Karate.Test
    Karate testPost() {
        return Karate.run("book").tags("@post").relativeTo(getClass());
    }
}
