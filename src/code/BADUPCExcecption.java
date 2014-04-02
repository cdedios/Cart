/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 *  Is thrown when UPC code is not on the data base previously.
 * @author carlos
 */
class BADUPCExcecption extends Exception {
    
    public BADUPCExcecption(){
        System.err.printf("The given UPC code is not on the data base \n");
    }
}
