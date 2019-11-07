package model;

/**
 * @author Josef, Thor, Hallur og Frederik 
 */

import java.util.ArrayList;


public class OrdreListe {

    private ArrayList<Order> ordreliste = new ArrayList<Order>();

    public OrdreListe() {

    }

    //Kan tilføje ordrer til ordrelisten
    public void tilføjOrdrer(Order order) {
        ordreliste.add(order);
    }

    //Kan fjerne ordre når ordren er leveret 
    public void fjernOrdrer(Order order) {
        ordreliste.remove(order);
    }
    //returnere ordrelisten 
    public ArrayList<Order> getOrderListe() {
        return ordreliste;
    }

    //Sorter ordrer i listen efter afhentningstid med det kortetste som første. 
    //Listen bliver sortet ved hjælp af selection sort
    public void sorterListeEfterAfhentning() {
        int n = ordreliste.size();
        for (int i = 0; i < n-1; i++) {
            int mindste = i;
            for (int j = i ++; j < n; j++) {
                if (ordreliste.get(j).getTidTilAfhentning() < ordreliste.get(mindste).getTidTilAfhentning()) {
                    mindste = j;
                }
            }
            //En swop-hjælpemetode kunne have gjort dette mere letlæseligt. 
            Order temp = ordreliste.get(mindste);
            Order hentesFørst = ordreliste.get(i);
            ordreliste.set(mindste, hentesFørst);
            ordreliste.set(i, temp);
        }
    }
    
    public Pizza findMestPopulærIAlleOrdre() {
        ArrayList<Pizza> mestPopulærePizzaListe = new ArrayList<Pizza>();
        Pizza mestPopulærIOrdre = null, mestPopulærPizzaIAlt = null;
        int maxTæller = 0, tæller = 0;
        for (Order order : ordreliste) {
            mestPopulærIOrdre = order.findMestPopulær();
            mestPopulærePizzaListe.add(mestPopulærIOrdre);
            int n = mestPopulærePizzaListe.size();
            for (int i = 0; i < n-1; i++) {
                tæller = 1;
                for (int j = i++; i < n-1; j++) {
                    if (mestPopulærePizzaListe.get(i).getPizzaNavn().equals(mestPopulærePizzaListe.get(j).getPizzaNavn())) {
                        tæller++;
                    }
                }
                //Tager og sammenligner tæller og maxtæller. Hvis tæller er større end maxtæller er størst byttes der 
                //rundt på tæller og maxtæller og finder pizzaen i pladsen I i arraylisten. 
                if (tæller > maxTæller) {
                    maxTæller = tæller;
                    mestPopulærPizzaIAlt = mestPopulærePizzaListe.get(i);
                }
            }
        }
        return mestPopulærPizzaIAlt;
    }

    @Override
    public String toString() {
        String ordreListe = "";

        for (Order order1 : ordreliste) {
            ordreListe += order1.toString();
        }

        return ordreListe;
    }

}
