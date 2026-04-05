class Solution {

    private static final char DL = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length());
            sb.append(DL);
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int idx = 0;

        while (idx < str.length()) {
            StringBuilder num = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            while (str.charAt(idx) != DL) {
                num.append(str.charAt(idx++));
            }
            idx++;

            int count = Integer.parseInt(num.toString());

            while (count > 0) {
                count--;
                sb.append(str.charAt(idx++));
            }

            res.add(sb.toString());
        }

        return res;
    }
}
