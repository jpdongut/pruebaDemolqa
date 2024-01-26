@PruebaGlobal
Feature: Realizar test de la pagina Demolqa

  @Prueba1
  Scenario Outline: Verificar el formulario de registro
    Given Abri el navegador para entrar a demolqa
    When Ingreso a la seccion forms para ir a practice form
    And Diligencio el formulario <nombre><apellido><correoElectronico><numeroTelefono>
    Then Validar Mensaje exitoso al llenar el formulario
    And Cerrar pagina demolqa

    Examples: 
      | nombre   | apellido | correoElectronico   | numeroTelefono |
      | "Carlos" | "Vargas" | "cvargas@gmail.com" | "3005698745"   |

  @Prueba2
  Scenario: Verificar la funcionalidad de los enlaces
    Given Abri el navegador para entrar a demolqa
    When Ingreso a la seccion elements para ir a links
    Then Seleccionar links y validar su contenido
    And Validar el primer link en orden alfabetico y hacer clic
    And Cerrar pagina demolqa

  @Prueba3
  Scenario Outline: Verificar la funcionalidad del carrusel
    Given Abri el navegador para entrar a demolqa
    When Ingreso a la seccion widgets para ir a slider
    Then Validar que el slider quede en la posicion indicada <posicion>
    And Cerrar pagina demolqa
    
    Examples: 
      | posicion   | 
      | 3 |
    
