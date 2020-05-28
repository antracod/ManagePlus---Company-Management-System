package com.teodor.repositories;

import com.teodor.models.Payment;

import java.util.Collection;
import java.util.List;

public interface IRepository<T> {

    void addEntry(T entry);
    Collection<T> getEntry();
    void deleteEntry(int id);
    void updateEntry(T entry);
}
