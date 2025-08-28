package com.nttdata.steps;

import com.nttdata.model.QATest;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.CoreMatchers.equalTo;


public class ProcesodeOrdenesPetStoreStep {
    QATest qaTest = new QATest();

    public void elUsuarioSeEncuentraEnLaUrlDeLaTienda(){
        System.out.println(qaTest.getURL_SOL());
    }

    public void creoLaOrdenDeUnaNuevaMascota(){
        SerenityRest.given()
                .baseUri(qaTest.getURL_SOL())
                .contentType("application/json").body("{\n" +
                        "  \"id\":0,\n"+
                        "  \"petId\": 0,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \"2025-08-27T22:25:50.564Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .log().all()
                .post("/store/order")
                .then()
                .log().all();
        System.out.println("ID de la Orden : " + lastResponse().jsonPath().getString("id") );
    }

    public void elEstadoDeRegistroEs(String estado) {
        restAssuredThat(response -> response.body("status", equalTo(estado)));
        if (estado.equalsIgnoreCase("placed")){
            System.out.println("Orden generada");
        }else {
            System.out.println("Orden en estado Desconocido");
        }
    }

    public void seCompletoLaSolicitud(){
        restAssuredThat(response -> response.body("complete",equalTo(true)));
        boolean completado = SerenityRest.lastResponse().jsonPath().getBoolean("complete");
        if (completado) {
            System.out.println("La orden esta completada");
        } else {
            System.out.println("La orden no ha sido completada");
        }
    }

    public void elCodigoDeRepuestaEs(int codigoresultante){
        restAssuredThat(response -> response.statusCode(codigoresultante));
        System.out.println("Test Aprobado");

    }

    public void tengoUnaOrdenConUna(String id){
        qaTest.setId(id);
        System.out.println("ID de Orden a Validar: " + qaTest.getId());
    }

    public void solicitoSuInformacionUtilizandoSu(String id){

        SerenityRest.given()
                .baseUri(qaTest.getURL_SOL())
                .contentType("application/json")
                .pathParam("orderId",id)
                .get("/store/order/{orderId}")
                .then()
                .log().all();
    }

    public void laRespuestaDebeTenerElMismoIDQueEnvieEnLaSolicitud(){
        System.out.println("ID de la Respuesta : "+ SerenityRest.lastResponse().jsonPath().getString("id"));
        if (SerenityRest.lastResponse().jsonPath().getString("id") != null){
        System.out.println("La respuesta presenta el mismo ID : " + qaTest.getId() + " = " + SerenityRest
                .lastResponse().jsonPath().getString("id"));
        }else {
            System.out.println("La respuesta no presenta el mismo ID");
        }
    }

    public void elEstadoDeRegistroDebeSer(String estadoesperado) {
        restAssuredThat(response -> response.body("status", equalTo(estadoesperado)));
        if (estadoesperado.equalsIgnoreCase("placed")){
            System.out.println("El estado de la orden es el correcto : " + estadoesperado);
        }else {
            System.out.println("El estado de la orden es desconocido");
        }
    }

    public void debeSerUnaOrdenCompletada(){
        restAssuredThat(response -> response.body("complete",equalTo(true)));
        boolean completadoesperado = SerenityRest.lastResponse().jsonPath().getBoolean("complete");
        if (completadoesperado) {
            System.out.println("La orden encontrada esta completada");
        } else {
            System.out.println("La orden no ha sido encontrada");
        }
    }

    public void elCodigoDeRespuestaDebeSer(int codigoesperado){
        restAssuredThat(response -> response.statusCode(codigoesperado));
        System.out.println("Test Aprobado.");
    }



}
