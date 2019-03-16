package com.waylanpunch.mymagazine.service;

import com.waylanpunch.mymagazine.pojo.Article;
import com.waylanpunch.mymagazine.pojo.Attachment;

import java.util.List;

public interface IAttachmentService {

    List<Attachment> findAllAttachments();
}
