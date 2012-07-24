package com.jcertif.web.ihm.calendar;

import com.jcertif.web.model.Event;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import static junit.framework.TestCase.*;

public class AgendaBeanTest {

    @Test
    public void testIsEventMachedWithLine() throws ParseException {

        AgendaBean agendaBean = new AgendaBean();
        Event evt = getEvent("09:00","10:00");
        AgendaLine line = getAgendaLine("0900");
        assertEquals(true,agendaBean.isEventMachedWithLine(line, evt));
    }

    private AgendaLine getAgendaLine(String HHmm) throws ParseException {
        AgendaLine line = new AgendaLine();
        line.setTime(new SimpleDateFormat("HHmm").parse(HHmm));
        return line;
    }

    private Event getEvent(String dateDebut, String dateFin) throws ParseException {
        Event evt = new Event();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Calendar dateDebutEvent = Calendar.getInstance();
        Calendar dateFinEvent = Calendar.getInstance();
        dateDebutEvent.setTime(dateFormat.parse(dateDebut));
        dateFinEvent.setTime(dateFormat.parse(dateFin));
        evt.setDateDebut(dateDebutEvent);
        return evt;
    }
}
