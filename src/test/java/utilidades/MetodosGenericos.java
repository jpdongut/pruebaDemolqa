package utilidades;

import static org.junit.Assert.fail;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageobjects.DemolqaPageObjects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsString;

public class MetodosGenericos {

	LevantarDrives levantarDrivers;

	public MetodosGenericos(LevantarDrives levantarDrivers) {
		super();
		this.levantarDrivers = levantarDrivers;

	}

	public void esperarMilisegundos(int miliSegundos) {

		try {
			Thread.sleep(miliSegundos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void iniciarWebDemolqa() {
		try {
			levantarDrivers.abrirPaginaDemolqa();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cerrarChromeDriver() {
		try {
			levantarDrivers.chromeDriver.quit();
			Process process = Runtime.getRuntime().exec("tasklist");
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			String driver = "chromedriver.exe";
			while ((line = reader.readLine()) != null) {
				if (line.toLowerCase().contains(driver)) {
					Runtime.getRuntime().exec("taskkill /F /IM " + driver);
					System.out.println("Cerré un proceso chrome: " + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		esperarMilisegundos(2000);
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) levantarDrivers.chromeDriver;
		js.executeScript("window.scrollBy(0, 500)");
	}

	public void clicElemento(String locatorType, String locator) {
		levantarDrivers.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			WebElement element = levantarDrivers.chromeDriver.findElement(by);
			element.click();
			System.out.println("Se realizó click en: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
			fail();
		}
	}

	public String obtenertexto(String locatorType, String locator) {
		levantarDrivers.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String text = "";
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			WebElement element = levantarDrivers.chromeDriver.findElement(by);
			text = element.getText();
			System.out.println("Se obtiene el texto del localizador: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
			fail();
		}
		return text;
	}
	
	public String obtenertextoValue(String locatorType, String locator) {
		levantarDrivers.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String text = "";
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			WebElement element = levantarDrivers.chromeDriver.findElement(by);
			text = element.getAttribute("value");
			System.out.println("Se obtiene el texto del localizador: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
			fail();
		}
		return text;
	}

	public void escribirEnCampo(String locatorType, String locator, String text) {
		levantarDrivers.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			WebElement element = levantarDrivers.chromeDriver.findElement(by);
			element.sendKeys(text);
			System.out.println("Se ingreso el texto: " + text + " en el elemento: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
			fail();
		}
	}

	public void cambiarDimensionesNavegador() {
		levantarDrivers.chromeDriver.manage().window().setSize(new Dimension(700, 1200));
	}

	public void validarIgualdadTextos(String textoCapturado, String textoAIgualar) {
		assertThat(textoCapturado, is(equalTo(textoAIgualar)));
	}
	
	public void validarIgualdadNumerosEnteros(int numeroCapturado, int numeroAIgualar) {
		assertThat(numeroCapturado, is(equalTo(numeroAIgualar)));
	}

	public void validarContenerFragmentoTexto(String textoCapturado, String textoAIgualar) {
		assertThat(textoCapturado, containsString(textoAIgualar));
	}

	public void validarEstadoTrueElemento(boolean estado) {
		assertThat(estado, is(equalTo(true)));
	}

	public void cambiarDePestaña(int indice) {
		List<String> ventanasList = new ArrayList<>(levantarDrivers.chromeDriver.getWindowHandles());
		if (indice >= 0 && indice < ventanasList.size()) {
			levantarDrivers.chromeDriver.switchTo().window(ventanasList.get(indice));
		} else {
			System.out.println("El índice proporcionado está fuera del rango de ventanas.");
		}
	}

	public void cerrarPestañaActual() {
		levantarDrivers.chromeDriver.close();
	}

	public boolean validarVisibilidadElemento(String locatorType, String locator) {
		levantarDrivers.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean check = false;
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}

		try {
			WebElement element = levantarDrivers.chromeDriver.findElement(by);
			check = element.isDisplayed();
			System.out.println("Se realizó click en: " + locator);
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
			fail();
		}

		return check;
	}

	public String obtenerTextoEnOrdenAlfabetico(String locatorType, String locator) {
		levantarDrivers.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String primerTextoAlfabetico = "";
		boolean check = false;
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			WebElement contenedor = levantarDrivers.chromeDriver.findElement(by);

			// Obtiene todas las etiquetas <p> dentro del contenedor
			List<WebElement> etiquetasParrafo = contenedor.findElements(By.tagName("p"));

			// Ordena las etiquetas por su texto en orden alfabético
			List<WebElement> etiquetasOrdenadas = etiquetasParrafo.stream()
					.sorted((e1, e2) -> e1.getText().compareToIgnoreCase(e2.getText())).collect(Collectors.toList());

			// Obtiene el texto del primer párrafo después de ordenarlo

			if (!etiquetasOrdenadas.isEmpty()) {
				primerTextoAlfabetico = etiquetasOrdenadas.get(0).getText();
			}
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
			fail();
		}
		return primerTextoAlfabetico;
	}

	public void hacerClicEnLink(String texto) {
		WebElement elemento = null;

		switch (texto.toLowerCase()) {
		case "home":
			elemento = levantarDrivers.chromeDriver.findElement(By.xpath(DemolqaPageObjects.LINK_HOME));
			elemento.click();
			break;
		case "homeht8z9":
			elemento = levantarDrivers.chromeDriver.findElement(By.xpath(DemolqaPageObjects.LINK_HOMEHT8Z9));
			elemento.click();
			break;
		case "created":
			elemento = levantarDrivers.chromeDriver.findElement(By.xpath(DemolqaPageObjects.LINK_CREATED));
			elemento.click();
			break;
		case "no content":
			elemento = levantarDrivers.chromeDriver.findElement(By.xpath(DemolqaPageObjects.LINK_NO_CONTENT));
			elemento.click();
			break;
		case "moved":
			elemento = levantarDrivers.chromeDriver.findElement(By.xpath(DemolqaPageObjects.LINK_MOVED));
			elemento.click();
			break;
		case "bad request":
			elemento = levantarDrivers.chromeDriver.findElement(By.xpath(DemolqaPageObjects.LINK_BAD_REQUEST));
			elemento.click();
			break;
		case "unauthorized":
			elemento = levantarDrivers.chromeDriver.findElement(By.xpath(DemolqaPageObjects.LINK_UNAUTHORIZED));
			elemento.click();
			break;
		case "forbidden":
			elemento = levantarDrivers.chromeDriver.findElement(By.xpath(DemolqaPageObjects.LINK_FORBIDDEN));
			elemento.click();
			break;
		case "not found":
			elemento = levantarDrivers.chromeDriver.findElement(By.xpath(DemolqaPageObjects.LINK_NOT_FOUND));
			elemento.click();
			break;
		default:
			System.out.println("Texto no reconocido para hacer clic en el enlace.");
		}
	}

	public void arrastrarSlider(String locatorType, String locator, int xOffset, int yOffset) {
		levantarDrivers.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
			WebElement slider = levantarDrivers.chromeDriver.findElement(by);

			// Crea una instancia de la clase Actions
			Actions actions = new Actions(levantarDrivers.chromeDriver);

			// Utiliza dragAndDropBy para arrastrar el slider a la posición deseada
			actions.dragAndDropBy(slider, -2, yOffset).build().perform();
		} catch (Exception e) {
			System.out.println("No se pudo interactuar con el elemento: " + locator);
			fail();
		}
	}
	
	public void deslizarSlider(String locatorType, String locator, int rango) {
		levantarDrivers.chromeDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		By by = null;
		switch (locatorType) {
		case "name":
			by = By.name(locator);
			break;
		case "id":
			by = By.id(locator);
			break;
		case "xpath":
			by = By.xpath(locator);
			break;
		default:
			throw new IllegalArgumentException("Tipo de localizador no válido: " + locatorType);
		}
		try {
        WebElement slider = levantarDrivers.chromeDriver.findElement(by);

        // Usa JavaScriptExecutor para establecer el valor del atributo 'value' del slider
        JavascriptExecutor js = (JavascriptExecutor) levantarDrivers.chromeDriver;
        String script = "arguments[0].value = arguments[1]";
        js.executeScript(script, slider, rango);
        
		}catch(Exception e){
			System.out.println("No se pudo interactuar con el elemento: " + locator);
			fail();
		}
    }

}
