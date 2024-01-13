package com.ugar.databasecrud.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Roles {
    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String user_id;

    @DynamoDBAttribute(attributeName = "user_name")
    private String name;


}
