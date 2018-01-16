package fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.presentation.modele;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.gouv.education.sirhen.ct.commun.presentation.modele.IModele;

/**
 * Modèle UI.
 */
public class UIModele implements IModele {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	/** Le logger. */
	private static Logger logger = LoggerFactory.getLogger(UIModele.class);

	/**
	 * Menu courant.
	 */
	private String menuCourant;

	/**
	 * Constructeur.
	 */
	public UIModele() {
		logger.info("Initialisation de UIModele ...");
	}

	/**
	 * Accesseur en lecture de l'attribut <code>menuCourant</code>.
	 * 
	 * @return Menu courant visité par l'utilisateur.
	 */
	public final String getMenuCourant() {
		return menuCourant;
	}

	/**
	 * Accesseur en écriture de l'attribut <code>menuCourant</code>.
	 * 
	 * @param menuCourant
	 *            Menu courant visité par l'utilisateur.
	 */
	public final void setMenuCourant(final String menuCourant) {
		this.menuCourant = menuCourant;
	}

}
