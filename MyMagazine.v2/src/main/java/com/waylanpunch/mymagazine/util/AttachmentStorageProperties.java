package com.waylanpunch.mymagazine.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/4/2 22:30
 */
//@Component//注册为组件
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "attachment.storage")
@PropertySource("classpath:attachment.properties")
public class AttachmentStorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "E:\\WORKSPACE\\IntelliJIDEA_Workspace\\MyMagazine.v2\\upload2";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
