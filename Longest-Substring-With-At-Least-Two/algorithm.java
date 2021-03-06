public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) return 0;
        int ans = 1; int start = 0;
        char[] twoChar = new char[]{' ',' '};
        int[] twoInd = new int[]{-1,-1};
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(twoChar[0] == ' ' && twoChar[1] == ' ') {
                twoChar[0] = ch;
                twoInd[0] = i;
            }
            else if(twoChar[1] == ' ') {
                if(twoChar[0] == ch) {
                    twoInd[0] = i;
                }
                else {
                    twoChar[1] = ch;
                    twoInd[1] = i;
                }
            }
            else {
                if(twoChar[0] == ch) {
                    twoInd[0] = i;
                }
                else if(twoChar[1] == ch) {
                    twoInd[1] = i;
                }
                else {
                    if(twoInd[0] > twoInd[1]) {
                        start = twoInd[1]+1;
                        twoChar[1] = ch;
                        twoInd[1] = i;
                    } 
                    else {
                        start = twoInd[0]+1;
                        twoChar[0] = ch;
                        twoInd[0] = i;
                    }
                }
            }
            ans = Math.max(ans,Math.max(twoInd[0]-start,twoInd[1]-start)+1);
        }
        return ans;
    }
