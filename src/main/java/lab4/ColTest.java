package lab4.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColTest {

    @Test
    public void validStringsReturnCorrectCol() {
        assertEquals(Col.A, Col.from("A"));
        assertEquals(Col.B, Col.from("B"));
        assertEquals(Col.C, Col.from("C"));
        // Add other columns if they exist
    }

    @Test
    public void methodIsCaseInsensitive() {
        assertEquals(Col.A, Col.from("a"));
        assertEquals(Col.B, Col.from("b"));
        // Continue for all columns
    }

    @Test
    public void invalidStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Col.from("Z"));
        assertThrows(IllegalArgumentException.class, () -> Col.from(""));
        assertThrows(IllegalArgumentException.class, () -> Col.from(null));
    }
}
