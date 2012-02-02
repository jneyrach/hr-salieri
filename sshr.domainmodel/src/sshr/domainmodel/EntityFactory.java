package sshr.domainmodel;


public enum EntityFactory {

    Instance;


    public static <T extends BaseEntity> T getNewEntity(Class<T> cls) throws InstantiationException, IllegalAccessException, EntityAccessNotAllowedException {

        return BaseEntity.newInstance( cls );
    }

}
