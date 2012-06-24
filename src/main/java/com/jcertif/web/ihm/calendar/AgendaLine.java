package com.jcertif.web.ihm.calendar;


import com.jcertif.web.model.Event;
import com.jcertif.web.model.Speaker;
import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class AgendaLine {

    public static final int TIMELINE_INTERVALL = 15;
    public static final String EVENT_START = "event-start";
    public static final String EVENT_MIDDLE = "event-middle";
    public static final String EVENT_END = "event-end";

    private Date time;
    private List<AgendaEvent> events = new ArrayList<AgendaEvent>();

    public List<AgendaEvent> getEvents() {
        return events;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Event findEvent(String room) {
        if (EVENT_START.equals(getCSSClass(room))) {
            Event evt = getEvent(room);
            return evt;
        }
        return null;
    }

    public Speaker findSpeaker(String room) {
        if (EVENT_START.equals(getCSSClass(room))) {
            AgendaEvent evt = getEvent(room);
            return evt.getSpeaker();
        }
        return null;
    }

    public String getCSSClass(String salle) {
        Event evt = getEvent(salle);
        if (evt != null) {
            if (format(time).equals(formatToGMT(evt.getDateDebut().getTime()))) {
                return EVENT_START;
            }

            if (format(DateUtils.addMinutes(time,TIMELINE_INTERVALL)).equals(formatToGMT(evt.getDateFin().getTime()))) {
                return EVENT_END;
            }

            if (format(time).compareTo(formatToGMT(evt.getDateDebut().getTime())) > 0 && format(time).compareTo(formatToGMT(evt.getDateFin().getTime())) < 0) {
                return EVENT_MIDDLE;
            }



        }

        return "no-class";
    }

    public String format(Date date) {
        return new SimpleDateFormat("HH:mm").format(date);
    }

    public String formatToGMT(Date date){
        if(date == null){
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(date);
    }

    public Boolean isStartEvent(String room) {
        return EVENT_START.equals(getCSSClass(room));
    }


    private AgendaEvent getEvent(String salle) {
        for (AgendaEvent evt : events) {
            if (evt.getSalle().equalsIgnoreCase(salle)) {
                return evt;
            }
        }

        return null;
    }


}
