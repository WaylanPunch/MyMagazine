package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.dao.LogMapper;
import com.waylanpunch.mymagazine.pojo.Log;
import com.waylanpunch.mymagazine.pojo.LogExample;
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
public class LogService implements ILogService {

    @Autowired
    private LogMapper logMapper;


    @Override
    public List<Log> findAllLogs() {
        LogExample logExample = new LogExample();
        LogExample.Criteria criteria = logExample.createCriteria();
        criteria.andLogIdIsNotNull();
        return logMapper.selectByExample(logExample);
    }
}
