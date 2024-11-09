package os.sa.pituusvertailija;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import os.sa.pituusvertailija.domain.KategoriaRepository;
import os.sa.pituusvertailija.domain.Kategoria;

@DataJpaTest
public class KategoriaRepositoryTest {

    @Autowired
    private KategoriaRepository kategoriaRepository;

    @Test
    public void findByNameShouldReturnKategoria() {
        assertThat(kategoriaRepository.findByName("Rakennukset")).isNotNull();
    }

    @Test
    public void creteNewKategoria() {
        assertThat(kategoriaRepository.save(new Kategoria("Testi")).getKategoriaid()).isNotNull();
    }

    @Test
    public void deleteKategoria() {
        Kategoria kategoria = kategoriaRepository.findByName("Rakennukset");
        kategoriaRepository.delete(kategoria);
        assertThat(kategoriaRepository.findByName("Rakennukset")).isNull();
    }
}
