package com.sefide.objects.chapter_05;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private int sequence;
    private DiscountConditionType type;

    public boolean isSatisfiedBy(Screening screening) { // Screening을 여기까지 끌고와야 할 문제인가
        if(type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }

        return isSatisfiedBySequence(screening);
    }

    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                !startTime.isAfter(screening.getWhenScreened().toLocalTime()) &&
                !endTime.isBefore(screening.getWhenScreened().toLocalTime());
    }
}
