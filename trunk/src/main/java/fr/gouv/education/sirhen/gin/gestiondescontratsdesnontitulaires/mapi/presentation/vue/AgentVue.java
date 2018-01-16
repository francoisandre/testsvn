package fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.presentation.vue;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UISelectItems;
import javax.faces.model.SelectItem;

import fr.gouv.education.sirhen.ct.commun.presentation.vue.ListeVue;

/**
 * Vue Agent.
 * 
 * @param <T>
 *            Type de l'objet à lister.
 */
public class AgentVue<T> extends ListeVue < T > {

	/** Composant select. */
	private UISelectItems civiliteListeItems;

	/** Liste de items. */
	private List < SelectItem > civiliteListe;

	/** Constructor. */
	public AgentVue() {
		super();

		civiliteListe = new ArrayList<SelectItem>();
	}

	/**
	 * Accesseur en écriture de l'attribut <code>civiliteListeItems</code>.
	 * 
	 * @param civiliteListeItems
	 *            L'attribut civiliteListeItems à modifier.
	 */
	public final void setCiviliteListeItems(final UISelectItems civiliteListeItems) {
		this.civiliteListeItems = civiliteListeItems;
	}

	/**
	 * Accesseur en lecture de l'attribut <code>civiliteListeItems</code>.
	 * 
	 * @return L'attribut civiliteListeItems à lire.
	 */
	public final UISelectItems getCiviliteListeItems() {
		return civiliteListeItems;
	}

	/**
	 * Accesseur en écriture de l'attribut <code>civiliteListe</code>.
	 * 
	 * @param civiliteListe
	 *            L'attribut civiliteListe à modifier.
	 */
	public final void setCiviliteListe(final List < SelectItem > civiliteListe) {
		this.civiliteListe = civiliteListe;
	}

	/**
	 * Accesseur en lecture de l'attribut <code>civiliteListe</code>.
	 * 
	 * @return L'attribut civiliteListe à lire.
	 */
	public final List < SelectItem > getCiviliteListe() {
		return civiliteListe;
	}

}
