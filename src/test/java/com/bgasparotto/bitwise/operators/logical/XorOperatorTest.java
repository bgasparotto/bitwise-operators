package com.bgasparotto.bitwise.operators.logical;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class XorOperatorTest {
    private final byte lOperand = (byte) 0b01010110;
    private final byte rOperand = (byte) 0b11100100;
    private final byte expected = (byte) 0b10110010;

    @Test
    public void shouldParseByteBinaryLiteral() {
        assertThat(lOperand).isEqualTo((byte) 86);
        assertThat(rOperand).isEqualTo((byte) -28);
        assertThat(expected).isEqualTo((byte) -78);
    }

    @Test
    public void shouldCopyBitsIfTheyExistOnOnlyOneOperand() {
        assertThat(lOperand ^ rOperand).isEqualTo(expected);
    }
}
