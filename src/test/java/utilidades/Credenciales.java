package utilidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Credenciales extends Properties {
	
	private static final long serialVersionUID = 1L;
	
	
	
	public static Properties propertiesWebs() {
		Properties prop = new Properties();
		InputStream is = null;

		try {
			is = new FileInputStream(System.getProperty("user.dir") + "/urlPaginas.properties");
			
			prop.load(is);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return prop;
	}


}
