package com.ygy.interceptor;

import java.util.Map;

import org.apache.struts2.dispatcher.HttpParameters;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthenticationInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map session = invocation.getInvocationContext().getSession();
		String userInfo = (String) session.get("userId");
		if (userInfo != null) {
			return invocation.invoke();
		} else {
			return Action.INPUT;
		}
	}

}
