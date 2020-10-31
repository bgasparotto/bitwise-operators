package com.bgasparotto.bitwise.operators.shift;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RightShiftOperatorTest {

    @Test
    public void shouldRightShiftBitsOnce() {
        int lOperand = 0b00000000_00000000_00000000_11100101;
        int expected = 0b00000000_00000000_00000000_01110010;

        assertThat(lOperand >> 1).isEqualTo(expected);
    }

    @Test
    public void shouldRightShiftBitsTwiceWhenMsbIsOne() {
        int lOperand = 0b10000000_00000000_00000000_00100101;
        int expected = 0b11100000_00000000_00000000_00101001;

        assertThat(lOperand >> 2).isEqualTo(expected);
    }

    @Test
    public void shouldRightShiftBitsTwiceWhenMsbIsZero() {
        int lOperand = 0b00000000_00000000_00000000_00100101;
        int expected = 0b00000000_00000000_00000000_00001001;

        assertThat(lOperand >> 2).isEqualTo(expected);
    }

    @Test
    public void shouldCastByteAndShortToIntAndRightShiftTwiceWhenMsbIsOne() {
        byte byteOperand = (byte) 0b10100101;
        short shortOperand = (short) 0b11111111_10100101;
        int expected = 0b11111111_11111111_11111111_11101001;

        assertThat(byteOperand >> 2).isEqualTo(expected);
        assertThat(shortOperand >> 2).isEqualTo(expected);
    }

    @Test
    public void shouldCastByteAndShortToIntAndRightShiftTwiceWhenMsbIsZero() {
        byte byteOperand = (byte) 0b00100101;
        short shortOperand = (short) 0b00000000_00100101;
        int expected = 0b00000000_00000000_00000000_00001001;

        assertThat(byteOperand >> 2).isEqualTo(expected);
        assertThat(shortOperand >> 2).isEqualTo(expected);
    }

    @Test
    public void shouldCastCharToIntAndRightShiftTwice() {
        char operand = 0b11000000_00100101;
        int expected = 0b00000000_00000000_00110000_00001001;

        assertThat(operand >> 2).isEqualTo(expected);
    }
}
