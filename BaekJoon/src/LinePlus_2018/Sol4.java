package LinePlus_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Sol4 {
	public static void main(String[] args) throws IOException {
		ArrayList<String> Uids=new ArrayList<String>();
		Map<String,String> datas=new HashMap();
		Map<Integer,String> response=new HashMap();
		response.put(200, "200 OK");
		response.put(200, "201 Created");
		response.put(403, "403 FORBIDDEN");
		response.put(403, "404 NOT_FOUND");
		response.put(405, "405 METHOD_NOT_ALLOWED");
		
		
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                String method = tokenizer.nextToken();
                String url = tokenizer.nextToken();	
                String body = null;
                if (tokenizer.hasMoreTokens()) {
                    body = tokenizer.nextToken();
                }
                if(method.equals("POST")){
                	
                } else if(method.equals("GET")){
                	
                } else{
                	
                }
            }
        }
    }
}
