class Solution {
    class Element {
        public int row;
        public int col;
        public int val;
        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++) {
            Element ele = new Element(i,0,nums.get(i).get(0));
            max = Math.max(max,nums.get(i).get(0));
            pq.offer(ele);
        }
        
        int[] res = new int[2];
        int range = Integer.MAX_VALUE;
        
        while(pq.size() == nums.size()) {
            Element e = pq.poll();
            if(max-e.val < range) {
                range = max-e.val;
                res[0] = e.val;
                res[1] = max;
            }
            if(e.col+1 < nums.get(e.row).size()) {
                e.col += 1;
                e.val = nums.get(e.row).get(e.col);
                max = Math.max(max,e.val);
                pq.offer(e);
            }
        }
        
        return res;
    }
}
