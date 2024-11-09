package os.sa.pituusvertailija;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import os.sa.pituusvertailija.web.VertController;

@SpringBootTest
class PituusvertailijaApplicationTests {

	@Autowired
	private VertController controller;

		@Test
		public void contextLoads() throws Exception {
			assertThat(controller).isNotNull();
		}

}
