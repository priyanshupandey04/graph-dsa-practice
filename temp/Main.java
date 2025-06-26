
public class Main {
    public static void main(String[] args) {
        // int[] nums1 = { -2, -1, 0, 1, 2 };
        // int[] nums2 = { -3, -1, 2, 4, 5 };
        // long k = 3;
        int[] nums1 = { -2, -1, 0, 1, 2 };
        int[] nums2 = { -3, -1, 2, 4, 5 };
        long k = 3;
        System.out.println(kthSmallestProduct(nums1, nums2, k));
    }

    static public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length, n2 = nums2.length;
        long min = Math.min((long) nums1[0] * (long) nums2[0],
                Math.min((long) nums1[0] * (long) nums2[n2 - 1], (long) nums1[n1 - 1] * (long) nums2[0]));
        long max = Math.max((long) nums1[n1 - 1] * (long) nums2[n2 - 1],
                Math.max((long) nums1[0] * (long) nums2[n2 - 1], (long) nums1[n1 - 1] * (long) nums2[0]));
        max = Math.max(max, (long) nums1[0] * (long) nums2[0]);
        int[] nums2reversed = nums2reversed(nums2);
        long start = -6, end = -6, mid = 0, ans = -10;

        while (start <= end) {
            mid = start + (end - start) / 2;
            long lessThanX = smallerThanX(nums1, nums2, mid, false, nums2reversed) + 1;
            System.out.println(".....................");
            long lessThanEqualToX = smallerThanX(nums1, nums2, mid, true, nums2reversed);
            System.out.println("-------------------------------------------mid: " + mid + " lessThanX: " + lessThanX + " lessThanEqualToX: " + lessThanEqualToX);
            if (lessThanX - 1 == lessThanEqualToX)
                lessThanX = lessThanEqualToX;
            if (k >= lessThanX && k <= lessThanEqualToX) {
                ans =  mid;
                end = mid - 1;
            } else if(k > lessThanX)
                start = mid + 1;
            else 
                end = mid - 1;
        }
        return ans;
    }

    private static int[] nums2reversed(int[] nums2) {
        int n2 = nums2.length;
        int[] nums2reversed = new int[n2];
        for (int i = 0; i < n2; i++) {
            nums2reversed[i] = nums2[n2 - i - 1];
        }
        return nums2reversed;
    }

    private static long smallerThanX(int[] nums1, int[] nums2, long mid, boolean isFull, int[] nums2reversed) {
        int n1 = nums1.length, n2 = nums2.length, posJ = n2 - 1, negJ = 0, zeroes = 0;
        long smallers = 0;
        for (int i = 0; i < n1; i++) {
            System.out.println("i = " + i + " isPos = " + (nums1[i] >= 0));
            if (nums1[i] == 0) {
                zeroes++;
                continue;
            }
            if (nums1[i] < 0) {
                long x = mid;
                if (isFull)
                    x = mid + 1;
                while (negJ < n2 && (long) (nums2[negJ]) * (long) (nums1[i]) >= x) {
                    negJ++;
                }
                smallers += (n2 - negJ);
                System.out.println("negJ: " + negJ + " smallers: " + smallers + " x = " + x);
            } else {
                long x = mid;
                if (isFull)
                    x = mid + 1;
                while (posJ >= 0 && (long) (nums2[posJ]) * (long) (nums1[i]) >= x) {
                    posJ--;
                }
                smallers += posJ + 1;
                System.out.println("posJ: " + posJ + " smallers: " + smallers + " x = " + x);
            }
        }
        if (mid > 0 || (isFull && mid == 0))
            return smallers + zeroes * n2;
        return smallers;
    }

}