package com.cg.user.constant;

/**This enum holds all the constant which are used for validation.
 * 
 * @author anangupt
 *
 */
public enum MessageConstant {

	UA0001("UA0001"),
	UA0002("UA0002"),
	UA0004("UA0004"),
	UA0003("UA0003"),
	UA0005("UA0005"),
	UA0006("UA0006"),
	UA0007("UA0007"),
	UA0008("UA0008"),
	UA0009("UA0009"),
	UA0010("UA0010"),
	UA0011("UA0011"),
	UA0012("UA0012"),
	UA0013("UA0013"),
	UA0014("UA0014"),
	UA0015("UA0015"),
	UA0016("UA0016"),
	UA0017("UA0017"),
	UA0018("UA0018"),
	UA0019("UA0019"),
	UA0020("UA0020"),
	UA0021("UA0021"),
	UA0022("UA0022"),
	UA0023("UA0023"),
	UA0024("UA0024"),
	UA0025("UA0025"),
	UA0026("UA0026"),
	UA0027("UA0027"),
	UA0028("UA0028"),
	UA0029("UA0029"),
	UA0030("UA0030"),
	UA0031("UA0031"),
	UA0032("UA0032"),
	UA0033("UA0033"),
	UA0034("UA0034"),
	UA0035("UA0035"),
	UA0036("UA0036"),
	UA0037("UA0037");

	private String value;

	MessageConstant(String url) {
		this.value = url;
	}

	public String val() {
		return value;
	}

}
