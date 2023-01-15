
class Solution {

    static class Pair {

        int min, max;

        Pair(int max, int min) {
            this.min = min;
            this.max = max;
        }
    }

    public static void getMinMax(int[] a, Pair p) {
        int i;

        // If there are even number of elements in array
        // then assign the first two elements as minimum and maximum accordingly
        if (a.length % 2 == 0) {
            if (a[0] > a[1]) {
                p.max = a[0];
                p.min = a[1];
            } else {
                p.max = a[1];
                p.min = a[0];
            }

            // index to start the comparison of the element from the second index of the array
            i = 2;

        } else { // If there are odd number of elements in array
            // then assign the first element itself as the max and min elements
            p.min = a[0];
            p.max = a[0];

            // index to start the comparison of the element from the first index of the array
            i = 1;
        }

        while (i < a.length - 1) {

            if (a[i] > a[i + 1]) {
                if (a[i] > p.max) {
                    p.max = a[i];
                }
                if (a[i + 1] < p.min) {
                    p.min = a[i];
                }
            } else {
                if (a[i + 1] > p.max) {
                    p.max = a[i + 1];
                }
                if (a[i] < p.min) {
                    p.min = a[i];
                }
            }

            i++;
        }
    }

    public static void main(String[] args) {

        int[] a = {22, 12, 32, 3, 23};

        Pair p = new Pair(a[0], a[0]);

        getMinMax(a, p);

        System.out.println("Max element: " + p.max + " Min element : " + p.min);
    }
}
