/*
 * Project 2: Unitary Testing
 * Name: Carlos de Dios Felis
 * Date: 11/01/2013
 */
package code;

import java.util.Arrays;
import java.util.List;



/**
 *  Represents the currency of the money.
 *  Contains a static list of the valid Currency names.
 * @author carlos
 */
class Currency {
    private static List<String> validCurrency = Arrays.asList("EUR","USD","PLN","BGP","YEN");
    String abbreviation;
    /**
    *   Initialize the string abreviation with the given string.
    * @param str choosen string
    * @throws BadCurrencyException if the given string is not predefined on the
    * internal static list of valid abreviations
    */
    Currency(String str) throws BadCurrencyException{
        if (!validCurrency.contains(str)) {
            throw new BadCurrencyException();
        }
        this.abbreviation = str;
    }
    
    public String getAbbreviation(){
        return abbreviation;
    }
    @Override
    public boolean equals(Object obj){
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() != getClass())
            return false;
        Currency n = (Currency) obj;
        return this.abbreviation.contentEquals(n.abbreviation);
    }

    
    @Override    
    public int hashCode(){
        return this.abbreviation.hashCode();
    }   
}
