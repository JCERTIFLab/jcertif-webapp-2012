package com.jcertif.web.model;


import static junit.framework.TestCase.*;

import com.jcertif.web.ihm.calendar.AgendaEvent;
import com.jcertif.web.ihm.calendar.AgendaLine;
import org.junit.Test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class AgendaLineTest {

    @Test
    public void testGetCSSClassEventStart() throws ParseException {
        AgendaLine line = getAgendaLine(10,0);
        line.getEvents().add(getEvent("10","11"));
        assertEquals(AgendaLine.EVENT_START, line.getCSSClass("Hall"));
    }

    @Test
    public void testGetCSSClassEventMiddle() throws ParseException {
        AgendaLine line = getAgendaLine(11,0);
        line.getEvents().add(getEvent("10","15"));
        assertEquals(AgendaLine.EVENT_MIDDLE, line.getCSSClass("Hall"));
    }

    @Test
    public void testGetCSSClassEventEnd() throws ParseException {
        AgendaLine line = getAgendaLine(15,45);
        line.getEvents().add(getEvent("10","16"));
        assertEquals(AgendaLine.EVENT_END, line.getCSSClass("Hall"));
    }

    private AgendaLine getAgendaLine(int hour, int minute) throws ParseException {
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        AgendaLine line = new AgendaLine();
        line.setTime(timeFormat.parse(hour + ":" + minute));
        return line;
    }

    private AgendaEvent getEvent(String startHour, String endHour) throws ParseException{
    	DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        AgendaEvent evt1 = new AgendaEvent();
        evt1.setNom("Java EE is good");
        Calendar dateDeb = Calendar.getInstance();
        dateDeb.setTime(dateFormat.parse(startHour + ":00"));
        evt1.setDateDebut(dateDeb);
        Calendar dateFin = Calendar.getInstance();
        dateFin.setTime(dateFormat.parse(endHour + ":00"));
        evt1.setDateFin(dateFin);
        evt1.setSalle("Hall");
        return evt1;
    }
}
