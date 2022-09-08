package ift3911_tp3.Methodes;

import ift3911_tp3.Destinations.Destination;

import java.time.LocalDateTime;
import java.util.List;

public class EtatItineraire implements State{
    private LocalDateTime dateDepart;
    private LocalDateTime dateArrivee;
    private List<Destination> destinations;


    public EtatItineraire(
            LocalDateTime dateDepart,
            LocalDateTime dateArrivee,
            List<Destination> destinations) {


        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.destinations = destinations;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public LocalDateTime getDateArrivee() {
        return dateArrivee;
    }

    public LocalDateTime getDateDepart() {
        return dateDepart;
    }

    public void setDateArrivee(LocalDateTime dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public void setDateDepart(LocalDateTime dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }
}
