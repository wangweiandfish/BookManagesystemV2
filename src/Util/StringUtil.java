package Util;
/**
 * 字符串工具类
 * @author DELL2017
 *创建时间:2020年6月19日 下午6:09:43
 */
public class StringUtil {
	/**
	 * 判断是否为空
	 * @param str
	 * @return true(空) false(非空)
	 */
public static boolean isEmpty(String str) {
	if(str==null || "".equals(str.trim())) {
		return true;
	}else {
		return false;
	}
}

public static boolean isNotEmpty(String str) {
	if(str!=null && !"".equals(str.trim())) {
		return true;
	}else {
		return false;
	}
}
}
