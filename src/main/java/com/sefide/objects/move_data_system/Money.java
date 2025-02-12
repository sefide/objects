package com.sefide.objects.move_data_system;

public class Money {
    public static final Money ZERO = new Money(0.0);
    private double value;

    public Money(double value) {
        this.value = value;
    }

    public Money minus(Money money) {
        // 뺄셈 로직
        return money;
    }

    public Money plus(Money money) {
        // 덧셈 로직
        return money;
    }

    public Money times(double percent) {
        // 곱셈 로직
        return new Money(value * percent);
    }
}
