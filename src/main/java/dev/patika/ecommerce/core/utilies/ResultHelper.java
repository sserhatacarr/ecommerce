package dev.patika.ecommerce.core.utilies;

import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultData;

public class ResultHelper {
    public static <T> ResultData<T> created(T data) {
        return new ResultData<>(true, Msg.CREATED, "201", data);
    }

    public static <T> ResultData<T> validationError(T data) {
        return new ResultData<>(false, Msg.VALIDATION_ERROR, "400", data);
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(true, Msg.OK, "200", data);
    }

    public static  Result notFoundError(String msg) {
        return new Result(false, msg, "404");
    }
}
