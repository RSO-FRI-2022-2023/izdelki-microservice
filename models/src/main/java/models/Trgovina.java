package models;


import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "trgovina")
@NamedQueries(value =
        {
                //vrni vse trgovine
                @NamedQuery(name = "Trgovina.getAll",
                        query = "SELECT t FROM Trgovina t"),
                //vrni trgovino - id
                @NamedQuery(name = "Trgovina.getById",
                        query = "SELECT t FROM Trgovina t WHERE t.id = :idTrgovine"),
                //vrni trgovino- ime
                @NamedQuery(name = "Trgovina.getByIme",
                        query = "SELECT t FROM Trgovina t WHERE t.ime = :ime"),

        })
public class Trgovina implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trgovina_id")

    private Integer id;
    private String ime;
    private String lokacija;


    @JsonbTransient
    @OneToMany(mappedBy = "trgovina", cascade = CascadeType.ALL)
    private List<Cena> cene;

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

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

}
