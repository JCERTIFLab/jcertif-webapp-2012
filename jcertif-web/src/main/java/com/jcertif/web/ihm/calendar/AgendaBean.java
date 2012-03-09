/****************************************************
        Code name  jcertif-web                  
        All right reserved 2012                  
        DIOUFA DEV LIFE                             
 *****************************************************/
package com.jcertif.web.ihm.calendar;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import com.jcertif.web.model.Event;
import com.jcertif.web.model.Speaker;
import com.jcertif.web.service.ReferentielService;
import com.jcertif.web.service.ResourceService;
import com.jcertif.web.service.RestService;

/**
 * @author Mamadou
 * 
 */
@Named
@SessionScoped
public class AgendaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3243371323747830221L;

	private ScheduleModel eventModel;

	/** Referentiel Service **/
	@Inject
	private ReferentielService referentielService;
	
	@Inject
	private ResourceService resService;
	
	private Date dateDebutSchedule;

	private Event event;

	Speaker speaker;

	/**
	 * @return the speakers
	 */
	public List<Event> getEvents() {
		return referentielService.getEvents();
	}

	/**
	 * @return the dateDebutSchedule
	 */
	public Date getDateDebutSchedule() {
		Date dateTmp;
		for (Event event : referentielService.getEvents()) {
			dateTmp = event.getDateDebut().getTime();
			if (dateDebutSchedule == null || dateTmp.before(dateDebutSchedule))
				dateDebutSchedule = dateTmp;
		}
		return dateDebutSchedule;
	}

	/**
	 * @param dateDebutSchedule
	 *            the dateDebutSchedule to set
	 */
	public void setDateDebutSchedule(Date dateDebutSchedule) {
		this.dateDebutSchedule = dateDebutSchedule;
	}

	/**
	 * @return the eventModel
	 */
	public ScheduleModel getEventModel() {
		if (eventModel == null) {
			eventModel = new DefaultScheduleModel();
			for (Event event : this.getEvents()) {
				eventModel.addEvent(new DefaultScheduleEvent(event.getNom(), event.getDateDebut()
						.getTime(), event.getDateFin().getTime()));
			}
		}

		return eventModel;
	}

	public AgendaBean() {
		super();
	}

	public List<Speaker> getSpeakers() {
		return referentielService.getSpeakers();
	}
	
	public String getSpeakerPhotoUrl() {
		return resService.getSpeakerPhotoUrl();
	}

	public void onEventSelect(ScheduleEntrySelectEvent selectEvent) {

		Date dateTmp;
		for (Event ev : referentielService.getEvents()) {
			dateTmp = selectEvent.getScheduleEvent().getStartDate();
			if (dateTmp.equals(ev.getDateDebut().getTime())) {
				setEvent(ev);
				if(ev.getSpeakersId() != null)
					speaker = getSpeakers().get(ev.getSpeakersId().intValue());
			}
		}


	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * @param event
	 *            the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * @return the speaker
	 */
	public Speaker getSpeaker() {
		return speaker;
	}

	/**
	 * @param speaker the speaker to set
	 */
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

}
