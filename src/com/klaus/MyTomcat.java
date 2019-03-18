package com.klaus;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MyTomcat {

	
	private int port=8080;
	private Map<String , String> urlServletMap= new HashMap<String , String>();
	
	public MyTomcat(int port) {
		
		this.port=port;
	}
	
	public void start() {
		//≥ı ºªØinit
		
		initServletMapping();
		
	ServerSocket serverSocket=null;
			try {
				
				serverSocket= new ServerSocket(port);
				System.out.println("tomcat is start");
				
				while(true) {
					
					Socket socket= serverSocket.accept();
				InputStream inputStream=	socket.getInputStream();
				OutputStream outputStream=	socket.getOutputStream();
				
				
				dispatch(new MyRequest(inputStream), new MyResponse(outputStream));
				
				socket.close();
				}
				
				
				
			}catch (Exception e) {
			e.printStackTrace();
			}
		
		
	}
	
	private void initServletMapping() {
		
		for (ServletMapping servletMapping : ServletMappingConfig.ServletMapping) {
			urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
			
		}
		
	}
	
	private void dispatch(MyRequest myRequest, MyResponse myResponse) {
		
		String clazz= urlServletMap.get(myRequest.getUrl());
		
		
		try {
			Class<MyServlet> myServletClazz= (Class<MyServlet>) Class.forName(clazz);
			MyServlet myServlet = myServletClazz.newInstance();
			myServlet.service(myRequest, myResponse);
		
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	
	public static void main(String [] args) {
		new MyTomcat(8080).start();
		
		
	}
}
