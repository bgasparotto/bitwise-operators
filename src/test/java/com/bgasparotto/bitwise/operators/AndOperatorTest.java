package com.bgasparotto.bitwise.operators;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AndOperatorTest {
    private final byte lOperand = (byte) 0b01010110;
    private final byte rOperand = (byte) 0b11100100;
    private final byte expected = (byte) 0b01000100;

    @Test
    public void shouldParseByteBinaryLiteral() {
        assertThat(lOperand).isEqualTo((byte) 86);
        assertThat(rOperand).isEqualTo((byte) -28);
        assertThat(expected).isEqualTo((byte) 68);
    }

    @Test
    public void shouldCopyBitsIfTheyExistOnBothOperands() {
        assertThat(lOperand & rOperand).isEqualTo(expected);
    }
}
