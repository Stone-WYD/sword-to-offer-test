package chapter5;

/**
 * @program: sword-to-offer-test
 * @author: Stone
 * @create: 2024-04-22 16:27
 */
public class Test34 {
    // 外星语言是否排序
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[order.length()];
        for (int i = 0; i < order.toCharArray().length; i++) {
            orderArray[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];
            if (!isSorted(w1, w2, orderArray)) return false;
        }
        return true;
    }

    private boolean isSorted(String w1, String w2, int[] orderArray) {
        String shortS = w1.length() > w2.length() ? w2 : w1;
        for (int i = 0; i < shortS.length(); i++) {
            if (w1.charAt(i) - 'a' > w2.charAt(i) - 'a') {
                return true;
            } else if (w1.charAt(i) - 'a' < w2.charAt(i) - 'a') {
                return false;
            }
        }
        return false;
    }
}