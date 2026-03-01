package com.prac.practical;


import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class SubStrTagHandler extends TagSupport{
	private String input;
	private int start;
	private int end;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.println(input.substring(start,end));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
		
	}

	public String getInput() {
		return input;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}