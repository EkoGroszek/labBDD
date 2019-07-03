package edu.iis.mto.bdd.trains.services;

import edu.iis.mto.bdd.trains.model.Line;
import org.joda.time.LocalTime;

import java.util.List;

public class IntineraryServiceImpl implements IntineraryService, TimetableService {

    public IntineraryServiceImpl() {
    }
    
     public List<LocalTime> findNextDepartures(String departure, String destination, LocalTime startTime) {
        return null;
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
