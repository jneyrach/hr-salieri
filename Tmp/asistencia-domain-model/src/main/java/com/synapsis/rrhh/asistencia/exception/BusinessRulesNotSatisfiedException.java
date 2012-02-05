/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.synapsis.rrhh.asistencia.exception;

/**
 *
 * @author Administrator
 */
public class BusinessRulesNotSatisfiedException extends Exception {

    public BusinessRulesNotSatisfiedException() {}

    public BusinessRulesNotSatisfiedException(String message) {super(message);}

    public BusinessRulesNotSatisfiedException(Throwable ex) {super(ex);}

    public BusinessRulesNotSatisfiedException(String message, Throwable ex) {super(message, ex);}

}
