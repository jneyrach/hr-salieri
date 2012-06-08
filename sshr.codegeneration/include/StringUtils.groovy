class StringUtils {

    public String getParameterString(String prop) {
        
        def String[] tmp = prop.split(" ")
        def StringBuilder sb = new StringBuilder()
        
        tmp.each {
                  
                  def String aux = ""
                  
                  aux = auxCapitalize(it)
                  
                  sb.append( aux )
        }
        
        return auxUnCapitalize( sb.toString() )
    }
 
    public String getPropertyDeclarationString(String prop) {
        
        def String[] tmp = prop.split(" ")
        def StringBuilder sb = new StringBuilder()
        
        tmp.each {
                  
                  def String aux = ""
                  
                  aux = auxCapitalize(it)
                  
                  sb.append( aux )
        }
        
        return "_" + auxUnCapitalize( sb.toString() )
    }
 
    public String getFieldDeclarationString(String prop) {
        
        def String[] tmp = prop.split(" ")
        def StringBuilder sb = new StringBuilder()
        def String separator = ""
        
        tmp.each {
                  
                  def String aux = ""
                  
                  aux = it.toUpperCase()
                  
                  sb.append( separator + aux )
                  
                  separator = "_"
        }
        
        return sb.toString()
    }
 
    public String getFieldGetterDeclarationString(String prop) {
        
        def String[] tmp = prop.split(" ")
        def StringBuilder sb = new StringBuilder()
        
        tmp.each {
                  
                  def String aux = ""
                  
                  aux = auxCapitalize(it)
                  
                  sb.append( aux )
        }
        
        return "get" + sb.toString()
    }
 
    public String getFieldSetterDeclarationString(String prop) {
        
        def String[] tmp = prop.split(" ")
        def StringBuilder sb = new StringBuilder()
        
        tmp.each {
                  
                  def String aux = ""
                  
                  aux = auxCapitalize(it)
                  
                  sb.append( aux )
        }
        
        return "set" + sb.toString()
    }
 
    public String auxCapitalize(String s) {
        
        if (s.length() == 0) return s;
        
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
 
    public String auxUnCapitalize(String s) {
        
        if (s.length() == 0) return s;
        
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }
 
}
