package utilidades;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LevantarDrives {

	MetodosGenericos metodosGenericos;
	
	public WebDriver chromeDriver;
	private WebDriverWait wait;

	public void iniciarChromeDriver() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe" );
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();

	}
	
	public void abrirPaginaDemolqa() {
		iniciarChromeDriver();
		chromeDriver.get(Credenciales.propertiesWebs().getProperty("web.demolqa.url"));
		chromeDriver.manage().window().maximize();
		setWait(new WebDriverWait(chromeDriver, 60));
	}
	
	

	public WebDriverWait getWait() {
		return wait;
	}

	public void setWait(WebDriverWait wait) {
		this.wait = wait;
	}
	
	
}
