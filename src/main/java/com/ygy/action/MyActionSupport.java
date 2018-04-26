package com.ygy.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MyActionSupport extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public PrintWriter getWriter() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("GB2312");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

	public HttpSession getSession() {
		return this.getRequest().getSession();
	}

	public HttpServletRequest getRequest() {

		return ServletActionContext.getRequest();
	}

}
