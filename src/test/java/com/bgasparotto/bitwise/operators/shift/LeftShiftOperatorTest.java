package com.bgasparotto.bitwise.operators.shift;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeftShiftOperatorTest {

    @Test
    public void shouldLeftShiftBitsOnce() {
        byte lOperand = (byte) 0b11100101;
        byte expected = (byte) 0b11001010;

        byte result = (byte) (lOperand << 1);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldLeftShiftBitsTwice() {
        byte lOperand = (byte) 0b11100101;
        byte expected = (byte) 0b10010100;

        byte result = (byte) (lOperand << 2);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void shouldLeftShiftBitsThreeTimes() {
        byte lOperand = (byte) 0b11100101;
        byte expected = (byte) 0b00101000;

        byte result = (byte) (lOperand << 3);
        assertThat(result).isEqualTo(expected);
    }
}
