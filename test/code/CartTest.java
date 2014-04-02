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
 *  Test the Cart class main funcitons 
 * @author carlos
 */
public class CartTest {
    DataBase pdb ;
    Exchanger ce;
    Cart cart;
    Currency c;
    UPC prod1;       
    /**
     *  Initalize the objects for being used.
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    @Before
    public void setUp() throws BadCurrencyException, BadQuantityException{
        pdb = new productDatabaseDouble();
        ce = new CurrencyExchangerDouble();
        c = new Currency("EUR");
        cart = new Cart(c, pdb, ce);
        prod1 = new UPC("1234");
    }
    /**
     *  Change the currency.
     * @throws BadCurrencyException
     */
    @Test    
    public void currency_selection_test() throws BadCurrencyException {
        Currency nc = new Currency("USD");
        cart.selectCurrency(nc);
        assertEquals(nc, cart.currency);
    }
    /**
     *  Push the Cart to throw the BadQuantityException.
     * @throws BADUPCExcecption
     * @throws BadQuantityException
     */
    @Test (expected=BadQuantityException.class)
    public void quantity() throws BADUPCExcecption, BadQuantityException{
        cart.addItem(prod1, 0);        
    }
    /**
     *  Add one single item and check that has been added.
     * @throws BADUPCExcecption
     * @throws BadQuantityException
     */
    @Test
    public void add_single_item() throws BADUPCExcecption, BadQuantityException{
        int quant = 1;
        cart.addItem(prod1, quant);        
        assertEquals(quant, (int)cart.prodQuant.get(prod1));
        
    }
    /**
     *  Check the addition of multimple items with the same UPC. 
     *  The quantity should be encreased with the quantity that
     *  was already on the Cart.
     * @throws BADUPCExcecption
     * @throws BadQuantityException
     */
    @Test
    public void add_multiple_items() throws BADUPCExcecption, BadQuantityException{
        int quant = 1;
        cart.addItem(prod1, quant);        
        cart.addItem(prod1, quant*4);
        assertEquals(quant*5, (int)cart.prodQuant.get(prod1));
        
    }
    
    /**
     *  Check te getTotal method for one single item.
     * @throws BadCurrencyException
     * @throws BADUPCExcecption
     * @throws BadQuantityException
     */
    @Test
    public void total_of_one_item() throws BadCurrencyException, BADUPCExcecption, BadQuantityException{
        
        Money m = pdb.getPrice(prod1);        
        cart.addItem(prod1, 1);
        assertEquals(m, cart.getTotal());
    }
    /**
     *  Check the getTotal method for the same item added multiples times.
     * @throws BADUPCExcecption
     * @throws BadQuantityException
     * @throws BadCurrencyException
     */
    @Test
    public void total_same_item_multiple_times() throws BADUPCExcecption, BadQuantityException, BadCurrencyException{
        Money m = pdb.getPrice(prod1);
        cart.addItem(prod1,5);
        cart.addItem(prod1, 2);
        Money exp = new Money(m.value.multiply(new BigDecimal(7)), c);
        assertEquals(exp,cart.getTotal());
    }
    /**
     *  Check the getTotal method for the different items added.
     * @throws BADUPCExcecption
     * @throws BadQuantityException
     * @throws BadCurrencyException
     */
    @Test
    public void total_multiple_items_different_currencys() throws BADUPCExcecption, BadQuantityException, BadCurrencyException{
        int quant = 1;
        UPC prod2 = new UPC("12345");
        Currency c2 = new Currency("USD");
        cart.addItem(prod1, quant);        
        cart.addItem(prod2, quant*4);
        cart.selectCurrency(c2);
        Money total = new Money(new BigDecimal(40),c2);
        Money subtotal = cart.getTotal();
        assertEquals(total,cart.getTotal());
        
    }
    
    /**
     *  Check the getTotal() method for an empty Cart
     * @throws BadCurrencyException
     * @throws BADUPCExcecption
     * @throws BadQuantityException  
     */
    @Test
    public void total_of_empty_cart() throws BadCurrencyException, BADUPCExcecption, BadQuantityException{
        Money mEmpty = new Money(BigDecimal.ZERO, c);
        assertEquals(mEmpty, cart.getTotal());
    }    
    /*
     * Double of the ProductDBr class to test the class Cart properly.
     */
    private static class productDatabaseDouble implements DataBase{
        Money m;
        
        public productDatabaseDouble() throws BadCurrencyException, BadQuantityException {
            m = new Money(new BigDecimal(8), new Currency("EUR"));
        }
        
        @Override
        public void addProduct(UPC upc, Money money) { }

        @Override
        public Money getPrice(UPC upc) throws BADUPCExcecption {return m;}

        @Override
        public boolean available(UPC upc) { return true; }
        
    }
    /*
     * Double of the CurrencyExchanger class to test the class Cart properly.
     */
    private static class CurrencyExchangerDouble implements Exchanger{
        
        public CurrencyExchangerDouble(){}
        @Override
        public void setRate(Currency from, Currency to, double rate) {}

        @Override
        public Money convert(Money from, Currency to) throws BadCurrencyException, BadQuantityException {
            return new Money(from.getValue(), to);
        }
        
    }
}
