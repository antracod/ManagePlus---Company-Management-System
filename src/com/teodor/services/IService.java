package com.teodor.services;

import java.util.Collection;

public interface IService<T> {

        void addEntry(T entry);
        Collection<T> getEntry();
        void deleteEntry(int id);
        void updateEntry(T entry);
    }


