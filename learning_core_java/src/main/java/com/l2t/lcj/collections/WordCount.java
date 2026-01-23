package com.l2t.lcj.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCount {

    public static void main(String[] args) {

        String data = "learning java is fun to have fun learn java learning java is fun to have fun learn java learning java is fun to have fun learn java";
        String[] words = data.split(" ");
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word,0)+1);
        }
        System.out.println(wordCountMap);

        Set<String> keys = wordCountMap.keySet();

        for(String key: keys){
            System.out.println(key+" : "+wordCountMap.get(key));
        }

        Collection<Integer> values = wordCountMap.values();

        for(Integer value: values){
            System.out.println(value);
        }

        for(Map.Entry<String,Integer> entry: wordCountMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        wordCountMap.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }
}
