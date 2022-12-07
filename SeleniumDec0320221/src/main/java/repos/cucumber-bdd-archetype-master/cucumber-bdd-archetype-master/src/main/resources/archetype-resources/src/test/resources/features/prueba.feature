Feature: Ejemplo
  Este ejemplo muestra ejemplos simples de Gherkin

  Scenario Outline: Busqueda por Examples
    #Scenario Outline permite ejecutar el mismo escenario varias veces reemplazando "<palabra>"
    #con las palabras definidas mas abajo en la seccion Examples.
    Given estoy en la pagina de busqueda de google
    When busco "<palabra>"
    Then el titulo contiene "<palabra>"

    Examples:
      |palabra    |
      |Cucumber   |
      |BDD        |

  Scenario: Realizar busqueda sin internet
    #Este escenario muestra la ejecucion de una prueba sin conexion.
    Given estoy en la pagina de busqueda de google
    And ingreso la palabra "Selenium"
    When Se pierde la conexion de internet
    And realizo la busqueda
    Then se muestra la pagina sin conexion