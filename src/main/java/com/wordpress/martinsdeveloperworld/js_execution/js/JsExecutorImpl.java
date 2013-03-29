package com.wordpress.martinsdeveloperworld.js_execution.js;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JsExecutorImpl implements JsExecutor {

	@Override
	public void execute(String script) throws JsExecutionException {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		if (engine != null) {
			try {
				engine.eval(script);
			} catch (ScriptException e) {
				throw new JsExecutionException(e);
			}
		} else {
			throw new JsExecutionException("No JavaScript engine available.");
		}
	}
}
