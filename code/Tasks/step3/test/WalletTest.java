package Tasks.step3.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

import Tasks.step3.src.Wallet;

public class WalletTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    Wallet wallet = new Wallet();

    //# Preparation
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(this.outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    //# Helper
    /** Local helper method */
    private String getOutputString() {
        return outputStreamCaptor.toString().replaceAll("\\p{Cntrl}", "");
    }

    //# Tests
    @Test
    public void testWalletConstructionPrintsAnyLengthAboutCoins() {
        wallet.printCoins();

        assertTrue(this.getOutputString().length() > 0);
    }

    @Test
    public void testWalletZipperExistsAsFieldTypeBoolean() throws NoSuchFieldException {
        String fieldName = "zipper";
        Field field;

        try {
            field = wallet.getClass().getDeclaredField(fieldName);
        }
        catch (NoSuchFieldException e) {
            throw new NoSuchFieldException("No zipper field found with the expected type boolean");
        }

        assertTrue(field.getType().isPrimitive());
        assertEquals(field.getType().toString(), "boolean");
    }

    @Test
    public void testWalletZipperCanOpenAndClose() {
        // Method open = wallet.getClass().getDeclaredMethod("zipperOpen");
    }
}
