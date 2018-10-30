package com.serverless;

import java.util.List;
import java.util.Map;

public class Response {

	private final List<Map<Object, Object>> input;

	public Response(List<Map<Object, Object>> input2) {
		this.input = input2;
	}

	public List<Map<Object, Object>> getInput() {
		return this.input;
	}
}
