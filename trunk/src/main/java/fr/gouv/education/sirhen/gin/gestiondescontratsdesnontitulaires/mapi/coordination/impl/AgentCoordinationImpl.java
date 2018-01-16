package fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.coordination.impl;

import java.util.Collection;
import java.util.List;

import fr.gouv.education.sirhen.abl.dua.mas.ws.client.agentservice.IAgentService;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.Agent;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.AgentLeger;
import fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.coordination.IAgentCoordination;
import fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.utils.Configuration;
import fr.gouv.education.sirhen.ct.commun.coordination.AbstractCoordinationImpl;
import fr.gouv.education.sirhen.ct.commun.transverse.exception.FonctionnelleException;
import fr.gouv.education.sirhen.ct.gestionnomenclature.service.INomenclatureService;
import fr.gouv.education.sirhen.ct.gestionnomenclature.transverse.vo.IElement;

/**
 * 
 */
public class AgentCoordinationImpl extends AbstractCoordinationImpl implements IAgentCoordination {

	/**
	 * client appelant le MAS.
	 */
	private IAgentService clientDUA;

	/** Client Nomenclature. */
	private INomenclatureService clientNomenclature;

	/** Interface Configuration. */
	private Configuration config;

	/**
	 * Accesseur en lecture de l'attribut clientDUA.
	 * 
	 * @return client appelant le MAS.
	 */
	public final IAgentService getClientDUA() {
		return clientDUA;
	}

	/**
	 * Accesseur en écriture de l'attribut clientDUA.
	 * 
	 * @param clientDUA
	 *            client appelant le MAS.
	 */
	public final void setClientDUA(final IAgentService clientDUA) {
		this.clientDUA = clientDUA;
	}

	/**
	 * Accesseur en écriture de l'attribut <code>clientNomenclature</code>.
	 * 
	 * @param clientNomenclature
	 *            L'attribut clientNomenclature à modifier.
	 */
	public final void setClientNomenclature(final INomenclatureService clientNomenclature) {
		this.clientNomenclature = clientNomenclature;
	}

	/**
	 * Accesseur en écriture de l'attribut <code>config</code>.
	 * 
	 * @param config
	 *            L'attribut config à modifier.
	 */
	public final void setConfig(final Configuration config) {
		this.config = config;
	}

	/**
	 * {@inheritDoc}
	 */
	public final Agent creerAgent(final Agent agent) throws FonctionnelleException {
		return clientDUA.creerAgent(agent);
	}

	/**
	 * {@inheritDoc}
	 */
	public final Agent modifierAgent(final Agent agent) throws FonctionnelleException {
		return clientDUA.modifierAgent(agent);
	}

	/**
	 * {@inheritDoc}
	 */
	public final Agent rechercherAgentParNumen(final String numen) throws FonctionnelleException {
		return clientDUA.rechercherAgentParNumen(numen);
	}

	/**
	 * {@inheritDoc}
	 */
	public final Agent rechercherAgentParId(final long idAgent) throws FonctionnelleException {
		return clientDUA.rechercherAgentParId(idAgent);
	}

	/**
	 * {@inheritDoc}
	 */
	public final List < AgentLeger > rechercherAgent(final AgentLeger agentLeger, final int index, final int quantite)
		throws FonctionnelleException {
		return clientDUA.rechercherAgent(agentLeger, index, quantite);
	}

	/**
	 * {@inheritDoc}
	 */
	public final void supprimerAgents(final Collection < AgentLeger > agentLegers) throws FonctionnelleException {
		for (AgentLeger agentLeger : agentLegers) {
			clientDUA.supprimerAgent(agentLeger.getId());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Collection < ? extends IElement > rechercherCiviliteListeElements() {
		return clientNomenclature.rechercherElementsCourant(config.getOrigManSirhen(), config.getCodeCivilite());
	}
}
