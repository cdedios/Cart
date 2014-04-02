/*
 * Project 2: Unitary Testing
 * Name: Carlos de Dios Felis
 * DNI: 47903957V
 * Date: 11/01/2013
 */
package code;

import java.math.BigDecimal;
import java.math.MathContext;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *  Test the MultyCurrencyMoney class main funcitons 
 * @author carlos
 */
public class MultiCurrencyMoneyTest {
    
    MultiCurrencyMoney mcm;
    Money m,mm,m1,m2;
    Currency c,c1,c2;
    BigDecimal price = new BigDecimal(4);
    CurrencyExchanger exchanger;
    
    /**
     *  Initalize the objects for being used.
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Before
    public void initObjects() throws BadCurrencyException, BadQuantityException{
        //mcm = new MultiCurrencyMoney(); perque sino tots els test treballaran sobre
        //l mateix objecte i no ens interessa
        c = new Currency("USD");
        c1 = new Currency("EUR");
        c2 = new Currency("PLN");
        m = new Money(price, c);
        m1 = new Money(price.multiply(price), c1);
        m2 = new Money(new BigDecimal(6), c2);
        mm = new Money(new BigDecimal(5),c);
    }
    
    /**
     *  Check if the method addMoney is working
     */
    @Test
    public void add_money_test() {
        mcm = new MultiCurrencyMoney();
        mcm.addMoney(m);
        assertTrue(mcm.allMoney.contains(m));
    }
    /**
     *  Adds 2 Money with the same Currency to the MultyCurrencyMoney and check
     * if the getTotal() method works.
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Test
    public void get_total_same_currency_test() throws BadCurrencyException, BadQuantityException{
        mcm = new MultiCurrencyMoney();
        exchanger = new CurrencyExchanger();        
        mcm.addMoney(m);
        mcm.addMoney(mm);
        
        assertEquals(new BigDecimal(9), mcm.getTotal(exchanger, c).getValue());
        assertEquals(c, mcm.getTotal(exchanger, c).getCurrency());
    }
    
    /**
     *Adds 3 Money with different Currencies to the MultyCurrencyMoney and check
     * if the getTotal() method works.
     * One of the values for the conversion is quite little and thats why I have 
     * used the MathContext.DECIMAL32
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Test
    public void get_total_different_currency_test() throws BadCurrencyException, BadQuantityException{
        mcm = new MultiCurrencyMoney();
        exchanger = new CurrencyExchanger();
        mcm.addMoney(m);
        mcm.addMoney(m1);
        mcm.addMoney(m2);
        Money totaa = mcm.getTotal(exchanger, c);
        assertEquals(new BigDecimal(110), mcm.getTotal(exchanger, c2).getValue());
        assertEquals(c, mcm.getTotal(exchanger, c).getCurrency());
        assertEquals(new BigDecimal(36.600000, MathContext.DECIMAL32), mcm.getTotal(exchanger, c).value.abs(MathContext.DECIMAL32));
        assertEquals(c2, mcm.getTotal(exchanger, c2).getCurrency());
    }

}