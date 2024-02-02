package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;

public class WriteReader<T> {

    public String writeObjectToFile(Object obj) {
        //Type typeOf = obj.getClass();
        String fileName = "C:\\Users\\acm11\\Dev\\GitHub\\3sem-assignments-template\\week01\\week1\\src\\main\\java\\org\\example\\data.ser";
        //String fileName = typeOf.toString();
        //String fileSuffix = (java.time.LocalDateTime.now()).format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        //fileName = fileName + fileSuffix + ".ser";
        try {
            //File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(obj);
            out.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    public T getObjectFromFile(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fis);
            T obj = (T) in.readObject();
            in.close();
            fis.close();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
