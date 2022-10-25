package si.fri.rso.zddt.izdelki.services.DTOs;


public class CenaDTO {
    private Integer id;
    private double cena;
    private int izdelek_id;
    private int trgovina_id;

    public int getIzdelek_id() {
        return izdelek_id;
    }

    public void setIzdelek_id(int izdelek_id) {
        this.izdelek_id = izdelek_id;
    }

    public int getTrgovina_id() {
        return trgovina_id;
    }

    public void setTrgovina_id(int trgovina_id) {
        this.trgovina_id = trgovina_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
