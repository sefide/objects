package com.sefide.objects.chapter_05;

public class ReservationAgency {
//    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
//        Movie movie = screening.getMovie();
//
//        boolean discountable = false;
//        for (DiscountCondition condition : movie.getDiscountConditions()) {
//            if (condition.getType() == DiscountConditionType.PERIOD) {
//                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
//                        !condition.getStartTime().isAfter(screening.getWhenScreened().toLocalTime()) &&
//                        !condition.getEndTime().isBefore(screening.getWhenScreened().toLocalTime());
//            } else {
//                discountable = condition.getSequence() == screening.getSequence();
//            }
//
//            if (discountable) {
//                break;
//            }
//        }
//
//        Money fee;
//        if (discountable) { // 할인 여부
//            Money discountAmount = switch (movie.getMovieType()) {
//                case AMOUNT_DISCOUNT -> movie.getDiscountAmount();
//                case PERCENT_DISCOUNT -> movie.getFee().times(movie.getDiscountPercent());
//                case NONE_DISCOUNT -> Money.ZERO;
//            };
//
//            fee = movie.getFee().minus(discountAmount).times(audienceCount);
//        } else {
//            fee = movie.getFee();
//        }
//
//        return new Reservation(customer, screening, fee, audienceCount);
//    }

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
