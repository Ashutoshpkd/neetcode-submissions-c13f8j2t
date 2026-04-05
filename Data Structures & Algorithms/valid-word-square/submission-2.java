class Solution {
    public boolean validWordSquare(List<String> words) {
        int col = words.get(0).length();

        for (int c=0; c<col; c++) {
            StringBuilder sb = new StringBuilder();

            for (int r=0; r<words.size(); r++) {
                if (c >= words.get(r).length()) break;

                sb.append(words.get(r).charAt(c));
            }

            if (words.size() <= c || !words.get(c).equals(sb.toString())) return false;
        }

        return true;
    }
}
