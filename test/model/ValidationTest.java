package model;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tharindu
 */
public class ValidationTest {
    
    public ValidationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIs_Valid_Password() {
        System.out.println("is_Valid_Password");
        JPasswordField pwd = null;
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.is_Valid_Password(pwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of is_Letter method, of class Validation.
     */
    @Test
    public void testIs_Letter() {
        System.out.println("is_Letter");
        char ch = ' ';
        boolean expResult = false;
        boolean result = Validation.is_Letter(ch);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of is_Numeric method, of class Validation.
     */
    @Test
    public void testIs_Numeric() {
        System.out.println("is_Numeric");
        char ch = ' ';
        boolean expResult = false;
        boolean result = Validation.is_Numeric(ch);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of phoneNumberValidate method, of class Validation.
     */
    @Test
    public void testPhoneNumberValidate() {
        System.out.println("phoneNumberValidate");
        JTextField js = null;
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.phoneNumberValidate(js);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of emptyValue method, of class Validation.
     */
    @Test
    public void testEmptyValue_JTextField_String() {
        System.out.println("emptyValue");
        JTextField js = null;
        String key = "";
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.emptyValue(js, key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of emptyValue method, of class Validation.
     */
    @Test
    public void testEmptyValue_JComboBox() {
        System.out.println("emptyValue");
        JComboBox js = null;
        Validation instance = new Validation();
        boolean expResult = false;
        boolean result = instance.emptyValue(js);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valiDateText method, of class Validation.
     */
    @Test
    public void testValiDateText() {
        System.out.println("valiDateText");
        JTextField js = null;
        String txt = "";
        Validation instance = new Validation();
        String expResult = "";
        String result = instance.valiDateText(js, txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numberValues method, of class Validation.
     */
    @Test
    public void testNumberValues() {
        System.out.println("numberValues");
        JTextField js = null;
        Validation instance = new Validation();
        String expResult = "";
        String result = instance.numberValues(js);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of correct method, of class Validation.
     */
    @Test
    public void testCorrect() {
        System.out.println("correct");
        JTextField js = null;
        Validation instance = new Validation();
        instance.correct(js);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inCorrect method, of class Validation.
     */
    @Test
    public void testInCorrect() {
        System.out.println("inCorrect");
        JTextField js = null;
        Validation instance = new Validation();
        instance.inCorrect(js);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valiDateEmail method, of class Validation.
     */
    @Test
    public void testValiDateEmail() {
        System.out.println("valiDateEmail");
        JTextField js = null;
        Validation instance = new Validation();
        String expResult = "";
        String result = instance.valiDateEmail(js);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
