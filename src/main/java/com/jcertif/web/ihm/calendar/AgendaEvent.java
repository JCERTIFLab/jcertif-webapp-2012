package com.jcertif.web.ihm.calendar;

import com.jcertif.web.model.Event;
import com.jcertif.web.model.Speaker;


public class AgendaEvent extends Event {

    private Speaker speaker;

    public Speaker getSpeaker() {
        return speaker;
    }
    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }
}
