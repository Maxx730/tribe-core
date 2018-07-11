package tools;

public class Response {
    private String type;
    private String message;

    public Response(String type,String message){
        this.type = type;
        this.message = message;
    }

    //Getter Methods
    public String getType(){
        return this.type;
    }

    public String getMessage(){
        return this.message;
    }

    //Setter Methods
    public void setType(String type){
        this.type = type;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
