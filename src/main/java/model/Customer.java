

package model;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */

public class Customer {
    private String name; 
    private int tele; 
    
    public Customer(String name, int tele){
        this.name = name; 
        this.tele = tele; 
    }
    
    public Customer(){
        
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name){
        name = name; 
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "Kunde: \n  Navn:" + name; 
    }
    
}
