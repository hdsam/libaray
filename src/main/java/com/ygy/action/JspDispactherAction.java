package com.ygy.action;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class JspDispactherAction extends ActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9115783929954417209L;

	@Override
	public String execute() throws Exception {
		String uri=ServletActionContext.getRequest().getParameter("uri");
		return uri;
	}
}
