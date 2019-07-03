package edu.iis.mto.bdd.trains.services;

import java.time.LocalTime;

public interface IntineraryService {

    void findNextDepartures(String departure, String destination, LocalTime startTime);
}
