package Reto4Ciclo4;

import Reto4Ciclo4.interfaces.InterfaceClothe;
import Reto4Ciclo4.interfaces.InterfaceOrder;
import Reto4Ciclo4.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Component
@SpringBootApplication
public class Reto4Ciclo4Application implements CommandLineRunner {

	@Autowired
	private InterfaceUser interfaceUser;
	@Autowired
	private InterfaceClothe interfaceClothe;
	@Autowired
	private InterfaceOrder interfaceOrder;

	public static void main(String[] args) {
		SpringApplication.run(Reto4Ciclo4Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		interfaceClothe.deleteAll();
		interfaceUser.deleteAll();
		interfaceOrder.deleteAll();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	}
}
