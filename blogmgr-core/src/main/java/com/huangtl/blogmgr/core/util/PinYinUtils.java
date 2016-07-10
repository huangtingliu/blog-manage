package com.huangtl.blogmgr.core.util;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * 汉字拼音转拼音工具
 * @date 2016年7月10日
 * @author PraiseLord
 * 具体参考 {@link net.sourceforge.pinyin4j.PinyinHelper}
 */
public final class PinYinUtils {
	
	/**
	 * 将一组字符中的汉字转成拼音，而其他非汉字的则保留原样。
	 * @param text
	 * <pre>
	 *  null            = "" 
	 *  ""              = ""
	 *  "aa#"           = "aa#"
	 *  "adf明i1sd砂"   = "adfmi1giosdsha"
	 *  </pre>
	 */
	public static String toPinYin(String text){
		if(StringUtils.isBlank(text)){return "";}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char unit = text.charAt(i);
			String singleStr = String.valueOf(unit);
			if( Pattern.matches("[\u4e00-\u9fa5]", singleStr)){//是汉字就转接
				singleStr = PinyinHelper.toGwoyeuRomatzyhStringArray(unit)[0];
			}
			sb.append(singleStr);
		}
		
		return sb.toString();
	}

}
