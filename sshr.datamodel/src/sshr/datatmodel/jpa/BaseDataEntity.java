package sshr.datamodel.jpa;

import java.io.Serializable;


public abstract class BaseDataEntity <T> implements Serializable {

	public abstract void autoPopulate(T de);

	public abstract T reversePopulate(T de);

}