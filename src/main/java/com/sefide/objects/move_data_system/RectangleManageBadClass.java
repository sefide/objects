package com.sefide.objects.move_data_system;

public class RectangleManageBadClass {
    void enlarge(Rectangle rectangle, int multiple) {
        rectangle.setRight(rectangle.getRight() * multiple);
        rectangle.setBottom(rectangle.getBottom() * multiple);
    }
}
