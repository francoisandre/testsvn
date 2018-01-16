package fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.transverse.constantes;

/**
 * Interface IMessages.
 * 
 */
public interface IMessages {
	/**
	 * La clé du projet.
	 */
	String CLE_PROJECTID = "gin.gestiondescontratsdesnontitulaires.mapi";

	/**
	 * La clé de la création Agent.
	 */
	String CLE_AGENT_CREATION_OK = "gin.gestiondescontratsdesnontitulaires.mapi.msg.ihm.001";
	/**
	 * La clé de la modification Agent.
	 */
	String CLE_AGENT_MODIFICATION_OK = "gin.gestiondescontratsdesnontitulaires.mapi.msg.ihm.002";
	/**
	 * La clé du Message erreur commun.
	 */
	String CLE_MSG_ERREUR_COMMUN = "gin.gestiondescontratsdesnontitulaires.mapi.msg.ihm.003";
	/**
	 * La clé de la création de l'affectation.
	 */
	String CLE_AFFECTATION_CREATION_OK = "gin.gestiondescontratsdesnontitulaires.mapi.msg.ihm.004";

	/**
	 * préfixe des codes d'erreur de l'application.
	 */
	String CODE_ERR_APPLI = CLE_PROJECTID + ".err";

	/**
	 * La clé de l'erreur de la suppression IHM.
	 */
	String CLE_IHM_ERR_SUPPRESSION = "gin.gestiondescontratsdesnontitulaires.mapi.err.ihm.001";
	/**
	 * La clé de l'erreur de l'affectation IHM.
	 */
	String CLE_IHM_ERR_AFFECTATION = "gin.gestiondescontratsdesnontitulaires.mapi.err.ihm.002";
	/**
	 * La clé de l'erreur du dépot de la piece jointe IHM.
	 */
	String CLE_IHM_ERR_PJ = "gin.gestiondescontratsdesnontitulaires.mapi.err.ihm.003";

	/**
	 * La clé de NAV.
	 */
	String CLE_NAV = "NaV";

}
