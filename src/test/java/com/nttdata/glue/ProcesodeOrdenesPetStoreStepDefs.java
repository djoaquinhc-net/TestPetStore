package com.nttdata.glue;

import com.nttdata.steps.ProcesodeOrdenesPetStoreStep;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProcesodeOrdenesPetStoreStepDefs {
    @Steps
    ProcesodeOrdenesPetStoreStep procesodeOrdenesPetStoreStep;

    @Given("el usuario se encuentra en la url de la tienda")
    public void elUsuarioSeEncuentraEnLaUrlDeLaTienda() {
        procesodeOrdenesPetStoreStep.elUsuarioSeEncuentraEnLaUrlDeLaTienda();
    }

    @When("creo la orden de una nueva mascota")
    public void creoLaOrdenDeUnaNuevaMascota() {
        procesodeOrdenesPetStoreStep.creoLaOrdenDeUnaNuevaMascota();
    }

    @Then("el estado de registro es {string}")
    public void elEstadoDeRegistroEs(String estado) {
        procesodeOrdenesPetStoreStep.elEstadoDeRegistroEs(estado);
    }

    @And("se completo la solicitud")
    public void seCompletoLaSolicitud() {
        procesodeOrdenesPetStoreStep.seCompletoLaSolicitud();
    }

    @And("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int codigoresultante) {
        procesodeOrdenesPetStoreStep.elCodigoDeRepuestaEs(codigoresultante);
    }


    @Given("tengo una orden con una {string}")
    public void tengoUnaOrdenConUna(String id) {
        procesodeOrdenesPetStoreStep.tengoUnaOrdenConUna(id);
    }

    @When("solicito su informacion utilizando su {string}")
    public void solicitoSuInformacionUtilizandoSuID(String id) {
        procesodeOrdenesPetStoreStep.solicitoSuInformacionUtilizandoSu(id);
    }

    @Then("la respuesta debe tener el mismo ID que envie en la solicitud")
    public void laRespuestaDebeTenerElMismoIDQueEnvieEnLaSolicitud() {
        procesodeOrdenesPetStoreStep.laRespuestaDebeTenerElMismoIDQueEnvieEnLaSolicitud();
    }

    @And("el estado de registro debe ser {string}")
    public void elEstadoDeRegistroDebeSer(String estadoesperado) {
        procesodeOrdenesPetStoreStep.elEstadoDeRegistroDebeSer(estadoesperado);
    }

    @And("debe ser una orden completada")
    public void debeSerUnaOrdenCompletada() {
        procesodeOrdenesPetStoreStep.debeSerUnaOrdenCompletada();
    }

    @And("el codigo de respuesta debe ser {int}")
    public void elCodigoDeRespuestaDebeSer(int codigoesperado) {
        procesodeOrdenesPetStoreStep.elCodigoDeRespuestaDebeSer(codigoesperado);
    }


}
