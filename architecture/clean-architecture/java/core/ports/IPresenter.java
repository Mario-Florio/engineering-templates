package core.ports;

import core.entities.Response;

public interface IPresenter<T> {
    public Response<T> present(T data);
}
