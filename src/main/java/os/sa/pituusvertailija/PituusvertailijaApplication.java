package os.sa.pituusvertailija;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import os.sa.pituusvertailija.domain.Esine;
import os.sa.pituusvertailija.domain.EsineRepository;
import os.sa.pituusvertailija.domain.Kategoria;
import os.sa.pituusvertailija.domain.KategoriaRepository;
import os.sa.pituusvertailija.domain.Users;
import os.sa.pituusvertailija.domain.UsersRepository;

@SpringBootApplication
public class PituusvertailijaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PituusvertailijaApplication.class, args);
	} 

	@Bean
	public CommandLineRunner demo(EsineRepository erepository, KategoriaRepository krepository, UsersRepository urepository) {
		return (args) -> {

			Kategoria kategoria1 = new Kategoria("Vaatetus");
			krepository.save(kategoria1);
			Kategoria kategoria2 = new Kategoria("Rakennukset");
			krepository.save(kategoria2);

			erepository.save(new Esine("T-paita", 70.0 , 20.0, kategoria1));
			erepository.save(new Esine("Farkut", 100.0, 50.0, kategoria1));
			erepository.save(new Esine("Talo", 5000.0, 10000.0, kategoria2));

			Users user1 = new Users ("user", "$2a$10$nAckPIKVHRpUm8Ilk6JkQe7/Rk6UddaGzYKDN.h7z.45T2BIFjpju", "USER", "user@gotmail.net");
			Users user2 = new Users ("Ossi", "$2a$10$nAckPIKVHRpUm8Ilk6JkQe7/Rk6UddaGzYKDN.h7z.45T2BIFjpju", "ADMIN", "test@email.com");
			
			urepository.save(user1);
			urepository.save(user2);
		};
	}

}