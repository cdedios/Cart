/*
 * Project 2: Unitary Testing
 * Name: Carlos de Dios Felis
 * DNI: 47903957V
 * Date: 11/01/2013
 */
package code;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *  Test the Money class main funcitons
 * @author carlos
 */
public class MoneyTest {
    Money m;
    BigDecimal zero = BigDecimal.ZERO;
    BigDecimal price = new BigDecimal(77);
    
    /**
     *  Check if a new Money with value zero is created correctly.
     * @throws BadQuantityException 
     */
    @Test
    public void get_value_of_zero_is_zero() throws BadQuantityException {
        m = new Money(zero, null);
        assertEquals(zero, m.getValue());
    }
    /**
     *  Push the Money class to throw the BadQuantityException creating a new Money
     *  with a value below Zero.
     * @throws BadQuantityException 
     */
    @Test (expected=BadQuantityException.class)
    public void money_less_than_zero() throws BadQuantityException{
        m = new Money(new BigDecimal(-4), null);
    }
    
    /**
     *  Check the getCurrency() method
     * @throws BadCurrencyException
     * @throws BadQuantityException
     */
    @Test
    public void get_Currency() throws BadCurrencyException, BadQuantityException{
        Currency c = new Currency("PLN");
        m = new Money(zero, c);
        assertEquals(c, m.getCurrency());
    }
    /**
     *  Check the getValue() method
     * @throws BadQuantityException 
     */
    @Test
    public void get_Value() throws BadQuantityException {
        m = new Money(price, null);
        assertEquals(price , m.getValue());
    }
}
