import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestApplication {
    @DisplayName("Test Application")
    @Test
    void testApplication(){
        Assertions.assertEquals(true, true);
    }
}
