package ${entity.providerImplPackage};

import com.tscloud.common.framework.dubbo.impl.DubboBaseInterfaceImpl;
import com.tscloud.common.framework.service.IBaseInterfaceService;
import ${entity.entityPackage}.${entity.className?cap_first};
import ${entity.providerPackage}.I${entity.className?cap_first}Provider;

public class ${entity.className?cap_first}ProviderImpl extends DubboBaseInterfaceImpl<${entity.className?cap_first}> implements I${entity.className?cap_first}Provider {

    @Override
    public IBaseInterfaceService<${entity.className?cap_first}> getBaseInterfaceService() {
        return ${entity.serviceBeanClassFilePackage}.get${entity.className?cap_first}Service();
    }


}
