

package model;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Betaling {
    private Order order; 
    private String betalingsform; 
    
    public Betaling(Order order, boolean kort){
        this.order = order; 
        betalingsForm(kort); 
    }
    
    public String betalingsForm(boolean kort){
        betalingsform = ""; 
        if(kort == true){
            return betalingsform += "kort"; 
        } else return betalingsform += "kontant"; 
    }
    
     public void lavKvittering(){
        BufferedWriter bw = null;
        try { 
            File kvittering = new File("Kvittering.txt");
            bw = new BufferedWriter(new FileWriter(kvittering)); 
            bw.write(toString()); 
            bw.newLine(); 
            
        } catch (IOException ex) {
                System.out.println("FIL IKKE FUNDET");
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                System.out.println("BUFFEREDWRITER IKKE LUKKET");
            }
        }
    }
    
    
   @Override 
    public String toString(){
        return order.toString() + " Betalingsform: " + betalingsform; 
    }
    
}
