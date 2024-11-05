package os.sa.pituusvertailija.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Esine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long esineid;
    private String nimi;
    private int korkeus;
    private int leveys;

    @JsonIgnoreProperties("esineet")
    @ManyToOne
    @JoinColumn(name = "kategoriaid")
    private Kategoria kategoria;

    public Esine() {
    }

    public Esine(String nimi, int korkeus, int leveys, Kategoria kategoria) {
        this.nimi = nimi;
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.kategoria = kategoria;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public void setKorkeus(int korkeus) {
        this.korkeus = korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public void setLeveys(int leveys) {
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
