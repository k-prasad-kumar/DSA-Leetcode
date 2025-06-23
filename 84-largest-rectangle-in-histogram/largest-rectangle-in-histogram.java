class Solution {
    public int[] nextSmallerElements(int[] arr, int n){
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i=n-1; i>=0; i--){
            int curr = arr[i];

            while(st.peek() != -1 && arr[st.peek()] >= curr){
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }

        return ans;
    }

    public int[] prevSmallerElements(int[] arr, int n){
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i=0; i<n; i++){
            int curr = arr[i];

            while(st.peek() != -1 && arr[st.peek()] >= curr){
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        if (heights == null || n == 0) return 0;
        
        int[] prev = new int[n];
        prev = prevSmallerElements(heights, n);

        int[] next = new int[n];
        next = nextSmallerElements(heights, n);

        int area = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int l = heights[i];

            if(next[i] == -1) next[i] = n;

            int newArea = l * (next[i] - prev[i] - 1);
            area = area > newArea ? area : newArea;
        }

        return area;
    }
}