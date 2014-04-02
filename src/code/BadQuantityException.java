/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *  Is thrown when you try to add 0 or negative items to the Cart
 * @author carlos
 */
class BadQuantityException extends Exception {

    public BadQuantityException() {
        System.err.println("The Quantitiy choosen must be higher than 0");
    }
    
}
