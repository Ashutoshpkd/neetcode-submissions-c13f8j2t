class Solution {
    public String decodeString(String s) {
        Info decoded = decode(s, 0);
        return decoded.res.toString();
    }

    private Info decode(String s, int idx) {
        if (idx >= s.length()) return new Info(idx, new StringBuilder());
        int num = 0;
        Info res = new Info(0, new StringBuilder());

        for (int i=idx; i<s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '[') {
                Info curr = decode(s, i + 1);
                for (int j=0; j<num; j++) {
                    res.res.append(curr.res.toString());
                }
                i = curr.idx;
                num = 0;
            } else {
                if (s.charAt(i) == ']') {
                    res.idx = i;
                    break;
                }

                res.res.append(s.charAt(i));
            }
        }

        return res;
    }

    private static class Info {
        int idx;
        StringBuilder res;

        public Info(int idx, StringBuilder res) {
            this.idx = idx;
            this.res = res;
        }
    }
}