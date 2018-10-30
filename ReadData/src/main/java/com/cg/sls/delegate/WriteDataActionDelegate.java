package com.cg.sls.delegate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import  com.cg.framework.base.auth.AuthDTO;
import  com.cg.framework.base.delegate.AbstractActionDelegate;
import  com.cg.framework.constant.RoleConstant;
import  com.cg.framework.validation.ImpersonateUserValidator;
import com.cg.sls.request.UserRequest;
import com.cg.sls.response.ReadDataResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class has the concrete implementation of doProcess method
 * 
 * @author anangupt
 *
 */
@Component
public class WriteDataActionDelegate extends AbstractActionDelegate<UserRequest, ReadDataResponse> {

	private static final Logger LOGGER = LoggerFactory.getLogger(WriteDataActionDelegate.class);


	@Autowired
	ImpersonateUserValidator impersonateUserValidator;
	
	
	/**
	 * This method does the initial validation and passes the request object to the
	 * add OKTA service.
	 */
	public ReadDataResponse doProcess(UserRequest userRequest, AuthDTO authObject) {

		LOGGER.info("enter::AddUserActionDelegate::doProcess {}", userRequest);
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		DynamoDB dynamoDB = new DynamoDB(client);
		Table table = dynamoDB.getTable("WriteData");
		String input = userRequest.getInput();
		JSONObject jsonObj = new JSONObject(input);
		JSONArray output = jsonObj.getJSONArray("output");
		System.out.println("output....."+output);
		List<Map<Object, Object>> list = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		//String[] arr = new String[output.length()];
		String arr = output.toString();
		try {
			list =   mapper.readValue(arr, new TypeReference<List<Map<Object, Object>>>(){});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("length" +output.length());
		for(int i=0;i<output.length();i++) {
			String[] array=list.get(i).values().toString().split(",");
            System.out.println("List"+output.get(i));
            String seyear=array[0].substring(1);
           String se=array[5].replaceAll("]", "");
           LOGGER.info("Array.....: " + arr);
           System.out.println("Array.....: " +arr.toString());
          
           Item item = new Item()
        		   .withPrimaryKey("Id", array[4])
        		   .withString("year", array[0])
        		   .withString("northeast", array[3])
        		   .withString("west", array[2])
        		   .withString("midwest", array[5])
        		   .withString("south", array[1]);
           System.out.println("putItem.....");
           PutItemOutcome outcome = table.putItem(item);
           System.out.println("received: ......" + outcome);
           LOGGER.info("received: " + outcome);
	}
        ReadDataResponse readDataResponse = new ReadDataResponse();
		readDataResponse.setMessage("data saved successfully");
		return readDataResponse;
	}

	/**
	 * PreProcessing the input.
	 * 
	 * @param userRequest
	 * @param authObject
	 * @return
	 */
	/*private ActionErrorMessage preProcessing(UserRequest userRequest, AuthDTO authObject) {
		
		
		ActionErrorMessage actionErrorMessage = null;
//		validate input parameters.
		actionErrorMessage = doValidation(userRequest,authObject);
		if (actionErrorMessage != null && actionErrorMessage.isError()) {
			LOGGER.info("exit::AddUserActionDelegate::preProcessing::doValidation");
			return actionErrorMessage;
		}
//	    Check the permission to create with list of auction.
		actionErrorMessage = checkPermisssion(authObject, userRequest);
		if (actionErrorMessage != null && actionErrorMessage.isError()) {
			LOGGER.info("exit::AddUserActionDelegate::preProcessing::checkPermisssion");
			return actionErrorMessage;
		}
		
		return null;
	}
*/
	/**Check the user has the permission to create a user with selected list of auction.
	 * 
	 * @param authObject
	 * @param userRequest
	 * @return
	 */
	/*public ActionErrorMessage checkPermisssion(AuthDTO authObject,UserRequest userRequest) {

		ActionErrorMessage actionErrorMessage = null;
		boolean havePermission = false;
		// check whether add/edit permission is present
		
		if (authObject.getProfile().isInternal()) {
			if (checkPermisssion(authObject, RoleConstant.ADD_EDIT_USERS)) {
				havePermission = true;
			}
		}else {
			for (String auction : userRequest.getAuctions()) {
				if (!checkPermisssion(authObject,auction, RoleConstant.ADD_EDIT_USERS)) {
					havePermission = false;
					break;
				}else {
					havePermission = true;
				}
			}
		}
		if ( ! havePermission) {
			actionErrorMessage =  genericMessageHandler.doProcess(MessageConstant.UA0006.val(), MessageData.ERROR, TerritoryLocal.getLocal(TerritoryLocal.US));
			LOGGER.error("AddUserActionDelegate::checkPermisssion::User does not have add/edit permission");
		}
		return actionErrorMessage;

	}
*/
	/**
	 * This method check for the whether user has a permission to access the api.
	 * 
	 * @param authObject
	 * @return boolean
	 */
	@Override
	public boolean checkPermisssion(AuthDTO authObject, RoleConstant role) {
		boolean isPermission = true;
		if (authObject.getPermissions() == null || !(authObject.getPermissions().contains(role.getVal()))) {
			isPermission = false;
		}
		return isPermission;
	}

	/**validate the input request.
	 * 
	 */
	/*@Override
	public ActionErrorMessage doValidation(UserRequest userRequest, AuthDTO authObject) {
		LOGGER.info("AddUserActionDelegate::doValidation");
		return addUserValidator.doValidate(userRequest, authObject);
	}*/

}
