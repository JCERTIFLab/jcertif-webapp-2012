/****************************************************
        Code name  jcertif-web                  
        All right reserved 2012                  
        DIOUFA DEV LIFE                             
 *****************************************************/
package com.jcertif.web.ihm.calendar;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.ScheduleEntrySelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import com.jcertif.web.model.Event;
import com.jcertif.web.service.ReferentielService;

/**
 * @author Mamadou
 *
 */
@Named
@RequestScoped
public class AgendaBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3243371323747830221L;

	private ScheduleModel eventModel = new DefaultScheduleModel();;

	/** Referentiel Service **/
	@Inject
	private ReferentielService referentielService;

	private Date dateDebutSchedule ;

	private Event event;

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
		for(Event event: referentielService.getEvents()){
			dateTmp = event.getDateDebut().getTime();
			if(dateDebutSchedule == null || dateTmp.before(dateDebutSchedule))
				dateDebutSchedule = dateTmp;
		}
		return dateDebutSchedule;
	}

	/**
	 * @param dateDebutSchedule the dateDebutSchedule to set
	 */
	public void setDateDebutSchedule(Date dateDebutSchedule) {
		this.dateDebutSchedule = dateDebutSchedule;
	}

	/**
	 * @return the eventModel
	 */
	public ScheduleModel getEventModel() {
		for(Event event: this.getEvents()){
			eventModel.addEvent(new DefaultScheduleEvent(event.getNom(), event.getDateDebut().getTime(), event.getDateFin().getTime()));
		}
		return eventModel;
	}

	public AgendaBean() {
	}

	public void onEventSelect(ScheduleEntrySelectEvent selectEvent) {
		Date dateTmp;
		for(Event ev: referentielService.getEvents()){
			dateTmp = selectEvent.getScheduleEvent().getStartDate();
			if(dateTmp.equals(ev.getDateDebut().getTime())){
				setEvent(ev);
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
	 * @param event the event to set
	 */
	public void setEvent(Event event) {
		this.event = event;
	}

}
