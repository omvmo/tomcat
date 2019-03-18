package com.klaus;

public abstract class MyServlet {

	public abstract void doGet(MyRequest myRequest,MyResponse myResponse);
	
	public abstract void doPost(MyRequest myRequest,MyResponse myResponse);
	
	public void service(MyRequest myRequest,MyResponse myResponse) {
		
		if(myRequest.getMethod().equalsIgnoreCase("POST")) {
			
			doGet(myRequest,myResponse);
			
		}else if(myRequest.getMethod().equalsIgnoreCase("GET")) {
			
			doPost(myRequest,myResponse);
			
		}
		
	}
}
