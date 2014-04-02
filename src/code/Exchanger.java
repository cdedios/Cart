/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *
 * @author carlos
 */
public interface Exchanger {
    /**
     *
     * @param from
     * @param to
     * @param rate
     */ 
    public void setRate(Currency from, Currency to, double rate);
    /**
     *
     * @param from
     * @param to
     * @return
     * @throws BadCurrencyException
     * @throws BadQuantityException  
     */
    public Money convert(Money from, Currency to) throws BadCurrencyException,BadQuantityException;
}
