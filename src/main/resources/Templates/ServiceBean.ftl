    public static I${entity.className?cap_first}Service get${entity.className?cap_first}Service() {
        try {
            I${entity.className?cap_first}Service service = (I${entity.className?cap_first}Service) ServiceBeanContext.getInstance().getBean("${entity.className}Service");
            return service;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }