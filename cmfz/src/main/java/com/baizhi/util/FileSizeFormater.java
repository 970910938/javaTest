package com.baizhi.util;

import java.math.BigDecimal;

public class FileSizeFormater {
    private static final BigDecimal B = new BigDecimal(1024);
    private static final BigDecimal K = new BigDecimal(1024*1024);
    private static final BigDecimal M = new BigDecimal(1024*1024*1024);
    private static final BigDecimal G = new BigDecimal(1024*1024*1024*1024);
/*计算上传文件大小*/
    public static String addSize(long size){
        BigDecimal bdsize = new BigDecimal(size);
        BigDecimal a = bdsize.divide(B, 2,BigDecimal.ROUND_HALF_UP);
        String s = "";
        if(size < 1024){
            s = String.valueOf(size)+"B";
        }else if(size < 1024* 1024){
            s = bdsize.divide(B, 2,BigDecimal.ROUND_HALF_UP).toString()+"K";
        }else if(size < 1024 * 1024 * 1024){
            s = bdsize.divide(K, 2,BigDecimal.ROUND_HALF_UP).toString()+"M";
        }else{
            s = bdsize.divide(M, 2,BigDecimal.ROUND_HALF_UP).toString()+"G";
        }
        return s;
    }
}
