/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.synapsis.rrhh.asistencia.exception;

/**
 *
 * @author Administrator
 */
public class WebAppException extends RuntimeException {

    public WebAppException() {}

    public WebAppException(String message) {super(message);}

    public WebAppException(Throwable ex) {super(ex);}

    public WebAppException(String message, Throwable ex) {super(message, ex);}    
    
}
