package Util;
/**
 * �ַ���������
 * @author DELL2017
 *����ʱ��:2020��6��19�� ����6:09:43
 */
public class StringUtil {
	/**
	 * �ж��Ƿ�Ϊ��
	 * @param str
	 * @return true(��) false(�ǿ�)
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
