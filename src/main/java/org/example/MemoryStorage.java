package org.example;

public class MemoryStorage <T> implements DataStorage{

    String dataStored;


    @Override
    public String store(Object dataToStore) {
        this.dataStored = dataToStore.toString();
        return dataStored;
    }

    @Override
    public Object retrieve(String source) {
        return dataStored;
    }
}
