package sshr.entitymodel;

import sshr.entitymodel.EntityFactory;
import sshr.entitymodel.DummyEntity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class TestDomainModelFactory {

	@Test
	public void testCreateEntityFromFactory() {
	
		try {
				assertTrue( EntityFactory.getNewEntity( DummyEntity.class ) != null );
		
		} catch (Exception ex) {
				System.out.println("----------------------------");
				System.out.println("ERROR:");
				ex.printStackTrace();
				System.out.println("----------------------------");
		}
		
	}

}
