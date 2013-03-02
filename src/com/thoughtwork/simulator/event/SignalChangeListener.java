package com.thoughtwork.simulator.event;

import java.util.EventListener;

public interface SignalChangeListener extends EventListener {
    void signalChange(SignalChangeEvent evt);
}
