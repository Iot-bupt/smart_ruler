package com.tjlcast.server.services;

import com.tjlcast.server.data.Transform;
import com.tjlcast.server.mapper.TransformRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by tangjialiang on 2018/4/23.
 */

@Service
@Slf4j
public class TransformService{

    @Autowired
    private TransformRepository transformRepository;

    public List<Transform> getAllTransform() {
        List<Transform> all = transformRepository.findAll();
        return all ;
    }

    public Transform getByTransformId(UUID id) {
        Transform byId = transformRepository.findById(id);
        return byId ;
    }

    public boolean deleteAll() {
        transformRepository.deleteAll();
        return true ;
    }

    public boolean deleteById(UUID id) {
        transformRepository.delete(id);
        return true ;
    }

    public boolean addTransform(Transform tf) {
        transformRepository.save(tf) ;
        return true ;
    }

    public boolean addTransform(List<Transform> tfs) {
        transformRepository.save((Iterable<? extends Transform>) tfs.iterator()) ;
        return true ;
    }
}
