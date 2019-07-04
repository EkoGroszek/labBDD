package edu.iis.mto.bdd.trains.services;

import com.google.common.collect.ImmutableList;
import edu.iis.mto.bdd.trains.model.Line;
import org.joda.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimetableService implements TimetableService {

    List<Line> lines = ImmutableList.of(
            Line.named("Western").departingFrom("Emu Plains").withStations("Emu Plains", "Parramatta", "Town Hall",
                    "North Richmond"),
            Line.named("Western").departingFrom("North Richmond").withStations("North Richmond", "Town Hall",
                    "Parramatta", "Emu Plains"),
            Line.named("Epping").departingFrom("Epping").withStations("Epping", "Strathfield", "Central"),
            Line.named("Epping").departingFrom("City").withStations("Central", "Strathfield", "Epping"));

    // All trains leave the depots at the same time.
    List<LocalTime> universalDepartureTimes = ImmutableList.of(new LocalTime(7, 58), new LocalTime(8, 0), new LocalTime(8, 2),
                                                               new LocalTime(8, 11), new LocalTime(8, 14), new LocalTime(8, 21));


    @Override
    public List<LocalTime> findArrivalTimes(Line line, String targetStation) {
        Line targetLine = lineMatching(line);
        return universalDepartureTimes;
    }

    private Line lineMatching(Line requestedLine) {
        for (Line line : lines) {
            if (line.equals(requestedLine)) {
                return line;
            }
        }
        return null;
    }

    @Override
    public List<Line> findLinesThrough(String departure, String destination) {
        // return ImmutableList.of(lines.get(0));
        List<Line> resultLines = new ArrayList<>();
        for (Line line : lines) {
            if (line.getStations().contains(departure) && line.getStations().contains(destination)) {
                if (line.getStations().indexOf(destination) > line.getStations().indexOf(departure)) {
                    resultLines.add(line);
                }
            }
        }
        return resultLines;
    }

    @Override
    public void scheduleArrivalTime(String line, LocalTime departureTime) {
        // To change body of created methods use File | Settings | File Templates.
    }

    @Override
    public LocalTime getArrivalTime(String travellingOnLine, String destination) {
        // TODO: Call the back-end service to retrieve this data
        return null;
    }
}
