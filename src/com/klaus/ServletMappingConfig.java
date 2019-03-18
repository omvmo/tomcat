package com.klaus;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {
public static List<ServletMapping> ServletMapping= new ArrayList<ServletMapping>();
	

static {
	
	ServletMapping.add(new ServletMapping("findGril", "/girl", "com.klaus.FindGrilServlet"));

	
}
}
