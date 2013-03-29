package com.wordpress.martinsdeveloperworld.js_execution.cli;

public class CliOptions {
	private boolean successful = true;
	private String jsFile;

	public String getJsFile() {
		return jsFile;
	}

	public void setJsFile(String jsFile) {
		this.jsFile = jsFile;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

}
