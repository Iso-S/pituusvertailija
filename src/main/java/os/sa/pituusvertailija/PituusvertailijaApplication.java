package os.sa.pituusvertailija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import os.sa.pituusvertailija.domain.Esine;
import os.sa.pituusvertailija.domain.EsineRepository;
import os.sa.pituusvertailija.domain.Kategoria;
import os.sa.pituusvertailija.domain.KategoriaRepository;

@SpringBootApplication
public class PituusvertailijaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PituusvertailijaApplication.class, args);
	} 

	@Bean
	public CommandLineRunner demo(EsineRepository erepository, KategoriaRepository krepository) {
		return (args) -> {

			Kategoria kategoria1 = new Kategoria("Vaatetus");
			krepository.save(kategoria1);
			Kategoria kategoria2 = new Kategoria("Rakennukset");
			krepository.save(kategoria2);

			erepository.save(new Esine("T-paita", 70, 20, kategoria1));
			erepository.save(new Esine("Farkut", 100, 50, kategoria1));
			erepository.save(new Esine("Talo", 5000, 10000, kategoria2));

		};
	}

}