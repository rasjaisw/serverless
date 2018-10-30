package com.serverless;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<List<Map<Object, Object>>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(Handler.class);

	@Override
	public ApiGatewayResponse handleRequest(List<Map<Object, Object>> input, Context context) {
		LOG.info("received: " + input);
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDB dynamoDB = new DynamoDB(client);
		Table table = dynamoDB.getTable("Writedata");
        int size=input.size();
        LOG.info("Size.....: " +size);
        for(int i=0;i<size;i++) {
            String[] arr=input.get(i).values().toString().split(",");
            String seyear=arr[0].substring(1);
           String se=arr[5].replaceAll("]", "");
            LOG.info("Array.....: " + arr);
           System.out.println(arr);
           Item item = new Item()
        		   .withPrimaryKey("Id", seyear)
        		   .withString("year", arr[1])
        		   .withString("northeast", arr[2])
        		   .withString("west", arr[3])
        		   .withString("midwest", arr[4])
        		   .withString("south", se);
           PutItemOutcome outcome = table.putItem(item);
           LOG.info("received: " + outcome);
	}
        LOG.info("received: " + input);
       // LOG.info("received: " + outcome);
		Response responseBody = new Response(input);
		return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(responseBody)
				.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
				.build();
	}}
