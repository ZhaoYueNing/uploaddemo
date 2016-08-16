package cn.zhaoyuening.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		DiskFileItemFactory  factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		try {
			List<FileItem> fileList = upload.parseRequest(request);
			for (FileItem item : fileList) {
				if (item.isFormField()) {
					//�����ϴ��ļ�
				}else{
					//���ϴ��ļ�
					InputStream in = item.getInputStream();
					String fileName = item.getName();
					//���ļ����浽f�ĸ�Ŀ¼��
					FileOutputStream fos = new FileOutputStream("F:\\"+fileName);
					IOUtils.copy(in, fos);
					
					response.getWriter().print("<h1>�ϴ��ɹ�</h1>");
				}
			}
		} catch (FileUploadException e) {
		}
		
	}

}
