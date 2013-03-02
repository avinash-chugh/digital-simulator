package com.thoughtwork.simulator;

import com.thoughtwork.simulator.event.SignalChangeEvent;
import com.thoughtwork.simulator.event.SignalChangeListener;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class WireTest {
    private boolean received;

    @Before
    public void setUp() throws Exception {
        received = false;
    }

    @Test
    public void shouldReceiveOnSignal() {
        Wire wire = newWire(true);
        assertThat(wire.signal(), equalTo(true));
    }

    @Test
    public void shouldReceiveOffSignal() {
        Wire wire = newWire(false);
        assertThat(wire.signal(), equalTo(false));
    }

    @Test
    public void shouldReceiveSignalChangeEvents() throws Exception {
        Wire wire = new Wire();
        wire.addListener(new SignalChangeListener() {
            @Override
            public void signalChange(SignalChangeEvent evt) {
                received = true;
            }
        });
        wire.sendSignal(true);
        assertThat(received, equalTo(true));
    }

    private Wire newWire(boolean signal) {
        Wire wire = new Wire();
        wire.sendSignal(signal);
        return wire;
    }
}
