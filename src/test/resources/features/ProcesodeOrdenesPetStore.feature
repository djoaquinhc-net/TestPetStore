Feature: Proceso de ordenes en PetStore

  @orden
  Scenario: Crear orden nueva en la tienda

    Given el usuario se encuentra en la url de la tienda
    When creo la orden de una nueva mascota
    Then el estado de registro es "placed"
    And se completo la solicitud
    And el codigo de respuesta es 200

  @orden
  Scenario Outline: Solicitar informacion de orden existente

    Given tengo una orden con una "<ID>"
    When solicito su informacion utilizando su "<ID>"
    Then la respuesta debe tener el mismo ID que envie en la solicitud
    And el estado de registro debe ser "placed"
    And debe ser una orden completada
    And el codigo de respuesta debe ser 200

    Examples:
    |ID|
    |4|
    |3223364|
    |8124785380296072006|
    #NOTA: EL ESTADO DE LAS IDS PUEDE VARIAR DUARNTE LAS PRUEBAS YA QUE ES UNA API PUBLICA A LA QUE ESTAMOS HACIENDO EL TEST.