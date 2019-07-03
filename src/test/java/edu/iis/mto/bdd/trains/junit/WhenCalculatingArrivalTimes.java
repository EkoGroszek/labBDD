package edu.iis.mto.bdd.trains.junit;

import edu.iis.mto.bdd.trains.services.IntineraryService;
import edu.iis.mto.bdd.trains.services.IntineraryServiceImpl;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class WhenCalculatingArrivalTimes {
    private IntineraryService intineraryService;

    @Before
    public void setUp() {
        intineraryService = new IntineraryServiceImpl();
    }

    @Test
    public void LineFromParramattaToTownHall_AtEightOClock_ShouldReturnProperDepartureTimes() {
        // given
        String departure = "Parramatta";
        String destination = "Town Hall";
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, Calendar.JUNE, 3, 8, 0, 0);
        LocalTime atHour = LocalTime.fromCalendarFields(calendar);

        List<LocalTime> departureTimes = new ArrayList<>();
        departureTimes.add(new LocalTime(8, 2, 0));
        departureTimes.add(new LocalTime(8, 11, 0));
        departureTimes.add(new LocalTime(8, 14, 0));

        // when
        List<LocalTime> departures = intineraryService.findNextDepartures(departure, destination, atHour);

        // then
        Assert.assertThat(departures, is(departureTimes));
    }


}
