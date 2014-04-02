/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *  Is thrown when the Curreny choosen is not valid.
 * @author carlos
 */
class BadCurrencyException extends Exception {

    public BadCurrencyException() {
        System.err.println("The Currency choosen is not valid");
    }
    
}
