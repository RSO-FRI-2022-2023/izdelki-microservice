package si.fri.rso.zddt.izdelki.services.DTOs;

public class TrgovinaDTO {
    private Integer id;
    private String ime;
    private String lokacija;
    private double latitude;
    private double longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getLokacija() {
        return lokacija;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }
}
