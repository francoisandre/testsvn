package fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.presentation.controleur;

import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.Adresse;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.Agent;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.AgentLeger;
import fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.coordination.IAgentCoordination;
import fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.presentation.modele.AgentModele;
import fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.presentation.vue.AgentVue;
import fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.transverse.constantes.IMessages;
import fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.transverse.constantes.IPages;
import fr.gouv.education.sirhen.ct.commun.presentation.controleur.AbstractControleurImpl;
import fr.gouv.education.sirhen.ct.commun.transverse.exception.FonctionnelleException;
import fr.gouv.education.sirhen.ct.gestionnomenclature.presentation.controleur.util.NomenclatureJSFUtil;
import fr.gouv.education.sirhen.ct.gestionnomenclature.transverse.vo.IElement;

/**
 * Controleur Agent.
 */
public final class AgentControleur extends AbstractControleurImpl < AgentModele, AgentVue < AgentLeger >, IAgentCoordination > {

	/** Serial. */
	private static final long serialVersionUID = 1420020980516133722L;

	/** Le logger. */
	private static Logger logger = LoggerFactory.getLogger(AgentControleur.class);

	/** L'id de l'agent courant. */
	private Long idAgent = null;

	/** Nombre d'agent à remonter au maximum. */
	private static final int MAX_AGENT_RECHERCHE = 20;

	/** Log d'erreur. */
	private static final String ERR_LOG = "Probleme : ";

	/**
	 * Accesseur en lecture de l'attribut <code>idAgent</code>.
	 * 
	 * @return L'attribut idAgent à lire.
	 */
	public Long getIdAgent() {
		return idAgent;
	}

	/**
	 * Accesseur en écriture de l'attribut <code>idAgent</code>.
	 * 
	 * @param idAgent
	 *            L'attribut idAgent à modifier.
	 */
	public void setIdAgent(final Long idAgent) {
		this.idAgent = idAgent;
	}

	/**
	 * Constructeur.
	 */
	public AgentControleur() {
	}

	/**
	 * Service de recherche des personnes appelant le MAS.
	 * 
	 * @return La page rechercher Agent.
	 */

	public String rechercheAgents() {
		try {
			logger.info("Recherche des agents ");
			Agent agent = getModele().getRecherche();

			AgentLeger al = new AgentLeger();
			al.setNom(agent.getNom());
			al.setPrenom(agent.getPrenom());
			al.setNumen(agent.getNumen());

			List < AgentLeger > lAgentsLeger = getCoordination().rechercherAgent(al, 0, MAX_AGENT_RECHERCHE);
			getModele().setListe(lAgentsLeger);
			getModele().setAccesResultatsRechercheAuthorise(true);
			return IPages.PAGE_RECHERCHE_AGENTS;
		} catch (FonctionnelleException e) {
			logger.error(ERR_LOG, e);
			ajoutMessageErreur(e, IMessages.CODE_ERR_APPLI);
		}
		return IPages.MEME_PAGE;
	}

	/**
	 * Service de création d'un nouvel agent appelant le MAS.
	 * 
	 * @return null.
	 */
	public String creerAgent() {

		try {
			Agent agentCree = getCoordination().creerAgent(getModele().getCourant());

			getModele().setAccesCreationAgentsAuthorise(false);
			ajoutMessage(FacesMessage.SEVERITY_INFO, IMessages.CLE_AGENT_CREATION_OK, agentCree.getNumen());

			getModele().setCourant(null);
		} catch (FonctionnelleException e) {
			logger.error(ERR_LOG, e);
			ajoutMessageErreur(e, IMessages.CODE_ERR_APPLI);
		}

		return IPages.MEME_PAGE;
	}

	/**
	 * Service de mise a jour d'un agent existant.
	 * 
	 * @return null.
	 */
	public String sauvegardeModificationAgent() {
		try {
			Agent ret = getCoordination().modifierAgent(getModele().getCourant());
			// Maj Objet dans le modele
			getModele().setCourant(ret);
		} catch (FonctionnelleException e) {
			logger.error(ERR_LOG, e);
			ajoutMessageErreur(e, IMessages.CODE_ERR_APPLI);
		}

		return IPages.MEME_PAGE;
	}

	/**
	 * Service d'extraction des données d'un agent pour la consultation.
	 * 
	 * @return La page modifier Agent.
	 */
	public String modifierAgent() {
		try {
			mettreAJourAgentCourant();
			return IPages.PAGE_MODIFICATION_AGENT;
		} catch (FonctionnelleException e) {
			logger.error(ERR_LOG, e);
			ajoutMessageErreur(e, IMessages.CODE_ERR_APPLI);
		}
		return IPages.MEME_PAGE;
	}

	/**
	 * Service d'extraction des données d'un agent pour la consultation.
	 * 
	 * @return La page consulter Agent .
	 */
	public String consulterAgent() {
		try {
			mettreAJourAgentCourant();
			return IPages.PAGE_CONSULTATION_AGENT;
		} catch (FonctionnelleException e) {
			logger.error(ERR_LOG, e);
			ajoutMessageErreur(e, IMessages.CODE_ERR_APPLI);
		}
		return IPages.MEME_PAGE;
	}

	/**
	 * Service de suppression des agents sélectionnés appelant le MAS.
	 * 
	 * @return null.
	 */

	public String supprimerAgents() {
		try {
			List < AgentLeger > listeSupprimer = getVue().getListSelected();
			// Suppression dans la BDD
			getCoordination().supprimerAgents(listeSupprimer);
			// Suppression dans le model
			getModele().getListe().removeAll(listeSupprimer);
		} catch (FonctionnelleException e) {
			logger.error(ERR_LOG, e);
			ajoutMessageErreur(e, IMessages.CODE_ERR_APPLI);
		}
		return IPages.MEME_PAGE;
	}

	/**
	 * Met a jour les données de l'agent courant au cas où elles auraient été modifiées en base.
	 * 
	 * @throws FonctionnelleException
	 *             Exception Fonctionnelle.
	 */
	private void mettreAJourAgentCourant() throws FonctionnelleException {
		Agent courant = null;
		if (idAgent != null) { // Mode Rest
			courant = getCoordination().rechercherAgentParId(idAgent);
		} else {
			AgentLeger selectione = getVue().getSelected();
			courant = getCoordination().rechercherAgentParId(selectione.getId());
		}

		if (courant.getAdresse() == null) {
			courant.setAdresse(new Adresse());
		}
		getModele().setCourant(courant);
	}

	/**
	 * Initiliase l'agent courant avant d'envoyer l'ecran de saisie.
	 * 
	 * @return La page créer Agent.
	 */
	public String saisieAgent() {
		getModele().setCourant(null);
		getModele().setAccesCreationAgentsAuthorise(true);
		return IPages.PAGE_CREATION_AGENT;
	}

	/**
	 * Appelée quand l'utilisateur souhaite rechercher des agents (pour la consultation de leurs données).
	 * 
	 * @return La page rechercher Agent.
	 */
	public String saisieCritereRechercheAgents() {
		getModele().setAccesConsultationAgentsAuthorise(true);
		getModele().setAccesModificationAgentsAuthorise(true);
		getModele().setAccesDifAuthorise(false);
		getModele().setAccesSuppressionAgentsAuthorise(false);
		getModele().setAccesResultatsRechercheAuthorise(false);

		getModele().purge();
		return IPages.PAGE_RECHERCHE_AGENTS;
	}

	/**
	 * Appelée quand l'utilisateur souhaite rechercher des agents (pour les supprimer).
	 * 
	 * @return La page rechercher Agent.
	 */
	public String saisieCritereRechercheAgentsSuppression() {
		getModele().setAccesConsultationAgentsAuthorise(false);
		getModele().setAccesModificationAgentsAuthorise(false);
		getModele().setAccesDifAuthorise(false);
		getModele().setAccesSuppressionAgentsAuthorise(true);
		getModele().setAccesResultatsRechercheAuthorise(false);

		getModele().purge();
		return IPages.PAGE_RECHERCHE_AGENTS;
	}

	/**
	 * Appelée quand l'utilisateur souhaite rechercher des agents (pour la consultation de leurs comptes DIF).
	 * 
	 * @return La page rechercher Agent.
	 */
	public String saisieCritereRechercheDIF() {
		getModele().setAccesConsultationAgentsAuthorise(false);
		getModele().setAccesModificationAgentsAuthorise(false);
		getModele().setAccesDifAuthorise(true);
		getModele().setAccesSuppressionAgentsAuthorise(false);
		getModele().setAccesResultatsRechercheAuthorise(false);

		getModele().purge();
		return IPages.PAGE_RECHERCHE_AGENTS;
	}

	/**
	 * Appelée pour annuler l'operation et reinitialiser le formulaire.
	 * 
	 * @return La page créer Agent.
	 */
	public String annulerCreationAgent() {
		getModele().setCourant(null);
		return IPages.PAGE_CREATION_AGENT;
	}

	/**
	 * Service de verification de la selection des agents à supprimer.
	 * 
	 * @return null.
	 */
	public String verifierCheckbox() {
		List < AgentLeger > listeSupprimer = getVue().getListSelected();
		if (listeSupprimer == null || listeSupprimer.isEmpty()) {
			logger.error("Probleme : La selection d’au moins un agent est obligatoire.");
			ajoutMessageErreur(IMessages.CLE_IHM_ERR_SUPPRESSION);
		}
		return IPages.MEME_PAGE;
	}

	/**
	 * Récupere la nomenclature CIVILITE à partir d'un action ajax.
	 * 
	 * @param event
	 *            L'event qui a déclanché le traitement
	 */
	public void civiliteListeActionListener(final ActionEvent event) {

		Collection < ? extends IElement > civiliteElems = getCoordination().rechercherCiviliteListeElements();
		vue.getCiviliteListeItems().setValue(NomenclatureJSFUtil.convertionNomencatureToSelectItem(civiliteElems));

	}

}
