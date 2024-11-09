package os.sa.pituusvertailija.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Esine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long esineid;
    @NotNull
    private String nimi;
    @NotNull
    @Min(1)
    private Double korkeus;
    @NotNull
    @Min(1)
    private Double leveys;

    @JsonIgnoreProperties("esineet")
    @ManyToOne
    @JoinColumn(name = "kategoriaid")
    private Kategoria kategoria;

    public Esine() {
    }

    public Esine(String nimi, Double korkeus, Double leveys, Kategoria kategoria) {
        this.nimi = nimi;
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.kategoria = kategoria;
    }

    public Long getEsineid() {
        return esineid;
    }

    public void setEsineid(Long esineid) {
        this.esineid = esineid;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Double getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(Double korkeus) {
        this.korkeus = korkeus;
    }

    public Double getLeveys() {
        return leveys;
    }

    public void setLeveys(Double leveys) {
        this.leveys = leveys;
    }

    public Kategoria getKategoria() {
        return kategoria;
    }

    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return "Esine [esineid=" + esineid + ", nimi=" + nimi + ", korkeus=" + korkeus + ", leveys=" + leveys + "]";
    }

    

}
