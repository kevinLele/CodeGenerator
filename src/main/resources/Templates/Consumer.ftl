public static I${entity.className?cap_first}Provider get${entity.className?cap_first}Provider() {
    I${entity.className?cap_first}Provider ${entity.className}Provider = null;

    try {
        ${entity.className}Provider = (I${entity.className?cap_first}Provider) ServiceBeanContext.getInstance().getBean("${entity.className}Provider");
    } catch (Exception e) {
        log.error("get${entity.className?cap_first}Provider service instance fail,  ", e);
    }

    return ${entity.className}Provider;
}