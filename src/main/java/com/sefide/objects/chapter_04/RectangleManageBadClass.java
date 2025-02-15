package com.sefide.objects.chapter_04;

public class RectangleManageBadClass {
    void enlarge(Rectangle rectangle, int multiple) {
        rectangle.setRight(rectangle.getRight() * multiple);
        rectangle.setBottom(rectangle.getBottom() * multiple);
    }
}
