import java.util.HashMap;
import java.util.Map;

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
        return result;
    }

}
//核心判断哈希表中是否存在需要的那个数

