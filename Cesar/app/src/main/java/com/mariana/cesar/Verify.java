package com.mariana.cesar;

import java.util.HashMap;
import java.util.Map;

public class Verify {

    public boolean verifyPermuted(String word, String word2){
        Map<Character, Integer> hashWord = new HashMap<>();
        Map<Character, Integer> hashWord2 = new HashMap<>();
        if (word.length() == word2.length() && word.charAt(0) == word2.charAt(0)) {
            int tamDifference = 0;
            for (int i = 1; i < word.length(); i++) {
//              If word are different count for after check if diffent / tamTotal are more than 2 / 3
                if (word.charAt(i) == word2.charAt(i)) {
                    tamDifference++;
                }
                add(word.charAt(i), hashWord);
                add(word2.charAt(i), hashWord2);
            }
//            Check if permutation are more than 2 / 3
            if (tamDifference / word.length() > 2.0f / 3.0f) {
//                return False
                return false;
            }
//            Verify if the two words have the same qtd of letters
            for (char letter : hashWord.keySet()) {
                if (!hashWord2.containsKey(letter)) {
                    return false;
                } else {
                    if (hashWord.get(letter) != hashWord2.get(letter)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public void add(char letter, Map<Character, Integer> hashWord) {
        if (hashWord.containsKey(letter)) {
            hashWord.put(letter, hashWord.get(letter) + 1);
        }else{
            hashWord.put(letter, 1);
        }

    }

    public boolean verifyTypo(String word, String word2){
        if (Math.abs(word.length() - word2.length()) > 1){
            return false;
        }else{
            if (word.length() >= word2.length()){
                return comparate(word2, word);
            }else {
                return comparate(word, word2);
            }

        }
    }

    public boolean comparate(String word, String word2){
        boolean findTypo = true;
        int i, j;
        for (i = 0, j = 0; i < word.length(); i++, j++){
            if(word.charAt(i) != word2.charAt(j) && findTypo){
                findTypo = false;
                i++;
            }else if(word.charAt(i) != word2.charAt(j)){
                return false;
            }
        }
        if (j < word2.length() - 1 && !findTypo) {
            return false;
        }else{
            return true;
        }
    }


}
