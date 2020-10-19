# Bitwise Operators
Bitwise operators operate directly on the **bits** of an integral type. An integral type is a
numeric data type whose values are of *integer* type.

In java, the integral types are:
- byte
- short
- int
- long
- char

In order to understand bitwise operators, we need to look into how these values are represented.

## Binary Representation
Values are stored in bits, and each of these types have a different size and may reserve 1 bit for
the *two's complement* sign. 

### Two's Complement
- For positive numbers, the sign bit is `0` and the decimal value is the `sum of the remaining bits`
- For negative, the sign is `1` and the decimal value is `- sign + sum of the remaining bits`

For example, the table below shows how different values are represented for the `byte` type:
```
|--------------------------------|-------------------------------------|-------|
|sign|     Binary Value          |                                     |Decimal|
| 128| 64| 32| 16|  8|  4|  2|  1|              Operation              | Value |
|--------------------------------|-------------------------------------|-------|
|   1   0   0   0   0   0   0   0| -128 + 0 + 0 + 0 + 0 + 0 + 0 + 0    | -128  |
|--------------------------------|-------------------------------------|-------|
|   1   0   0   1   1   0   1   0| -128 + 0 + 0 + 16 + 8 + 0 + 2 + 0   | -102  |
|--------------------------------|-------------------------------------|-------|
|   1   1   1   1   1   1   1   1| -128 + 64 + 32 + 16 + 8 + 4 + 2 + 1 |   -1  |
|--------------------------------|-------------------------------------|-------|
|   0   0   0   0   0   0   0   0| 0 + 0 + 0 + 0 + 0 + 0 + 0 + 0       |    0  |
|--------------------------------|-------------------------------------|-------|
|   0   0   0   0   0   0   0   1| 0 + 0 + 0 + 0 + 0 + 0 + 0 + 1       |    1  |
|--------------------------------|-------------------------------------|-------|
|   0   1   1   0   0   1   1   0| 0 + 64 + 32 + 0 + 0 + 4 + 2 + 0     |  102  |
|--------------------------------|-------------------------------------|-------|
|   0   1   1   1   1   1   1   1| 0 + 64 + 32 + 16 + 8 + 4 + 2 + 1    |  127  |
```

For instance, in order find the negative of a number, we (1) invert all bits, then (2) add one bit:
```
Positive number 102 => 0110 0110
1. Invert all bits  => 1001 1001
2. Add one bit      => 1001 1010
```