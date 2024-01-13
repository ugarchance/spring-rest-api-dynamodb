package com.ugar.databasecrud.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "location-test")// validates if the DynamoDB table exists or not.
// DynamoDB does not create collection automatically so it is important to create dynamodb before hand
@Data @NoArgsConstructor @AllArgsConstructor

public class Location {

    @DynamoDBHashKey(attributeName = "timestamp")//marking a property as the hash key for a modeled class
    @DynamoDBAutoGeneratedKey       //for making the hashkey property to autogenerate the key & it supports String type only
    private String timestamp;

    @DynamoDBAttribute(attributeName = "latitude")//Maps a property to dynamodb table attribute.
    private double latitude;

    @DynamoDBAttribute(attributeName = "longitude")
    private  double longitude;
}
