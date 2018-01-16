package fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.coordination;

import java.util.Collection;
import java.util.List;

import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.Agent;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.AgentLeger;
import fr.gouv.education.sirhen.ct.commun.coordination.ICoordination;
import fr.gouv.education.sirhen.ct.commun.transverse.exception.FonctionnelleException;
import fr.gouv.education.sirhen.ct.gestionnomenclature.transverse.vo.IElement;

/**
 * Interface de AgentCoordination.
 * 
 */
public interface IAgentCoordination extends ICoordination {

	/**
	 * Service de création d'un Agent appelant le MAS.
	 * 
	 * @param agent
	 *            Entité Agent à créer.
	 * @return L'Agent créé.
	 * @throws FonctionnelleException
	 *             Exception fonctionnelle.
	 */
	Agent creerAgent(Agent agent) throws FonctionnelleException;

	/**
	 * Service de modification d'un Agent appelant le MAS.
	 * 
	 * @param agent
	 *            Entité Agent à modifier.
	 * @return L'Agent modifié.
	 * @throws FonctionnelleException
	 *             Exception fonctionnelle.
	 */
	Agent modifierAgent(Agent agent) throws FonctionnelleException;

	/**
	 * Service de récupération d'un Agent par son Numen appelant le MAS.
	 * 
	 * @param numen
	 *            Numen de l'Agent recherché.
	 * @return L'Agent recherché.
	 * @throws FonctionnelleException
	 *             Exception fonctionnelle.
	 * @throws FonctionnelleException
	 *             Exception fonctionnelle
	 */
	Agent rechercherAgentParNumen(String numen) throws FonctionnelleException;

	/**
	 * Service de recherche d'un Agent par son ID appelant le MAS.
	 * 
	 * @param idAgent
	 *            Identifiant de l'Agent recherché.
	 * @return L'Agent recherché.
	 * @throws FonctionnelleException
	 *             Exception fonctionnelle.
	 */
	Agent rechercherAgentParId(long idAgent) throws FonctionnelleException;

	/**
	 * Service de pagination pour la recherche des Agent appelant le MAS.
	 * 
	 * @param agentLeger
	 *            Agent à rechercher.
	 * @param index
	 *            Indicateur de début de la pagination de la recherche.
	 * @param quantite
	 *            Nombre de résultat attendu.
	 * @return Liste d'Agentleger recherchés.
	 * @throws FonctionnelleException
	 *             Exception fonctionnelle.
	 */
	List < AgentLeger > rechercherAgent(AgentLeger agentLeger, int index, int quantite) throws FonctionnelleException;

	/**
	 * Service de suppression en masse des Agents par appel au MAS.
	 * 
	 * @param agentLegers
	 *            Collection d'agents à supprimer.
	 * @throws FonctionnelleException
	 *             Exception fonctionnelle.
	 */
	void supprimerAgents(Collection < AgentLeger > agentLegers) throws FonctionnelleException;

	/**
	 * renvoie la liste des éléments d'une nomenclature passée en paramètre.
	 * 
	 * @return la liste des elements.
	 */
	Collection < ? extends IElement > rechercherCiviliteListeElements();
}
