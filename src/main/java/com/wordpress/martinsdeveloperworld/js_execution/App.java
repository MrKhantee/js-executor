package com.wordpress.martinsdeveloperworld.js_execution;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.wordpress.martinsdeveloperworld.js_execution.cli.CliOptions;
import com.wordpress.martinsdeveloperworld.js_execution.cli.CliParser;
import com.wordpress.martinsdeveloperworld.js_execution.js.JsExecutionException;
import com.wordpress.martinsdeveloperworld.js_execution.js.JsExecutor;
import com.wordpress.martinsdeveloperworld.js_execution.js.JsExecutorImpl;

public class App {

	public static void main(String[] args) {
		JsExecutor jsExecutor = new JsExecutorImpl();
		CliOptions cliOptions = parseCliParameter(args);
		if (cliOptions.isSuccessful()) {
			try {
				String script = FileUtils.readFileToString(new File(cliOptions.getJsFile()));
				jsExecutor.execute(script);
			} catch (IOException e) {
				System.err
						.println(String.format("Reading file '%s' failed: %s", cliOptions.getJsFile(), e.getMessage()));
			} catch (JsExecutionException e) {
				System.err.println(String.format("Execution of JavaScript failed: %s.", e.getMessage()));
			}
		}
	}

	private static CliOptions parseCliParameter(String[] args) {
		CliParser cliParser = new CliParser();
		return cliParser.parse(args);
	}
}
