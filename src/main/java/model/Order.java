package model;

/**
 * @author Frederik, Hallur, Josef og Thor
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Order {

    private Kunde kunde;
    private ArrayList<Pizza> orderliste = new ArrayList<Pizza>();
    private int tidTilAfhentning, id, nr, tele;

    public Order(Kunde kunde, int tidTilAfhentning) {
        this.kunde = kunde;
        this.tidTilAfhentning = tidTilAfhentning;
    }

    public Order(int id, int nr, int tele) {
        this.id = id; 
        this.nr =nr; 
        this.tele = tele; 
    }

    public double getTotalPris() {
        double totalPris = 0;
        for (Pizza pizza : orderliste) {
            totalPris += pizza.getPizzaPris();
        }
        return totalPris;
    }

    public int getTidTilAfhentning() {
        return tidTilAfhentning;
    }

    public void addPizzaTilOrdrer(Pizza pizza) {
        orderliste.add(pizza);
    }

    public void removePizzaTilOrdrer(Pizza pizza) {
        orderliste.remove(pizza);
    }

    public ArrayList<Pizza> getOrderListe() {
        return orderliste;
    }

    public void skrivOrdrer() {
        BufferedWriter bw = null;
        try {
            File pizzaliste = new File("Bestillingsliste.txt");
            bw = new BufferedWriter(new FileWriter(pizzaliste, true));
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
    
    public Pizza findMestPopulær(){
        Pizza mestPopulærPizza = null;  
        int højesteTæller = 0, tæller = 0;  
        int n = orderliste.size(); 
        for (int i = 0; i < n-1; i++) {
            tæller = 1; 
            for(int j = i++; j < n; j++){
            if(orderliste.get(i).getPizzaNavn().equals(orderliste.get(j).getPizzaNavn())){
                tæller++; 
            }
          }
            if(tæller > højesteTæller){
                højesteTæller = tæller; 
                mestPopulærPizza = orderliste.get(i); 
            }
        }
        return mestPopulærPizza; 
    }

    @Override
    public String toString() {
        String totalMenu = "";
        totalMenu += "KVITTERING" + "\n";
        totalMenu += "*****************" + "\n";
        //totalMenu += "Kundens navn: " + kunde.getNavn() + "\n";
        //totalMenu += "Kundens nummer: " + kunde.getNummer() + "\n";
        //totalMenu += "Tid til afhenting: " + getTidTilAfhentning() + " min" + "\n";
        totalMenu += "OrdreID: " + id ; 

        for (Pizza total : orderliste) {
            totalMenu += " Pizza: " + total.getPizzaNavn() + ", pizzaens pris " + total.getPizzaPris() + "\n";
        }

        totalMenu += "\n Samlet pris: " + getTotalPris() + " kr" + "\n";
        return totalMenu;
    }

}
