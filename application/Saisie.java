package application;
import java.io.*;

public class Saisie {
	public static String saisieChaine() {
		String valeur;
		try {		
			BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
			valeur = entree.readLine();
			return (valeur);
		}
		catch (IOException e) {
			System.out.println ("probleme de lecture");
			return ("");
		}
	}

		public static int saisieValeur(){
			String valeur	;
			try {
				BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
				valeur = entree.readLine();
				int choix = Integer.parseInt(valeur,10);
				return (choix);
			}
			catch (IOException e) {
				System.out.println ("probleme de lecture");
				return (0);
			}
		}
	}
