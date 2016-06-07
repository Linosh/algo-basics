import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dmitriiiermiichuk on 6/5/16.
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak2("aaaaaaa", new HashSet<>(Arrays.asList("aaaa", "aaa"))));
    }

    public boolean wordBreak2(String s, Set<String> wordDict) {
        int[] pos = new int[s.length()+1];

        Arrays.fill(pos, -1);

        pos[0]=0;

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[s.length()]!=-1;
    }

    public boolean wordBreak(String s, Set<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }

    public boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length())
            return true;

        for(String a: dict){
            int len = a.length();
            int end = start+len;

            //end index should be <= string length
            if(end > s.length())
                continue;

            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }

        return false;
    }
}
