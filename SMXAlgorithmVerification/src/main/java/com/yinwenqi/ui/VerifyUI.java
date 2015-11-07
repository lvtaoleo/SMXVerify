package com.yinwenqi.ui;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yinwenqi.model.LoginRsp;
import com.yinwenqi.model.UserInfo;
import com.yinwenqi.service.VerifyService;

@Controller
public class VerifyUI {

	@Autowired
	VerifyService verifyService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public LoginRsp login(@RequestBody(required = true) UserInfo userInfo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 校验用户账户密码的加密信息是否正确
		boolean canLogin = verifyService.verify(userInfo);
		LoginRsp rsp = new LoginRsp();
		if (canLogin) {
			// 重定向到登录后网页
			RequestDispatcher rd = request.getRequestDispatcher("/welcome.html");
			rd.forward(request, response);
			response.sendRedirect("/welcome.html");
			// 设置登陆成功结果
			rsp.setResult("success");
			rsp.setLastLoginTime(verifyService.getLastLoginTime(userInfo.getUserName()));
		} else {
			rsp.setResult("failed");
		}

		return rsp;
	}

	@RequestMapping(value = "index.do")
	public void index_jsp(Model model) {
		model.addAttribute("liming", "榛庢槑浣犲ソ");
		System.out.println("index.jsp");
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String show(@PathVariable int id, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("id------------------------>" + id);
		return "user";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// RequestDispatcher rd = request.getRequestDispatcher("/welcome.html");
		// rd.forward(request, response);
		// response.setStatus(200);
		// response.sendRedirect("/welcome.html");
		return "test";
	}
}
