/*
 * Copyright (c) 2016, Byng Services Ltd
 */
package co.byng.internal.engineering.kpiprovider.util.serialization.gson;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 */
@RunWith(MockitoJUnitRunner.class)
public class GsonObjectDeserializerTest {

    private Reader reader;
    private Gson gson;
    private GsonObjectDeserializer objectDeserializer;

    @Before
    public void setUp() {
        this.reader = mock(Reader.class);
        this.gson = new Gson();
        this.objectDeserializer = new GsonObjectDeserializer(this.gson, this.reader.getClass());
    }
    
    /**
     * Test of getReaderClass method, of class GsonObjectDeserializer.
     */
    @Test
    public void testGetAndSetReaderClass() {
        assertSame(this.reader.getClass(), this.objectDeserializer.getReaderClass());
        
        Reader differentReader = mock(Reader.class);
        Class<Reader> differentReaderClass = (Class<Reader>) differentReader.getClass();
        
        this.objectDeserializer.setReaderClass(differentReaderClass);
        assertSame(differentReaderClass, this.objectDeserializer.getReaderClass());
    }
    
    @Test
    public void testDefaultReaderClassConstructor() {
        GsonObjectDeserializer differentDeserializer = new GsonObjectDeserializer(this.gson);

        assertSame(InputStreamReader.class, differentDeserializer.getReaderClass());
    }

    /**
     * Test of deserialize method, of class GsonObjectDeserializer.
     */
    @Test
    public void testDeserialize() throws Exception {
        this.objectDeserializer.setReaderClass(InputStreamReader.class);
        
        ByteArrayInputStream stream = new ByteArrayInputStream(
            "{\"property\": \"value\"}".getBytes()
        );
        
        Model model = this.objectDeserializer.deserialize(stream, Model.class);
        
        assertTrue(model instanceof Model);
        assertEquals("value", model.property);
    }
    
    @Test(expected = IOException.class)
    public void testDeserializeThrowsExceptionForIncompatibleReader() throws IOException {
        ByteArrayInputStream stream = new ByteArrayInputStream(
            "{\"property\": \"value\"}".getBytes()
        );
        
        this.objectDeserializer.deserialize(stream, Model.class);
    }
    


    private class Model {
        
        @Expose
        @SerializedName("property")
        public String property;
        
    }
    
}
