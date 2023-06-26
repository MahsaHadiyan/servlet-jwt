import com.example.demo.controller.TestOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by M.Hadiyan
 * Date: 6/26/2023
 * Time: 11:55 AM
 **/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestOneClassLoader {



    @Test
    public void test() {

        TestOne test= new TestOne();

        Set<Class> classes = test.findAllClassesUsingClassLoader(
                "com.example.demo.controller");
        Assertions.assertEquals(11, classes.size());
    }


}
