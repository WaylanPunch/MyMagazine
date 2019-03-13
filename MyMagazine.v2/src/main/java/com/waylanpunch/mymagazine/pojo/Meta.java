package com.waylanpunch.mymagazine.pojo;

public class Meta {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_metas.meta_id
     *
     * @mbg.generated
     */
    private Integer metaId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_metas.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_metas.slug
     *
     * @mbg.generated
     */
    private String slug;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_metas.type
     *
     * @mbg.generated
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_metas.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_metas.sort
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_metas.parent
     *
     * @mbg.generated
     */
    private Integer parent;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_metas
     *
     * @mbg.generated
     */
    public Meta(Integer metaId, String name, String slug, String type, String description, Integer sort, Integer parent) {
        this.metaId = metaId;
        this.name = name;
        this.slug = slug;
        this.type = type;
        this.description = description;
        this.sort = sort;
        this.parent = parent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_metas
     *
     * @mbg.generated
     */
    public Meta() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_metas.meta_id
     *
     * @return the value of t_metas.meta_id
     *
     * @mbg.generated
     */
    public Integer getMetaId() {
        return metaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_metas.meta_id
     *
     * @param metaId the value for t_metas.meta_id
     *
     * @mbg.generated
     */
    public void setMetaId(Integer metaId) {
        this.metaId = metaId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_metas.name
     *
     * @return the value of t_metas.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_metas.name
     *
     * @param name the value for t_metas.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_metas.slug
     *
     * @return the value of t_metas.slug
     *
     * @mbg.generated
     */
    public String getSlug() {
        return slug;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_metas.slug
     *
     * @param slug the value for t_metas.slug
     *
     * @mbg.generated
     */
    public void setSlug(String slug) {
        this.slug = slug == null ? null : slug.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_metas.type
     *
     * @return the value of t_metas.type
     *
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_metas.type
     *
     * @param type the value for t_metas.type
     *
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_metas.description
     *
     * @return the value of t_metas.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_metas.description
     *
     * @param description the value for t_metas.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_metas.sort
     *
     * @return the value of t_metas.sort
     *
     * @mbg.generated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_metas.sort
     *
     * @param sort the value for t_metas.sort
     *
     * @mbg.generated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_metas.parent
     *
     * @return the value of t_metas.parent
     *
     * @mbg.generated
     */
    public Integer getParent() {
        return parent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_metas.parent
     *
     * @param parent the value for t_metas.parent
     *
     * @mbg.generated
     */
    public void setParent(Integer parent) {
        this.parent = parent;
    }
}