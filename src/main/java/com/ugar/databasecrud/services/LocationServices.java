package com.ugar.databasecrud.services;

import com.ugar.databasecrud.entity.Location;
import com.ugar.databasecrud.repository.LocationRepository;

import java.time.Instant;
import java.util.List;

public interface LocationServices  {
    List<Location> getLocationList();
    Location findByTimestamp(String timestamp);
    List<Location> findLocationsBetweenTimestamps(String startTimestamp, String endTimestamp);

}
