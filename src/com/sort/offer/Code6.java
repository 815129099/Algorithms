package com.sort.offer;

import java.util.Arrays;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Code6 {
    public static int minNumberInRotateArray(int [] array) {
        int length = array.length;
        if(length==0){
            return 0;
        }
        return getMin(array);
    }

    public static int getMin(int[] array){
        int length = array.length;
        if (length==0){
            return Integer.MAX_VALUE;
        }else if(length==1){
            return array[0];
        }else if(length==2){
            return Math.min(array[0],array[1]);
        }
        int middle = length/2;
        int min = array[length-1];
        if(array[middle]<=min){
            min = array[middle];
            min = Math.min(getMin(Arrays.copyOfRange(array,0,middle)),min);
        }else{
            min = Math.min(getMin(Arrays.copyOfRange(array,middle+1,length)),min);
        }
        return min;
    }

    public static void main(String[] args) {
        //int[] arr = {4197,4251,4281,4287,4307,4334,4364,4410,4445,4467,4492,4572,4596,4727,4777,4919,4921,4984,5037,5065,5291,5351,5355,5385,5403,5416,5638,5711,5754,5757,5766,5813,5839,5847,5925,5940,6032,6078,6091,6218,6302,6372,6455,6544,6581,6670,6733,6750,6758,6983,7039,7099,7126,7222,7382,7407,7424,7431,7553,7586,7608,7693,7739,7771,7919,7991,8022,8045,8239,8248,8314,8347,8535,8604,8650,8688,8786,8799,8843,8957,8987,8990,9023,9102,9112,9144,9196,9234,9241,9353,9434,9435,9472,9479,9487,9500,9533,9590,9681,9761,9809,9813,9834,9842,9861,22,42,103,119,141,156,171,186,195,202,310,371,465,583,633,672,755,782,816,936,961,1040,1046,1117,1139,1206,1258,1281,1292,1340,1342,1345,1349,1353,1371,1438,1459,1657,1681,1731,1797,1830,2069,2094,2189,2232,2290,2315,2316,2369,2390,2404,2412,2518,2548,2557,2588,2667,2675,2678,2875,2896,2948,3001,3050,3064,3118,3125,3137,3159,3169,3190,3270,3333,3551,3699,3764,3794,3816,3978,3993,4002,4076,4156,4165};
        int[] arr = {2,2,1,2,2,2};
        System.out.println(minNumberInRotateArray(arr));
    }
}
