package zhizhenhechuangkou;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//使用算法：滑动窗口（双指针）
//给定一个字符串 s ，找出其中不含有重复字符的最长子串的长度。
//s = "pwwkew" wke 长度3
public class zhizhen {
    public int chang(String s){
        Set<Character> set=new HashSet<>();//创建哈希表存储字符串
        int left=0;
        int max=0;
        for(int right=0;right<s.length();right++){
            char ch =s.charAt(right);//取右指针为当前指针
            while(set.contains(ch)){//判断ch是否重复出现set中
                set.remove(s.charAt(left));//重复出现就删除最左边的字符，直至set中没有重复
                left++;//左边界右移缩小set
            }
            set.add(ch);//存入当前右指针
            max=Math.max(max,right-left+1);

        }
        return max;
    }//核心双指针，创建哈希表存储字符串，，创建右指针为当前指针
    //判断哈希表是否有与当前指针重复的字符，有的话移动左指针，缩小窗口，没有就放入哈希表

}
