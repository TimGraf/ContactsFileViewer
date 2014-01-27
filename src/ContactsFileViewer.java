import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.grafcode.contactsfileviewer.controller.ContactsController;

public class ContactsFileViewer {
	private static final String FILE_OPTION            = "csvfile";
	private static final String PRINT_COMPANIES_OPTION = "company";
	private static final String PRINT_USERS_OPTION     = "user";
	private static final String PRINT_HELP_OPTION      = "help";
	
	private static Options options = new Options();
	
	public static void main(String[] args) {
		
		try {
			CommandLine commandLine = setUpCommandLineOptions(args);
			
			handleCommandLineOptions(commandLine);	
		} catch (Exception excepton) {
			handleException(excepton);
		}
	}
	
	@SuppressWarnings({"static-access"})
	static CommandLine setUpCommandLineOptions(String[] aruments) throws ParseException {
		CommandLineParser parser = new BasicParser();
		
		options.addOption(OptionBuilder.withArgName("file")
                .hasArg()
                .withDescription("Group contacts file in CSV format." )
                .create(FILE_OPTION));
		
		options.addOption(PRINT_COMPANIES_OPTION, false, "List unique contacts' company names.");
		options.addOption(PRINT_USERS_OPTION, false, "List unique contacts' user names.");
		options.addOption(PRINT_HELP_OPTION, false, "Show this message.");
		
		return parser.parse(options, aruments);
	}
	
	static void handleCommandLineOptions(CommandLine commandLine) throws Exception {
		ContactsController contactsController = new ContactsController();
		
		if (commandLine.hasOption(PRINT_HELP_OPTION)) {
			printHelpMessage();
		} else {
		
			if (commandLine.hasOption(FILE_OPTION)) {
				String fileName = commandLine.getOptionValue(FILE_OPTION);
				
				contactsController.createModelFromFile(fileName);
				
				if (commandLine.hasOption(PRINT_COMPANIES_OPTION)) {
					contactsController.displayUniqueSortedComanyNames();
				} 
				
				if (commandLine.hasOption(PRINT_USERS_OPTION)) {
					contactsController.displayAllUserNamesSorted();
				}
			} else {
				printHelpMessage();
			}
		}
	}
	
	static void printHelpMessage() {
		HelpFormatter formatter = new HelpFormatter();
		
		formatter.printHelp("ContactsFileViewer", options);
	}
	
	static void handleException(Exception exception) {
		System.out.println(exception.getMessage());
		
		exception.printStackTrace();
	}
}
