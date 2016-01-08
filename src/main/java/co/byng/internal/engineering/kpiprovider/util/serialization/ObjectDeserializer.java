/**
 * JsonReader.java
 * Created 15-Dec-2015 19:27:50
 *
 * @author M.D.Ward <matthew.ward@byng.co>
 * Copyright (c) 2015, Byng Services Ltd
 */

package co.byng.internal.engineering.kpiprovider.util.serialization;

import java.io.IOException;
import java.io.InputStream;



/**
 * ObjectDeserializer 
 * 
 * @author M.D.Ward <matthew.ward@byng.co>
 */
public interface ObjectDeserializer {

    public <T> T deserialize(InputStream inputStream, Class<T> classOfT) throws IOException;
    
}
