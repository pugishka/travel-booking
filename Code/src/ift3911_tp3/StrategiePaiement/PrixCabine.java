package ift3911_tp3.StrategiePaiement;

import ift3911_tp3.Place.Cabine;
import ift3911_tp3.Place.Place;

public class PrixCabine implements PriceCalculator{
    private float priceD = 1.00f;
    private float priceF = 0.90f;
    private float priceI = 0.50f;
    private float priceO = 0.75f;
    private float priceS = 0.90f;
    @Override
    public void calculatePrice(Place place) {
        Cabine cabine = (Cabine) place;

        switch (cabine.getSection()) {
            case D:
                cabine.setPrix(cabine.getCompagnie().getSeatPrice() * priceD);
                break;
            case F:
                cabine.setPrix(cabine.getCompagnie().getSeatPrice() * priceF);
                break;
            case I:
                cabine.setPrix(cabine.getCompagnie().getSeatPrice() * priceI);
                break;
            case O:
                cabine.setPrix(cabine.getCompagnie().getSeatPrice() * priceO);
                break;
            case S:
                cabine.setPrix(cabine.getCompagnie().getSeatPrice() * priceS);
                break;
        }
    }
}
