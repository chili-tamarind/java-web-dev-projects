package org.launchcode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BalancedBracketsTest {
    //TODO: add tests here

    //this test was input for us. it tests if true is equal to true which is true. maybe for setup and to add packages
    @Test
    public void emptyTest() {
        assertEquals(true, true);
    }

    //reworked onlyBracketsReturnTrue to send a message if the return is false
    @Test
    public void onlyBracketsReturnsTrue() {
        String message = "should return true for balanced brackets";
        String testString = "[]";
        boolean result = BalancedBrackets.hasBalancedBrackets(testString);
        assertTrue(result, message);
    }

    @Test
    public void onlyBracketsReturnsTrueBracketsInFront() {
        String message = "should return true for balanced brackets has brackets then letter";
        String testString = "[]Hello";
        boolean result = BalancedBrackets.hasBalancedBrackets(testString);
        assertTrue(result, message);
    }

    @Test
    public void onlyBracketsReturnsTrueBracketsLettersInFront() {
        String message = "should return true for balanced brackets has letters then bracket";
        String testString = "Hello[]";
        boolean result = BalancedBrackets.hasBalancedBrackets(testString);
        assertTrue(result, message);
    }

    @Test
    public void emptyStringReturnsTrue() {
        String message = "should return true for empty input";
        String testString = "";
        boolean result = BalancedBrackets.hasBalancedBrackets(testString);
        assertTrue(result, message);
    }

    @Test
    public void onlyBracketsReturnTrueOneOfTheLetterInside(){
        String message = " Should return true one of the letter inside the bracket";
        String testString = "[H]ello";
        boolean result = BalancedBrackets.hasBalancedBrackets(testString);
        assertTrue(result, message);
    }

    @Test
    public void singleLeftBracketReturnsFalse() {
        String message = " Should return false if only left bracket";
        String testString = "[";
        boolean result = BalancedBrackets.hasBalancedBrackets(testString);
        assertFalse(result, message);
    }

    @Test
    public void nestedBracketsReturnTrue(){
        String message = " Should return true when there are nested brackets";
        String testString = "[[[[LaunchCode]]]]";
        boolean result = BalancedBrackets.hasBalancedBrackets(testString);
        assertTrue(result, message);
    }

    @Test
    public void multipleUnbalanceBracketsReturnsFalse(){
        String message = " Should return false with multiple unbalanced brackets";
        String testString = "[[[[LaunchCode]]]";
        boolean result = BalancedBrackets.hasBalancedBrackets(testString);
        assertFalse(result, message);
    }

    @Test
    public void doubleLeftBracketsReturnsFalseFive(){
        String message = " Should return false with multiple unbalanced brackets";
        String testString = "[[[[LaunchCode]]]";
        boolean result = BalancedBrackets.hasBalancedBrackets(testString);
        assertFalse(result, message);
    }

    @Test
    public void nestedUnbalancedBracketsWithLettersReturnsFalse() {
        String message = "Should return false when there are nested unbalanced brackets with letters";
        String testString = "[L][]]aunchCode";
        boolean result = BalancedBrackets.hasBalancedBrackets(testString);
        assertFalse(result, message);
    }

}