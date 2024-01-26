package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;


import utilidades.LevantarDrives;
import utilidades.MetodosGenericos;

public class Hook {
	
	LevantarDrives levantarDrivers;
	MetodosGenericos metodosGenericos;
	
	
	
	
	public Hook(LevantarDrives levantaDriver, MetodosGenericos metodosGenericos) {
		super();
		this.levantarDrivers=levantaDriver;
		this.metodosGenericos=metodosGenericos;
		
	}

	@Before
	public void iniciarTests() {
		System.out.println("************************************INICIO TEST************************************");		
	}
	
	@After
	public void FinalizarTests() {
		try {
			metodosGenericos.cerrarChromeDriver();
		}catch(Exception e) {
			System.out.println("Se presento error cerrando chromeDriver");
		}
		System.out.println("************************************Fin TEST************************************");
	}
}
