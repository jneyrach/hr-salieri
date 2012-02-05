/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.synapsis.rrhh.asistencia.exception;

/**
 *
 * @author Marcello
 */
public class NoDataFoundException extends Exception {

    public NoDataFoundException() {}

    public NoDataFoundException(String message) {super(message);}

    public NoDataFoundException(Throwable ex) {super(ex);}

    public NoDataFoundException(String message, Throwable ex) {super(message, ex);}

}
