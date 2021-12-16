package metier;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import beans.Utilisateur;
import dao.UtilisteurDao;

public class ModifierUser {
	private static final String CHAMP_ID = "id";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	
	private boolean status ;
	private String statusMessage;
	private Utilisateur utilisateur;
	private HttpServletRequest request;
	private Map<String, String> erreurs;
	
	public ModifierUser(HttpServletRequest request) {
		this.status = false;
		this.request = request;
		this.erreurs = new HashMap<>();
	}
	public boolean modifer() {
		
		String id = request.getParameter(CHAMP_ID);
		String nom = getParameter(CHAMP_NOM);
		String prenom = getParameter(CHAMP_PRENOM);
		String login = getParameter(CHAMP_LOGIN);
		String password = getParameter(CHAMP_PASSWORD);
		
		utilisateur = new Utilisateur(nom, prenom, login, password);
		
		validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		validerPasswords();
		
		if(erreurs.isEmpty()) {
			if(id !=null && id.matches("[0-9]+")) {
				Utilisateur utilisateur = new  Utilisateur(Integer.parseInt(id), nom, prenom, login,password);
				status = UtilisteurDao.modifier(utilisateur);
			}
			if(status) {
				statusMessage  = "modification bi dialeuna bou bakh";
				
				return true;
			}
			else {
				statusMessage = "Echec de la mofication ";
				return false;
			}
		}
		return false;
		 
			
		
	}
     private String getParameter(String parametre) {
		
		String valeur = request.getParameter(parametre);
		
		if(valeur == null || valeur.trim().isEmpty()) {
			return null;
		}
		return valeur.trim();
	}
     private void validerChamps(String ...champs) {
 		
 		for (String champ : champs) {
 			if(getParameter(champ) == null) {
 				
 				erreurs.put(champ, "Vous devez renseigner ce champ");
 			}
 		}
 	}
 	
 	private void validerPasswords() {
 		
 		String password = getParameter(CHAMP_PASSWORD);
 		String passwordBis  = getParameter(CHAMP_PASSWORD_BIS);
 		
 		if(password != null && !password.equals(passwordBis)) {
 			erreurs.put(CHAMP_PASSWORD,"Les mots de passe ne sont pas conformes");
 			erreurs.put(CHAMP_PASSWORD_BIS,"Les mots de passe ne sont pas conformes");
 		}
 	}
	public String getStatusMessage() {
		
		return null;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}
	
}
