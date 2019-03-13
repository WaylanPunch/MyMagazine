package com.waylanpunch.mymagazine.pojo;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_users.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_users.username
     *
     * @mbg.generated
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_users.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_users.email
     *
     * @mbg.generated
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_users.home_url
     *
     * @mbg.generated
     */
    private String homeUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_users.display_name
     *
     * @mbg.generated
     */
    private String displayName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_users.created
     *
     * @mbg.generated
     */
    private Date created;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_users.activated
     *
     * @mbg.generated
     */
    private Date activated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_users.logged
     *
     * @mbg.generated
     */
    private Date logged;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_users.group_name
     *
     * @mbg.generated
     */
    private String groupName;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    public User(Integer userId, String username, String password, String email, String homeUrl, String displayName, Date created, Date activated, Date logged, String groupName) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.homeUrl = homeUrl;
        this.displayName = displayName;
        this.created = created;
        this.activated = activated;
        this.logged = logged;
        this.groupName = groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbg.generated
     */
    public User() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_users.user_id
     *
     * @return the value of t_users.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_users.user_id
     *
     * @param userId the value for t_users.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_users.username
     *
     * @return the value of t_users.username
     *
     * @mbg.generated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_users.username
     *
     * @param username the value for t_users.username
     *
     * @mbg.generated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_users.password
     *
     * @return the value of t_users.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_users.password
     *
     * @param password the value for t_users.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_users.email
     *
     * @return the value of t_users.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_users.email
     *
     * @param email the value for t_users.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_users.home_url
     *
     * @return the value of t_users.home_url
     *
     * @mbg.generated
     */
    public String getHomeUrl() {
        return homeUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_users.home_url
     *
     * @param homeUrl the value for t_users.home_url
     *
     * @mbg.generated
     */
    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl == null ? null : homeUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_users.display_name
     *
     * @return the value of t_users.display_name
     *
     * @mbg.generated
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_users.display_name
     *
     * @param displayName the value for t_users.display_name
     *
     * @mbg.generated
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_users.created
     *
     * @return the value of t_users.created
     *
     * @mbg.generated
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_users.created
     *
     * @param created the value for t_users.created
     *
     * @mbg.generated
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_users.activated
     *
     * @return the value of t_users.activated
     *
     * @mbg.generated
     */
    public Date getActivated() {
        return activated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_users.activated
     *
     * @param activated the value for t_users.activated
     *
     * @mbg.generated
     */
    public void setActivated(Date activated) {
        this.activated = activated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_users.logged
     *
     * @return the value of t_users.logged
     *
     * @mbg.generated
     */
    public Date getLogged() {
        return logged;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_users.logged
     *
     * @param logged the value for t_users.logged
     *
     * @mbg.generated
     */
    public void setLogged(Date logged) {
        this.logged = logged;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_users.group_name
     *
     * @return the value of t_users.group_name
     *
     * @mbg.generated
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_users.group_name
     *
     * @param groupName the value for t_users.group_name
     *
     * @mbg.generated
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }
}