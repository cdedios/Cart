/*
 * Project 2: Unitary Testing
 * Name: Carlos de Dios Felis
 * Date: 11/01/2013
 */
package code;

/**
 * Interface of a simple Data Base.
 * @author carlos
 */
public interface DataBase {
    /**
     * Add a product to the database with the given parameters.
     * @param upc Product code.
     * @param money Price of the Product.
     */
    public void addProduct(UPC upc,Money money);
    /**
     *  Gives the price of the choosen product.
     * @param upc Product code.
     * @return  a new Money object with the price of the upc product.
     * @throws BADUPCExcecption  if the upc is not on the data base.
     */
    public Money getPrice(UPC upc)throws BADUPCExcecption;
    /**
     *  Check if the upc given is already on the database.
     * @param upc product code.
     * @return boolean True if it's in, false if not.
     */
    public boolean available(UPC upc);
}
