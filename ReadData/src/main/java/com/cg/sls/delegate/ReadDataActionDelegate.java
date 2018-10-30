package com.cg.sls.delegate;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import  com.cg.framework.base.auth.AuthDTO;
import  com.cg.framework.base.delegate.AbstractActionDelegate;
import  com.cg.framework.constant.RoleConstant;
import  com.cg.framework.validation.ImpersonateUserValidator;
import com.cg.sls.request.UserRequest;
import com.cg.sls.response.ReadDataResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

/**
 * This class has the concrete implementation of doProcess method
 * 
 * @author anangupt
 *
 */
@Component
public class ReadDataActionDelegate extends AbstractActionDelegate<UserRequest, ReadDataResponse> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReadDataActionDelegate.class);


	@Autowired
	ImpersonateUserValidator impersonateUserValidator;
	
	

	/**
	 * This method does the initial validation and passes the request object to the
	 * add OKTA service.
	 */
	public ReadDataResponse doProcess(UserRequest userRequest, AuthDTO authObject) {

		LOGGER.info("enter::ReadDataActionDelegate::doProcess {}", userRequest);
		System.out.println("enter::ReadDataActionDelegate::doProcess {}" +userRequest);
		ReadDataResponse readDataResponse = new ReadDataResponse();
		List<Map<Object, Object>> response = new LinkedList<Map<Object, Object>>();
		   //List<String> list = new ArrayList<>();
		   S3Object s3Obj = null;
		String bucketName = "rash1";
		String key = "data.csv";
		try {
			AmazonS3 amazonS3Client = AmazonS3ClientBuilder
					  .standard()
					  .withRegion(Regions.US_EAST_1)
					  .build();
		s3Obj = amazonS3Client.getObject(new GetObjectRequest(bucketName, key));
		
		System.out.println("Content-Type: " + s3Obj.getObjectMetadata().getContentType());
     
     try {
     	
         CsvMapper mapper = new CsvMapper();
         CsvSchema schema = CsvSchema.emptySchema().withHeader();
         MappingIterator<Map<Object, Object>> iterator = mapper.reader(Map.class)
                 .with(schema)
                 .readValues(s3Obj.getObjectContent());
         while (iterator.hasNext()) {
             response.add(iterator.next());
     	
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
     System.out.println();
		
     ObjectMapper mapper = new ObjectMapper();
     mapper.enable(SerializationFeature.INDENT_OUTPUT);
     mapper.writeValue(System.out, response);
     }
		catch(AmazonServiceException e) {
         e.printStackTrace();
      }
     catch(SdkClientException e) {
         e.printStackTrace();
 		
     } catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		readDataResponse.setOutput(response);
		//readDataResponse.setMessage("data retrieved successfully");
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
			LOGGER.info("exit::ReadDataActionDelegate::preProcessing::doValidation");
			return actionErrorMessage;
		}
//	    Check the permission to create with list of auction.
		actionErrorMessage = checkPermisssion(authObject, userRequest);
		if (actionErrorMessage != null && actionErrorMessage.isError()) {
			LOGGER.info("exit::ReadDataActionDelegate::preProcessing::checkPermisssion");
			return actionErrorMessage;
		}
		
		return null;
	}*/

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
			LOGGER.error("ReadDataActionDelegate::checkPermisssion::User does not have add/edit permission");
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
	}
*/
}
