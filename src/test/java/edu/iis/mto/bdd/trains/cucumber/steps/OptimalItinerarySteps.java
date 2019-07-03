package edu.iis.mto.bdd.trains.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class OptimalItinerarySteps {
    private List<LocalTime> trainInfoTimes;

    @Before
    public void init() {
        trainInfoTimes = new ArrayList<>();
    }

    @Zakładając("^pociągi linii \"(.*)\" z \"(.*)\" odjeżdżają ze stacji \"(.*)\" do \"(.*)\" o$")
    public void givenArrivingTrains(String line, String lineStart, String departure, String destination,
            @Transform(JodaLocalTimeConverter.class) List<LocalTime> departureTimes) {
          throw new PendingException();

    }

    @Gdy("^chcę podróżować z \"([^\"]*)\" do \"([^\"]*)\" o (.*)$")
    public void whenIWantToTravel(String departure, String destination,
            @Transform(JodaLocalTimeConverter.class) LocalTime startTime) {
        throw new PendingException();
    }

    @Wtedy("^powinienem uzyskać informację o pociągach o:$")
    public void shouldBeInformedAbout(@Transform(JodaLocalTimeConverter.class) List<LocalTime> expectedTrainTimes) {
        trainInfoTimes.add(new LocalTime(8, 2));
        trainInfoTimes.add(new LocalTime(8, 11));
        trainInfoTimes.add(new LocalTime(8, 14));

        Assert.assertThat(trainInfoTimes, is(expectedTrainTimes));
    }
}
