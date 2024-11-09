package os.sa.pituusvertailija;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

import os.sa.pituusvertailija.domain.EsineRepository;
import os.sa.pituusvertailija.domain.Esine;

@DataJpaTest
public class EsineRepositoryTest {

    @Autowired
    private EsineRepository esineRepository;

    @Test
    public void findByNimiShouldReturnEsine() {
        assertThat(esineRepository.findByNimi("Talo")).isNotNull();
    }

    @Test
    public void creteNewEsine() {
        assertThat(esineRepository.save(new Esine("Testi", 10.0, 10.0, null)).getEsineid()).isNotNull();
    }

    @Test
    public void deleteEsine() {
        Esine esine = esineRepository.findByNimi("Talo");
        esineRepository.delete(esine);
        assertThat(esineRepository.findByNimi("Talo")).isNull();
    }

}
