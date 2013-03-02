package com.thoughtwork.simulator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ProbeTest {

    private Wire wire;
    private Probe probe;

    @Before
    public void setUp() throws Exception {
        wire = new Wire();
        probe = new Probe(wire);
    }

    @Test
    public void shouldBeEmpty() throws Exception {
        assertThat(probe.getSignals(), is(""));
    }

    @Test
    public void shouldReceiveSignalFromWire() throws Exception {
        wire.sendSignal(true);
        assertThat(probe.getSignals(), equalTo("(true)"));
    }

    @Test
    public void shouldReceiveSignalsFromWire() throws Exception {
        wire.sendSignal(true);
        wire.sendSignal(false);
        assertThat(probe.getSignals(), equalTo("(true)(false)"));
    }
}
