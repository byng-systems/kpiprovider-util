/*
 * Copyright (c) 2016, Byng Services Ltd
 */
package co.byng.internal.engineering.kpiprovider.util;

import java.net.HttpURLConnection;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public class HttpConnectionFactoryTest {
    
    private HttpConnectionFactory.Impl httpConnectionFactory;
    
    @Before
    public void setUp() {
        this.httpConnectionFactory = new HttpConnectionFactory.Impl();
    }
    
    /**
     * Test of createConnection method, of class HttpConnectionFactory.
     */
    @Test
    public void testCreateConnection() throws Exception {
        URL url = new URL("http://localhost/");
        
        assertTrue(this.httpConnectionFactory.createConnection(url) instanceof HttpURLConnection);
    }
    
}
