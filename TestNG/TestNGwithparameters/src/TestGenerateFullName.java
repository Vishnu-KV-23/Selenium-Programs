import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestGenerateFullName {

    NameGeneration obj = new NameGeneration();

    @Test
    @Parameters({"firstname", "lastname"})
    public void testFullName(String firstname, String lastname) {
        // Fill the code here
        String expected = firstname + " " + lastname;
        String actual = obj.getFullName(firstname, lastname);
        assertEquals(actual, expected);
    }
}
