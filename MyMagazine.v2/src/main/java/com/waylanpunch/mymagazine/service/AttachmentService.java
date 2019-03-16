package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.dao.AttachmentMapper;
import com.waylanpunch.mymagazine.pojo.Attachment;
import com.waylanpunch.mymagazine.pojo.AttachmentExample;
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
public class AttachmentService implements IAttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;


    @Override
    public List<Attachment> findAllAttachments() {
        AttachmentExample attachmentExample = new AttachmentExample();
        AttachmentExample.Criteria criteria = attachmentExample.createCriteria();
        criteria.andAttachmentIdIsNotNull();
        return attachmentMapper.selectByExample(attachmentExample);
    }
}
