package com.sthirty.student.controller;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.annotation.MultipartConfig;

@MultipartConfig(fileSizeThreshold=1024*1024*2, 
maxFileSize=1024*1024*10,      
maxRequestSize=1024*1024*50)

/**
 * Servlet implementation class ImageController
 */
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR="student-images";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String imageid=request.getParameter("studentId");
			String new_name ;
			
			response.setContentType("text/html;charset=UTF-8");
	        String applicationPath = /*request.*/getServletContext().getRealPath("");
            String savePath = applicationPath + File.separator + SAVE_DIR;
           
                File fileSaveDir=new File(savePath);
                if(!fileSaveDir.exists()){
                    fileSaveDir.mkdir();
                }
                File stf=new File(savePath+ File.separator+ imageid);
                stf.mkdir();
                Part part=request.getPart("file");
	            String fileName=extractFileName(part);
	            fileName = imageid+".jpg";
	            new_name = fileName;
	            part.write(stf + File.separator + fileName);
	            response.sendRedirect("studentProfileRedirect.jsp");
		  }
		catch(Exception ex){
			ex.printStackTrace();
		 }
	}
	
	 private String extractFileName(Part part) {
	     String contentDisp = part.getHeader("content-disposition");
	     String[] items = contentDisp.split(";");
	     for (String s : items) {
	         if (s.trim().startsWith("filename")) {
	             return s.substring(s.indexOf("=") + 2, s.length()-1);
	          }
	      }
	     return "";
	}
}
	
