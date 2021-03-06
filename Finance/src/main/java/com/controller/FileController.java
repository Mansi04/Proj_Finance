package com.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/download")
public class FileController {

	@RequestMapping(value="/image", method=RequestMethod.GET)
	public void downloadImageResource( HttpServletRequest request,HttpServletResponse response)
    {
		String fileName=request.getParameter("fileName"); 
        String dataDirectory = System.getProperty("catalina.home")+ File.separator + "tmpFiles"; 
       
        Path file = Paths.get(dataDirectory, fileName);
        if (Files.exists(file)) 
        {
            response.setContentType("image/jpg");
            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
	
}
