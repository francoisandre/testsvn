package fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.presentation.modele;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.Adresse;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.Agent;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.AgentLeger;
import fr.gouv.education.sirhen.ct.commun.presentation.modele.AbstractCourantImpl;
import fr.gouv.education.sirhen.ct.commun.presentation.modele.IModele;

/**
 * Modèle agent.
 */
public class AgentModele extends AbstractCourantImpl < Agent, AgentLeger > implements IModele {

	/** Serial. */
	private static final long serialVersionUID = 1L;

	/** Le logger. */
	private static Logger logger = LoggerFactory.getLogger(AgentModele.class);

	/**
	 * Flag pour l'acces au service du DIF.
	 */
	private boolean accesDifAuthorise;

	/**
	 * Flag pour l'acces au service de consultation des agents.
	 */
	private boolean accesConsultationAgentsAuthorise;

	/**
	 * Flag pour l'acces au service de modification des agents.
	 */
	private boolean accesModificationAgentsAuthorise;

	/**
	 * Flag pour l'acces au service de suppression des agents.
	 */
	private boolean accesSuppressionAgentsAuthorise;

	/**
	 * Flag pour l'acces au service de creation des agents.
	 */
	private boolean accesCreationAgentsAuthorise;

	/**
	 * Flag pour l'acces au service de creation des agents.
	 */
	private boolean accesResultatsRechercheAuthorise;

	/**
	 * Contructeur.
	 */
	public AgentModele() {
		logger.info("Initialisation du modele ...");
	}

	/**
	 * Accesseur en lecture de l'attribut accesDifAuthorise.
	 * 
	 * @return Acces au service DIF.
	 */
	public final boolean isAccesDifAuthorise() {
		return accesDifAuthorise;
	}

	/**
	 * Accesseur en écriture de l'attribut accesDifAuthorise.
	 * 
	 * @param accesDifAuthorise
	 *            Acces au service DIF.
	 */
	public final void setAccesDifAuthorise(final boolean accesDifAuthorise) {
		this.accesDifAuthorise = accesDifAuthorise;
	}

	/**
	 * Accesseur en lecture de l'attribut accesConsultationAgentsAuthorise.
	 * 
	 * @return Acces au service de consultation des agents.
	 */
	public final boolean isAccesConsultationAgentsAuthorise() {
		return accesConsultationAgentsAuthorise;
	}

	/**
	 * Accesseur en écriture de l'attribut accesConsultationAgentsAuthorise.
	 * 
	 * @param accesConsultationAgentsAuthorise
	 *            Acces au service de consultation des agents.
	 */
	public final void setAccesConsultationAgentsAuthorise(final boolean accesConsultationAgentsAuthorise) {
		this.accesConsultationAgentsAuthorise = accesConsultationAgentsAuthorise;
	}

	/**
	 * Accesseur en lecture de l'attribut accesModificationAgentsAuthorise.
	 * 
	 * @return Acces au service de modification des agents.
	 */
	public final boolean isAccesModificationAgentsAuthorise() {
		return accesModificationAgentsAuthorise;
	}

	/**
	 * Accesseur en écriture de l'attribut accesModificationAgentsAuthorise.
	 * 
	 * @param accesModificationAgentsAuthorise
	 *            Acces au service de modification des agents.
	 */
	public final void setAccesModificationAgentsAuthorise(final boolean accesModificationAgentsAuthorise) {
		this.accesModificationAgentsAuthorise = accesModificationAgentsAuthorise;
	}

	/**
	 * Accesseur en lecture de l'attribut accesSuppressionAgentsAuthorise.
	 * 
	 * @return Acces au service de suppression des agents.
	 */
	public final boolean isAccesSuppressionAgentsAuthorise() {
		return accesSuppressionAgentsAuthorise;
	}

	/**
	 * Accesseur en écriture de l'attribut accesSuppressionAgentsAuthorise.
	 * 
	 * @param accesSuppressionAgentsAuthorise
	 *            Acces au service de suppression des agents.
	 */
	public final void setAccesSuppressionAgentsAuthorise(final boolean accesSuppressionAgentsAuthorise) {
		this.accesSuppressionAgentsAuthorise = accesSuppressionAgentsAuthorise;
	}

	/**
	 * Accesseur en lecture de l'attribut accesCreationAgentsAuthorise.
	 * 
	 * @return Acces au service de création des agents.
	 */
	public final boolean isAccesCreationAgentsAuthorise() {
		return accesCreationAgentsAuthorise;
	}

	/**
	 * Accesseur en écriture de l'attribut accesCreationAgentsAuthorise.
	 * 
	 * @param accesCreationAgentsAuthorise
	 *            Acces au service de création des agents.
	 */
	public final void setAccesCreationAgentsAuthorise(final boolean accesCreationAgentsAuthorise) {
		this.accesCreationAgentsAuthorise = accesCreationAgentsAuthorise;
	}

	/**
	 * Accesseur en lecture de l'attribut accesResultatsRechercheAuthorise.
	 * 
	 * @return Acces au formulaire resultats de recherche.
	 */
	public final boolean isAccesResultatsRechercheAuthorise() {
		return accesResultatsRechercheAuthorise;
	}

	/**
	 * Accesseur en écriture de l'attribut accesResultatsRechercheAuthorise.
	 * 
	 * @param accesResultatsRechercheAuthorise
	 *            Acces au formulaire resultats de recherche.
	 */
	public final void setAccesResultatsRechercheAuthorise(final boolean accesResultatsRechercheAuthorise) {
		this.accesResultatsRechercheAuthorise = accesResultatsRechercheAuthorise;
	}

	/**
	 * {@inheritDoc}
	 */
	public final Agent createNewObject() {
		Agent ret = new Agent();
		ret.setAdresse(new Adresse());
		return ret;
	}

	/**
	 * {@inheritDoc}
	 */
	public final void purge() {
		super.purge();
	}

}
