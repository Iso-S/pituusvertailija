package os.sa.pituusvertailija.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface KategoriaRepository extends CrudRepository<Kategoria, Long> {
    Kategoria findByName(String name);
    List<Kategoria> findByKategoriaid(Long kategoriaid);
}
