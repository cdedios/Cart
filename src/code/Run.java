/*
 * Project 2: Unitary Testing
 * Name: Carlos de Dios Felis
 * Date: 11/01/2013
 */
package code;

import java.math.BigDecimal;

/**
 *  Main class
 * @author carlos
 */
public class Run {

    /**
     *  Main class just to check "everything" is working.
     * @param args
     * @throws BadQuantityException
     */
    public static void main(String args[]) throws BadQuantityException {
        try {
            Currency curr = new Currency("EUR");
            Currency curr2 = new Currency("USD");
            UPC upc1 = new UPC("12345");
            UPC upc2 = new UPC("1234");
            ProductDB pdb = new ProductDB();
            CurrencyExchanger ce = new CurrencyExchanger();
            
            pdb.addProduct(upc1, new Money(new BigDecimal(6), curr));
            pdb.addProduct(upc2, new Money(new BigDecimal(7), curr2));
            Cart c1 = new Cart(curr, pdb, ce);
            
            c1.addItem(upc1, 4);
            c1.addItem(upc2, 5);
            Money mTotal = c1.getTotal();
            System.out.printf("Final amount: "+mTotal.value.toString()+"\n");
        }
        catch (BadCurrencyException e) {
            System.out.printf("here we go1");
            e.printStackTrace();
        }
        catch (BADUPCExcecption e){
            e.printStackTrace();
            System.out.printf("here we go2");
        }
    }
}
