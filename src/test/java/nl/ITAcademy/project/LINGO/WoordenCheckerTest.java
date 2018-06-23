package nl.ITAcademy.project.LINGO;

import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

public class WoordenCheckerTest {

    @Test
    public void pickRandomWord() {
        WoordenChecker woordenChecker = new WoordenChecker();
        woordenChecker.pickRandomWord();
        assertNotNull(woordenChecker.getWord());
    }

    @Test
    public void isValidWord() {
        WoordenChecker woordenChecker = new WoordenChecker();
        Assert.assertTrue(woordenChecker.isValidWord("water"));
        Assert.assertFalse(woordenChecker.isValidWord("wtaer"));
        Assert.assertFalse(woordenChecker.isValidWord("vier"));
        Assert.assertFalse(woordenChecker.isValidWord("kanton"));
    }

    @Test
    public void checkLocation() {
        WoordenChecker woordenChecker = new WoordenChecker();
        woordenChecker.setWord("water");
        String[] expectedOutput1 = {"right", "right", "right", "right", "right"};
        assertArrayEquals(expectedOutput1, woordenChecker.checkInput("water"));
        String[] expectedOutput2 = {"right", null, "wrong", null, "right"};
        assertArrayEquals(expectedOutput2, woordenChecker.checkInput("woaor"));
        String[] expectedOutput3 = {"wrong", null, null, "right", null};
        assertArrayEquals(expectedOutput3, woordenChecker.checkInput("regen"));
        String[] expectedOutput4 = {"right", null, null, null, null};
        assertArrayEquals(expectedOutput4, woordenChecker.checkInput("woooo"));
        String[] expectedOutput5 = {null, "right", "wrong", "right", null};
        assertArrayEquals(expectedOutput5, woordenChecker.checkInput("lawen"));
    }
}