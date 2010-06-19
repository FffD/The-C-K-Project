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
	public final static String initialC = "Entrez un C0, tapez Entr\u00E9e pour valider";
	public final static String initialK = "Entrez un K0, tapez Entr\u00E9e pour valider";
	public final static String inputCorK = "Pour ajouter une connaissance, tapez K \nPour partitionner un concept, tapez C \n";
	public final static String inputK = "Entrez un Knowledge, tapez Entr\u00E9e pour valider";
	public final static String inputC = "Entrez un Concept, tapez Entr\u00E9e pour valider";
	public final static String inputLinkCtoK = "Si cette connaissance \u00E0 un lien avec un des concept suivants, entrez le num\u00E9ro du concept, sinon tapez -1, suivi d'Entr\u00E9e";
	public final static String inputCtoPartition = "Quel concept voulez vous partitionner? Entrez le num\u00E9ro et tapez Entr\u00E9e";
	public final static String inputKtoPartitionC = "Quelle connaissance vous permet de partitionner ?"+NEW_LINE+"Entrez le num\u00E9ro et tapez Entr\u00E9e ou -1 ajouter une connaissance manquante";
	public final static String inputContinueQuestion = "Voulez-vous continuer ?";

	/** Error messages **/
	public final static String errorInput = "Mauvaise saisie !";
	public final static String errorFileRead = "probleme de lecture";

}
