package com.wordpress.martinsdeveloperworld.js_execution.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.wordpress.martinsdeveloperworld.js_execution.App;

public class CliParser {

	private static final String OPTION_JS_FILE = "jsfile";

	public CliOptions parse(String args[]) {
		CliOptions cliOptions = new CliOptions();

		Option jsFile = OptionBuilder.withArgName("js").hasArg().withDescription("execute given js file")
				.create(OPTION_JS_FILE);
		Options options = new Options();
		options.addOption(jsFile);

		CommandLineParser parser = new GnuParser();
		try {
			CommandLine line = parser.parse(options, args);
			if (line.hasOption(OPTION_JS_FILE)) {
				String optionValue = line.getOptionValue(OPTION_JS_FILE);
				cliOptions.setJsFile(optionValue);
			}
		} catch (ParseException exp) {
			cliOptions.setSuccessful(false);
			System.err.println(exp.getMessage());
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp(App.class.getSimpleName(), options);
		}
		return cliOptions;
	}
}
