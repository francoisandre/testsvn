package fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.service.bouchon;

import java.util.ArrayList;
import java.util.List;

import fr.gouv.education.sirhen.abl.dua.mas.ws.client.agentservice.IAgentService;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.Agent;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.AgentLeger;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.PieceJointe;
import fr.gouv.education.sirhen.ct.commun.transverse.DateUtils;
import fr.gouv.education.sirhen.ct.commun.transverse.exception.FonctionnelleException;

/**
 * Bouchon Agent Service.
 * 
 */
public class AgentServiceBouchon implements IAgentService {

	/** Exception fonctionnelle. */
	private final FonctionnelleException exception = new FonctionnelleException();

	/** Préfixe code. */
	private static final String PREFIXE_CODE = "abl.dua.mas";

	/** Constante sept. */
	private static final int SEPT = 7;

	/** Constante trois. */
	private static final int TROIS = 3;

	/**
	 * {@inheritDoc}
	 */
	public final Agent creerAgent(final Agent agent) throws FonctionnelleException {
		if (agent.getNom() != null && agent.getNom().startsWith(PREFIXE_CODE)) {
			exception.setCode(agent.getNom());
			throw exception;
		} else {
			agent.setId(1L);
			genererNumen(agent);
		}
		return agent;
	}

	/**
	 * {@inheritDoc}
	 */
	public final Agent modifierAgent(final Agent agent) throws FonctionnelleException {
		if (agent.getNom() != null && agent.getNom().startsWith(PREFIXE_CODE)) {
			exception.setCode(agent.getNom());
			throw exception;
		}
		return agent;
	}

	/**
	 * {@inheritDoc}
	 */
	public final List < AgentLeger > rechercherAgent(final AgentLeger al, final int debut, final int quantite)
		throws FonctionnelleException {
		List < AgentLeger > listeAgent = new ArrayList < AgentLeger >();
		AgentLeger agentLeger = new AgentLeger();
		agentLeger.setNom(al.getNom());
		agentLeger.setPrenom(al.getPrenom());
		agentLeger.setNumen(al.getNumen());

		listeAgent.add(agentLeger);
		return listeAgent;
	}

	/**
	 * {@inheritDoc}
	 */
	public final Agent rechercherAgentParNumen(final String numen) throws FonctionnelleException {
		Agent agent = new Agent();
		if (numen != null && numen.startsWith(PREFIXE_CODE)) {
			exception.setCode(numen);
			throw exception;
		} else {
			Long idAgent = new Long(numen.substring(TROIS));
			agent.setNumen(numen);
			agent.setId(idAgent);
		}
		return agent;
	}

	/**
	 * Génére un numen.
	 * <p>
	 * Le numen est un champ est defini par la concaténation des données suivantes : année civile en cours(sur 2 caractères), « N
	 * », Numéro incrémental (sur 7 caractères) (cf. RGM-GIA-CRE-04).
	 * 
	 * @param agent
	 *            Entité Agent traité.
	 * @throws FonctionnelleException
	 *             Les exceptions foctionnelles.
	 */
	public final void genererNumen(final Agent agent) throws FonctionnelleException {
		String annee = DateUtils.getAAAA().substring(2);
		String idAgent = agent.getId().toString();
		while (idAgent.length() < SEPT) {
			idAgent = "0" + idAgent;
		}
		agent.setNumen(annee + "N" + idAgent);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deposerPieceJointe(final long idAgent, final PieceJointe pieceJointe) throws FonctionnelleException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	public final Agent rechercherAgentParId(final long idAgent) throws FonctionnelleException {
		Agent agent = new Agent();
		agent.setId(idAgent);
		agent.setNom("Nom " + idAgent);
		agent.setPrenom("Prénom " + idAgent);
		return agent;
	}

	/**
	 * {@inheritDoc}
	 */
	public final List < PieceJointe > recupererPieceJointe(final long idAgent) throws FonctionnelleException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void supprimerAgent(final long idAgent) throws FonctionnelleException {

	}

}
