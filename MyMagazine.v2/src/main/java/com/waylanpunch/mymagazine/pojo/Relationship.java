package com.waylanpunch.mymagazine.pojo;

public class Relationship {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_relationships.article_id
     *
     * @mbg.generated
     */
    private Integer articleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_relationships.meta_id
     *
     * @mbg.generated
     */
    private Integer metaId;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_relationships
     *
     * @mbg.generated
     */
    public Relationship(Integer articleId, Integer metaId) {
        this.articleId = articleId;
        this.metaId = metaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_relationships
     *
     * @mbg.generated
     */
    public Relationship() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_relationships.article_id
     *
     * @return the value of t_relationships.article_id
     *
     * @mbg.generated
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_relationships.article_id
     *
     * @param articleId the value for t_relationships.article_id
     *
     * @mbg.generated
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_relationships.meta_id
     *
     * @return the value of t_relationships.meta_id
     *
     * @mbg.generated
     */
    public Integer getMetaId() {
        return metaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_relationships.meta_id
     *
     * @param metaId the value for t_relationships.meta_id
     *
     * @mbg.generated
     */
    public void setMetaId(Integer metaId) {
        this.metaId = metaId;
    }
}