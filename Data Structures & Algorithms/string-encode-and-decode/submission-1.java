class Solution {

    private static final char DELIMITER = '#';

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length());
            encoded.append(DELIMITER);
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int l=0, r=0;

        while (r < str.length()) {
            char currCh = str.charAt(r);

            if (currCh == DELIMITER) {
                int len = Integer.parseInt(str.substring(l, r));
                l = r + 1;

                String decoded = str.substring(l, l + len);
                res.add(decoded);

                l = l + len;
                r = l;
            } else {
                r++;
            }
        }

        return res;
    }
}
