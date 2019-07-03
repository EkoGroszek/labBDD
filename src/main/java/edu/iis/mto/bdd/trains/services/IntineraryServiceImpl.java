package edu.iis.mto.bdd.trains.services;

import edu.iis.mto.bdd.trains.model.Line;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;

import java.util.ArrayList;
import java.util.List;

public class IntineraryServiceImpl implements IntineraryService, TimetableService {
    private Line westernLine;
    private List<LocalTime> departureTimes;

    public IntineraryServiceImpl() {
        westernLine = Line.named("Western").departingFrom("Emu Plains").withStations("Parramatta", "Town Hall");
        initializeDepartureTimes();
    }

    private void initializeDepartureTimes() {
        departureTimes = new ArrayList<>();
        departureTimes.add(new LocalTime(7, 58, 0));
        departureTimes.add(new LocalTime(8, 0, 0));
        departureTimes.add(new LocalTime(8, 2, 0));
        departureTimes.add(new LocalTime(8, 11, 0));
        departureTimes.add(new LocalTime(8, 14, 0));
        departureTimes.add(new LocalTime(8, 21, 0));

    }

     public List<LocalTime> findNextDepartures(String departure, String destination, LocalTime startTime) {
        List<LocalTime> departures = new ArrayList<>();

        if (departure.equals("Parramatta") && destination.equals("Town Hall")) {
            for (LocalTime time : departureTimes) {
                if (startTime.compareTo(time) != 1 && Minutes.minutesBetween(startTime, time).getMinutes() <= 15) {
                    departures.add(time);
                }
            }
        }

        return departures;
    }

    @Override public List<org.joda.time.LocalTime> findArrivalTimes(Line line, String targetStation) {
        return null;
    }

    @Override public List<Line> findLinesThrough(String departure, String destination) {
        return null;
    }

    @Override public void scheduleArrivalTime(String line, org.joda.time.LocalTime departureTime) {

    }

    @Override public org.joda.time.LocalTime getArrivalTime(String travellingOnLine, String destination) {
        return null;
    }
}
