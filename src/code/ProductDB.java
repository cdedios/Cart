/*
 * Project 2: Unitary Testing
 * Name: Carlos de Dios Felis
 * Date: 11/01/2013
 */
package code;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * A Data Base to check the products price. 
 * This class implements the DataBase interface. 
 *
 * @author carlos
 */
public class ProductDB implements DataBase{
    HashMap<UPC, Money> products;
    
    /**
     *Called by the cart to know the prices
     * @throws BadCurrencyException by the initProductDB() fucntion when some
     * upc is not correct, think that will "never" happen.
     * @throws BadQuantityException  
     */
    public ProductDB() throws BadCurrencyException, BadQuantityException {
        products = new HashMap<UPC, Money>();
        this.initProductDB();
    }
    /**
     * Add to the to the internal hashmap products the given upc as a key and 
     * the price as the value.
     * @param upc the product code
     * @param price the product price
     */
    @Override
    public void addProduct(UPC upc, Money price){
        if (products.containsKey(upc)) {
            System.out.print("The product with the code"+ upc.getCode()+" is already on de database\n");
        }
        products.put(upc, price);
    }
    @Override
    public boolean available(UPC upc) {
        return products.containsKey(upc);
    }
    
    @Override
    public Money getPrice(UPC upc)throws BADUPCExcecption{
        if(!products.containsKey(upc)){
            throw new BADUPCExcecption();
        }
        return products.get(upc);
    }
    
    /**
     * Initialize the Data Base with some parameters in order to have some functional
     * data base.
     * @throws BadCurrencyException if some of the Currencys created are not ok
     * @throws BadQuantityException  
     */
    public void initProductDB() throws BadCurrencyException, BadQuantityException {
        UPC upc1 = new UPC("123323");
        UPC upc2 = new UPC("12345");
        UPC upc3 = new UPC("1234");
        UPC upc4 = new UPC("1267223");
        UPC upc5 = new UPC("1111763");
        
        Currency c1 = new Currency("EUR");        
        Currency c2 = new Currency("USD");        
        Currency c3 = new Currency("PLN");    
        
        Money m1 = new Money(new BigDecimal(4),c1);
        Money m2 = new Money(new BigDecimal(8),c2);
        Money m3 = new Money(new BigDecimal(2),c3);
        
        this.addProduct(upc1, m1);
        this.addProduct(upc2, m2);
        this.addProduct(upc3, m3);        
        this.addProduct(upc4, m2);
        this.addProduct(upc5, m3);
    }

}
