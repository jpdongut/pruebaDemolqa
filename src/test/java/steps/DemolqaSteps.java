package steps;

import pageobjects.DemolqaPageObjects;
import utilidades.MetodosGenericos;

public class DemolqaSteps {
	
	
	MetodosGenericos metodosGenericos;
	
	public DemolqaSteps(MetodosGenericos metodosGenericos) {
		super();
		this.metodosGenericos = metodosGenericos;
	}
	
	public void abrirWebDemolqa() {
		metodosGenericos.iniciarWebDemolqa();
	}
	
	public void cerrarDemolqa() {
		metodosGenericos.cerrarChromeDriver();
	}
	
	public void ingresarAOpcionPracticeForm() {
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.DIV_FORMS);
		metodosGenericos.esperarMilisegundos(2000);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.DIV_PRACTICE_FORM);
	}
	
	public void llenarFormulario(String nombre, String apellido, String correoElectronico, String numeroTelefono) {
		metodosGenericos.escribirEnCampo("xpath", DemolqaPageObjects.CAMPO_NOMBRE, nombre);
		metodosGenericos.escribirEnCampo("xpath", DemolqaPageObjects.CAMPO_APELLIDO, apellido);
		metodosGenericos.escribirEnCampo("xpath", DemolqaPageObjects.CAMPO_CORREO, correoElectronico);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.RADIO_GENERO_HOMBRE);
		metodosGenericos.escribirEnCampo("xpath", DemolqaPageObjects.CAMPO_NUMERO_CELULAR, numeroTelefono);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.CAMPO_FECHA);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LISTA_DESPLEGABLE_MES);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.OPCION_MES_SEPTIEMBRE);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LISTA_DESPLEGABLE_ANIO);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.OPCION_ANIO_2005);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.OPCION_DIA_UNO);
		metodosGenericos.cambiarDimensionesNavegador();
		for(int i=0; i<3; i++) {
			metodosGenericos.scrollDown();
		}
		
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.BOTON_ENVIAR_FORMULARIO);
	}
	
	public void validarMensajeExitosoAlDiligenciarFormulario() {
		String texto = metodosGenericos.obtenertexto("xpath", DemolqaPageObjects.MENSAJE_EXITOSO_FORMULARIO);
		metodosGenericos.validarIgualdadTextos(texto,"Thanks for submitting the form");
		
	}
	
	public void ingresarALaSeccionDeLinks() {
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.DIV_ELEMENTS);
		metodosGenericos.esperarMilisegundos(1000);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.DIV_LINKS);
		metodosGenericos.esperarMilisegundos(1000);
		
	}
	
	public void validarContenidoDeLosLinks() {
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LINK_HOME);
		metodosGenericos.cambiarDePestaña(1);
		boolean estadoUno = metodosGenericos.validarVisibilidadElemento("xpath", DemolqaPageObjects.IMAGEN_HOME);
		metodosGenericos.validarEstadoTrueElemento(estadoUno);
		metodosGenericos.cerrarPestañaActual();
		metodosGenericos.cambiarDePestaña(0);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LINK_HOMEHT8Z9);
		metodosGenericos.cambiarDePestaña(1);
		boolean estadoDos = metodosGenericos.validarVisibilidadElemento("xpath", DemolqaPageObjects.IMAGEN_HOME);
		metodosGenericos.validarEstadoTrueElemento(estadoDos);
		metodosGenericos.cerrarPestañaActual();
		metodosGenericos.cambiarDePestaña(0);
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LINK_CREATED);
		metodosGenericos.esperarMilisegundos(4000);
		metodosGenericos.scrollDown();
		metodosGenericos.esperarMilisegundos(2000);
		String textoCreated = metodosGenericos.obtenertexto("xpath", DemolqaPageObjects.CAMPO_VALIDACION_LINKS);
		metodosGenericos.validarContenerFragmentoTexto(textoCreated,"status text Created");
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LINK_NO_CONTENT);
		metodosGenericos.esperarMilisegundos(4000);
		String textoNoContent = metodosGenericos.obtenertexto("xpath", DemolqaPageObjects.CAMPO_VALIDACION_LINKS);
		metodosGenericos.validarContenerFragmentoTexto(textoNoContent,"status text No Content");
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LINK_MOVED);
		metodosGenericos.esperarMilisegundos(4000);
		String textoMoved = metodosGenericos.obtenertexto("xpath", DemolqaPageObjects.CAMPO_VALIDACION_LINKS);
		metodosGenericos.validarContenerFragmentoTexto(textoMoved,"status text Moved Permanently");
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LINK_BAD_REQUEST);
		metodosGenericos.esperarMilisegundos(4000);
		String textoBadRequest = metodosGenericos.obtenertexto("xpath", DemolqaPageObjects.CAMPO_VALIDACION_LINKS);
		metodosGenericos.validarContenerFragmentoTexto(textoBadRequest,"status text Bad Request");
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LINK_UNAUTHORIZED);
		metodosGenericos.esperarMilisegundos(4000);
		String textoUnauthorized = metodosGenericos.obtenertexto("xpath", DemolqaPageObjects.CAMPO_VALIDACION_LINKS);
		metodosGenericos.validarContenerFragmentoTexto(textoUnauthorized,"status text Unauthorized");
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LINK_FORBIDDEN);
		metodosGenericos.esperarMilisegundos(4000);
		String textoForbidden = metodosGenericos.obtenertexto("xpath", DemolqaPageObjects.CAMPO_VALIDACION_LINKS);
		metodosGenericos.validarContenerFragmentoTexto(textoForbidden,"status text Forbidden");
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.LINK_NOT_FOUND);
		metodosGenericos.esperarMilisegundos(4000);
		String textoNotFound = metodosGenericos.obtenertexto("xpath", DemolqaPageObjects.CAMPO_VALIDACION_LINKS);
		metodosGenericos.validarContenerFragmentoTexto(textoNotFound,"status text Not Found");
		
	}
	
	public void clickearPrimerLinkDelOrdenAlfabetico() {
		String textoLista = metodosGenericos.obtenerTextoEnOrdenAlfabetico("xpath", DemolqaPageObjects.CONJUNTO_LINKS);
		metodosGenericos.hacerClicEnLink(textoLista);
		metodosGenericos.esperarMilisegundos(3000);
		String texto = metodosGenericos.obtenertexto("xpath", DemolqaPageObjects.CAMPO_VALIDACION_LINKS);
		metodosGenericos.validarContenerFragmentoTexto(texto,"status text " + textoLista);
	}
	
	public void ingresarALaSeccionDeSlider() {
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.DIV_WIDGETS);
		metodosGenericos.esperarMilisegundos(1000);
		metodosGenericos.scrollDown();
		metodosGenericos.clicElemento("xpath", DemolqaPageObjects.DIV_SLIDER);
		metodosGenericos.esperarMilisegundos(1000);
		
	}
	
	public void arrastrarElSliderAOtraPosicion(int posicion) {
		metodosGenericos.deslizarSlider("xpath", DemolqaPageObjects.BOTON_SLIDER,posicion);
		metodosGenericos.deslizarSlider("xpath", DemolqaPageObjects.INPUT_SLIDER,posicion);
		metodosGenericos.esperarMilisegundos(2000);
		String texto = metodosGenericos.obtenertextoValue("xpath", DemolqaPageObjects.INPUT_SLIDER);
		int numeroCapturado = Integer.parseInt(texto);
		metodosGenericos.validarIgualdadNumerosEnteros(numeroCapturado,posicion);
	}

}
