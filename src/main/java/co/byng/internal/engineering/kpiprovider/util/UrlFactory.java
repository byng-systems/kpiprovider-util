/**
 * RelativeUrlFactory.java
 * Created 11-Dec-2015 22:49:42
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.util;

import java.net.MalformedURLException;
import java.net.URL;



/**
 * UrlFactory 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface UrlFactory {

    public URL buildUrl(String spec, String query) throws MalformedURLException;
    
    public URL buildUrl(String spec) throws MalformedURLException;
    
    
    
    public class Impl implements UrlFactory {
        
        protected URL baseUrl;

        public Impl(URL baseUrl) {
            this.baseUrl = baseUrl;
        }

        public URL getBaseUrl() {
            return baseUrl;
        }

        @Override
        public URL buildUrl(String pathInfo, String query) throws MalformedURLException {
            return new URL(
                this.baseUrl,
                pathInfo + "?" + query
            );
        }

        @Override
        public URL buildUrl(String pathInfo) throws MalformedURLException {
            return this.buildUrl(pathInfo, "");
        }
        
    }
    
}
