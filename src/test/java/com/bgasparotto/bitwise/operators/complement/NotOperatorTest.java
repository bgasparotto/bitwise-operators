package com.bgasparotto.bitwise.operators.complement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NotOperatorTest {
    private final byte lOperand = (byte) 0b01010110;
    private final byte expected = (byte) 0b10101001;

    @Test
    public void shouldParseByteBinaryLiteral() {
        assertThat(lOperand).isEqualTo((byte) 86);
        assertThat(expected).isEqualTo((byte) -87);
    }

    @Test
    public void shouldFlipAllBits() {
        assertThat(~lOperand).isEqualTo(expected);
    }
}
