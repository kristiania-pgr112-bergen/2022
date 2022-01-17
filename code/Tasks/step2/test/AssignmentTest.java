package Tasks.step2.test;

import Tasks.step2.src.Assignment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    Assignment assignment = new Assignment();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testAddThreeNumbers(){
        assertTrue(assignment.addThreeNumbers(1,2, 3) ==6);
    }

    @Test
    public void testIsNumberSmallMediumOrBig() {
        assertTrue(assignment.isNumberSmallMediumOrBig(99).equalsIgnoreCase("Small"));
        assertTrue(assignment.isNumberSmallMediumOrBig(100).equalsIgnoreCase("Medium"));
        assertTrue(assignment.isNumberSmallMediumOrBig(1001).equalsIgnoreCase("Big"));
    }

    @Test
    public void testPrintAllStrings() {
        String[] strings = {"Coding", "is", "fun!"};
        assignment.printAllStrings(strings);
        assertEquals("Codingisfun!", outputStreamCaptor.toString().replaceAll("\\p{Cntrl}", ""));
    }

    @Test
    public void testArraySum() {
        int[] numbers = {5, 10, 16};
        assertTrue(assignment.arraySum(numbers)==31);
    }

    @Test
    public void testPrintFirstSentence() {
        char [] chars = "This is the first sentence. This is the second. I even have a third!".toCharArray();
        assignment.printFirstSentence(chars);
        assertEquals("This is the first sentence.", outputStreamCaptor.toString());
    }

    @Test
    public void testPrintFirstSentenceNoDot() {
        char [] charsWithNoDot = "Hei!".toCharArray();
        assignment.printFirstSentence(charsWithNoDot);
        assertEquals("Hei!", outputStreamCaptor.toString());
    }

    @Test
    public void testPrintCourseName() {
        assignment.printCourseName("PGR103");
        assertEquals("Objektorientert programmering", outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();
        assignment.printCourseName("DB1102");
        assertEquals("Database", outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();
        assignment.printCourseName("TK2100");
        assertEquals("Informasjonssikkerhet", outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();
        assignment.printCourseName("Non-existing code");
        assertEquals("Unknown", outputStreamCaptor.toString().trim());
    }

    @Test
    public void testPrintAllStringsNotCorona() {
        String[] strings = {"These", "are", "fun", "Corona", "times!"};
        assignment.printAllStringsNotCorona(strings);
        assertEquals("Thesearefuntimes!", outputStreamCaptor.toString().replaceAll("\\p{Cntrl}", ""));
    }

    @Test
    public void testPrintUpperCaseStrings() {
        String[] strings = {"These", "are", "fun", "Corona", "times!"};
        assignment.printUpperCaseStrings(strings);
        assertEquals("THESEAREFUNCORONATIMES!", outputStreamCaptor.toString().replaceAll("\\p{Cntrl}", ""));
    }

    @Test
    public void testIsColorInNorwegianFlag() {
        assertTrue(assignment.isColorInNorwegianFlag("blue"));
        assertTrue(assignment.isColorInNorwegianFlag("red"));
        assertTrue(assignment.isColorInNorwegianFlag("white"));
        assertFalse(assignment.isColorInNorwegianFlag("green"));
    }

    @Test
    public void testFirstOccurrence() {
        assertTrue(assignment.firstOccurrence("blue", 'l')==1);
        assertTrue(assignment.firstOccurrence("blue", 'x')==-1);
    }

    @Test
    public void testCombinedLength() {
        assertTrue(assignment.combinedLength("red", "blue")==7);
    }

    @Test
    public void testAddNumbers() {
        assertTrue(assignment.addNumbers(1,2,3,4)==10);
        assertTrue(assignment.addNumbers(1,2)==3);
    }

    @Test
    public void testPrintAllStringsNotCoronaCaseInsensitive() {
        String[] strings = {"These", "are", "fun", "cOrOna", "times!"};
        assignment.printAllStringsNotCoronaCaseInsensitive(strings);
        assertEquals("Thesearefuntimes!", outputStreamCaptor.toString().replaceAll("\\p{Cntrl}", ""));
    }



}