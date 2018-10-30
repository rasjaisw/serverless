package com.serverless;

import java.util.List;
import java.util.Map;

public class Response {

	private final List<Map<String, String>> input;

	public Response(List<Map<String, String>> input) {
		this.input = input;
	}

	public List<Map<String, String>> getInput() {
		return this.input;
	}
}
