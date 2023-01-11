public class MedianOfTwoSortedArray {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            if(m>n)
                return findMedianSortedArrays(nums2, nums1);

            int left = 0;
            int right = m;
            int midMerge = (m+n+1)/2 ;

            while(left<=right)
            {
                int mid = (left+right)/2;
                int leftASize = mid;
                int leftBSize = midMerge - mid;

                int leftA = leftASize>0 ? nums1[leftASize-1] : Integer.MIN_VALUE;
                int leftB = leftBSize>0 ? nums2[leftBSize-1] : Integer.MIN_VALUE;
                int rightA = leftASize<m ? nums1[leftASize] : Integer.MAX_VALUE;
                int rightB = leftBSize<n ? nums2[leftBSize] : Integer.MAX_VALUE;

                if(leftB<=rightA && rightB>=leftA)
                {
                    if((m+n)%2==0)
                        return (Math.max(leftA, leftB) + Math.min(rightA, rightB))/2.0 ;
                    else
                        return Math.max(leftA, leftB);
                }
                else if(leftA>rightB)
                    right = mid - 1;
                else
                    left = mid+1;


            }
            return 0.0;
        }
}
