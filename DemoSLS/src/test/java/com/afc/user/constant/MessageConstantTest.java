package com.afc.user.constant;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.user.constant.MessageConstant;

import static org.junit.Assert.*;

/**
 * The class <code>MessageConstantTest</code> contains tests for the class
 * <code>{@link MessageConstant}</code>.
 * 
 * @author satipati
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class MessageConstantTest {

	/**
	 * Run the String val() method test.
	 *
	 * @throws Exception
	 * 
	 */
	@Test
	public void testMessageConstantVal() throws Exception {
		MessageConstant messageConstant = null;

		messageConstant = MessageConstant.UA0001;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0002;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0003;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0004;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0005;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0006;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0007;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0008;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0009;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0010;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0011;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0012;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0013;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0014;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0015;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0016;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0017;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0018;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0019;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0020;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0021;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0022;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0023;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0024;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0025;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0026;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0027;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0028;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0029;
		assertNotNull(messageConstant.val());

		messageConstant = MessageConstant.UA0030;
		assertNotNull(messageConstant.val());

	}

}