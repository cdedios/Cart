/*
 * Project 2: Unitary Testing
 * Name: Carlos de Dios Felis
 * DNI: 47903957V
 * Date: 11/01/2013
 */
package code;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *  Test the UPC class main funcitons 
 * @author carlos
 */
public class UPCTest {
    String code = "352345";

    /**
     *  Check if the code given on the constructor is the same with getCode
     */
    @Test
    public void get_code_test() {
        UPC upc = new UPC(code);
        assertEquals(code, upc.getCode());
    }
    /**
     *  Check if two diferent objects are not equals  with equals()
     */
    @Test
    public void not_equals_test(){
        UPC upc = new UPC(code);
        UPC upc2 = new UPC(code+code);
        assertFalse(upc.equals(upc2));
    }
    /**
     *  Check if two equals objects are equals with equals() 
     */
    @Test
    public void equals_test(){
        UPC upc = new UPC(code);
        UPC upc2 = new UPC(code);
        assertTrue(upc.equals(upc2));
    }    
}
