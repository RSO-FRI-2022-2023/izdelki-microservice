package models;

import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "izdelek")
@NamedQueries(value =
        {
                //vrni vse izdelke
                @NamedQuery(name = "Izdelek.getAll",
                        query = "SELECT i FROM Izdelek i"),
                //vrni izdelek - id
                @NamedQuery(name = "Izdelek.getById",
                        query = "SELECT i FROM Izdelek i WHERE i.id = :idIzdelka"),
                //vrni izdelek - kategorija
                @NamedQuery(name = "Izdelek.getByCategory",
                        query = "SELECT i FROM Izdelek i WHERE i.kategorija = :kategorija"),
                //vrni izdelek - naziv
                @NamedQuery(name = "Izdelek.getByDescription",
                        query = "SELECT i FROM Izdelek i WHERE i.naziv = :naziv"),
        })

public class Izdelek implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "izdelek_id")
    private Integer id;

    private String naziv;
    private String kategorija;

    @JsonbTransient
    @OneToMany(mappedBy = "izdelek", cascade = CascadeType.ALL)
    private List<Cena> cene;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }
}
