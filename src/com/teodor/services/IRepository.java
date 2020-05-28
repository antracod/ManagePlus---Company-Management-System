package com.teodor.services;

import com.teodor.models.Payment;

import java.util.List;

public interface IRepository<T> {
    T getById(int id);
    T getByValue(int value);
    List<T> getAll();

    void addEntry(T entry);
    void deleteEntry(T entry);
    void updateEntry(T entry);
}
