<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
System.out.println(request.getSession().getId());
System.out.println(request.getSession().getLastAccessedTime());
System.out.println(request.getSession().toString());
	String path = request.getContextPath(); 
	// 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp/）: 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    System.out.println(basePath);
%> 
<html dir="ltr" lang="zh_CN">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
		<title>JavaScript版国密算法的实现</title>
	
		<!--- CSS --->
		<link rel="stylesheet" href="<%=basePath%>/views/css/style.css" type="text/css" />
	
	
		<!--- Javascript libraries (jQuery and Selectivizr) used for the custom checkbox --->
	
		<!--[if (gte IE 6)&(lte IE 8)]>
			<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
			<script type="text/javascript" src="selectivizr.js"></script>
			<noscript><link rel="stylesheet" href="fallback.css" /></noscript>
		<![endif]-->
    <!-- for pkcs5pkey -->
    <script src="<%=basePath%>/views/js/smjs/core.js"></script>
    <script src="<%=basePath%>/views/js/smjs/cipher-core.js"></script>
    <script src="<%=basePath%>/views/js/smjs/md5.js"></script>
    <script src="<%=basePath%>/views/js/smjs/tripledes.js"></script>
    <script src="<%=basePath%>/views/js/smjs/enc-base64.js"></script>
    <!-- for crypto -->
    <script src="<%=basePath%>/views/js/smjs/sha1.js"></script>
    <script src="<%=basePath%>/views/js/smjs/sha256.js"></script>
    <!-- for crypto, asn1, asn1x509 -->
    <script src="<%=basePath%>/views/js/smjs/yahoo-min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/jsbn.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/jsbn2.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/prng4.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/rng.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/rsa.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/rsa2.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/base64.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/asn1hex-1.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/rsapem-1.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/rsasign-1.2.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/x509-1.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/pkcs5pkey-1.0.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/asn1-1.0.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/asn1x509-1.0.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/crypto-1.1.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/ec.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/ec-patch.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/ecdsa-modified-1.0.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/sm3.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/sm3-sm2-1.0.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/ecparam-1.0.js"></script>
    <script type="text/javascript" src="<%=basePath%>/views/js/smjs/sm2.js"></script>		
	<script src="<%=basePath%>/views/js/jquery-1.7.1.min.js"></script>


	<script type="text/javascript">
	    
		jQuery(document).ready(function () {
			var publicKeyG;
			$.ajax({
                url : 'http://localhost/SMXAlgorithmVerification/rest/getPublicKey',
				type : "post",
				dataType : "jsonp",
				contentType : "application/json;charset=UTF-8",
			    jsonp: "callbackparam", //服务端用于接收callback调用的function名的参数  
			    jsonpCallback: "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来  
				success : function (json) {
					/* alert(json[0].publicKey); */
					publicKeyG = json[0].publicKey;
				},
				error : function () {
					alert("system error");
				}
			}); 
			
			$('#submit').click(function () {
				$.ajax({
	                url : 'http://localhost/SMXAlgorithmVerification/rest/login',
					type : "post",
					dataType : "jsonp",
					contentType : "application/json;charset=UTF-8",
					data : JSON.stringify(
					  { 'userName': document.getElementById("username").value,
						'password': document.getElementById("password").value,
				/* 		'password': doCrypt(publicKeyG), */
						'rememberPwd': 0 ,
						'certStr': 'certStr' ,
						'publicKey': 'publicKey' ,
						'cryptMode': document.getElementById("curve1").value }) ,
				    jsonp: "callbackparam", //服务端用于接收callback调用的function名的参数  
				    jsonpCallback: "success_jsonpCallback", //callback的function名称,服务端会把名称和data一起传递回来  
					success : function (json) {
						if (json[0].result=='true') {
							location.href=("<%=basePath%>/views/"+json[0].location+".jsp");
						} else {
							alert(json[0].resultMsg);	
						}
					},
					error : function () {
						alert("system error");
					}
				}); 
	
			});
		});
		function redirct(){
			$.get('http://localhost/SMXAlgorithmVerification/rest/redirect', {
				    userName : 'Robin'
				  }, function(data, status) {
				   //data为返回对象，status为请求的状态
				   alert(data);
				   alert(status);
				  });
		}
		function doCrypt(pubkeyHex) {
		    var msg = document.getElementById("password").value;
		    var msgData = CryptoJS.enc.Utf8.parse(msg);

		    if (pubkeyHex.length > 64 * 2) {
		        pubkeyHex = pubkeyHex.substr(pubkeyHex.length - 64 * 2);
		    }

		    var xHex = pubkeyHex.substr(0, 64);
		    var yHex = pubkeyHex.substr(64);

		    var cipherMode = 'C1C3C2';

		    var cipher = new SM2Cipher(cipherMode);
		    var userKey = cipher.CreatePoint(xHex, yHex);

		    msgData = cipher.GetWords(msgData.toString());

		    var encryptData = cipher.Encrypt(userKey, msgData);
		    return encryptData;
		}
	</script>

	</head>

	<body>
		<div id="container">
			<form id="form">

                <br>
				<div class="login">登陆</div>
				<div class="username-text">用户名:</div>
				<div class="password-text">密码:</div>
				<div class="username-field">
					<input type="text" name="username" id="username" value="yinwenqi" />
				</div>
				<div class="password-field">
					<input type="password" name="password" id= "password" value="yinwenqi" />
				</div>
			
				<input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住密码</label>
				<select class="select" name="curve1" id="curve1">
                    <option value="SM2">SM2
                    </option>
                    <option value="secp256r1">secp256r1 (= NIST P-256, P-256, prime256v1)
                    </option>
                    <option value="secp256k1">secp256k1
                    </option>
                    <option value="secp384r1">secp384r1 (= NIST P-384, P-384)
                    </option>
                </select>
				<div class="forgot-usr-pwd">忘记 <a href="#">用户名</a> or <a href="#">密码</a>?</div>
				
				<input type="button" name="submit" id="submit"  value="GO" />
					
			</form>
			
		</div>
		<div id="footer">
			基于国密算法的SSL VPN安全通信协议的设计与实现   <a href="http://www.mycodes.net/" target="_blank" title="关于"></a>
		</div>
	</body>
</html>