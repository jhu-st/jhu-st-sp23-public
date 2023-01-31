import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpUtilsTest {

    @Test
    public void testValidBracketsEmptyExp() {
        assertTrue(ExpUtils.validBrackets(""));
    }

    // Reveals a fault
    @Test
    public void testValidBracketsExpLength1Bracket() {
        assertFalse(ExpUtils.validBrackets("("));
    }

    @Test
    public void testValidBracketsExpLength2ValidBrackets() {
        assertTrue(ExpUtils.validBrackets("()"));
    }

    @Test
    public void testValidBracketsExpLength1Invalid() {
        assertFalse(ExpUtils.validBrackets(")"));
    }

    @Test
    public void testValidBracketsExpValidWithInvalidChar() {
        assertFalse(ExpUtils.validBrackets("(3)"));
    }

    @Test
    public void testValidBracketsExpressionInvalidExpInvalidChar() {
        assertFalse(ExpUtils.validBrackets("(3"));
    }

    @Test
    public void testValidBracketsExpInvalidBracketsDoNotMatch() {
        assertFalse(ExpUtils.validBrackets("(]"));
    }

}
