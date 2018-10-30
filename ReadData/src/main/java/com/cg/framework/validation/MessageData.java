package com.cg.framework.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class encapsulates a validation or business error related information
 *
 * @author Anand Gupta
 * @version 1.0
 */
public class MessageData implements Serializable {
	
	/**
     * Setting message number with Integer min value.
     * 
     */
	private static final long serialVersionUID = 3949101548310588L;
	
	int messageNumber = Integer.MIN_VALUE;
	

	/**
     * Property propertyName for which error is to be shown. If its not set by the user, which indicates that error is
     * not field specific and will be shown on top
     */
    private String propertyName;
    /**
     * Error key in the resource bundle
     */
    private String messageKey;

    /**
     * replacement parameters for the message defined in the resource bundle.
     */
    private final List<ParamInfo> params = new ArrayList<ParamInfo>();

    /**
     * Type of the message Error , Warning, Information
     */
    private String messageType ;
    
    
    /**
     * Constant to indicate that the  type of the message is Error
     */
    public static final String ERROR = "E";
    /**
     * Constant to indicate that the  type of the message is Warning
     */

    public static final String WARNING = "W";
    /**
     * Constant to indicate that the type of the message is Information
     */
    public static final String INFORMATION = "I";

    /**
     * Constant to indicate that type of message is Confirmation
     */
    public static final String CONFIRMATION = "C";

    /**
     * Constructor to initialize with property for which error is to  be shown and key
     *
     * @param propertyName name of the property
     * @param key          key in resource bundle
     * @param type         String type of the message E,W,I
     */
    public MessageData( String propertyName, String key, String type ) {
    	
        this.propertyName = propertyName;
        this.messageKey = key;
        this.messageType = type;

    }


    /**
     * Constructor to initialize with key and type of the error
     *
     * @param key  key in resource bundle
     * @param type String type of the message E,W,I
     */
    public MessageData( String key, String type ) {

        this.messageKey = key;
        this.messageType = type;

    }

    /**
     * Adds a message parameter to the existing list for this message
     *
     * @param paramKey
     */
    public void addParams( String paramKey ) {

        params.add( new ParamInfo( paramKey, null ) );
    }

    /**
     * Use this method if you want to print a message like this <br> list of fields required are A,B,C
     *
     * @param list of keys.
     */
    public void addParamKeys(List<String> list) {

        ParamInfo info = new ParamInfo();
        info.setKeys(list);
        params.add( info );
    }

    /**
     * Adds the message parameter key and its value for this message. If param value is provided , it will not be
     * retrieved from the resource bundle
     *
     * @param value value of the parameter to be replaced in the message.
     */
    public void addParamValue(String value) {
        params.add(new ParamInfo( value ));
    }

    /**
     * Adds the message parameter key and its values for this message. If param value is provided , it will not be
     * retrieved from the resource bundle
     *
     * @param value value of the parameter to be replaced in the message.
     */
    public void addParamValues(List<String> values) {
        params.add(new ParamInfo( values ));
    }


    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }


    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public List<ParamInfo> getParams() {
        return params;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }


    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }


    private String identifierValue = null;


    public String getIdentifierValue() {
        return identifierValue;
    }

    public void setIdentifierValue(String identifierValue) {
        this.identifierValue = identifierValue;
    }



} 
