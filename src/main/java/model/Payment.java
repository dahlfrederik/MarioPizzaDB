

package model;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class Payment {
    private Order order; 
    private String paymentType; 
    
    public Payment(Order order, boolean card){
        this.order = order; 
        betalingsForm(card); 
    }
    
    public String betalingsForm(boolean card){
        paymentType = ""; 
        if(card == true){
            return paymentType += "kort"; 
        } else return paymentType += "kontant"; 
    }
    
     public void createReceipt(){
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
        return order.toString() + " Betalingsform: " + paymentType; 
    }
    
}
