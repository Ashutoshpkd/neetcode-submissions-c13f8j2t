class Solution {
    public String convert(String s, int numRows) {
        List<List<Character>> zigzag = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        int idx = 0;

        for (int i=0; i<numRows; i++) zigzag.add(new ArrayList<>());

        while (idx < s.length()) {

            for (int i=0; i<numRows && idx < s.length(); i++) {
                zigzag.get(i).add(s.charAt(idx++));
            }

            int loopCnt = numRows - 2, putIdx = numRows - 2;

            while (loopCnt > 0 && idx < s.length()) {

                for (int r=0; r<numRows && idx < s.length(); r++) {
                    if (r == putIdx) {
                        zigzag.get(r).add(s.charAt(idx++));
                        putIdx--;
                    } else {
                        zigzag.get(r).add('#');
                    }
                }

                loopCnt--;
            }
        }

        for (int i=0; i<zigzag.size(); i++) {
            List<Character> row = zigzag.get(i);

            for (int j=0; j<row.size(); j++) {
                if (row.get(j) != '#') {
                    res.append(row.get(j));
                }
            }
        }

        return res.toString();
    }
}