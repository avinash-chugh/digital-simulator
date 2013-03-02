package com.thoughtwork.simulator;

import com.thoughtwork.simulator.event.SignalChangeEvent;
import com.thoughtwork.simulator.event.SignalChangeListener;

/**
 * An Inverter is a NOT gate
 */
public class Inverter implements SignalChangeListener {
    private Wire in;
    private Wire out;

    public Inverter(Wire in, Wire out) {
        this.in = in;
        this.out = out;

        in.addListener(this);
        refreshSignal();
    }

    @Override
    public void signalChange(SignalChangeEvent evt) {
        refreshSignal();
    }

    private void refreshSignal() {
        out.sendSignal(!in.signal());
    }
}
