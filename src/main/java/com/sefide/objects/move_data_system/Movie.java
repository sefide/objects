package com.sefide.objects.move_data_system;

public class Movie {
    private String title;
    private Duration ruggningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType; // 영화에 사용된 할인 정책의 종류를 알 수 있는 방법..
    private Money discountAmount;
    private double discountPercent;
}
