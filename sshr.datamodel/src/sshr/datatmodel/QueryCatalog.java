package sshr.datamodel;


public interface QueryCatalog {

    public EntityQuery  getQuerySpecification();
    public EntityQuery  getQuerySpecification(Class<?> eclass);

}