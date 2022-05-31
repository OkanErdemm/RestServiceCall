package com.global.bilgi.restservice.call.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.global.bilgi.restservice.call.LinuxConnection;
import com.global.bilgi.restservice.call.Propertys;

@Controller
public class WsController {
	
	static String command;
	
	@RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("./swagger-ui.html");
    }
	
	
	@GetMapping("api/curl")
	public String curlWithCallWs(Model model) {
		Propertys propertys = new Propertys();
		model.addAttribute("propertys", propertys);
		return "curl_form";

	}

	@PostMapping(path="api/curl", produces=MediaType.APPLICATION_JSON_VALUE)
	public String submitForm(@ModelAttribute("propertys") Propertys propertys)
			throws IOException, InterruptedException {

		if(propertys.getToken().isEmpty() && propertys.getMethod().equalsIgnoreCase("get")) {
			
		command ="curl -X " + propertys.getMethod().toUpperCase() + " --header " + "'Accept: application/json' "
				+ " " + "'" + propertys.getUrl() + propertys.getHeader() + "'";
		}
		
		else if(!propertys.getToken().isEmpty() && propertys.getMethod().equalsIgnoreCase("get")) {
			
		command ="curl -i " +"--location --request "+propertys.getMethod().toUpperCase()+" '"+propertys.getUrl()+propertys.getHeader()+"'"+" \\"+"\n"+
		"--header 'Accept: application/json' \\"+"\n"+
		"--header 'Content-Type: application/json' \\"+"\n"+
		"--header 'token: "+propertys.getToken()+"'";

		}
		
		else if(propertys.getToken().isEmpty() && propertys.getMethod().equalsIgnoreCase("post")) {
			
			command="curl -d"+"'"+propertys.getBody()+"' "+"-H 'Content-Type: application/json'"+" "+propertys.getUrl();
		}
		
		else if(!propertys.getToken().isEmpty() && propertys.getMethod().equalsIgnoreCase("post")) {
			
			command ="curl -i " +"--location --request "+propertys.getMethod().toUpperCase()+" '"+propertys.getUrl()+propertys.getHeader()+"'"+" \\"+"\n"+
					"--header 'Accept: application/json' \\"+"\n"+
					"--header 'Content-Type: application/json' \\"+"\n"+
					"--header 'token: "+propertys.getToken()+"'"+" \\"+"\n"+
					"-d '"+propertys.getBody()+"'".trim();
		}
		
		else
			command="pwd";				

		
		LinuxConnection linuxConnection = new LinuxConnection();
		propertys.setSonuc(linuxConnection.sshConnection(command));

		return "curl_form_success";

	}
	
	
	

}