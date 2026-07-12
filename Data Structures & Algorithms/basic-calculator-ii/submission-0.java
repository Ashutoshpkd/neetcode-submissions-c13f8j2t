class Solution {
    public int calculate(String s) {
        char op = '+';
        int num = 0;
        Stack<Integer> st = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (op == '+') {
                    st.push(num);
                }

                if (op == '-') {
                    st.push(-num);
                }

                if (op == '*') {
                    st.push(st.pop() * num);
                }

                if (op == '/') {
                    st.push(st.pop() / num);
                }

                op = c;
                num = 0;
            }
        }

        int res = 0;

        while (!st.isEmpty()) {
            res += st.pop();
        }

        return res;
    }
}