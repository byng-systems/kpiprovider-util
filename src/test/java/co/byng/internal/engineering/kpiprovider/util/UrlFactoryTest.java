/*
 * Copyright (c) 2016, Byng Services Ltd
 */
package co.byng.internal.engineering.kpiprovider.util;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public class UrlFactoryTest {
    
    private URL baseUrl;
    private UrlFactory.Impl urlFactory;
    
    @Before
    public void setUp() throws MalformedURLException {
        this.baseUrl = new URL("https://www.google.co.uk/search/");
        this.urlFactory = new UrlFactory.Impl(this.baseUrl);
    }
    
    @Test
    public void testImplConstructorAndBaseUrlGetter() {
        assertSame(this.baseUrl, this.urlFactory.getBaseUrl());
    }
    
    @Test
    public void testBuildUrl() throws MalformedURLException {
        assertEquals(
            "https://www.google.co.uk/search/path?",
            this.urlFactory.buildUrl("./path").toString()
        );
        
        assertEquals(
            "https://www.google.co.uk/search/path?query",
            this.urlFactory.buildUrl("./path", "query").toString()
        );
    }

}
