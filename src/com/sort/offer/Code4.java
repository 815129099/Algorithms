package com.sort.offer;


public class Code4 {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0 || in.length==0){
            return null;
        }else if(pre.length==1){
            return new TreeNode(pre[0]);
        }
        int length = pre.length;
        int val = pre[0];

        int index = 0;
        //确定根节点的位置
        for(int i=0;i<length;i++){
            if(val==in[i]){
                index = i;
                break;
            }
        }

        TreeNode node = new TreeNode(val);
        TreeNode left = null;
        if(index!=0){
            int[] lpre = new int[index];
            int lp=0,li=0;
            int[] lin = new int[index];
            for(int j=0;j<=index;j++){
                if(j==0){
                    lin[li++] = in[j];
                }else if(j==index){
                    lpre[lp++] = pre[j];
                }else{
                    lin[li++] = in[j];
                    lpre[lp++] = pre[j];
                }
            }
            left = reConstructBinaryTree(lpre,lin);
        }
        node.left = left;

        TreeNode right = null;
        if(index!=length-1){
            int[] rpre = new int[length-index-1];
            int rp=0,ri=0;
            int[] rin = new int[length-index-1];
            for(int j=index+1;j<length;j++){
                rpre[rp++] = pre[j];
                rin[ri++] = in[j];
            }
            right = reConstructBinaryTree(rpre,rin);
        }
        node.right = right;
        return node;
    }

    public static void main(String[] args) {
        int[] l = {1,2,3,4};
        int[] r = {1,2,3,4};
        TreeNode t = reConstructBinaryTree(l,r);
    }


}
