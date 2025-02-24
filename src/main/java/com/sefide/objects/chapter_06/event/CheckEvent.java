package com.sefide.objects.chapter_06.event;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CheckEvent {
    public void check1() {
        RecurringSchedule schedule =
                new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30));
        Event meeting = new Event("회의", LocalDateTime.of(2019, 5, 8, 10, 30), Duration.ofMinutes(30));

        assert meeting.isSatisfiedWithBug(schedule);
    }

    public void checkBug2() {
        RecurringSchedule schedule =
                new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30));
        Event meeting = new Event("회의", LocalDateTime.of(2019, 5, 9, 10, 30), Duration.ofMinutes(30));

        assert !meeting.isSatisfiedWithBug(schedule);
        assert meeting.isSatisfiedWithBug(schedule); // 결과값이 달라진다.
    }

    public void check3() {
        RecurringSchedule schedule =
                new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30));
        Event meeting = new Event("회의", LocalDateTime.of(2019, 5, 9, 10, 30), Duration.ofMinutes(30));

        assert !meeting.isSatisfied(schedule);
        assert !meeting.isSatisfied(schedule);
    }
}
