package core.entities;

public class Response<T> {
    public String message;
    public Boolean success;
    public T data;

    public Response(String message, Boolean success, T data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }
}
