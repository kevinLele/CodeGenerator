package ${entity.entityPackage};

import com.tscloud.common.framework.domain.TrackableEntity;

import java.io.Serializable;
import java.util.Date;

public class ${entity.className?cap_first} extends TrackableEntity implements Serializable {

    <#list entity.properties as property>
    <#if !property.parentProperty>
    private ${property.javaType} ${property.propertyName};
    </#if>
    </#list>

    <#list entity.properties as property>
    <#if !property.parentProperty>
    public ${property.javaType} get${property.propertyName?cap_first}() {
        return ${property.propertyName};
    }

    public void set${property.propertyName?cap_first}(${property.javaType} ${property.propertyName}) {
        this.${property.propertyName} = ${property.propertyName};
    }

    </#if>
    </#list>
}