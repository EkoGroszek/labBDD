package edu.iis.mto.bdd.trains.cucumber.steps;

import cucumber.api.Transform;
import cucumber.api.java.pl.Gdy;
import cucumber.api.java.pl.Wtedy;
import cucumber.api.java.pl.Zakładając;
import edu.iis.mto.bdd.trains.model.Line;
import edu.iis.mto.bdd.trains.services.InMemoryTimetableService;
import edu.iis.mto.bdd.trains.services.IntineraryService;
import edu.iis.mto.bdd.trains.services.IntineraryServiceImpl;
import edu.iis.mto.bdd.trains.services.TimetableService;
import org.joda.time.LocalTime;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class OptimalItinerarySteps {

    private Line foundLine;

    private String destination;

    private String departure;

    private LocalTime startTime;

    private List<LocalTime> trainInfoTimes = new ArrayList<>();

    private TimetableService timetableService = new InMemoryTimetableService();

    private IntineraryService intineraryService = new IntineraryServiceImpl(timetableService);

    @Zakładając("^pociągi linii \"(.*)\" z \"(.*)\" odjeżdżają ze stacji \"(.*)\" do \"(.*)\" o$")
    public void givenArrivingTrains(String line, String lineStart, String departure, String destination,
            @Transform(JodaLocalTimeConverter.class) List<LocalTime> departureTimes) {
        List<Line> lines = timetableService.findLinesThrough(departure, destination);
        this.foundLine = lines.get(0);
        Assert.assertThat(foundLine.getStations(), is(lines.get(0).getStations()));
    }

    @Gdy("^chcę podróżować z \"([^\"]*)\" do \"([^\"]*)\" o (.*)$")
    public void whenIWantToTravel(String departure, String destination, @Transform(JodaLocalTimeConverter.class) LocalTime startTime) {
        this.departure = departure;
        this.destination = destination;
        this.startTime = startTime;
    }

    @Wtedy("^powinienem uzyskać informację o pociągach o:$")
    public void shouldBeInformedAbout(@Transform(JodaLocalTimeConverter.class) List<LocalTime> expectedTrainTimes) {
        trainInfoTimes.add(new LocalTime(8, 2));
        trainInfoTimes.add(new LocalTime(8, 11));
        trainInfoTimes.add(new LocalTime(8, 14));

        List<LocalTime> times = intineraryService.findNextDepartures(departure, destination, startTime);
        Assert.assertThat(times, is(expectedTrainTimes));
    }
}
