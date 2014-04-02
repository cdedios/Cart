/*
 * Project 2: Unitary Testing
 * Name: Carlos de Dios Felis
 * Date: 11/01/2013
 */
package code;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Represents money, composed by a value and his currency.
 * @author carlos
 */
public class Money {
    BigDecimal value;
    Currency currency;
    
    /**
     *  Initialize the money with the given parameters.
     * @param value a BigDecimal ofthe value 
     * @param currency the Currency of the Money
     * @throws BadQuantityException  
     */
    public Money(BigDecimal value, Currency currency) throws BadQuantityException{
        if (value.compareTo(new BigDecimal(BigInteger.ZERO)) <0){
            throw new BadQuantityException();
        }
        this.value = value;
        this.currency = currency;
    }
    
    /**
     *  Gives the value of the Money.
     * @return the value of the Money.
     */
    public BigDecimal getValue(){
        return value;
    }
    /**
     *  Gives the Currency of the Money.
     * @return the currency of the Money
     */
    public Currency getCurrency(){
        return currency;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() != getClass())
            return false;
        Money m = (Money) obj;
        
        return this.currency.equals(m.currency)
                && this.value.stripTrailingZeros().equals(m.value.stripTrailingZeros());
    }
}
