
package wiipad;


public class IOResult<T> {
    private T data;
    private boolean ok;
    
    public IOResult(boolean ok, T data){
       this.ok = ok;
       this.data = data;
       
    }

    public boolean hasData(){
        return data != null;
    }
    
    public T getData() {
        return data;
    }

    public boolean isOk() {
        return ok;
    }
    
    
    
}
