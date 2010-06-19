package application;

public final class Consts {

	public static final int NOT_FOUND = -1;
	/** System property - <tt>line.separator</tt>*/
	public static final String NEW_LINE = System.getProperty("line.separator");
	/** System property - <tt>file.separator</tt>*/
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	/** System property - <tt>path.separator</tt>*/
	public static final String PATH_SEPARATOR = System.getProperty("path.separator");
	
	
	/** Input Strings **/
	public final static String initialC = "Enter your C0 and press return to validate";
	public final static String initialK = "Enter your K0 and press return to validate";
	public final static String inputCorK = "To add some knowledge please press K\nTo partition a concept please press C\n";
	public final static String inputK = "Enter some knowledge and press return to validate";
	public final static String inputC = "Enter a concept and press return to validate";
	public final static String inputLinkCtoK = "If this knowledge has a link with one of the following concepts please enter the concept's number, otherwise enter -1 and press return to validate";
	public final static String inputCtoPartition = "Witch of the following concepts do you wish to partition? enter it's number and press return to validate";
	public final static String inputKtoPartitionC = "What knowledge allows you to partition?"+NEW_LINE+"Enter it's number and press return or enter -1 to add a missing knowledge for your partition!";
	public final static String inputContinueQuestion = "Do you want to continue ?";

	/** Error messages **/
	public final static String errorInput = "Error in the input!";
	public final static String errorFileRead = "Error in reading the file!";

}
