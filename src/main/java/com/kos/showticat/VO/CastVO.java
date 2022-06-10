package com.kos.showticat.VO;

public class CastVO {
	private String show_code;
	private String cast_num;
	private String cast_name;
	private String cast_url;
	
	public CastVO() {}
	
	public CastVO(String cast_name, String cast_url) {
		super();
		this.cast_name = cast_name;
		this.cast_url = cast_url;
	}

	public CastVO(String show_code, String cast_num, String cast_name, String cast_url) {
		super();
		this.show_code = show_code;
		this.cast_num = cast_num;
		this.cast_name = cast_name;
		this.cast_url = cast_url;
	}

	public String getShow_code() {
		return show_code;
	}

	public void setShow_code(String show_code) {
		this.show_code = show_code;
	}

	public String getCast_num() {
		return cast_num;
	}

	public void setCast_num(String cast_num) {
		this.cast_num = cast_num;
	}

	public String getCast_name() {
		return cast_name;
	}

	public void setCast_name(String cast_name) {
		this.cast_name = cast_name;
	}

	public String getCast_url() {
		return cast_url;
	}

	public void setCast_url(String cast_url) {
		this.cast_url = cast_url;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CastVO [show_code=").append(show_code).append(", cast_num=").append(cast_num)
				.append(", cast_name=").append(cast_name).append(", cast_url=").append(cast_url).append("]");
		return builder.toString();
	}
	
}
