package com.teamwill.leasing.Service;

import java.util.List;

public interface ServiceAbstraction<T>{
    public T add(T t);
    public T update(T t,Long id);
    public List<T> getAll(Integer pageNo, Integer pageSize, String sortBy);
    public T get(Long id);
    public void delete(Long id);

}
