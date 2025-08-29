package interfaceadapters.presenters;

import core.ports.IPresenter;
import core.entities.Response;

public class Presenter<T> implements IPresenter<T> {
    @Override
    public Response<T> present(T data) {
        String message = "Success";
        Boolean success = true;

        return new Response<T>(message, success, data);
    }
}
