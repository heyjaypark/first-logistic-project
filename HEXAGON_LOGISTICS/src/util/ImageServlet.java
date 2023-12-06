package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;


		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    // 이미지 파일의 경로 설정
	        String imagePath = getServletContext().getRealPath("/images");
	        String imageName = request.getParameter("imageName"); // 파라미터로 이미지 파일명 받기
	        File imageFile = new File(imagePath, imageName);

	        // 이미지 파일이 존재하는지 확인
	        if (imageFile.exists()) {
	            // 이미지를 읽어와서 응답으로 전송
	            response.setContentType("image/png");
	            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(imageFile));
	                    OutputStream os = response.getOutputStream()) {
	                byte[] buffer = new byte[1024];
	                int bytesRead;
	                while ((bytesRead = bis.read(buffer)) != -1) {
	                    os.write(buffer, 0, bytesRead);
	                }
	            }
	        } else {
	            // 이미지 파일이 없을 경우 404 응답
	            response.sendError(HttpServletResponse.SC_NOT_FOUND);
	        }
		}
}
