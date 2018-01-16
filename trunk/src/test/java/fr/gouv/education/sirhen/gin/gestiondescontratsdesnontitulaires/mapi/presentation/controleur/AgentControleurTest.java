package fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.presentation.controleur;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIData;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.Agent;
import fr.gouv.education.sirhen.abl.dua.mas.ws.client.types.AgentLeger;
import fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.coordination.IAgentCoordination;
import fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.presentation.modele.AgentModele;
import fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.transverse.constantes.IPages;
import fr.gouv.education.sirhen.ct.commun.test.ihm.AbstractSirhenJSFTest;

/**
 * Tests controleur agent.
 */
@ContextConfiguration(locations = {"classpath*:spring/ct-gestion-nomenclature-junit-context.xml",
	"classpath*:spring/ct-identification-junit-context.xml", "classpath*:spring/ct-annuaire-service-junit-context.xml",
	"classpath*:spring/application-context.xml", "classpath*:spring/test/client-bouchon-context.xml",
	"classpath*:spring/coordination-context.xml", "classpath*:spring/tech-context.xml", "classpath*:spring/j2se-context.xml" })
@RunWith(value = SpringJUnit4ClassRunner.class)
public class AgentControleurTest extends AbstractSirhenJSFTest {

	/**
	 * Injecté par spring et sera injecté dans AgentControleur dans setUp.
	 */
	@Autowired
	private IAgentCoordination agentCoordination;

	/** Controleur agent. */
	private AgentControleur agentControleur;

	/** Code. */
	private static final String CODE_AGENT_EXISTE = "abl.dua.mas.006";

	/** Message buddle. */
	private final String messageBundle = "properties.messages_code";

	/**
	 * Méthode lancée avant chaque test.
	 * 
	 * @throws Exception
	 *             Les exceptions
	 */
	@Before
	@Override
	public final void setUp() throws Exception {
		super.setUp();

		facesContext.getApplication().setMessageBundle(messageBundle);
		agentControleur = new AgentControleur();
		agentControleur.setModele(new AgentModele());
		agentControleur.setCoordination(agentCoordination);
	}

	/**
	 * Méthode lancée après chaque test.
	 * 
	 * @throws Exception
	 *             Les exceptions
	 */
	@After
	@Override
	public final void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test la recherche agent dans le cas nominal.
	 */
	@Test
	public final void rechercherAgentNominal() {

		Calendar dateNaissance = Calendar.getInstance();
		final int year = 1976;
		final int month = 05;
		final int day = 01;
		dateNaissance.set(year, month, day);

		// Formulaire de recherche
		Assert.assertEquals(IPages.PAGE_RECHERCHE_AGENTS, agentControleur.saisieCritereRechercheAgents());
		checkMessageCount(0);

		// Recherche agentControleur.getModele().getCourant().setNom("nom");
		agentControleur.getModele().getCourant().setPrenom("prenom");
		agentControleur.getModele().getCourant().setDateNaissance(dateNaissance);
		Assert.assertEquals(IPages.PAGE_RECHERCHE_AGENTS, agentControleur.rechercheAgents());

		checkMessageCount(0);
		Assert.assertTrue(agentControleur.getModele().getListe().size() > 0);

	}

	/**
	 * Test la consultation agent dans le cas nominal.
	 */
	@Test
	public final void consulterAgentNominal() {

		UIData data = new UIData() {
			@Override
			public Object getRowData() {
				AgentLeger a = new AgentLeger();
				a.setId(2L);
				a.setNom("aaaa");
				return a;
			}
		};

		agentControleur.getVue().setDataTable(data);

		Assert.assertEquals(IPages.PAGE_CONSULTATION_AGENT, agentControleur.consulterAgent());

		checkMessageCount(0);
	}

	/**
	 * Test la création d'agent dans le cas nominal.
	 */
	@Test
	public final void creerAgentNominal() {

		Agent agent = agentControleur.getModele().getCourant();
		agent.setNom("nom" + System.currentTimeMillis());
		agent.setPrenom("prenom");
		agent.setCivilite("M.");
		agent.setDateNaissance(Calendar.getInstance());

		Assert.assertEquals(null, agentControleur.creerAgent());

		checkMessageCount(FacesMessage.SEVERITY_ERROR, 0);
		checkMessageCount(FacesMessage.SEVERITY_INFO, 1);
	}

	/**
	 * Test la création d'agent dans le cas d'erreur 'l'agent existe'.
	 */
	@Test
	public final void creerAgentEchecAgentExiste() {

		Agent agent = agentControleur.getModele().getCourant();
		agent.setNom(CODE_AGENT_EXISTE);
		agent.setPrenom("prenom");
		agent.setCivilite("M.");
		agent.setDateNaissance(Calendar.getInstance());

		Assert.assertEquals(null, agentControleur.creerAgent());

		checkMessageCount(FacesMessage.SEVERITY_ERROR, 1);
	}

	/**
	 * Test la modification d'agent dans le cas nominal.
	 */
	@Test
	public final void modifierAgentNominal() {
		UIData data = new UIData() {
			@Override
			public Object getRowData() {
				AgentLeger a = new AgentLeger();
				a.setId(2L);
				a.setNom("aaaa");
				return a;
			}
		};

		agentControleur.getVue().setDataTable(data);
		// Formulaire de saisie de modification
		Assert.assertEquals(IPages.PAGE_MODIFICATION_AGENT, agentControleur.modifierAgent());
		checkMessageCount(0);

		// Modification
		Agent agent = agentControleur.getModele().getCourant();
		agent.setNom("nom" + System.currentTimeMillis());
		agent.setPrenom("prenom");
		agent.setCivilite("M.");
		agent.setDateNaissance(Calendar.getInstance());

		Assert.assertEquals(null, agentControleur.sauvegardeModificationAgent());
		checkMessageCount(FacesMessage.SEVERITY_ERROR, 0);
	}

	/**
	 * Test la modification d'agent dans le cas d'erreur 'l'agent existe'.
	 */
	@Test
	public final void modifierAgentEchecAgentExiste() {
		UIData data = new UIData() {
			@Override
			public Object getRowData() {
				AgentLeger a = new AgentLeger();
				a.setId(2L);
				a.setNom("aaaa");
				return a;
			}
		};

		agentControleur.getVue().setDataTable(data);
		// Formulaire de saisie de modification
		Assert.assertEquals(IPages.PAGE_MODIFICATION_AGENT, agentControleur.modifierAgent());
		checkMessageCount(0);

		// Modification
		Agent agent = agentControleur.getModele().getCourant();
		agent.setNom(CODE_AGENT_EXISTE);

		Assert.assertEquals(null, agentControleur.sauvegardeModificationAgent());
		checkMessageCount(FacesMessage.SEVERITY_ERROR, 1);
	}
}
