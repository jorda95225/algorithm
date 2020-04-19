/**
 * @autheor masheng
 * @description 二维数组中的查找
 * @date 2020/4/11
 */
//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public class TwoDimensionalFind {
    public boolean Find(int target,int[][] array){
        //1.判断数组是否为空
        if (array.length == 0){
            return false;
        }
        //取右上角元素
        int row = 0;
        int col = array[0].length - 1;
        //终止条件，不越界
        while (row < array.length && col > -1){
            if (array[row][col] == target){
                return true;
                //该数字大于要查找的数字，左移
            }else if (array[row][col] > target){
                col--;
            }else {
                row++;
            }
        }
        //如果没查找到，返回false
        return false;
    }
}