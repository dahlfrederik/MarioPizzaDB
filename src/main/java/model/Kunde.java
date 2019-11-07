

package model;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */

public class Kunde {
    private String navn; 
    private int nummer; 
    
    public Kunde(String navn, int nummer){
        this.navn = navn; 
        this.nummer = nummer; 
    }

    public String getNavn() {
        return navn;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    @Override
    public String toString() {
        return "Kunde: \n  Navn:" + navn + ", Tlf nummer: " + nummer;
    }
    
}
