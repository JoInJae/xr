package app.exception;

import app.data.response.type.Response;
import app.exception.basement.BaseException;

public class WrongApproachEntityException extends BaseException {

    private static final long serialVersionUID = -8364236381532562622L;

    public WrongApproachEntityException(Response response) {
        super(response);
    }
}
