package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import steps.DemolqaSteps;


public class DemolqaDefinitions {
	
	DemolqaSteps demolqaSteps;
	
	public DemolqaDefinitions(DemolqaSteps demolqaSteps) {
		super();
		this.demolqaSteps = demolqaSteps;		
	}
	
	@Given("^Abri el navegador para entrar a demolqa$")
	public void abriElNavegadorParaEntrarAEvalart() throws Exception {
		demolqaSteps.abrirWebDemolqa();
	}
	
	@When("^Ingreso a la seccion forms para ir a practice form$")
	public void ingresoALaSeccionFormsParaIrAPracticeForm() throws Exception {
		demolqaSteps.ingresarAOpcionPracticeForm();
	}

	@When("^Diligencio el formulario \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
	public void diligencioElFormulario(String nombre, String apellido, String correoElectronico, String numeroTelefono) throws Exception {
		demolqaSteps.llenarFormulario(nombre, apellido, correoElectronico,numeroTelefono);
	}
	
	@Then("^Cerrar pagina demolqa$")
	public void cerrar_pagina_demolqa() throws Exception {
		demolqaSteps.cerrarDemolqa();
	}
	
	@Then("^Validar Mensaje exitoso al llenar el formulario$")
	public void validarMensajeExitosoAlLlenarElFormulario() throws Exception {
		demolqaSteps.validarMensajeExitosoAlDiligenciarFormulario();
	}
	
	@When("^Ingreso a la seccion elements para ir a links$")
	public void ingresoALaSeccionElementsParaIrALinks() throws Exception {
		demolqaSteps.ingresarALaSeccionDeLinks();
	}

	@Then("^Seleccionar links y validar su contenido$")
	public void seleccionarLinksYValidarSuContenido() throws Exception {
		demolqaSteps.validarContenidoDeLosLinks();
	}
	
	@Then("^Validar el primer link en orden alfabetico y hacer clic$")
	public void validarElPrimerLinkEnOrdenAlfabeticoYHacerClic() throws Exception {
		demolqaSteps.clickearPrimerLinkDelOrdenAlfabetico();
	}
	
	@When("^Ingreso a la seccion widgets para ir a slider$")
	public void ingresoALaSeccionWidgetsParaIrASlider() throws Exception {
		demolqaSteps.ingresarALaSeccionDeSlider();
	}

	@Then("^Validar que el slider quede en la posicion indicada (\\d+)$")
	public void validarQueElSliderQuedeEnLaPosicionIndicada(int posicion) throws Exception {
		demolqaSteps.arrastrarElSliderAOtraPosicion(posicion);
	}






	


}
