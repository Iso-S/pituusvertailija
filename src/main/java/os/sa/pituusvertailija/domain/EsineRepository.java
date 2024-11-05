package os.sa.pituusvertailija.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EsineRepository extends CrudRepository<Esine, Long> {
    Esine findByNimi(String nimi);
    List<Esine> findByEsineid(Long esineid);
}