
package com.yinwenqi.ui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yinwenqi.db.CONS;
import com.yinwenqi.model.LoginRsp;
import com.yinwenqi.model.UserInfo;
import com.yinwenqi.model.UserInfoTest;
import com.yinwenqi.service.VerifyService;

@RestController
@RequestMapping(value = "/rest")
public class VerifyUI {

	public VerifyUI() {
		System.out.println("VerifyUI---------------------");
	}

	@Autowired
	VerifyService verifyService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody(required = true) UserInfo userInfo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(userInfo);
		LoginRsp loginRsp = verifyService.verify(userInfo);
		return loginRsp.getResultMsg();
	}

	@RequestMapping(value = "/getPublicKey", method = RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "success_jsonpCallback([{publicKey:\"" + CONS.publicKey + "\"}])";
	}

	@RequestMapping(value = "index.do")
	public void index_jsp(Model model) {
		model.addAttribute("liming", "黎明你好");
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
		//		RequestDispatcher rd = request.getRequestDispatcher("test");
		//		rd.forward(request, response);
		//		response.setStatus(200);
		//		response.sendRedirect("/SMXAlgorithmVerification/views/test.jsp");
		response.setHeader("Access-Control-Allow-Origin", "http://domain");
		return "success_jsonpCallback([{result:\"true\"}])";
	}

	@RequestMapping(value = "/testU", method = RequestMethod.POST)
	public String test(@RequestBody(required = true) UserInfoTest userInfo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(userInfo.toString());
		return "success_jsonpCallback([{result:\"true\",location:\"welcome\"}])";
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test222(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "http://domain");
		// return "success_jsonpCallback([{name:\"John\"}])";
		return "welcome";
	}

	@RequestMapping(value = "/test3", method = RequestMethod.POST)
	public ModelAndView test3() throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "This is a value");
		ModelAndView mav = new ModelAndView("welcome", map);
		return mav;
	}

	@RequestMapping(value = "/test4", method = RequestMethod.POST)
	public String test4() throws Exception {
		return "([{name:\"John\"}])";
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public ModelAndView testRedirect(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "This is a value");
		ModelAndView mav = new ModelAndView("redirect:welcome", map);
		return mav;
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView welcome(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("welcome");
		return mav;
	}
}
