package com.sort.offer;

public class Code11 {
    public boolean isSubStructure(TreeNode A,TreeNode B) {
        if(null==A || null==B){
            return false;
        }
        if(A.val==B.val && null==B.left && null==B.right){
            return true;
        }
        boolean result = false;
        if(A.val!=B.val){
            result = isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }else{
            if(null==B.left && null==B.right){
                return true;
            }else if(null==B.left){
                result = (isSubStructure(A.right,B.right))
                        ||(isSubStructure(A.left,B)||isSubStructure(A.right,B));
            }else if(null==B.right){
                result = (isSubStructure(A.left,B.left))
                        ||(isSubStructure(A.left,B)||isSubStructure(A.right,B));
            }else{
                result = (isSubStructure(A.left,B.left)&&isSubStructure(A.right,B.right))
                        ||(isSubStructure(A.left,B)||isSubStructure(A.right,B));
            }
        }
        return result;
    }
}
