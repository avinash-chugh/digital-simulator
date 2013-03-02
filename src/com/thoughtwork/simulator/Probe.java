package com.thoughtwork.simulator;

import com.thoughtwork.simulator.event.SignalChangeEvent;
import com.thoughtwork.simulator.event.SignalChangeListener;

/**
 * A Probe monitors the signal on the wire
 */
public class Probe implements SignalChangeListener {
    private StringBuilder signals;

    public Probe(Wire wire) {
        signals = new StringBuilder();
        wire.addListener(this);

    }

    public String getSignals() {
        return signals.toString();
    }

    @Override
    public void signalChange(SignalChangeEvent evt) {
        signals.append("(");
        signals.append(evt.getValue());
        signals.append(")");
    }
}
