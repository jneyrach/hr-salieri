
package com.synapsis.rrhh.asistencia.persistence.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.synapsis.rrhh.asistencia.exception.NoDataFoundException;
import com.synapsis.rrhh.asistencia.exception.NoSingleResultException;
import com.synapsis.rrhh.asistencia.exception.NotConnectedException;

public abstract class GenericEntityManager {

        private static EntityManagerFactory _entityManagerFactory = Persistence.createEntityManagerFactory("AsistenciaPU");
        private static EntityManager        _entityManager        = _entityManagerFactory == null ? null: _entityManagerFactory.createEntityManager();
        private static EntityTransaction    _entityTransaction    = _entityManager == null ? null : _entityManager.getTransaction();
        
        public static boolean beginEntityTransaction() {
            if (!_entityTransaction.isActive())
                _entityTransaction.begin();
            
            return true;
        }
        
        public static boolean commitEntityTransaction() {
            if (_entityTransaction.isActive())
                _entityTransaction.commit();
            else
                throw new RuntimeException("Not in Transaction!");
            
            return true;
        }
        
        public static boolean rollbackEntityTransaction() {
            if (_entityTransaction.isActive())
                _entityTransaction.rollback();
            
            return true;
        }
        
        public static Query createEBJQuery(String qryText) { return _entityManager.createQuery(qryText); }
        
        public static Query createNativeSQL(String sqlStr) { return _entityManager.createNativeQuery(sqlStr); }
        
        public static Query getNamedQuery(String qryName) { return _entityManager.createNamedQuery(qryName); }

        public static void createEntity(Object entity) throws NotConnectedException {
        
            if (_entityManager == null) throw new NotConnectedException("No se ha establecido la conexión a la base de datos. 'EntityManager' no se ha instanciado.");

            if (_entityTransaction.isActive()) {
                    try {
                            _entityManager.persist(entity);

                    } catch (Exception ex) {
                            throw new RuntimeException(ex);
                    }
            } else {
                        try {
                                _entityTransaction.begin();

                                _entityManager.persist(entity);

                                _entityTransaction.commit();                

                        } catch (Exception ex) {
                                if (_entityTransaction.isActive()) _entityTransaction.rollback();

                                throw new RuntimeException(ex);
                        }
            }
        
        }
        
        public static void updateEntity(Object entity) throws NotConnectedException {
        
            if (_entityManager == null) throw new NotConnectedException("No se ha establecido la conexión a la base de datos. 'EntityManager' no se ha instanciado.");
            
            if (_entityTransaction.isActive()) {
                    try {
                            _entityManager.merge(entity);

                    } catch (Exception ex) {
                            throw new RuntimeException(ex);
                    }
            } else {
                        try {
                                _entityTransaction.begin();

                                _entityManager.merge(entity);

                                _entityTransaction.commit();                

                        } catch (Exception ex) {
                                if (_entityTransaction.isActive()) _entityTransaction.rollback();

                                throw new RuntimeException(ex);
                        }
            }
        
        }
        
        public static void deleteEntity(Object entity) throws NotConnectedException {
        
            if (_entityManager == null) throw new NotConnectedException("No se ha establecido la conexión a la base de datos. 'EntityManager' no se ha instanciado.");
            
            if (_entityTransaction.isActive()) {
                    try {
                            _entityManager.remove(entity);

                    } catch (Exception ex) {
                            throw new RuntimeException(ex);
                    }
            } else {
                        try {
                                _entityTransaction.begin();
                                
                                _entityManager.remove(entity);

                                _entityTransaction.commit();                

                        } catch (Exception ex) {
                                if (_entityTransaction.isActive()) _entityTransaction.rollback();

                                throw new RuntimeException(ex);
                        }
            }
        
        }
        
        public static Object getEntityByID(Class eClass, Object id) throws NoDataFoundException, NotConnectedException {
        
            if (_entityManager == null) throw new NotConnectedException("No se ha establecido la conexión a la base de datos. 'EntityManager' no se ha instanciado.");
            
            try {
            		beginEntityTransaction();
            	
                    Object o = _entityManager.getReference(eClass, id);
                    
                    if (o == null) throw new NoDataFoundException("EntityManager no encontro un registro asociado a la entidad '" + eClass.getName() + "' con ID: '" + id.toString() + "'.");
                    
                    commitEntityTransaction();
                    
                    return o;
                
            } catch (NoDataFoundException ex) {
    				rollbackEntityTransaction();
                    throw new NoDataFoundException(ex);
            } catch (Exception ex) {
    				rollbackEntityTransaction();
                    throw new RuntimeException(ex);
            }
        
        }

        public static List getAll(Class entity) throws NoDataFoundException, NotConnectedException {
        
            if (_entityManager == null) throw new NotConnectedException("No se ha establecido la conexión a la base de datos. 'EntityManager' no se ha instanciado.");
            
            try {
            		beginEntityTransaction();
            	
                    Query qry = _entityManager.createQuery(" select o from " + entity.getSimpleName() + " o ");
                    
                    List qryResult = qry.getResultList();
                    
                    if (qryResult.isEmpty()) throw new NoDataFoundException("EntityManager no encontro registros asociados a la entidad '" + entity.getClass().getSimpleName() + "'.");
                    
                    _entityManager.clear();
                    
                    commitEntityTransaction();
                    
                    return qryResult;
                
            } catch (NoDataFoundException ex) {
    				rollbackEntityTransaction();
                    throw new NoDataFoundException(ex);
            } catch (Exception ex) {
    				rollbackEntityTransaction();
                    throw new RuntimeException(ex);
            }
        
        }

        public static List getListByStringQueryDefinition(String qryStr) throws NoDataFoundException, NotConnectedException {
        
            if (_entityManager == null) throw new NotConnectedException("No se ha establecido la conexión a la base de datos. 'EntityManager' no se ha instanciado.");
            
            try {
            		beginEntityTransaction();
            	
                    Query qryDef = _entityManager.createQuery(qryStr);
                
                    List qryResult = qryDef.getResultList();
                    
                    if (qryResult.isEmpty()) throw new NoDataFoundException("EntityManager no encontro registros asociados a la consulta '" + qryDef.toString() + "'.");
                    
                    _entityManager.clear();
                    
                    commitEntityTransaction();
                    
                    return qryResult;
                
            } catch (NoDataFoundException ex) {
    				rollbackEntityTransaction();
                    throw new NoDataFoundException(ex);
            } catch (Exception ex) {
    				rollbackEntityTransaction();
                    throw new RuntimeException(ex);
            }
        
        }

        public static Object getSingleResultByStringQueryDefinition(String qryStr) throws NoDataFoundException, NotConnectedException, NoSingleResultException {
        
            if (_entityManager == null) throw new NotConnectedException("No se ha establecido la conexión a la base de datos. 'EntityManager' no se ha instanciado.");
            
            try {
            		beginEntityTransaction();
            	
                    Query qryDef = _entityManager.createQuery(qryStr);
                
                    List tmp = qryDef.getResultList();
                    if (tmp.size() > 1) throw new NoSingleResultException("No se puede retornar un solo registro, la consulta retornó " + tmp.size() + ".");
                    
                    if (tmp.isEmpty()) throw new NoDataFoundException("EntityManager no encontro registros asociados a la consulta '" + qryDef.toString() + "'.");
                                    
                    _entityManager.clear();
                    
                    commitEntityTransaction();
                    
                    return tmp.get(0);
                
            } catch (NoSingleResultException ex) {
    				rollbackEntityTransaction();
                    throw new NoSingleResultException(ex);
            } catch (NoDataFoundException ex) {
    				rollbackEntityTransaction();
                    throw new NoDataFoundException(ex);
            } catch (Exception ex) {
    				rollbackEntityTransaction();
                    throw new RuntimeException(ex);
            }
        
        }

        public static List getListByQueryObject(Query qryDef) throws NoDataFoundException, NotConnectedException {
        
            if (_entityManager == null) throw new NotConnectedException("No se ha establecido la conexión a la base de datos. 'EntityManager' no se ha instanciado.");
            
            try {
            		beginEntityTransaction();
            	
                    List qryResult = qryDef.getResultList();
                    
                    if (qryResult.isEmpty()) throw new NoDataFoundException("EntityManager no encontro registros asociados a la consulta '" + qryDef.toString() + "'.");
                    
                    _entityManager.clear();
                    
                    commitEntityTransaction();
                    
                    return qryResult;
                
            } catch (NoDataFoundException ex) {
    				rollbackEntityTransaction();
                    throw new NoDataFoundException(ex);
            } catch (Exception ex) {
    				rollbackEntityTransaction();
                    throw new RuntimeException(ex);
            }
        
        }

        public static Object getSingleResultByQueryObject(Query qryDef) throws NoDataFoundException, NotConnectedException, NoSingleResultException {
        
            if (_entityManager == null) throw new NotConnectedException("No se ha establecido la conexión a la base de datos. 'EntityManager' no se ha instanciado.");
            
            try {
            		beginEntityTransaction();
            	
                    List tmp = qryDef.getResultList();
                    if (tmp.size() > 1) throw new NoSingleResultException("No se puede retornar un solo registro, la consulta retornó " + tmp.size() + ".");
                    
                    if (tmp.isEmpty()) throw new NoDataFoundException("EntityManager no encontro registros asociados a la consulta '" + qryDef.toString() + "'.");
                                    
                    _entityManager.clear();
                    
                    commitEntityTransaction();
                    
                    return tmp.get(0);
                
            } catch (NoSingleResultException ex) {
            		rollbackEntityTransaction();
                    throw new NoSingleResultException(ex);
            } catch (NoDataFoundException ex) {
        			rollbackEntityTransaction();
                    throw new NoDataFoundException(ex);
            } catch (Exception ex) {
        			rollbackEntityTransaction();
                    throw new RuntimeException(ex);
            }
        
        }

}
