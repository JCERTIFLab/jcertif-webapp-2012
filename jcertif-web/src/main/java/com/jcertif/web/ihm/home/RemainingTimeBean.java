package com.jcertif.web.ihm.home;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcertif.web.service.ReferentielService;

/**
 * Controller for remaining time.
 * 
 * @author rossi.oddet
 * 
 */
@Named
@RequestScoped
public class RemainingTimeBean {

	/** LOGGER **/
	private static final Logger LOG = LoggerFactory.getLogger(RemainingTimeBean.class);

	private static final int UN_JOUR_EN_MILLISEC = 1000 * 60 * 60 * 24;

	/** Référentiel service **/
	@Inject
	private ReferentielService referentielService;

	/**
	 * @return the remaining time
	 */
	public RemainingTime getRemainingTime() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("Get remaining time...");
		}
		Calendar today = Calendar.getInstance();

		long tempsRestantms = referentielService.getConference().getDateDebut().getTimeInMillis()
				- today.getTimeInMillis();

		final RemainingTime jr = getRemainingTime(tempsRestantms);

		return jr;
	}

	/**
	 * @param remainingTimeMs
	 *            remaining time is ms
	 * @return the remaining time
	 */
	protected RemainingTime getRemainingTime(long remainingTimeMs) {
		final RemainingTime remTime = new RemainingTime();
		String remTimeString = String.valueOf(Math.round((double) remainingTimeMs
				/ UN_JOUR_EN_MILLISEC));

		if (remTimeString.length() >= 3) {
			remTime.setHundred(remTimeString.charAt(remTimeString.length() - 3));
		} else {
			remTime.setHundred('0');
		}

		if (remTimeString.length() >= 2) {
			remTime.setDecade(remTimeString.charAt(remTimeString.length() - 2));
		} else {
			remTime.setDecade('0');
		}

		remTime.setUnit(remTimeString.charAt(remTimeString.length() - 1));
		return remTime;
	}

	/**
	 * @return conference formatted start date
	 */
	public String getFormattedStartDate() {
		return new SimpleDateFormat("dd MMM yyyy").format(referentielService.getConference()
				.getDateDebut().getTime());
	}
}
