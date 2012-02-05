
package com.synapsis.rrhh.asistencia.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CustomNamedQueryParameter {

    public String name();
    
    public CustomNamedQueryParametersTypes parType();
    
    public int ordinal();
    
}
