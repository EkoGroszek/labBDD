package edu.iis.mto.bdd.trains.services;

import edu.iis.mto.bdd.trains.model.Line;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;

import java.util.ArrayList;
import java.util.List;

public class IntineraryServiceImpl implements IntineraryService {

    private TimetableService timetableService;

    public IntineraryServiceImpl(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    public List<LocalTime> findNextDepartures(String departure, String destination, LocalTime startTime) {
        List<Line> lines = timetableService.findLinesThrough(departure, destination);
        List<LocalTime> times = new ArrayList<>();

        if (lines.get(0).getStations().contains(departure) && lines.get(0).getStations().contains(destination)) {
            for (LocalTime time : timetableService.findArrivalTimes(lines.get(0), destination)) {
                if (startTime.compareTo(time) != 1 && Minutes.minutesBetween(startTime, time).getMinutes() <= 15) {
                    times.add(time);
                }
            }
        }
        return times;

    }

}
