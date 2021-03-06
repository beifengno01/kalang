package kalang.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MathType   {
     public static final int INT=1;
     public static final int LONG=2;
     public static final int FLOAT=3;
     public static final int DOUBLE=4;
     public static final int BYTE = 5;
     public static final java.lang.String INT_STR="int";
     public static final java.lang.String LONG_STR="long";
     public static final java.lang.String FLOAT_STR="float";
     public static final java.lang.String DOUBLE_STR="double";
     public static final String BYTE_STR = "byte";
     public static final int OP_ADD=1;
     public static final int OP_SUB=2;
     public static final int OP_MUL=3;
     public static final int OP_DIV=4;
     public static final int OP_MOD=5;
     public static final java.lang.String OP_ADD_STR="+";
     public static final java.lang.String OP_SUB_STR="-";
     public static final java.lang.String OP_MUL_STR="*";
     public static final java.lang.String OP_DIV_STR="/";
     public static final java.lang.String OP_MOD_STR="%";
     public static boolean isFloatPoint(java.lang.String type) {
         return ((type.equals(kalang.util.MathType.FLOAT_STR))||(type.equals(kalang.util.MathType.DOUBLE_STR)));
         
    }
     public static boolean isFloatPoint(int type) {
         return ((type==kalang.util.MathType.FLOAT)||(type==kalang.util.MathType.DOUBLE));         
    }
     public static int getType(java.lang.String type) {
         if((type.equals(kalang.util.MathType.INT_STR))) {
             return kalang.util.MathType.INT;
        }else if((type.equals(kalang.util.MathType.LONG_STR))) {
             return kalang.util.MathType.LONG;
        }else if((type.equals(kalang.util.MathType.FLOAT_STR))) {
             return kalang.util.MathType.FLOAT;
        }else if((type.equals(kalang.util.MathType.DOUBLE_STR))) {
             return kalang.util.MathType.DOUBLE;
        }else if(type.equals(BYTE_STR)){
            return BYTE;
        }
         return 0;
         
    }
     public static java.lang.String getTypeStr(int type) {
         if((type==kalang.util.MathType.INT)) {
             return kalang.util.MathType.INT_STR;
        }else if((type==kalang.util.MathType.LONG)) {
             return kalang.util.MathType.LONG_STR;
        }else if((type==kalang.util.MathType.FLOAT)) {
             return kalang.util.MathType.FLOAT_STR;
        }else if((type==kalang.util.MathType.DOUBLE)) {
             return kalang.util.MathType.DOUBLE_STR;
        }else if(type == BYTE){
             return BYTE_STR;
         }
         return "";
    }
     public static int getOperation(java.lang.String op) {
         if((op.equals(kalang.util.MathType.OP_ADD_STR))) {
             return kalang.util.MathType.OP_ADD;
             
        }
         if((op.equals(kalang.util.MathType.OP_SUB_STR))) {
             return kalang.util.MathType.OP_SUB;
             
        }
         if((op.equals(kalang.util.MathType.OP_MUL_STR))) {
             return kalang.util.MathType.OP_MUL;
             
        }
         if((op.equals(kalang.util.MathType.OP_DIV_STR))) {
             return kalang.util.MathType.OP_DIV;
             
        }
         if((op.equals(kalang.util.MathType.OP_MOD_STR))) {
             return kalang.util.MathType.OP_MOD;
             
        }
         return 0;
         
    }
     public static java.lang.String getOperationStr(int op) {
         if((op==kalang.util.MathType.OP_ADD)) {
             return kalang.util.MathType.OP_ADD_STR;
             
        }
         if((op==kalang.util.MathType.OP_SUB)) {
             return kalang.util.MathType.OP_SUB_STR;
             
        }
         if((op==kalang.util.MathType.OP_MUL)) {
             return kalang.util.MathType.OP_MUL_STR;
             
        }
         if((op==kalang.util.MathType.OP_DIV)) {
             return kalang.util.MathType.OP_DIV_STR;
             
        }
         if((op==kalang.util.MathType.OP_MOD)) {
             return kalang.util.MathType.OP_MOD_STR;
             
        }
         return "";
         
    }
     public static java.lang.String getType(java.lang.String type1,java.lang.String type2,java.lang.String op) {
         int t1=getType(type1);
         int t2=getType(type2);
         int o=getOperation(op);
         int ret=getType(t1,t2,o);
         return getTypeStr(ret);
         
    }
     public static int getType(int type1,int type2,int op) {
         if(((isFloatPoint(type1)||isFloatPoint(type2))||(op==kalang.util.MathType.OP_DIV))) {
             return kalang.util.MathType.DOUBLE;
             
        }
         if(((type1==kalang.util.MathType.LONG)||(type2==kalang.util.MathType.LONG))) {
             return kalang.util.MathType.LONG;
             
        }
         return kalang.util.MathType.INT;
         
    }
     
    public static boolean castable(int fromType,int toType){
        if (fromType==toType) {
            return true;
        }
        HashMap<Integer, List> baseMap = new HashMap();
        baseMap.put(BYTE,Arrays.asList(new Integer[]{INT,LONG,FLOAT,DOUBLE}));
        baseMap.put(INT, Arrays.asList(new Integer[]{LONG, FLOAT, DOUBLE}));
        baseMap.put(LONG, Arrays.asList(new Integer[]{FLOAT, DOUBLE}));
        baseMap.put(FLOAT, Arrays.asList(new Integer[]{DOUBLE}));
        baseMap.put(DOUBLE, new LinkedList());
        if (baseMap.containsKey(fromType)) {
            return baseMap.get(fromType).contains(toType);
        }
        return false;
    }

     
}
 