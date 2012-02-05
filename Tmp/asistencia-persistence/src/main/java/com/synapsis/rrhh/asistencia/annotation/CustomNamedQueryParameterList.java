
package com.synapsis.rrhh.asistencia.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CustomNamedQueryParameterList {

    public CustomNamedQueryParameter[] value();
    
}
