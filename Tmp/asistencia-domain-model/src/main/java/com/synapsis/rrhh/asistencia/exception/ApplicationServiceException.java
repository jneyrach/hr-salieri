/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.synapsis.rrhh.asistencia.exception;

/**
 *
 * @author Administrator
 */
public class ApplicationServiceException extends Exception {

    public ApplicationServiceException() {}

    public ApplicationServiceException(String message) {super(message);}

    public ApplicationServiceException(Throwable ex) {super(ex);}

    public ApplicationServiceException(String message, Throwable ex) {super(message, ex);}

}
