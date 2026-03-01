package com;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.tagext.TagSupport;

public class Formatter extends TagSupport{
	public String input;
	public int doStartTag() throws JspException{
		try {
			JspWriter out = pageContext.getOut();
			if(input!=null) {
				out.print(input.replaceAll("_", " "));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
}
