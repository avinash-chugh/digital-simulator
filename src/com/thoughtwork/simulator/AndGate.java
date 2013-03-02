package com.thoughtwork.simulator;

import com.thoughtwork.simulator.event.SignalChangeEvent;
import com.thoughtwork.simulator.event.SignalChangeListener;

public class AndGate implements SignalChangeListener {
    private Wire in1;
    private Wire in2;
    private Wire out;

    public AndGate(Wire in1, Wire in2, Wire out) {
        this.in1 = in1;
        this.in2 = in2;
        this.out = out;
        in1.addListener(this);
        in2.addListener(this);
    }

    @Override
    public void signalChange(SignalChangeEvent evt) {
        out.sendSignal(in1.signal() && in2.signal());
    }
}
