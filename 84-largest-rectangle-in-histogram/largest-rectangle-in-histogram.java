class Solution {
    public int[] nextSmallerElements(int[] heights, int n){
        int[] arr = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i=n-1; i>=0; i--){
            int curr = heights[i];
            
            while(!st.isEmpty() && st.peek() != -1 && heights[st.peek()] >= curr){
                st.pop();
            }
            arr[i] = st.isEmpty() ? -1 : st.peek();
            // arr[i] = st.peek();
            st.push(i);
        }

        return arr;
    }

    public int[] prevSmallerElements(int[] heights, int n){
        int[] arr = new int[n];

        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i=0; i<n; i++){
            int curr = heights[i];

            while(!st.isEmpty() && st.peek() != -1 && heights[st.peek()] >= curr){
                st.pop();
            }
            arr[i] = st.isEmpty() ? -1 : st.peek();
            // arr[i] = st.peek();
            st.push(i);
        }

        return arr;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] prev = new int[n];
        prev = prevSmallerElements(heights, n);

        int[] next = new int[n];
        next = nextSmallerElements(heights, n);

        int area = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int l = heights[i];

            // if all equal next[] last elem will be -1
            if(next[i] == -1) next[i] = n;

            int b = next[i] - prev[i] - 1;
            int newArea = l * b;
            area = area > newArea ? area : newArea;
        }

        return area;
    }
}