package com.sefide.objects.chapter_10;

import com.sefide.objects.chapter_04.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone extends AbstractPhone {

    enum PhoneType {
        REGULAR,
        NIGHTLY
    }

    private PhoneType type;

    private Money amount;
    private Money regularAmount;
    private Money nightlyAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();
    private double taxRate;

    public Phone(Money amount, Duration seconds) {
        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
    }

    public Phone(Money regularAmount, Money nightlyAmount, Duration seconds) {
        this(PhoneType.NIGHTLY, Money.ZERO, regularAmount, nightlyAmount, seconds);
    }

    private Phone(PhoneType type, Money amount, Money regularAmount, Money nightlyAmount, Duration seconds) {
        this.type = type;
        this.amount = amount;
        this.regularAmount = regularAmount;
        this.nightlyAmount = nightlyAmount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
