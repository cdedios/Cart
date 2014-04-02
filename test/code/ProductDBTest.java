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
 *  Test the ProductDB class main funcitons 
 * @author carlos
 */
public class ProductDBTest {
    
    UPC upc = new UPC("66666");
    Currency c;
    Money mny;
    ProductDB pdb;

    /**
     *  Initalize the objects for being used.
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Before
    public void initObject() throws BadCurrencyException, BadQuantityException{
        c = new Currency("PLN");
        mny = new Money(new BigDecimal(4), c);
        //pdb.initProductDB();
    }
    /**
     *  Check the addProduct method 
     * @throws BADUPCExcecption
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Test
    public void add_product() throws BADUPCExcecption, BadCurrencyException, BadQuantityException {
        pdb = new ProductDB();
        pdb.addProduct(upc, mny);
        
        assertTrue(pdb.available(upc));
        assertEquals(mny, pdb.products.get(upc));
        assertEquals(mny, pdb.getPrice(upc));
    }
    
    /**
     *  Check if the exception BADUPCExcetpion is thrown when the UPC given
     *  on the addProduct(UPC,Money) method is wrong.
     * @throws BADUPCExcecption
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Test (expected=BADUPCExcecption.class)
    public void bad_udp_exception() throws BADUPCExcecption, BadCurrencyException, BadQuantityException{
        pdb = new ProductDB();
        pdb.addProduct(upc, mny);
        UPC fake_upc = new  UPC("1111");
        Money u = pdb.getPrice(fake_upc);
    }
    
    /**
     *  Check the getPrice(UPC) method
     * @throws BADUPCExcecption
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Test
    public void get_price_test() throws BADUPCExcecption, BadCurrencyException, BadQuantityException{
        pdb = new ProductDB();
        pdb.addProduct(upc, mny);
        assertEquals(mny, pdb.getPrice(upc)); 
    }
}
