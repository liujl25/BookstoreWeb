package com.lingshi.bookstore.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 使用同一的异常处理机制处理mvc异常
 * 	1.编写一个异常解析类，实现org.springframework.web.servlet.ModelAndView。HandlerExceptionResolver接口
 *  2.编写统一错误处理代码
 *  3.修改mvc配置文件，启用全局错误处理（目的：为了避免直接把程序异常暴露给用户）
 *  4.错误处理可以结合：jsp的错误处理页面，进行统一规范和处理
 *  
 * @author Liujl
 *
 */
public class CustomException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object param,
			Exception exception) {
		//根据不同的异常返回不同的视图或返回同一的视图
		ModelAndView view = null;
		if(exception instanceof NullPointerException) {
			view = new ModelAndView("common_error");
			return view;
		}else{
			view = new ModelAndView("common_error2");
			return view;
		}
	}

}
