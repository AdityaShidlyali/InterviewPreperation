
class Solution {

    static class Pair {

        int min, max;

        Pair(int max, int min) {
            this.min = min;
            this.max = max;
        }
    }

    public static void getMinMax(int[] a, Pair p) {
        if (a.length == 1) {
            p.min = a[0];
            p.max = a[0];
        } else if (a.length == 2) {
            if (a[0] > a[1]) {
                if (p.max < a[0]) {
                    p.max = a[0];
                }
                if (p.min > a[1]) {
                    p.min = a[1];
                }
            }

            if (a[1] > a[0]) {
                if (p.max < a[1]) {
                    p.max = a[1];
                }
                if (p.min > a[0]) {
                    p.min = a[0];
                }
            }
        } else {
            for (int i = 2; i < a.length; i++) {
                if (a[i] > p.max) {
                    p.max = a[i];
                }
                if (a[i] < p.min) {
                    p.min = a[i];
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {22, 12, 32, 3, 23};

        Pair p = new Pair(a[0], a[0]);

        getMinMax(a, p);

        System.out.println("Max element: " + p.max + " Min element : " + p.min);
    }
}
