package edu.iis.mto.bdd.trains.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.I;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;

import java.time.LocalTime;
import java.util.List;

public class EstimationArrivalSteps {

    @Zakładając("chcę się dostać z \"([^\"]*)\" do \"([^\"]*)\"$") public void withGivenStations(String from, String to) {
        throw new PendingException();
    }

    @I("następny pociąg na linii \"([^\"]*)\" odjeżdża o$") public void andNextTrainGoesFromSpecificLineAtSpecificTime(String fromLine,
            @Transform(JodaLocalTimeConverter.class) List<LocalTime> expectedTrainDepartures) {
        throw new PendingException();
    }

    @Gdy("zapytam o godzinę przyjazdu") public void whenAskAboutArrivalTime() {
        throw new PendingException();
    }

    @Wtedy("powinienem uzyskać następujący szacowany czas przyjazdu:$")
    public void thenShowEstimatedTimeOfArrival(@Transform(JodaLocalTimeConverter.class) List<LocalTime> estimatedArrivalTime) {
        throw new PendingException();
    }

}
