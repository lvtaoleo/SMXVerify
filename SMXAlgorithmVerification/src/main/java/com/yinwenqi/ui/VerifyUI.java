package com.yinwenqi.ui;

//import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yinwenqi.model.User;

@Controller
public class VerifyUI {

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String show(@PathVariable int id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("id------------------------>" + id);
		return "user";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//RequestDispatcher rd = request.getRequestDispatcher("/welcome.html");  
        //rd.forward(request, response);  
		//response.setStatus(200);
        //response.sendRedirect("/welcome.html");  
		return "test";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestBody(required = true) User user, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return "success";
	}
	
	@RequestMapping(value="index.do")  
    public void index_jsp(Model model){  
        model.addAttribute("liming", "黎明你好");  
        System.out.println("index.jsp");  
    }  
}
