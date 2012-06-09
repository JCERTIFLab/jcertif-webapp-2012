package com.jcertif.web.model;

import java.util.Comparator;

/**
 * Comparateur permettant de trier les sponsors par niveau de partenariat
 * 
 * @author rossi.oddet
 * 
 */
public class SponsorComparator implements Comparator<Sponsor> {

	/**
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Sponsor sponsor1, Sponsor sponsor2) {
		int retour = sponsor1.getIdNiveauPartenariat().compareTo(
				sponsor2.getIdNiveauPartenariat());

		if (retour == 0) {
			retour = sponsor1.getId().compareTo(sponsor2.getId());
		}

		return retour;
	}

}
