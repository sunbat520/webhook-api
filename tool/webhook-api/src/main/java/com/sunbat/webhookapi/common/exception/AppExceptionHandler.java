package com.sunbat.webhookapi.common.exception;

import cn.hutool.http.HttpStatus;
import com.sunbat.webhookapi.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: SunYb
 * @date: 2024/6/12 16:04
 * @version: 1.0
 */
    @RestControllerAdvice
public class AppExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(AppException.class)
    public R handleAppException(AppException e, HttpServletResponse response) {
        /**
         * 500
         */
        response.setStatus(HttpStatus.HTTP_INTERNAL_ERROR);
        R r = new R();
        r.put("code", e.getCode());
        r.put("msg", e.getMessage());

        return r;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public R handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) {
        logger.debug(e.getMessage(), e);
        /**
         * 400
         */
        response.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        return R.error(HttpStatus.HTTP_BAD_REQUEST, "请求参数异常");
    }

    @ExceptionHandler(BindException.class)
    public R handleBindException(BindException e, HttpServletResponse response) {
        logger.debug(e.getMessage(), e);
        /**
         * 400
         */
        response.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        return R.error(HttpStatus.HTTP_BAD_REQUEST, "请求参数格式错误");
    }

    @ExceptionHandler(AuthException.class)
    public R handleAuthException(AuthException e, HttpServletResponse response) {
        logger.debug(e.getMessage(), e);
        /**
         * 403
         */
        response.setStatus(HttpStatus.HTTP_FORBIDDEN);
        return R.error(HttpStatus.HTTP_FORBIDDEN, "没有权限，请联系管理员授权");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public R handlerNoFoundException(NoHandlerFoundException e, HttpServletResponse response) {
        logger.debug(e.getMessage(), e);
        /**
         * 404
         */
        response.setStatus(HttpStatus.HTTP_NOT_FOUND);
        return R.error(HttpStatus.HTTP_NOT_FOUND, "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e,
                                                           HttpServletResponse response) {
        logger.debug(e.getMessage(), e);
        /**
         * 405
         */
        response.setStatus(HttpStatus.HTTP_BAD_METHOD);
        return R.error(HttpStatus.HTTP_BAD_METHOD, "请求方法不支持，请检查method是否正确");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R handlerHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletResponse response) {
        logger.debug(e.getMessage(), e);
        /**
         * 406
         */
        response.setStatus(HttpStatus.HTTP_NOT_ACCEPTABLE);
        return R.error(HttpStatus.HTTP_NOT_ACCEPTABLE, "请求包体格式错误");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e, HttpServletResponse response) {
        logger.debug(e.getMessage(), e);
        /**
         * 409
         */
        response.setStatus(HttpStatus.HTTP_CONFLICT);
        return R.error(HttpStatus.HTTP_CONFLICT, "数据冲突，数据库中已存在该记录");
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public R handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e, HttpServletResponse response) {
        logger.debug(e.getMessage(), e);
        /**
         * 415
         */
        response.setStatus(HttpStatus.HTTP_UNSUPPORTED_TYPE);
        return R.error(HttpStatus.HTTP_UNSUPPORTED_TYPE, "请求头Content-Type不支持");
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e, HttpServletResponse response) {
        logger.error(e.getMessage(), e);
        /**
         * 500
         */
        response.setStatus(HttpStatus.HTTP_INTERNAL_ERROR);
        return R.error();
    }
}