package ift3911_tp3.Methodes;

import ift3911_tp3.Destinations.Destination;
import ift3911_tp3.Place.SectionVolTrain;

import java.time.LocalDateTime;
import java.util.List;

public class EtatVol implements State{

    private LocalDateTime dateDepart;
    private LocalDateTime dateArrivee;
    private List<Destination> destinations;
    private List<SectionVolTrain> sections;

    public EtatVol(
            LocalDateTime dateDepart,
            LocalDateTime dateArrivee,
            List<Destination> destinations,
            List<SectionVolTrain> sections) {

        this.dateDepart = dateDepart;
        this.dateArrivee = dateArrivee;
        this.destinations = destinations;

        this.sections = sections;


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

    public List<SectionVolTrain> getSections() {
        return sections;
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

    public void setSections(List<SectionVolTrain> sections) {
        this.sections = sections;
    }

}
