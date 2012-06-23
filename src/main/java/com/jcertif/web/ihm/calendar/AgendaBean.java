/****************************************************
 Code name  jcertif-web
 All right reserved 2012
 DIOUFA DEV LIFE
 *****************************************************/
package com.jcertif.web.ihm.calendar;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jcertif.web.model.Speaker;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.time.DateUtils;

import com.jcertif.web.model.Event;
import com.jcertif.web.service.ReferentielService;
import com.jcertif.web.service.ResourceService;

/**
 * @author Mamadou
 */
@Named
@RequestScoped
public class AgendaBean implements Serializable {

    private static final long serialVersionUID = 3243371323747830221L;
    public static final int TIMELINE_INTERVALL = 15;
    public static final String START_HOUR = "08:00";
    public static final String END_HOUR = "18:00";
    @Inject
    private ReferentielService referentielService;
    @Inject
    private ResourceService resService;

    private Map<String, List<AgendaLine>> agendaLineByDay;
    private Map<String, Set<String>> roomsByDay;

    private Speaker selectedSpeaker;
    private Event selectedSession;



    private void init() throws ParseException, InvocationTargetException, IllegalAccessException {
        long start = System.currentTimeMillis();


        Set<String> days = new HashSet<String>();
        for (Event evt : referentielService.getEvents()) {
            days.add(getFormattedDay(evt));
        }

        for(String day : days){
            Date heurePivot = buildHour(START_HOUR);
            while (heurePivot.before(buildHour(END_HOUR))) {
                AgendaLine line = new AgendaLine();
                line.setTime(heurePivot);

                for (Event evt : referentielService.getEvents()) {

                    if(day.equals(getFormattedDay(evt))){
                        if (isEventMachedWithLine(line, evt)) {
                            AgendaEvent agendaEvent = new AgendaEvent();
                            BeanUtils.copyProperties(agendaEvent,evt);
                            agendaEvent.setSpeaker(referentielService.getSpeaker(evt.getSpeakersId()));
                            line.getEvents().add(agendaEvent);
                            addRoomToDay(day, evt.getSalle());
                        }
                    }
                }
                addAgendaLineToDay(day, line);
                heurePivot = DateUtils.addMinutes(heurePivot, TIMELINE_INTERVALL);
            }
        }

        System.out.println("init " + (System.currentTimeMillis() -start) + " ms" );

    }

    private String getFormattedDay(Event evt) {
        return new SimpleDateFormat("dd/MM").format(evt.getDateDebut().getTime());
    }

    private boolean isEventMachedWithLine(AgendaLine line, Event evt) {
        return format(line.getTime()).equals(format(evt.getDateDebut().getTime()))
                || format(line.getTime()).equals(format(evt.getDateFin().getTime()))
                || (format(line.getTime()).compareTo(format(evt.getDateDebut().getTime())) > 0 && format(line.getTime()).compareTo(format(evt.getDateFin().getTime())) < 0);
    }

    private void addAgendaLineToDay(final String day, final AgendaLine line) {
        if (agendaLineByDay == null) {
            agendaLineByDay = new HashMap<String, List<AgendaLine>>();
        }
        List<AgendaLine> lines = agendaLineByDay.get(day);
        if (lines == null) {
            lines = new ArrayList<AgendaLine>();
            lines.add(line);
            agendaLineByDay.put(day, lines);
        } else {
            if (!lines.contains(line)) {
                lines.add(line);
            }
        }
    }

    private void addRoomToDay(final String day, final String room) {
        if (roomsByDay == null) {
            roomsByDay = new HashMap<String, Set<String>>();
        }
        Set<String> rooms = roomsByDay.get(day);
        if (rooms == null) {
            rooms = new HashSet<String>();
            rooms.add(room);
            roomsByDay.put(day,rooms);
        } else {
           rooms.add(room);
        }
    }


    private Date buildHour(String hourHHmmss) throws ParseException {
        return new SimpleDateFormat("HH:mm").parse(hourHHmmss);
    }

    public List<AgendaLine> getLines(String day) throws ParseException, InvocationTargetException, IllegalAccessException {
        if(agendaLineByDay == null){
            init();
        }
        return agendaLineByDay.get(day);
    }

    public Set<String> getRooms(String day) throws ParseException, InvocationTargetException, IllegalAccessException {
        if(roomsByDay == null){
            init();
        }
        return roomsByDay.get(day);
    }

    public String format(Date date) {
        if(date == null){
            return null;
        }
        return new SimpleDateFormat("HH:mm").format(date);
    }

    public Collection<String> getDays() throws ParseException, InvocationTargetException, IllegalAccessException {
        if (agendaLineByDay == null) {
            init();
        }
        return agendaLineByDay.keySet();
    }

    public String getSpeakerPhotoUrl() {
        return resService.getImgPicsUrl();
    }

    public Speaker getSelectedSpeaker() {
        return selectedSpeaker;
    }

    public void setSelectedSpeaker(Speaker selectedSpeaker) {
        this.selectedSpeaker = selectedSpeaker;
    }

    public Event getSelectedSession() {
        return selectedSession;
    }

    public void setSelectedSession(Event selectedSession) {
        this.selectedSession = selectedSession;
    }
}
