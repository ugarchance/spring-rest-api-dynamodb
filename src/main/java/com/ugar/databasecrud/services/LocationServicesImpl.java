package com.ugar.databasecrud.services;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.ugar.databasecrud.entity.Location;
import com.ugar.databasecrud.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.dynamodbv2.model.*;


import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocationServicesImpl implements LocationServices {

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getLocationList() {
        return (List<Location>) locationRepository.findAll();
    }

    @Override
    public Location findByTimestamp(String timestamp) {

        return locationRepository.findByTimestamp(timestamp);

    }

    @Override
    public List<Location> findLocationsBetweenTimestamps(String startTimestamp, String endTimestamp) {
        List<Location> locations = new ArrayList<>();

        ScanRequest scanRequest = new ScanRequest()
                .withTableName("location-test")
                .withFilterExpression("#zaman BETWEEN :start and :end")
                .withExpressionAttributeNames(new HashMap<String, String>() {{
                    put("#zaman", "timestamp");
                }})
                .withExpressionAttributeValues(new HashMap<String, AttributeValue>() {{
                    put(":start", new AttributeValue().withS(startTimestamp));
                    put(":end", new AttributeValue().withS(endTimestamp));
                }});

        ScanResult scanResult = amazonDynamoDB.scan(scanRequest);
        for (Map<String, AttributeValue> item : scanResult.getItems()) {
            locations.add(convertToLocation(item));
        }

        return locations;
    }

    private Location convertToLocation(Map<String, AttributeValue> item) {
        // DynamoDB'den gelen veriyi Location nesnesine dönüştürme

        return new Location(item.get("timestamp").getS(),
                Double.parseDouble(item.get("latitude").getN()),
                Double.parseDouble(item.get("longitude").getN()));
    }
}
