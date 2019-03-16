package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.dao.RelationshipMapper;
import com.waylanpunch.mymagazine.pojo.Relationship;
import com.waylanpunch.mymagazine.pojo.RelationshipExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/3/16 17:07
 */
@Service
public class RelationshipService implements IRelationshipService {

    @Autowired
    private RelationshipMapper relationshipMapper;


    @Override
    public List<Relationship> findAllRelationships() {
        RelationshipExample relationshipExample = new RelationshipExample();
        RelationshipExample.Criteria criteria = relationshipExample.createCriteria();
        criteria.andArticleIdIsNotNull();
        return relationshipMapper.selectByExample(relationshipExample);
    }
}
