package com.monica.petclinic.services.map;

import com.monica.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){

        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }

            map.put(object.getId(), object);

        } else {
            throw  new RuntimeException("Object can not be null");
        }

        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry->entry.getValue().equals(object));
    }

    /* my implementations

    void delete(T object){
        map.remove(object);
    }

    void deleteById(ID id){
        map.entrySet().removeIf(entry->{entry.getKey().equals(id)});
    }
    */

    private Long getNextId(){
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet())+1;
        }catch (NoSuchElementException ex){
            nextId = 1L;
        }
        
        return nextId;
    }


}
