package com.project.frqs.bryant;

public class draw {
    private int x, y, len;

    public draw(int x, int y, int len) { // constructor moment
        this.x = Math.min(Math.max(x, -16), 15);
        this.y = Math.min(Math.max(y, -12), 11);
        this.len = len = Math.min(len, Math.min(16 - x, 12 - y));
    }

    public static String[] get_coordinates(int x, int y, int len) {
        int[] draw_values = new int[5];

        draw square = new draw(x, y, z);
        draw_values[0] = this.x;
        draw_values[1] = this.y;
        draw_values[2] = this.len;
        return draw_values;
    }

    public static void main(String[] args) {
        draw gradShow = new draw("0101 0101 0101");
        gradShow.display();
        gradShow.changeSequence("0011 0011 0011");
        String resultSeq = gradShow.insertSegment("1111 1111", 4);
        String newSeq = "1100000111".replaceFirst("00", "");
        System.out.println(Math.sqrt(Math.pow(3,2)+Math.pow(4,2)));
        System.out.println(resultSeq);
        System.out.println(newSeq);
    }


}
