/*
 * Project 2: Unitary Testing
 * Name: Carlos de Dios Felis
 * DNI: 47903957V
 * Date: 11/01/2013
 */
package code;

import java.math.BigDecimal;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *  Test the CurrencyExchanger class main funcitons 
 * @author carlos
 */
public class CurrencyExchangerTest {
    CurrencyExchanger ce;
    Currency c1, c2;
    Money m;
    double rate = 2;
    BigDecimal price = new BigDecimal(4);
    
    /**
     *  Initalize the objects for being used.
     * @throws BadCurrencyException
     */
    @Before
    public void initObjects() throws BadCurrencyException{
        c1 = new Currency("EUR");
        c2 = new Currency("USD");        
    }

    /**
     *  test the setRates method
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Test
    public void set_rate_test() throws BadCurrencyException, BadQuantityException {
        ce = new CurrencyExchanger();
        ce.setRate(c1, c2, rate );
        m = new Money(price, c1);
        assertEquals(ce.convert(m, c2), new Money(price.multiply(new BigDecimal(rate)),c2));
        
    }
    /**
     *  Convert the same money to a different currency and convert it again to the
     * same as before.
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Test
    public void double_conversion_test() throws BadCurrencyException, BadQuantityException{
        ce = new CurrencyExchanger();
        m = new Money(price, c1);
        Money reslt = ce.convert(m, c2);
        reslt = ce.convert(reslt, c1);
        assertEquals(m,reslt);
    }
    /**
     *  Convert the money multiple times
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Test
    public void multiple_conversions_test() throws BadCurrencyException, BadQuantityException{
        m = new Money(price, c1);
        ce = new CurrencyExchanger();
        Currency c3 = new Currency("PLN");
        Money conv = ce.convert(m, c3);
        conv = ce.convert(conv, c1);
        assertEquals(m,conv);
    }
}
