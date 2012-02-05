
package com.synapsis.rrhh.asistencia.exception;

public class NoSingleResultException extends Exception {

    public NoSingleResultException() {}

    public NoSingleResultException(String message) {super(message);}

    public NoSingleResultException(Throwable ex) {super(ex);}

    public NoSingleResultException(String message, Throwable ex) {super(message, ex);}

}
