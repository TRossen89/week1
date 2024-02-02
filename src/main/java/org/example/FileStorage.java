package org.example;

import java.io.*;
import java.lang.reflect.Type;

public class FileStorage<T> implements DataStorage {

    WriteReader<T> writeReader = new WriteReader<>();
    public String store(Object data) {

        return writeReader.writeObjectToFile(data);

    }

    public Object retrieve(String source) {


        return writeReader.getObjectFromFile(source);
    }


}
