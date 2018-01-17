import java.util.ArrayList;
import java.util.List;

//Text Justification

public class LC68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        while(index < words.length) {
            int len = 0;
            List<String> t = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            while(index < words.length && len + words[index].length() <= maxWidth) {
                t.add(words[index]);
                len += words[index].length();
                index++;
                len++;
            }

            int size = t.size() - 1;
            if(size > 0 && index < words.length) {
                int space = (maxWidth - len + t.size()) / size;
                int mod = (maxWidth - len + t.size()) % size;
                for(int i = 0; i < t.size(); i++) {
                    if(i != t.size() - 1) {
                        sb.append(t.get(i));
                        for(int j = 0; j < space; j++) {
                            sb.append(" ");
                        }
                        if(mod > 0) {
                            sb.append(" ");
                            mod--;
                        }
                    }
                    else {
                        sb.append(t.get(i));
                    }
                }

            }
            else {
                for(int i = 0; i < t.size(); i++) {
                    if(i != t.size() - 1) {
                        sb.append(t.get(i));
                        sb.append(" ");
                    }
                    else {
                        sb.append(t.get(i));
                    }
                }
                for(int i = 0; i < maxWidth - len + 1; i++) {
                    sb.append(" ");
                }
            }
            ans.add(sb.toString());
        }
        return ans;

    }
}
