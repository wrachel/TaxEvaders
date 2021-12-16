package com.project.frqs.bryant;

import java.util.Arrays;

public class draw {
    private int x, y, len;

    public draw(int x, int y, int len) { // constructor moment
        this.x = Math.min(Math.max(x, -16), 15);
        this.y = Math.min(Math.max(y, -12), 11);
        this.len = len = Math.min(len, Math.min(16 - x, 12 - y));
    }

    public static int[] get_coordinates(int x, int y, int len) {
        int[] draw_values = new int[5];

        draw square = new draw(x, y, len);
        draw_values[0] = this.x;
        draw_values[1] = this.y;
        draw_values[2] = this.len;
        return draw_values;
    }

    public static void main(String[] args) {
        draw draw = new draw(1, 4, 3);
        System.out.println(Arrays.toString(draw.get_coordinates()));
    }


}
