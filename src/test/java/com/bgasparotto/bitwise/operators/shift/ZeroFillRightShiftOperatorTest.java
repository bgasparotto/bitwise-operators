package com.bgasparotto.bitwise.operators.shift;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZeroFillRightShiftOperatorTest {

    @Test
    public void shouldZeroFillRightShiftBitsOnce() {
        int lOperand = 0b01000000_00000000_00000000_11100101;
        int expected = 0b00100000_00000000_00000000_01110010;

        assertThat(lOperand >>> 1).isEqualTo(expected);
    }

    @Test
    public void shouldZeroFillRightShiftBitsTwiceWhenMsbIsOne() {
        int lOperand = 0b10000000_00000000_00000000_10100101;
        int expected = 0b00100000_00000000_00000000_00101001;

        assertThat(lOperand >>> 2).isEqualTo(expected);
    }

    @Test
    public void shouldZeroFillRightShiftBitsTwiceWhenMsbIsZero() {
        int lOperand = 0b01000000_00000000_00000000_00100101;
        int expected = 0b00010000_00000000_00000000_00001001;

        assertThat(lOperand >>> 2).isEqualTo(expected);
    }
}
