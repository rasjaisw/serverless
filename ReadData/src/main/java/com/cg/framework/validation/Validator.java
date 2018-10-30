package com.cg.framework.validation;

import com.cg.framework.base.auth.AuthDTO;

/**This class is used to define the abstraction forvaliator.
 * 
 * @author anangupt
 *
 * @param <T>
 */
public interface Validator<T> {

	/**This method contains the validation logic.
	 * 
	 * @param t
	 * @return
	 */
	public ActionErrorMessage doValidate(T t, AuthDTO authDTO);
	
}
