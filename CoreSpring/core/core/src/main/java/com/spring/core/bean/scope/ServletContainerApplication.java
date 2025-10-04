package com.spring.core.bean.scope;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletContext;
@RestController
public class ServletContainerApplication {
	private final ServletContext servletContext ;
	public ServletContainerApplication(ServletContext servletContext)
	{
		this.servletContext=servletContext;
	}
	
	@GetMapping("/contextPath")
	public String getContextPath() {
		return "Context Path: " + servletContext.getContextPath();
	}
	@GetMapping("/attribute")
    public String getAttribute() {
        String attribute = (String) servletContext.getAttribute("myAttribute");
        if (attribute == null) {
            return "Attribute not set.";
        }
        return "Attribute: " + attribute;
    }
	@GetMapping("/setAttribute")
    public String setAttribute() {
        servletContext.setAttribute("myAttribute", "Hello from ServletContext!");
        return "Attribute set.";
    }

    /*@GetMapping("/resource")
    public String getResource() throws IOException {
        InputStream inputStream = servletContext.getResourceAsStream("/static/myText.txt"); // Assuming myText.txt is in src/main/resources/static
        if (inputStream == null) {
            return "Resource not found.";
        }

        String content = new String(inputStream.readAllBytes());
        inputStream.close();
        return "Resource Content: " + content;
    }*/

    @GetMapping("/serverInfo")
    public String getServerInfo() {
        return "Server Info: " + servletContext.getServerInfo();
    }
}


