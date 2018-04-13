package com.HM.SortNumbers.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.HM.SortNumbers.service.SortNumbersAppService;

@Controller
public class SortNumbersAppController {


	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "ScrSortAppPage";
	}

	@Autowired
	SortNumbersAppService service;

	@RequestMapping(value="/sorted-numbers", method = RequestMethod.POST)
	public String sortNumbers(@RequestParam("numberVal") String numberVal, ModelMap model){

		model.put("results", service.sortNumbers(numberVal));
		model.put("isResultShow", "Y");
		return "ScrSortAppPage";
	}


}
