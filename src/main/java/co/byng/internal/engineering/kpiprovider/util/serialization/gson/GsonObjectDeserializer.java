/**
 * GsonObjectDeserializer.java
 * Created 15-Dec-2015 19:33:29
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.util.serialization.gson;

import co.byng.internal.engineering.kpiprovider.util.serialization.ObjectDeserializer;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;



/**
 * GsonObjectDeserializer
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public class GsonObjectDeserializer implements ObjectDeserializer {

    protected Gson gson;
    protected Class<? extends Reader> readerClass;

    public GsonObjectDeserializer(Gson gson, Class<? extends Reader> readerClass) {
        this.readerClass = readerClass;
        this.gson = gson;
    }
    
    public GsonObjectDeserializer(Gson gson) {
        this(gson, InputStreamReader.class);
    }

    public Class<? extends Reader> getReaderClass() {
        return readerClass;
    }
    
    public void setReaderClass(Class<? extends Reader> readerClass) {
        this.readerClass = readerClass;
    }

    @Override
    public <T> T deserialize(InputStream inputStream, Class<T> classOfT) throws IOException {
        try {
            return this.gson.fromJson(
                this.readerClass.getConstructor(InputStream.class).newInstance(inputStream),
                classOfT
            );
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new IOException(ex);
        }
    }

}
