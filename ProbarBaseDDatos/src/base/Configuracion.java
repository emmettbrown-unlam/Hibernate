package base;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Configuracion {
	private SessionFactory factory;
	
	
	public Configuracion() {
		Configuration cfg =new Configuration();
		cfg.configure("hibernate.cfg.xml");
		factory=cfg.buildSessionFactory();
		
		
	}

	public SessionFactory getFactory() {
		return factory;
	}

	
		
}
