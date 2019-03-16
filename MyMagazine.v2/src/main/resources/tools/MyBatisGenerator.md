**1.Reference**

https://github.com/mybatis/generator
http://www.mybatis.org/generator/

**2.Dependency**

    <dependency>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator</artifactId>
        <version>1.3.7</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.3.7</version>
    </dependency>

**3.generatorConfig.xml**

    \src\main\resources\generatorConfig.xml

Source Code:

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE generatorConfiguration
            PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
            "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
    
    <generatorConfiguration>
        <!--导入属性配置-->
        <properties resource="datasource.properties"></properties>
    
        <!-- 指定数据库驱动的jdbc驱动jar包的位置 -->
        <!--<classPathEntry location="${db.driverLocation}" />-->
    
        <!-- context 是逆向工程的主要配置信息 -->
        <!-- id：起个名字 -->
        <!-- targetRuntime：设置生成的文件适用于那个 mybatis 版本 -->
        <context id="default" targetRuntime="MyBatis3">
    
            <!--序列化model-->
            <!--<plugin type="org.mybatis.generator.plugins.SerializablePlugin"></plugin>-->
    
            <!--optional,旨在创建class时，对注释进行控制-->
            <commentGenerator>
                <property name="suppressDate" value="true" />
                <!-- 是否去除自动生成的注释 true：是 ： false:否 -->
                <property name="suppressAllComments" value="false" />
            </commentGenerator>
    
            <!--jdbc的数据库连接-->
            <jdbcConnection driverClass="${db.driverClassName}"
                            connectionURL="${db.url}"
                            userId="${db.username}"
                            password="${db.password}">
            </jdbcConnection>
    
            <!--非必须，类型处理器，在数据库类型和java类型之间的转换控制-->
            <javaTypeResolver>
                <!-- 默认情况下数据库中的 decimal，bigInt 在 Java 对应是 sql 下的 BigDecimal 类 -->
                <!-- 不是 double 和 long 类型 -->
                <!-- 使用常用的基本类型代替 sql 包下的引用类型 -->
                <property name="forceBigDecimals" value="false" />
            </javaTypeResolver>
    
            <!-- targetPackage：生成的实体类所在的包 -->
            <!-- targetProject：生成的实体类所在的硬盘位置 -->
            <javaModelGenerator targetPackage="com.waylanpunch.mymagazine.pojo"
                                targetProject=".\src\main\java">
                <!-- 是否允许子包 -->
                <property name="enableSubPackages" value="false" />
                <!-- 是否对modal添加构造函数 -->
                <property name="constructorBased" value="true" />
                <!-- 是否清理从数据库中查询出的字符串左右两边的空白字符 -->
                <property name="trimStrings" value="true" />
                <!-- 建立modal对象是否不可改变 即生成的modal对象不会有setter方法，只有构造方法 -->
                <property name="immutable" value="false" />
            </javaModelGenerator>
    
            <!-- targetPackage 和 targetProject：生成的 mapper 文件的包和位置 -->
            <sqlMapGenerator targetPackage="mappers"
                             targetProject=".\src\main\resources">
                <!-- 针对数据库的一个配置，是否把 schema 作为字包名 -->
                <property name="enableSubPackages" value="false" />
            </sqlMapGenerator>
    
            <!-- targetPackage 和 targetProject：生成的 interface 文件的包和位置 -->
            <javaClientGenerator type="XMLMAPPER"
                                 targetPackage="com.waylanpunch.mymagazine.dao" targetProject=".\src\main\java">
                <!-- 针对 oracle 数据库的一个配置，是否把 schema 作为字包名 -->
                <property name="enableSubPackages" value="false" />
            </javaClientGenerator>
            <!--<table tableName="t_users" domainObjectName="User"
                   enableCountByExample="true" enableUpdateByExample="true"
                   enableDeleteByExample="true" enableSelectByExample="true"
                   selectByExampleQueryId="true">
            </table>
            <table tableName="t_articles" domainObjectName="Article"
                   enableCountByExample="true" enableUpdateByExample="true"
                   enableDeleteByExample="true" enableSelectByExample="true"
                   selectByExampleQueryId="true">
            </table>
            <table tableName="t_attach" domainObjectName="Attachment"
                   enableCountByExample="true" enableUpdateByExample="true"
                   enableDeleteByExample="true" enableSelectByExample="true"
                   selectByExampleQueryId="true">
            </table>
            <table tableName="t_comments" domainObjectName="Comment"
                   enableCountByExample="true" enableUpdateByExample="true"
                   enableDeleteByExample="true" enableSelectByExample="true"
                   selectByExampleQueryId="true">
            </table>
            <table tableName="t_logs" domainObjectName="Log"
                   enableCountByExample="true" enableUpdateByExample="true"
                   enableDeleteByExample="true" enableSelectByExample="true"
                   selectByExampleQueryId="true">
            </table>
            <table tableName="t_metas" domainObjectName="Meta"
                   enableCountByExample="true" enableUpdateByExample="true"
                   enableDeleteByExample="true" enableSelectByExample="true"
                   selectByExampleQueryId="true">
            </table>
            <table tableName="t_options" domainObjectName="Option"
                   enableCountByExample="true" enableUpdateByExample="true"
                   enableDeleteByExample="true" enableSelectByExample="true"
                   selectByExampleQueryId="true">
            </table>
            <table tableName="t_relationships" domainObjectName="Relationship"
                   enableCountByExample="true" enableUpdateByExample="true"
                   enableDeleteByExample="true" enableSelectByExample="true"
                   selectByExampleQueryId="true">
            </table>-->
            <table schema="" tableName="t_users" domainObjectName="User">
            </table>
            <table schema="" tableName="t_articles" domainObjectName="Article">
                <columnOverride column="content" javaType="java.lang.String" jdbcType="VARCHAR" />
            </table>
            <table schema="" tableName="t_attachments" domainObjectName="Attachment">
            </table>
            <table schema="" tableName="t_comments" domainObjectName="Comment">
            </table>
            <table schema="" tableName="t_logs" domainObjectName="Log">
            </table>
            <table schema="" tableName="t_metas" domainObjectName="Meta">
            </table>
            <table schema="" tableName="t_options" domainObjectName="Option">
            </table>
            <table schema="" tableName="t_relationships" domainObjectName="Relationship">
            </table>
        </context>
    </generatorConfiguration>


**4.datasource.properties**

    \src\main\resources\datasource.properties

Source Code:

    db.driverLocation=E:/MAVENREPO/mysql/mysql-connector-java/8.0.15/mysql-connector-java-8.0.15.jar
    db.driverClassName=com.mysql.jdbc.Driver
    db.url=jdbc:mysql://192.168.1.105:3306/mymagazine?characterEncoding=utf-8&serverTimezone=GMT%2B8
    db.username=root
    db.password=123456
    
**5.Running MyBatis Generator**

    List<String> warnings = new ArrayList<String>();
    boolean overwrite = true;
    File configFile = new File("src/main/resources/generatorConfig.xml");
    ConfigurationParser cp = new ConfigurationParser(warnings);
    Configuration config = cp.parseConfiguration(configFile);
    DefaultShellCallback callback = new DefaultShellCallback(overwrite);
    MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
    myBatisGenerator.generate(null);
