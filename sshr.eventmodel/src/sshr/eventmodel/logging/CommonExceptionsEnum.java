package sshr.eventmodel.logging;


public enum CommonExceptionsEnum implements EventWrapper<RuntimeException, CommonExceptionsEnum> {

	INFO(new RuntimeException(""), ExceptionSeverityEnum.INFORMATIONAL),
	INSUFFICIENT_NUMBER_OF_PARAMETERS_PROVIDED_EXCEPTION(new RuntimeException("The given parameters does not match with the excpected."), ExceptionSeverityEnum.ERROR);

    
	private String[]                               customMessage;
	private RuntimeException                       exception;
	private ExceptionSeverityEnum                  severity;
	private EventWrapperUtil<CommonExceptionsEnum> customizer = new EventWrapperUtil<CommonExceptionsEnum>(this);

	
    CommonExceptionsEnum(RuntimeException exception, ExceptionSeverityEnum severity) {
    
        this.severity  = severity;
        this.exception = exception;
    }

	
    @Override
    public ExceptionSeverityEnum getSeverity() {
    
        return this.severity;
    }
    
    @Override
    public String[] getCustomMessage() {
    
        return this.customMessage;
    }
    
    @Override
    public Throwable getCause() {
    
        return this.exception.getCause();
    }
    
    @Override
    public RuntimeException getException() {
    
        return this.exception;
    }
    
    @Override
    public void setCustomMessage(final String... msg) {
    
        System.out.println("Method: void setCustomMessage(final String... msg) is not implemented");
    }

    public void setCause(final Throwable t) {
    
        System.out.println("Method: void setCause(final Throwable t) is not implemented");
    }
		
    @Override
    public CommonExceptionsEnum customize(final Throwable cause, final String... customMessage) {
    
        return this.customizer.customize(cause, customMessage);
    }

    @Override
    public CommonExceptionsEnum customize(final Throwable cause) {
    
        return this.customizer.customize(cause);
    }
		
}
