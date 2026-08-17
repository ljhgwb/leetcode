import java.util.*;

//判断n以内有多少个素数
public class suanfa {
    public static void main(String[] args){

        System.out.println(bf(100));
    }

    //暴力算法
    public static int bf(int n){
        int count = 0;
        for(int i = 2; i <= n; i++){
            count+=isprime(i)?1:0;
        }
        return count;
    }
    private static boolean isprime(int n){
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
//两数之和  给定数组nums和整数目标值target,找出数组中和为目标值那俩整数，并返回他们下标
class suanfa1{
    public int[] twosum(int[] nums,int target) {
        //创建哈希表
        Map<Integer, Integer> storeNums = new HashMap<>(nums.length, 1 );
        //接收返回下标
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            //找满足条件的数
            int another = target - nums[i];
            //去哈希表判断这个数存不存在，如果存在返回那个数下标
            Integer anotherIndex = storeNums.get(another);
            if(null!=anotherIndex){
                result[0]=anotherIndex;
                result[1]=i;
                break;
            }else{
                //不存在就放入哈希表中
                storeNums.put(nums[i],i);
            }
        }
        return result;//核心判断哈希表中是否存在需要的那个数
    }

}

//给数组和一个值val，需要原地移除所有数值等于val的元素，并返回移除后的数组长度
//不能使用额外数组空间
class suanfa2{
    public int num(int[] nums,int val){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            //核心判断指针处的位置是否需要前移，需要迁移几个位置.
            nums[i-sum]=nums[i];
            if(nums[i]==val){
                sum++;
            }
        }
        return nums.length-sum;
    }
}
//--------贪心算法
//题目：给整数数组，找连续子数组的最大和，子数组至少有一个元素。
//示例：[-2,1,-3,4,-1,2,1,-5,4]，最大子数组[4,-1,2,1]和为 6。
// ---贪心算法，求局部最优解，用当前子数组和+当前数和当前数进行比较，判断是否需要舍弃前面重新开始
// 每次循环后比较选当前最大值
 class suanfa3 {
   public int max(int[] nums){
       int dangqian=nums[0];
       int max=nums[0];
       for(int i=1;i<nums.length;i++){
           dangqian=Math.max(nums[i],dangqian+nums[i]);
           max=Math.max(dangqian,max);
       }
       return max;
   }
 }
//--------贪心算法
//给出一个区间的集合，请合并所有重叠的区间。
//示例 1
//输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠，将它们合并为 [1,6]
 class suanfa4 {
     public int[][] merge(int[][] intervals) {
         //数组长度小于等于1，直接返回，无需合并
         if (intervals.length <= 1) {
             return intervals;
         }
         //按照区间左端点升序排序
         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
         List<int[]> resList = new ArrayList<>();
         //第一个区间直接加入结果集
         resList.add(intervals[0]);
         //从第二个区间开始遍历
         for (int i = 1; i < intervals.length; i++) {
             //取出结果集中最后一个区间
             int[] last = resList.get(resList.size() - 1);
             //当前区间的左边界
             int curLeft = intervals[i][0];
             //当前区间的右边界
             int curRight = intervals[i][1];
             //判断是否重叠：当前左边界 <=上一个的右边界
             if (curLeft <= last[1]) {
                 //重叠，更新右边界，取两者最大
                 last[1] = Math.max(last[1], curRight);
             } else {
                 //不重叠，直接加入结果
                 resList.add(intervals[i]);
             }
         }
         //List转为二维数组返回
         return resList.toArray(new int[resList.size()][]);
     }//核心就是先将二维数组排序，创建集合赋值最小的数组区间，for循环遍历二维数组后续数组
      //判断当前数组区间左边是否<=集合中最后一个数组区间最右边，若是则重合，取出两个数组最大的有区间，赋值集合中数组，否则不重合直接放到集合中。
 }


