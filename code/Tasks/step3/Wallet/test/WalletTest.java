package Tasks.step3.Wallet.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

import Tasks.step3.Wallet.src.Wallet;

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
            throw new NoSuchFieldException("No zipper field found within the class");
        }

        assertEquals(Modifier.PRIVATE, field.getModifiers(), "Field does not have a private access modifier");
        assertTrue(field.getType().isPrimitive(), "Field type expected to be a primitive type");
        assertEquals(field.getType().toString(), "boolean", "Field type expected to be boolean");
    }

    @Test
    public void testWalletZipperCanOpenAndClose() throws NoSuchMethodException {
        Method open;
        Method close;

        // open zipper functionality
        try {
            open = wallet.getClass().getDeclaredMethod("zipperOpen");
        }
        catch(NoSuchMethodException e) {
            throw new NoSuchMethodException("Could not locate a method by the name zipperOpen");
        }

        assertEquals(Modifier.PUBLIC, open.getModifiers(), "Due to encapsulation, we expect zipperOpen to be public");
        assertEquals(open.getReturnType().toString(), "void", "We expect zipperOpen to return nothing");

        // close zipper functionality
        try {
            close = wallet.getClass().getDeclaredMethod("zipperClose");
        }
        catch(NoSuchMethodException e) {
            throw new NoSuchMethodException("Could not locate a method by the name zipperClose");
        }

        assertEquals(Modifier.PUBLIC, close.getModifiers(), "Due to encapsulation, we expect zipperClose to be public");
        assertEquals(close.getReturnType().toString(), "void", "We expect zipperClose to return nothing");

    }
}
