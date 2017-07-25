package com.profile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = -2927874805226977443L;
	
    public HelloServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		if(request.getParameterMap().isEmpty()) {
			System.out.println("getParameterMap() is Empty!");
			composeHTML(response.getWriter(), true, null, null);
		} else {
			String name = request.getParameter("username");
			String pass = request.getParameter("password");
			System.out.println("username: " + name + "; password: " + getMaskedPassword(pass));
			if(name == null || name.isEmpty()) {
				System.out.println("Unauthorised user!");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "ВЫ НЕ ПРОШЛИ АВТОРИЗАЦИЮ!!!!!");
			} else {
				System.out.println("Authorised successfully!");
				composeHTML(response.getWriter(), false, name, pass);
			}
		}
	}
	
	private void composeHTML(PrintWriter writer, boolean defaultPrint, String name, String pass) {
		writer.append("<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Start page</title>")
			.append("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>")
			.append("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">")
			.append("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\">")
			.append("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>")
			.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"></head>")
			.append("<style type=\"text/css\">body {padding-top: 90px;background-color:#222222;}.panel-login {border-color: #ccc;")
			.append("-webkit-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);-moz-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);")
			.append("box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);}.panel-login>.panel-heading {color: #00415d;")
			.append("background-color: #fff;border-color: #fff;text-align:center;}.panel-login>.panel-heading a{")
			.append("text-decoration: none;color: #666;font-weight: bold;font-size: 15px;-webkit-transition: all 0.1s linear;")
			.append("-moz-transition: all 0.1s linear;transition: all 0.1s linear;}.panel-login>.panel-heading a.active{")
			.append("color: #029f5b;font-size: 18px;}.panel-login>.panel-heading hr{margin-top: 10px;margin-bottom: 0px;")
			.append("clear: both;border: 0;height: 1px;")
			.append("background-image: -webkit-linear-gradient(left,rgba(0, 0, 0, 0),rgba(0, 0, 0, 0.15),rgba(0, 0, 0, 0));")
			.append("background-image: -moz-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));")
			.append("background-image: -ms-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));")
			.append("background-image: -o-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));}")
			.append(".panel-login input[type=\"text\"],.panel-login input[type=\"email\"],.panel-login input[type=\"password\"] {")
			.append("height: 45px;border: 1px solid #ddd;font-size: 16px;-webkit-transition: all 0.1s linear;")
			.append("-moz-transition: all 0.1s linear;transition: all 0.1s linear;}.panel-login input:hover,")
			.append(".panel-login input:focus {outline:none;-webkit-box-shadow: none;-moz-box-shadow: none;box-shadow: none;")
			.append("border-color: #ccc;}.btn-login {background-color: #59B2E0;outline: none;color: #fff;font-size: 14px;")
			.append("height: auto;font-weight: normal;padding: 14px 0;text-transform: uppercase;border-color: #59B2E6;}")
			.append(".btn-login:hover,.btn-login:focus {color: #fff;background-color: #53A3CD;border-color: #53A3CD;}")
			.append(".forgot-password {text-decoration: underline;color: #888;}.forgot-password:hover,.forgot-password:focus {")
			.append("text-decoration: underline;color: #666;}.btn-register {background-color: #1CB94E;outline: none;color: #fff;")
			.append("font-size: 14px;height: auto;font-weight: normal;padding: 14px 0;text-transform: uppercase;border-color: #1CB94A;}")
			.append(".btn-register:hover,.btn-register:focus {color: #fff;background-color: #1CA347;border-color: #1CA347;}")
			.append("#pswd_info {background: #dfdfdf none repeat scroll 0 0;color: #fff;position: absolute;top: -385px;}")
			.append("@media screen and (min-width: 1200px) {#pswd_info {left: 400px;}}")
			.append("@media screen and (min-width: 992px) and (max-width: 1199px) {#pswd_info {left: 330px;}}")
			.append("@media screen and (min-width: 768px) and (max-width: 991px) {#pswd_info {left: 470px;}}")
			.append("@media screen and (max-width: 767px) {#pswd_info {left: 1200px;}#pswd_info::before {display: none;}}")
			.append("#pswd_info h4{background: black none repeat scroll 0 0;display: block;font-size: 14px;letter-spacing: 0;")
			.append("padding: 17px 0;text-align: center;text-transform: uppercase;}")
			.append("#pswd_info ul {list-style: outside none none;}#pswd_info ul li {padding: 5px 45px;color: black;}")
			.append("#pswd_info::before {background: #dfdfdf none repeat scroll 0 0;content: \"\";height: 25px;left: -13px;")
			.append("margin-top: -12.5px;position: absolute;top: 50%;transform: rotate(45deg);width: 25px;}")
			.append("#pswd_info {display:none;}</style>")
			.append("<script type=\"text/javascript\">")
			.append("$(function() {$('#login-form-link').click(function(e) {$(\"#login-form\").delay(100).fadeIn(100);")
			.append("$(\"#register-form\").fadeOut(100);$('#register-form-link').removeClass('active');$(this).addClass('active');")
			.append("e.preventDefault();});/* $('#register-form-link').click(function(e) {$(\"#register-form\").delay(100).fadeIn(100);")
			.append("$(\"#login-form\").fadeOut(100);$('#login-form-link').removeClass('active');$(this).addClass('active');")
			.append("e.preventDefault();}); */$('#register-form-link').hover(function() {$('#pswd_info').show();")
			.append("}).mouseleave(function() {$('#pswd_info').hide();});});</script></head>")
			.append("<body>")
			.append("<div class=\"container theme-showcase\" role=\"main\"><div class=\"jumbotron\"><h1>Hello, ");
			if(defaultPrint) {
				writer.append("user!</h1>")
					.append("<p>You're not a registered user! To register follow the link below.</p>");
			} else {
				writer.append(name)
					.append("!</h1>")
					.append("<p>You're logged in with password: ")
					.append(getMaskedPassword(pass))
					.append("</p>");
			}
			writer.append("<hr/>");
			
			if(!defaultPrint) {
				writer.append("<!-- ");
			}
			
			writer.append("<div class=\"container\"><div class=\"row\"><div class=\"col-md-6 col-md-offset-3\">")
			.append("<div class=\"panel panel-login\"><div class=\"panel-heading\"><div class=\"row\"><div class=\"col-xs-6\">")
			.append("<a href=\"#\" class=\"active\" id=\"login-form-link\">Login</a></div><div class=\"col-xs-6\">")
			.append("<a href=\"#\" id=\"register-form-link\">Register</a></div></div><hr/></div>")
			.append("<div class=\"panel-body\"><div class=\"row\"><div class=\"col-lg-12\">")
			.append("<form id=\"login-form\" action=\"./hello\" method=\"get\" role=\"form\" style=\"display: block;\">")
			.append("<div class=\"form-group\">")
			.append("<input type=\"text\" name=\"username\" id=\"username\" tabindex=\"1\" class=\"form-control\" placeholder=\"Username\" value=\"\"></div>")
			.append("<div class=\"form-group\">")
			.append("<input type=\"password\" name=\"password\" id=\"password\" tabindex=\"2\" class=\"form-control\" placeholder=\"Password\"></div>")
			.append("<div class=\"form-group text-center\"><input disabled type=\"checkbox\" tabindex=\"3\" class=\"\" name=\"remember\" id=\"remember\">")
			.append("<label for=\"remember\"> Remember Me</label></div>")
			.append("<div class=\"form-group\"><div class=\"row\"><div class=\"col-sm-6 col-sm-offset-3\">")
			.append("<input type=\"submit\" name=\"login-submit\" id=\"login-submit\" tabindex=\"4\" class=\"form-control btn btn-login\" value=\"LogIn\">")
			.append("</div></div></div><div class=\"form-group\"><div class=\"row\"><div class=\"col-lg-12\"><div class=\"text-center\">")
			.append("<a href=\"#\" tabindex=\"5\" class=\"forgot-password\">Forgot Password?</a></div></div></div></div></form>")
			.append("<form id=\"register-form\" action=\"/hello\" method=\"post\" role=\"form\" style=\"display: none;\">")
			.append("<div class=\"form-group\">")
			.append("<input type=\"text\" name=\"username\" id=\"username\" tabindex=\"1\" class=\"form-control\" placeholder=\"Username\" value=\"\">")
			.append("</div><div class=\"form-group\">")
			.append("<input type=\"email\" name=\"email\" id=\"email\" tabindex=\"1\" class=\"form-control\" placeholder=\"Email Address\" value=\"\">")
			.append("</div><div class=\"form-group\">")
			.append("<input type=\"password\" name=\"password\" id=\"password\" tabindex=\"2\" class=\"form-control\" placeholder=\"Password\">")
			.append("</div><div class=\"form-group\">")
			.append("<input type=\"password\" name=\"confirm-password\" id=\"confirm-password\" tabindex=\"2\" class=\"form-control\" placeholder=\"Confirm Password\">")
			.append("</div><div class=\"form-group\"><div class=\"row\"><div class=\"col-sm-6 col-sm-offset-3\">")
			.append("<input type=\"submit\" name=\"register-submit\" id=\"register-submit\" tabindex=\"4\" class=\"form-control btn btn-register\" value=\"Register Now\">")
			.append("</div></div></div></form><div class=\"col-md-4\"><div class=\"aro-pswd_info\"><div id=\"pswd_info\">")
			.append("<h4>Info</h4><ul><li id=\"letter\" class=\"invalid\"><strong>Registration temporary disabled</strong></li>")
			.append("</ul></div></div></div></div></div></div></div></div></div></div>");
			if(!defaultPrint) {
				writer.append("-->");
			}
			writer.append("</div><hr/></div></body></html>");
		writer.flush();
		writer.close();
	}
	
	private String getMaskedPassword(String pass) {
		StringBuilder sb = new StringBuilder("");
		if(pass != null && !pass.isEmpty()) {
			for(int i = 0; i < pass.length(); i++) {
				sb.append("*");
			}
		} else {
			sb.append("no password");
		}
		sb.trimToSize();
		return sb.toString();
	}
}
