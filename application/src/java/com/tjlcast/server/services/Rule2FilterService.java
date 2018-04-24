package com.tjlcast.server.services;

import com.tjlcast.server.data.Rule2Filter;
import com.tjlcast.server.mapper.Rule2FilterMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Slf4j
public class Rule2FilterService {
    @Autowired
    private Rule2FilterMapper rule2FilterMapper;

    public boolean addARelation(Rule2Filter rule2Filter) {
        int i = rule2FilterMapper.addARelation(rule2Filter);
        return i==1 ? true : false ;
    }
}
