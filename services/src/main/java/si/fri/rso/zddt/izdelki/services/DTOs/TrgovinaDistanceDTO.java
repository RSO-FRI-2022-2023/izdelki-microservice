package si.fri.rso.zddt.izdelki.services.DTOs;

import si.fri.rso.zddt.common.models.Trgovina;

public class TrgovinaDistanceDTO {
    private double distance;
    private Trgovina trgovina;

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Trgovina getTrgovina() {
        return trgovina;
    }

    public void setTrgovina(Trgovina trgovina) {
        this.trgovina = trgovina;
    }
}
