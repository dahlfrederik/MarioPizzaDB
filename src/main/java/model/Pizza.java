package model;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */

public class Pizza {
    private int pizzaNummer; 
    private String pizzaNavn; 
    private int pizzaPris; 
 

    public Pizza(int pizzaNummer, String pizzaNavn, int pizzaPris) {
        this.pizzaNummer = pizzaNummer;
        this.pizzaNavn = pizzaNavn;
        this.pizzaPris = pizzaPris;
        
    }
    
    public int getPizzaNummer() {
        return pizzaNummer;
    }

    public void setPizzaNummer(int pizzaNummer) {
        this.pizzaNummer = pizzaNummer;
    }

    public String getPizzaNavn() {
        return pizzaNavn;
    }

    public void setPizzaNavn(String pizzaNavn) {
        this.pizzaNavn = pizzaNavn;
    }

    public int getPizzaPris() {
        return pizzaPris;
    }

    public void setPizzaPris(int pizzaPris) {
        this.pizzaPris = pizzaPris;
    }
    
    @Override
    public String toString() {
        return "Nr: "+ pizzaNummer + ", pizza med " + pizzaNavn + ", pris: " + pizzaPris  + " kr" + "\n"; 
    }
}
