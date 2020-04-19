/**
 * @autheor masheng
 * @description 旋转数组的最小数字
 * @date 2020/4/16
 */
//题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个
// 旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        //分析：直观解法，遍历数组找出最小元素，时间复杂度是O(n)，没有利用输入的旋转数组的特性
        //旋转之后的数组可以划分为两个排序的子数组，前面的子数组的元素都大于等于后面子数组的元素，最小的
        //元素刚好是这两个子数组的分界线
        //1.用两个指针分别指向第一个元素和最后一个元素，按照规则，第一个元素应该大于等于最后一个元素(不
        // 完全对，有特例)
        //2.找到数组中间的元素，如果该元素在前面的子数组中，它应该大于等于第一个元素，这时候数组中最小的
        // 元素在它后面，将第一个指针指向该中间元素，同样如果中间元素在后面的子数组中，它小于等于最后一个
        // 元素，数组中最小的元素在它前面，将最后一个指针指向该中间元素（二分方式）
        //3.重复查找，最终第一个指针会指向前面子数组的最后一个元素，第二个指针会指向后面子数组的第一个元素，
        // 也就是最小元素，这就是循环结束的条件
        //1.定义首尾指针
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            //如果第一个元素小于最后一个元素，数组有序，返回第一个元素
            if (array[i] < array[j]) {
                return array[i];
            }
            //取中间元素
            int mid = i + (j - i) >> 1;
            //如果中间元素大于第一个元素,i = mid + 1
            if (array[mid] > array[i]) {
                i = mid;
                //如果中间元素小于最后一个元素,j = mid，如果是mid-1,可能会错过最小值
            } else if (array[mid] < array[j]) {
                j = mid;
            } else {
                //如果相等就顺序查找
                i++;
            }

        }
        return array[i];
    }

    public static void main(String[] args) {
        MinNumberInRotateArray number = new MinNumberInRotateArray();
        int[] a = {5,6,3,4,4};
        System.out.println(number.minNumberInRotateArray(a));
    }
}