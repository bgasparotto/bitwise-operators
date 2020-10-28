# Bitwise Operators
Bitwise operators operate directly on the **bits** of an integral type. 
```
+----------+-----------------------+------------+------------------------------------------------+-----------------------------+
| Operator | Name                  | Type       | Description                                    | Example                     |
+----------+-----------------------+------------+------------------------------------------------+-----------------------------+
| &        | AND                   | Logical    | Copies a bit if it exists in both operands     | 0101 0110 &                 |
|          |                       |            |                                                | 1110 0100 =                 |
|          |                       |            |                                                | 0100 0100                   |
+----------+-----------------------+------------+------------------------------------------------+-----------------------------+
| |        | OR                    | Logical    | Copies a bit if it exists in either operand    | 0101 0110 |                 |
|          |                       |            |                                                | 1110 0100 =                 |
|          |                       |            |                                                | 1111 0110                   |
+----------+-----------------------+------------+------------------------------------------------+-----------------------------+
| ^        | XOR                   | Logical    | Copies a bit if it exists in only one operand  | 0101 0110 ^                 |
|          |                       |            |                                                | 1110 0100 =                 |
|          |                       |            |                                                | 1011 0010                   |
+----------+-----------------------+------------+------------------------------------------------+-----------------------------+
| ~        | NOT                   | Complement | Flips the bits                                 | ~0101 0110 = 1010 1001      |
+----------+-----------------------+------------+------------------------------------------------+-----------------------------+
| <<       | Left Shift            | Shift      | Left operand moves left by the number of the   | 1110 0101 << 1 = 1100 1010  |
|          |                       |            | right operand, filling values on the right     | 1110 0101 << 2 = 1001 0100  |
|          |                       |            | with zeroes.                                   | 1110 0101 << 3 = 0010 1000  |
+----------+-----------------------+------------+------------------------------------------------+-----------------------------+
| >>       | Right Shift           | Shift      | Left operand moves right by the number of the  | 1110 0101 >> 1 = 1111 0010  |
|          |                       |            | right operand, filling values on the left with | 1010 0101 >> 2 = 1110 1001  |
|          |                       |            | the sign bit.                                  | 0010 0101 >> 2 = 0000 1001  |
+----------+-----------------------+------------+------------------------------------------------+-----------------------------+
| >>>      | Zero Fill Right Shift | Shift      | Left operand moves right by the number of the  | 1110 0101 >>> 1 = 0111 0010 |
|          |                       |            | right operand, filling values on the left with | 1010 0101 >>> 2 = 0010 1001 |
|          |                       |            | zeroes.                                        | 0010 0101 >>> 2 = 0000 1001 |
+----------+-----------------------+------------+------------------------------------------------+-----------------------------+
```

An integral type is a numeric data type whose values are of *integer* type. In java, the integral 
types are `byte`, `short`, `int`, `long` and `char`.

In order to understand how bitwise operators modify the values of these types, we need to look into
how Java represents them.

## Binary Representation
Values are stored in bits, and each of the integral types have a different size and may reserve 1 
bit for the *two's complement* sign. 
```
+-------+--------+--------+----------------------+---------------------+
| Type  | Size   | Signed |      Min Value       |      Max Value      |
+-------+--------+--------+----------------------+---------------------+
| byte  | 8-bit  | yes    |                 -128 |                 127 |
+-------+--------+--------+----------------------+---------------------+
| short | 16-bit | yes    |               -32768 |               32767 |
+-------+--------+--------+----------------------+---------------------+
| int   | 32-bit | yes    |          -2147483648 |          2147483647 |
+-------+--------+--------+----------------------+---------------------+
| long  | 64-bit | yes    | -9223372036854775808 | 9223372036854775807 |
+-------+--------+--------+----------------------+---------------------+
| char  | 16-bit | no     |        '\u0000' or 0 |   '\uffff' or 65535 |
+-------+--------+--------+----------------------+---------------------+
```

> **Important!** Types smaller than int (byte, short and char) will be first promoted to int before
> a shift operation takes place. If you convert them back into the smaller types, the left most bits 
> will be truncated, producing undesired effects. Thus, it's recommended to perform shift operations
> on ints or longs instead.

### Two's Complement
- For positive numbers, the sign bit is `0` and the decimal value is the `sum of the remaining bits`
- For negative, the sign is `1` and the decimal value is `- sign + sum of the remaining bits`

For example, the table below shows how different values are represented for the `byte` type:
```
+--------------------------------+-------------------------------------+-------+
|sign|     Binary Value          |                                     |Decimal|
| 128| 64| 32| 16| 8 | 4 | 2 | 1 |              Operation              | Value |
+--------------------------------+-------------------------------------+-------+
|  1   0   0   0   0   0   0   0 | -128 + 0 + 0 + 0 + 0 + 0 + 0 + 0    |  -128 |
+--------------------------------+-------------------------------------+-------+
|  1   0   0   1   1   0   1   0 | -128 + 0 + 0 + 16 + 8 + 0 + 2 + 0   |  -102 |
+--------------------------------+-------------------------------------+-------+
|  1   1   1   1   1   1   1   1 | -128 + 64 + 32 + 16 + 8 + 4 + 2 + 1 |    -1 |
+--------------------------------+-------------------------------------+-------+
|  0   0   0   0   0   0   0   0 | 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0       |     0 |
+--------------------------------+-------------------------------------+-------+
|  0   0   0   0   0   0   0   1 | 0 + 0 + 0 + 0 + 0 + 0 + 0 + 1       |     1 |
+--------------------------------+-------------------------------------+-------+
|  0   1   1   0   0   1   1   0 | 0 + 64 + 32 + 0 + 0 + 4 + 2 + 0     |   102 |
+--------------------------------+-------------------------------------+-------+
|  0   1   1   1   1   1   1   1 | 0 + 64 + 32 + 16 + 8 + 4 + 2 + 1    |   127 |
+--------------------------------+-------------------------------------+-------+
```

For instance, in order find the negative of a number, we (1) invert all bits, then (2) add one bit:
```
Positive number 102 => 0110 0110
1. Invert all bits  => 1001 1001
2. Add one bit      => 1001 1010
```