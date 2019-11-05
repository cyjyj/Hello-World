package wf;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.Comparator;  
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;  
import java.util.TreeMap;  


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 
  
public class WordFrequency { 
    static Scanner in =new Scanner(System.in);
    static int qian;
    public static void main(String[] args) throws Exception {  
          
        
        //读取文件内容
        BufferedReader br = new BufferedReader(new FileReader("D:\\I Have a Dream.txt"));  
        List<String> lists = new ArrayList<String>();  //存储过滤后单词的列表  
        String readLine = null;
        while((readLine = br.readLine()) != null){  
            String[] wordsArr1 = readLine.split("[^a-zA-Z]");  //过滤出只含有字母的  
            for (String word : wordsArr1) {  
                if(word.length() != 0){  //去除长度为0的行  
                    lists.add(word);  
                }  
            }  
        }  
          
        br.close();  
        
        
     //存储单词计数信息，key值为单词，value为单词数  
        Map<String, Integer> wordsCount = new TreeMap<String,Integer>();      
          
        //单词的词频统计  
        for (String li : lists) {  
            if(wordsCount.get(li) != null){  
                wordsCount.put(li,wordsCount.get(li) + 1);  
            }else{  
                wordsCount.put(li,1);  
            }
          } 
  
        }  
        
   //按出现频率的大小进行排序  
    public static int SortMap(Map<String,Integer> oldmap){  
          
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());  
          
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){  
            @Override  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                return o2.getValue() - o1.getValue();  //降序  
            }  
        });  
          
        for(int i = 0; i<list.size(); i++){  
         //   System.out.println(list.get(i).getKey()+ "\t出现的次数为: " +list.get(i).getValue());  
         //控制小数点
        int a=list.get(i).getValue();
        int b=list.size(); 
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数  
        String num = df.format((float)a/b);//返回的是String类型 
        
        System.out.println(list.get(i).getKey()+ "\t\n出现的次数为: " +list.get(i).getValue()+"\t出现的频率为"+num);
       
        
        
        }
        return 0;
 
    }  
    
    
    public static int SortMap02(Map<String,Integer> oldmap){  
        
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());  
          
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){  
            @Override  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                return o2.getValue() - o1.getValue();  //降序  
            }  
        });  
          
        for(int i = 0; i<qian; i++){  
         //   System.out.println(list.get(i).getKey()+ "\t出现的次数为: " +list.get(i).getValue());  
         //控制小数点
        int a=list.get(i).getValue();
        int b=list.size(); 
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数  
        String num = df.format((float)a/b);//返回的是String类型 
        
        System.out.println(list.get(i).getKey()+ "\t\n出现的次数为: " +list.get(i).getValue()+"\t出现的频率为"+num);
       
        
        
        }
        return 0;
 
    }  
  
}