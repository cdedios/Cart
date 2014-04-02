/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

/**
 * Represents the product code, in this case as a String.
 * @author carlos
 */
public class UPC {
    private String code;
    
    /**
     *  Constructor with the given String.
     * @param code String code of the product
     */
    public UPC(String code){
        this.code = code;
    }
    /**
     *  Gets the code of the UPC.
     * @return the code of the UPC type:String 
     */
    public String getCode(){
        return code;
    }

    /**
     *
     * @return
     */
    @Override    
    public int hashCode(){
        return code.hashCode();
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
        UPC n = (UPC) obj;
        return this.code.equals(n.getCode());
    }
    
}
