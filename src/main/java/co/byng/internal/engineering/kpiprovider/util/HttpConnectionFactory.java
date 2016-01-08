/**
 * HttpConnectionFactory.java
 * Created 11-Dec-2015 23:01:30
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * HttpConnectionFactory 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface HttpConnectionFactory {

    public HttpURLConnection createConnection(URL url) throws IOException;
    
    
    
    public class Impl implements HttpConnectionFactory {

        @Override
        public HttpURLConnection createConnection(URL url) throws IOException, ClassCastException {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            return conn;
        }
        
    }
    
}
