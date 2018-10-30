package com.serverless;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

class ServerlessException extends RuntimeException

{
    public ServerlessException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}

public class Handler implements RequestHandler<Map<String, Object>, List<Map<String, String>>>  {

	private static final Logger LOG = Logger.getLogger(Handler.class);

	@Override
	public List<Map<String, String>> handleRequest(Map<String, Object> input, Context context) throws ServerlessException {
		
		List<Map<String, String>> response = new LinkedList<Map<String, String>>();
		  
		S3Object s3Obj = null;
		String bucketName = "read-serverless";
		String key = "data.csv";
		LOG.info("S3Ob : "+s3Obj);
		try {
			AmazonS3 amazonS3Client = AmazonS3ClientBuilder
					  .standard()
					  .withRegion(Regions.US_EAST_1)
					  .build();
			s3Obj = amazonS3Client.getObject(new GetObjectRequest(bucketName, key));
			LOG.info("S3Ob : "+s3Obj);
			if(s3Obj == null)
			{
				throw new ServerlessException("File does not exist");
			}
			else
			{
				System.out.println("Content-Type: " + s3Obj.getObjectMetadata().getContentType());
     
				try {
						CsvMapper mapper = new CsvMapper();
						CsvSchema schema = CsvSchema.emptySchema().withHeader();
						MappingIterator<Map<String, String>> iterator = mapper.reader(Map.class)
																		.with(schema)
																		.readValues(s3Obj.getObjectContent());
						while (iterator.hasNext()) 
						{
							response.add(iterator.next());
						}
					} 
				
				catch (IOException e)
				{
					e.printStackTrace();
				}
     
				ObjectMapper mapper = new ObjectMapper();
				mapper.enable(SerializationFeature.INDENT_OUTPUT);
				mapper.writeValue(System.out, response);
			}
		}
		catch(ServerlessException e) {
         e.printStackTrace();
		}
		catch(JsonProcessingException e) {
         e.printStackTrace();
 		} 
		catch (AmazonServiceException e) {
			e.printStackTrace();
		}
		catch (SdkClientException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.getMessage();
		}
		
		LOG.info("received: " + response);
		//Response responseBody = new Response(response);
		/*return ApiGatewayResponse.builder()
				.setStatusCode(200)
				.setObjectBody(responseBody)
				.setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
				.build();*/
		
		return response;
}
		
}
