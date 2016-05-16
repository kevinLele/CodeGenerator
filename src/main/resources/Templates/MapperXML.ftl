<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${entity.mapperPackage}.${entity.className?cap_first}Mapper">

    <resultMap type="${entity.entityPackage}.${entity.className?cap_first}" id="${entity.className}ResultMap">
        <#list entity.properties as property>
        <result column="${property.fieldName}" property="${property.propertyName}" javaType="${property.fullJavaType}"/>
        </#list>
    </resultMap>

    <sql id="column">
        <#list entity.properties as property>t.${property.fieldName}<#if property_has_next>,</#if></#list>
    </sql>

    <insert id="save" parameterType="${entity.entityPackage}.${entity.className?cap_first}">
        insert into ${entity.tableName}(<#list entity.properties as property>${property.fieldName}<#if property_has_next>,</#if></#list>)
        values(<#list entity.properties as property>${r"#"}{${property.propertyName}}<#if property_has_next>,</#if></#list>)
    </insert>

    <update id="update" parameterType="${entity.entityPackage}.${entity.className?cap_first}">
        update ${entity.tableName} t
        <include refid="sql_update"/>
        where t.id=${r"#"}{id}
    </update>

    <delete id="deleteById" parameterType="java.lang.String">
        delete from ${entity.tableName} where id = ${r"#"}{id};
    </delete>

    <select id="findById" resultMap="${entity.className}ResultMap">
        select
        <include refid="column"/>
        from ${entity.tableName} t where t.id = ${r"#"}{id}
    </select>

    <select id="findAll" resultMap="${entity.className}ResultMap">
        select
        <include refid="column"/>
        from ${entity.tableName} t
    </select>

    <select id="findByMap" parameterType="java.util.Map" resultMap="${entity.className}ResultMap">
        select
        <include refid="column"/>
        from ${entity.tableName} t
        <include refid="sql_where"/>
    </select>

    <select id="getCount" parameterType="java.util.Map" resultType="int">
        select
        count(1)
        from ${entity.tableName} t
        <include refid="sql_where"/>
    </select>

    <select id="findByPage" parameterType="java.util.Map" resultMap="${entity.className}ResultMap">
        select
        <include refid="column"/>
        from ${entity.tableName} t
        <include refid="sql_where"/>
        order by t.create_date desc
        limit ${r"#"}{startRowNum}, ${r"#"}{pageSize}
    </select>

    <select id="findByName" parameterType="java.util.Map" resultMap="${entity.className}ResultMap">
        select
        <include refid="column"/>
        from ${entity.tableName} t
        where t.name = ${r"#"}{name}
        <if test="id != null and id != ''">
            <![CDATA[
                and t.id <> ${r"#"}{id}
            ]]>
        </if>
    </select>

    <sql id="sql_where">
        <where>
            <#list entity.properties as property>
            <if test="${property.propertyName} != null and ${property.propertyName} != ''">
                <![CDATA[
                    and t.${property.fieldName} = ${r"#"}{${property.propertyName}}
                ]]>
            </if>
            </#list>
        </where>
    </sql>

    <sql id="sql_update">
        <set>
            <#list entity.properties as property>
            <if test="${property.propertyName} != null and ${property.propertyName} != ''">
                <![CDATA[
                    t.${property.fieldName} = ${r"#"}{${property.propertyName}},
                ]]>
            </if>
            </#list>
        </set>
    </sql>
</mapper>