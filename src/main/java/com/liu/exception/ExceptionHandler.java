package com.liu.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@Component
@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(SystemException.class)
	public ModelAndView handleSystemException(SystemException e){
		ModelAndView model = new ModelAndView("error/error");
		model.addObject("errorCode", e.getCode());
		model.addObject("errorMsg", e.getMsg());
		return model;
	}
}
