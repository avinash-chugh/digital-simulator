package com.thoughtwork.simulator;

import com.thoughtwork.simulator.event.SignalChangeEvent;
import com.thoughtwork.simulator.event.SignalChangeListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A Wire carries a signal
 */
public class Wire {
    private boolean signal;
    List<SignalChangeListener> listeners = new ArrayList<>();

    public void sendSignal(boolean value) {
        signal = value;
        notifySignal();
    }

    public void addListener(SignalChangeListener arg) {
        listeners.add(arg);
    }

    public boolean signal() {
        return signal;
    }

    private void notifySignal() {
        for (SignalChangeListener l : listeners) {
            l.signalChange(new SignalChangeEvent(this, signal));
        }
    }
}
