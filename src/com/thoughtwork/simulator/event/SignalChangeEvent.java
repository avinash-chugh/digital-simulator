package com.thoughtwork.simulator.event;

import java.util.EventObject;

public class SignalChangeEvent extends EventObject {
    private boolean value;

    public SignalChangeEvent(Object source, boolean signal) {
        super(source);
        value = signal;
    }

    public boolean getValue() {
        return value;
    }
}
