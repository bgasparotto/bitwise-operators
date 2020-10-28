package com.bgasparotto.bitwise.operators.shift;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeftShiftOperatorTest {

    @Test
    public void shouldLeftShiftBitsOnce() {
        int lOperand = 0b00011100_00000000_00000000_11100101;
        int expected = 0b00111000_00000000_00000001_11001010;

        assertThat(lOperand << 1).isEqualTo(expected);
    }

    @Test
    public void shouldLeftShiftBitsTwice() {
        int lOperand = 0b00011100_00000000_00000000_11100101;
        int expected = 0b01110000_00000000_00000011_10010100;

        assertThat(lOperand << 2).isEqualTo(expected);
    }

    @Test
    public void shouldLeftShiftBitsThreeTimes() {
        int lOperand = 0b00011100_00000000_00000000_11100101;
        int expected = 0b11100000_00000000_00000111_00101000;

        assertThat(lOperand << 3).isEqualTo(expected);
    }
}
