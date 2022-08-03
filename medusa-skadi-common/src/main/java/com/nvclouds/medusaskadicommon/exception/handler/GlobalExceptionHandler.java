package com.nvclouds.medusaskadicommon.exception.handler;

import com.nvclouds.medusaskadicommon.base.BaseResult;
import com.nvclouds.medusaskadicommon.enums.GlobalEnums;
import com.nvclouds.medusaskadicommon.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @Auther: ShouZhi@Duan
 * @Date: 2022/3/10 13:09
 * @Description: 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({GlobalException.class})
    public BaseResult<Object> handleException(GlobalException exception) {
        return response(exception);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public BaseResult<Object> validationBodyException(MethodArgumentNotValidException exception){
        exception.printStackTrace();
        BindingResult bindingResult = exception.getBindingResult();
        return responseValidate(GlobalEnums.SYSTEM_PARAMS_ERRO.getCode(),getBindingResult(bindingResult));
    }

    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public BaseResult<Object> validationBodyException(BindException exception){
        exception.printStackTrace();
        BindingResult bindingResult = exception.getBindingResult();
        return responseValidate(GlobalEnums.SYSTEM_PARAMS_ERRO.getCode(),getBindingResult(bindingResult));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public BaseResult<Object> handleServiceException(ConstraintViolationException e) {
        e.printStackTrace();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return  responseValidate(GlobalEnums.SYSTEM_PARAMS_ERRO.getCode(),message);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public BaseResult<Object> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        e.printStackTrace();
        MissingServletRequestParameterException ex = (MissingServletRequestParameterException)e;
        return  responseValidate(GlobalEnums.SYSTEM_PARAMS_ERRO.getCode(),ex.getParameterName() + "不能为空！");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseResult<Object> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        e.printStackTrace();
        return  responseValidate(GlobalEnums.SYSTEM_PARAMS_ERRO.getCode(),"不能用" + request.getMethod() + "方式请求，请检查接口具体请求方式post?get?put?delete? or others");
    }

    private BaseResult<Object> response(GlobalException exceptionEnum) {
        return  responseValidate(exceptionEnum.getGlobalEnums().getCode(),exceptionEnum.getGlobalEnums().getMsg());
    }

    private BaseResult<Object> responseValidate(Integer code, String msg) {
        return BaseResult.builder().code(code).msg(msg).build();
    }

    private String getBindingResult(BindingResult bindingResult){
        List<ObjectError> list = bindingResult.getAllErrors();
        return CollectionUtils.isEmpty(list) ? "" : list.get(0).getDefaultMessage().toString();
    }
}
