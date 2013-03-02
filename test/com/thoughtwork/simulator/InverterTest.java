package com.thoughtwork.simulator;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class InverterTest {
    private Wire in;
    private Wire out;

    @Before
    public void setup() {
        in = new Wire();
        out = new Wire();
    }

    @Test
    public void shouldReceiveOnSignalWhenOffSignalIsSent() {
        in.sendSignal(false);
        newInverter();
        assertThat(out.signal(), equalTo(true));
    }

    @Test
    public void shouldReceiveOffSignalWhenOnSignalIsSent() {
        in.sendSignal(true);
        newInverter();
        assertThat(out.signal(), equalTo(false));
    }

    @Test
    public void shouldChangeSignalOnOutWire() {
        newInverter();
        in.sendSignal(true);
        assertThat(out.signal(), equalTo(false));

        in.sendSignal(false);
        assertThat(out.signal(), equalTo(true));
    }

    private void newInverter() {
        new Inverter(in, out);
    }
}
