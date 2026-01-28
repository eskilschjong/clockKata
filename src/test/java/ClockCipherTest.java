import assignment.ClockCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClockCipherTest {

    @Test
    public void testEncrypt_givenMubashirHassan_shouldReturnMsussaHRNHaaib() {
        String message = "Mubashir Hassan";
        String expected = "Ms ussahr nHaaib";
        String actual = ClockCipher.encrypt(message);
        assertEquals(expected, actual);

    }
}
