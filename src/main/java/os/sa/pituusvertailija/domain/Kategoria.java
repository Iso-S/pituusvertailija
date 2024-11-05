package os.sa.pituusvertailija.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Kategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kategoriaid;
    private String name;

    @JsonIgnoreProperties("kategoria")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoria")
    private List<Esine> esineet;

    public Kategoria() {
    }

    public Kategoria(String name) {
        super();
        this.name = name;
    }

    public Long getKategoriaid() {
        return kategoriaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Esine> getEsineet() {
        return esineet;
    }

    public void setEsineet(List<Esine> esineet) {
        this.esineet = esineet;
    }

    @Override
    public String toString() {
        return "Kategoria [kategoriaid=" + kategoriaid + ", name=" + name + "]";
    }
}
