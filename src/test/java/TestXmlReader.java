import com.example.demo.tools.JDBC;
import com.example.demo.tools.XmlReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * * Date          Author             Task ID         Notes
 * * ==========   =================   ==============  ======================
 * * 6/24/2023        M.Hadiyan
 **/


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestXmlReader {


    @Test
    public void readXml() {
        XmlReader.getInstance().readXml("access", Arrays.asList("servlet-name", "roles"));
    }

    @Test
    public void getConnection() throws Exception {
        Connection connection = JDBC.getConnection();
        String schema = connection.getSchema();
        assertNotNull(schema);
    }

}
