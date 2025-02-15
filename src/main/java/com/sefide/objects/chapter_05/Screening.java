package com.sefide.objects.chapter_05;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public void setWhenScreened(LocalDateTime whenScreened) {
        this.whenScreened = whenScreened;
    }

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Money calculateFee(int audienceCount) {
       switch (movie.getMovieType()) {
           case AMOUNT_DISCOUNT:
               if (movie.isDiscountable(whenScreened, sequence)) {
                   return movie.calculateAmountDiscountFee().times(audienceCount);
               }
               break;
           case PERCENT_DISCOUNT:
               if (movie.isDiscountable(whenScreened, sequence)) {
                   return movie.calculatePercentDiscountFee().times(audienceCount);
               }
               break;
           case NONE_DISCOUNT:
               return movie.calculateNoneDiscountFee().times(audienceCount);
       }

       return movie.calculateNoneDiscountFee().times(audienceCount);
    }
}
