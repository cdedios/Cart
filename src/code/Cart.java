/*
 * Project 2: Unitary Testing
 * Name: Carlos de Dios Felis
 * Date: 11/01/2013
 */
package code;



import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author carlos
 */
public class Cart {
    
    Currency currency;
    HashMap<UPC, Integer> prodQuant;    
    DataBase products;
    Exchanger exchanger;
    
    /**
     *
     * @param currency
     * @param prodDB 
     * @param ce 
     */
    public Cart(Currency currency, DataBase prodDB, Exchanger ce) {
        this.currency = currency;
        prodQuant = new HashMap<UPC, Integer>();
        products =  prodDB;
        exchanger =  ce;
    }
    /**
     *
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    public void init() throws BadCurrencyException, BadQuantityException{
        products = new ProductDB();
        System.out.println("The Cart have been initialized");
    }
    /**
     *
     * @param currency
     */
    public void selectCurrency(Currency currency){
        System.out.println("The Currency of the Cart have changed from "+ this.currency.getAbbreviation() +" to --> "+currency.getAbbreviation());
        this.currency = currency;
    }
    
    /**
     *
     * @return
     * @throws BadCurrencyException
     * @throws BADUPCExcecption
     * @throws BadQuantityException  
     */
    public Money getTotal() throws BadCurrencyException, BADUPCExcecption, BadQuantityException{
        MultiCurrencyMoney total = new MultiCurrencyMoney();
        for (Map.Entry<UPC, Integer> entry : prodQuant.entrySet()) {
            UPC key = entry.getKey();
            int value = entry.getValue();
            for (int i = 0; i < value; i++){
                total.addMoney(products.getPrice(key));
            }
        }
        return total.getTotal(exchanger, currency);
    }

    void addItem(UPC upc, int quantity) throws BADUPCExcecption, BadQuantityException{
        if (!products.available(upc)){
            throw new BADUPCExcecption();
        }
        if (quantity <= 0){
            throw new BadQuantityException();
        }
        
        if(prodQuant.containsKey(upc)){
            prodQuant.put(upc, prodQuant.get(upc)+quantity);
        }
        else{
            prodQuant.put(upc, quantity);
        }        
    } 
}
