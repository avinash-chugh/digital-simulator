package com.thoughtwork.simulator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class OrGateTest {

    private Wire in1;
    private Wire in2;
    private Wire out;

    @Before
    public void setUp() throws Exception {
        in1 = new Wire();
        in2 = new Wire();
        out = new Wire();

        new OrGate(in1, in2, out);
    }

    @Test
    public void shouldReceiveOnSignalWhenEitherInSignalIsOn() throws Exception {

        in1.sendSignal(true);
        in2.sendSignal(false);
        assertThat(out.signal(), equalTo(true));
    }

    @Test
    public void shouldReceiveOffSignalWhenBothSignalsAreOff() throws Exception {
        in1.sendSignal(false);
        in2.sendSignal(false);
        assertThat(out.signal(), equalTo(false));
    }

    @Test
    public void shouldInvertTheOnSignalReceivedFromOrGate() throws Exception {
        in1.sendSignal(true);
        in2.sendSignal(false);
        Wire wire = new Wire();

        new Inverter(out, wire);
        assertThat(wire.signal(), equalTo(false));
    }
}
