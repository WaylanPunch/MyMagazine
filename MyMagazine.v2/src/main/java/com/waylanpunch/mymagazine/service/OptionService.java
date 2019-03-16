package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.dao.OptionMapper;
import com.waylanpunch.mymagazine.pojo.Option;
import com.waylanpunch.mymagazine.pojo.OptionExample;
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
public class OptionService implements IOptionService {

    @Autowired
    private OptionMapper optionMapper;


    @Override
    public List<Option> findAllOptions() {
        OptionExample optionExample = new OptionExample();
        OptionExample.Criteria criteria = optionExample.createCriteria();
        criteria.andNameIsNotNull();
        return optionMapper.selectByExample(optionExample);
    }
}
