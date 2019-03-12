package com.mymagazine.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Log implements Serializable {
    /**
     * 日志主键
     */
    private Integer id;

    /**
     * 产生的动作
     */
    private String action;

    /**
     * 产生的数据
     */
    private String data;

    /**
     * 发生人id
     */
    private Integer authorId;

    /**
     * 日志产生的ip
     */
    private String ip;

    /**
     * 日志创建时间
     * https://www.oracle.com/technetwork/articles/java/jf14-date-time-2125367.html
     * ANSI SQL 	           ---- Java SE 8
     * DATE 	               ---- LocalDate
     * TIME 	               ---- LocalTime
     * TIMESTAMP 	           ---- LocalDateTime
     * TIME WITH TIMEZONE 	   ---- OffsetTime
     * TIMESTAMP WITH TIMEZONE ----	OffsetDateTime
     *
     * http://www.importnew.com/14140.html
     */
    private LocalDateTime created;

    public Log() {
    }

    public Log(Integer id, String action, String data, Integer authorId, String ip, LocalDateTime created) {
        this.id = id;
        this.action = action;
        this.data = data;
        this.authorId = authorId;
        this.ip = ip;
        this.created = created;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
