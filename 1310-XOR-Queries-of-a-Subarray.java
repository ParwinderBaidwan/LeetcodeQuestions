class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int l = arr.length; 
        int l1 = queries.length;
        int []prefixXor = new int[l+1];

        // prefix XOR array 
        for(int i=0; i<l; i++){
            prefixXor[i+1] = prefixXor[i] ^ arr[i];
        }

        int[] result = new int[l1];
        for(int i=0; i<l1; i++){
            result[i] = prefixXor[queries[i][1] + 1] ^ prefixXor[queries[i][0]];
        }

        return result;
    }
}