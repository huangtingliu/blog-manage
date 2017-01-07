package com.huangtl.blogmgr.model.blog.dictionary;

/**
 * 通用枚举字典
 * @date 2016年8月19日
 * @author PraiseLord
 */
public interface CommonDictionary {
	/**
	 * 可用性
	 * 
	 * @date 2016年8月19日
	 * @author PraiseLord
	 */
	public enum Usability {
		DELETE(0,"已删除"),
		ENABLE(1, "可用"),
		DISABLE(2, "不可用");
		

		private int code;
		private String text;

		private Usability(int code, String text) {
			this.code = code;
			this.text = text;
		}
		public String getText() {
			return text;
		}
		public int getCode() {
			return code;
		}
	}

	/**
	 * 可见性
	 * @date 2016年8月19日
	 * @author PraiseLord
	 */
	public enum Visibility {
		DELETE(0,"已删除"),
		VISIBLE(1, "可见"),
		INVISIBLE(2, "不可见");
		
		
		private int code;
		private String text;

		private Visibility(int code, String text) {
			this.code = code;
			this.text = text;
		}
		public String getText() {
			return text;
		}
		public int getCode() {
			return code;
		}
	}

}
