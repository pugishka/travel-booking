package ift3911_tp3.Methodes;

import ift3911_tp3.Destinations.Destination;

import java.time.LocalDateTime;
import java.util.List;

public class EtatTrajet implements State{
    private LocalDateTime dateDepart;
    private LocalDateTime dateArrivee;
    private List<Destination> destinations;

    public EtatTrajet(
            LocalDateTime dateDepart,
            LocalDateTime dateArrivee,
            List<Destination> destinations) {
        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.destinations = destinations;
    }

    public LocalDateTime getDateDepart() {
        return dateDepart;
    }

    public LocalDateTime getDateArrivee() {
        return dateArrivee;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public void setDateDepart(LocalDateTime dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setDateArrivee(LocalDateTime dateArrivee) {
        this.dateArrivee = dateArrivee;
    }
}

