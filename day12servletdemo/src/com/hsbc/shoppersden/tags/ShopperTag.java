package com.hsbc.shoppersden.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShopperTag extends SimpleTagSupport{

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		getJspContext().getOut().print("LTI Creates Shoppers Den !!!!!!!!!");
	}

}
