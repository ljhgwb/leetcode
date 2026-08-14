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


