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
 *  Test the Currency class main funcitons.
 * @author carlos
 */
public class CurrencyTest {
    
    /**
     *   Check if the constructor throws BadCurrencyException given a wrong value.
     * @throws BadCurrencyException
     */
    @Test (expected=BadCurrencyException.class)
    public void constructor_exception() throws BadCurrencyException {
        Currency c = new Currency("WRONGCODE");
    }
    /**
     *  Check if the constructor throws BadCurrencyException given a null value.
     * @throws BadCurrencyException
     */
    @Test (expected=BadCurrencyException.class)
    public void null_abbreviation() throws BadCurrencyException{
        Currency c = new Currency(null);
    }
    
    /**
     *  Check the getAbbreviation() method.
     * @throws BadCurrencyException
     */
    @Test
    public void get_abbreviation_check() throws BadCurrencyException{
        Currency c = new Currency("EUR");
        assertEquals("EUR",c.getAbbreviation());
    }
    
}
