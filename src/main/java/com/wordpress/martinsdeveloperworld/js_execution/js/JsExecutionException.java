package com.wordpress.martinsdeveloperworld.js_execution.js;

import javax.script.ScriptException;

public class JsExecutionException extends Exception {

	public JsExecutionException(ScriptException e) {
		super(e);
	}

	public JsExecutionException(String msg) {
		super(msg);
	}

}
