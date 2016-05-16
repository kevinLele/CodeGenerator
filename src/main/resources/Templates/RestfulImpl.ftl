package ${entity.restfulImplPackage};

import ${entity.restfulPackage}.I${entity.className?cap_first}RestServer;
import com.tscloud.common.framework.Constants;
import com.tscloud.common.framework.dubbo.DubboBaseInterface;
import com.tscloud.common.framework.rest.impl.BaseRestServerInterfaceImpl;
import ${entity.entityPackage}.${entity.className?cap_first};

import javax.ws.rs.Path;

@Path(Constants.RestPathPrefix.${entity.restPathPrefix} + "${entity.className}RestServer")
public class ${entity.className?cap_first}RestServerImpl extends BaseRestServerInterfaceImpl<${entity.className?cap_first}> implements I${entity.className?cap_first}RestServer {

    @Override
    public DubboBaseInterface getDubboBaseInterface() {
        return ${entity.consumerClassFilePackage}.get${entity.className?cap_first}Provider();
    }
}
