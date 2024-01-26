package mainrunner;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import utilidades.BeforeSuite;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "definitions", 
		tags = "@Prueba3", snippets = SnippetType.CAMELCASE) 

public class MainRunner {
	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
		
	}
}
