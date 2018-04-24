package com.tjlcast.server.services;

import com.tjlcast.server.mapper.Rule2FilterMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class Rule2FilterService {
    @Autowired
    Rule2FilterMapper rule2FilterMapper;

    public boolean addARelation(UUID ruleId,UUID filterId) {
        int i = rule2FilterMapper.addARelation(ruleId.toString(),filterId.toString());
        return i==1 ? true : false ;
    }
}
