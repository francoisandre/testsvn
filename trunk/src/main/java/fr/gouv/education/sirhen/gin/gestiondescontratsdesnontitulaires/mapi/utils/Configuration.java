package fr.gouv.education.sirhen.gin.gestiondescontratsdesnontitulaires.mapi.utils;

import fr.gouv.education.sirhen.ct.socle.configuration.AbstractConfiguration;
import fr.gouv.education.sirhen.ct.socle.configuration.IConfiguration;

/**
 * Configuration.
 * 
 */
public class Configuration extends AbstractConfiguration implements IConfiguration {

	/**
	 * Environnement recette/production.
	 */
	private boolean modeProduction;

	/**
	 * Code nomenclature de la civilité.
	 */
	private String codeCivilite;

	/**
	 * Code origine du MAN SIRHEN.
	 */
	private String origManSirhen;

	/**
	 * Accesseur en lecture de l'attribut <code>modeProduction</code>.
	 * 
	 * @return L'attribut modeProduction à lire.
	 */
	public final boolean isModeProduction() {
		return modeProduction;
	}

	/**
	 * Accesseur en écriture de l'attribut <code>modeProduction</code>.
	 * 
	 * @param modeProduction
	 *            L'attribut modeProduction à modifier.
	 */
	public final void setModeProduction(final boolean modeProduction) {
		this.modeProduction = modeProduction;
	}

	/**
	 * Accesseur en lecture de l'attribut <code>codeCivilite</code>.
	 * 
	 * @return L'attribut codeCivilite à lire.
	 */
	public final String getCodeCivilite() {
		return codeCivilite;
	}

	/**
	 * Accesseur en écriture de l'attribut <code>codeCivilite</code>.
	 * 
	 * @param codeCivilite
	 *            L'attribut codeCivilite à modifier.
	 */
	public final void setCodeCivilite(final String codeCivilite) {
		this.codeCivilite = codeCivilite;
	}

	/**
	 * Accesseur en lecture de l'attribut <code>origManSirhen</code>.
	 * 
	 * @return L'attribut origManSirhen à lire.
	 */
	public final String getOrigManSirhen() {
		return origManSirhen;
	}

	/**
	 * Accesseur en écriture de l'attribut <code>origManSirhen</code>.
	 * 
	 * @param origManSirhen
	 *            L'attribut origManSirhen à modifier.
	 */
	public final void setOrigManSirhen(final String origManSirhen) {
		this.origManSirhen = origManSirhen;
	}
}
