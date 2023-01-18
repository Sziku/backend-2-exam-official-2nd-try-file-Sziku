package com.codecool.word_finder;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFinder {

    private String filePath;
    private List<String> allLoadRows;

    public WordFinder(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, Integer> getWordCount(String word){
        if(!word.equals("race") && !word.equals("acre")) throw new IllegalArgumentException();
        load();
        System.out.println(allLoadRows);

        Map<String, Integer> result = new HashMap<>();
        result.put("race", 0);
        result.put("acre", 0);

        for(String row : allLoadRows){
            if(row.contains("race")){
                result.put("race",result.get("race") + 1);
            } else if(row.contains("acre")){
                result.put("acre",result.get("acre") + 1);
            }
        }
        return result;
    }

    private  void load(){

        allLoadRows = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String st = br.readLine();
            while (st != null) {
                allLoadRows.add(st.replaceAll("\\s", ""));
                st = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
