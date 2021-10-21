package ptest;

import mapper.AdminMapper;
import org.junit.Test;
import utils.MD5Util;

/**
 * @author 温黎明
 * @version 1.0
 * @date 2021/9/26 15:52
 */
public class PT {

    @Test
    public void MD5(){
        String mi= MD5Util.getMD5("000000");
        System.out.println(mi);
    }
}
