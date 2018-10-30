package com.afc.user.token;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.cg.user.token.TokenGenerator;

/**
 * The class <code>TokenGeneratorTest</code> contains tests for the class <code>{@link TokenGenerator}</code>.
 *
 * @author pbhandal
 */
@RunWith(MockitoJUnitRunner.class)
public class TokenGeneratorTest {


	/**
	 * Run the String getToken() method test.
	 *
	 * @throws Exception
	 *
	 */
	@Test
	public void testGetToken_1()
			throws Exception {

		String actualResult = TokenGenerator.getToken();
		assertNotNull(actualResult);
	}

}