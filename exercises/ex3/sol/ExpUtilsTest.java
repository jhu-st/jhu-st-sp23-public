import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpUtilsTest {

    @Test
    public void testValidBracketsEmptyExp() {
        assertTrue(ExpUtils.validBrackets(""));
    }

    // Reveals a fault
    @Test
    public void testInvalidOpenParan() {
        assertFalse(ExpUtils.validBrackets("("));
    }

    @Test
    public void testValidCurlyBraces() {
        assertTrue(ExpUtils.validBrackets("{}"));
    }

    @Test
    public void testValidCurlyBrackets() {
        assertTrue(ExpUtils.validBrackets("[]"));
    }

    @Test
    public void testValidCurlyParentheses() {
        assertTrue(ExpUtils.validBrackets("()"));
    }

    @Test
    public void testInvalidCloseParan() {
        assertFalse(ExpUtils.validBrackets(")"));
    }

    @Test
    public void testInvalidChar1() {
        assertFalse(ExpUtils.validBrackets("(3)"));
    }

    @Test
    public void testInvalidChar2() {
        assertFalse(ExpUtils.validBrackets("[3"));
    }

    @Test
    public void testInvalidBracket() {
        assertFalse(ExpUtils.validBrackets("(]"));
    }

    @Test
    public void testInvalidCurlyBrace() {
        assertFalse(ExpUtils.validBrackets("[}"));
    }

    @Test
    public void testInvalidParenthesis() {
        assertFalse(ExpUtils.validBrackets("{)"));
    }
}
