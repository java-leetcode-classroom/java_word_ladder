import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        HashMap<String, List<String>> patternMap = new HashMap<>();
        HashSet<String> visit = new HashSet<>();
        List<String> copyWordList = new ArrayList<>(wordList);
        copyWordList.add(beginWord);
        for (String word: copyWordList) {
            int sLen = word.length();
            for (int idx = 0; idx < sLen; idx++) {
                String pattern = word.substring(0, idx)+"*"+word.substring(idx+1);
                List<String> patternList = patternMap.containsKey(pattern)? patternMap.get(pattern): new ArrayList<>();
                patternList.add(word);
                patternMap.put(pattern, patternList);
            }
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visit.add(beginWord);
        int res = 1;
        while(queue.size() != 0) {
            int qLen = queue.size();
            for (int idx = 0; idx < qLen; idx++) {
                String top = queue.poll();
                if (top.equals(endWord)) {
                    return res;
                }
                // generate match pattern
                int sLen = top.length();
                for (int k = 0; k < sLen; k++) {
                    String pattern = top.substring(0, k) + "*"+ top.substring(k+1);
                    List<String> patternList = patternMap.get(pattern);
                    for (String word : patternList) {
                        if (!visit.contains(word)) {
                            visit.add(word);
                            queue.add(word);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
