package com.lqb.ss.MyShardingSphere.common;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lvqibin
 * @version 1.0.0
 * @date 2021-04-15
 *
 */
@Slf4j
public class Message implements Serializable {
    public final static int SUCCESS = 200;
    private boolean isRelease;

    private Exception exception;
    private String message = "success";
    private int status = SUCCESS;
    private String total = "0";
    private Object data;
    private String description;
    private Map<String, Object> parameterDetail = new HashMap<String, Object>();
    private boolean isTokenExist = true;

    public Message() {
    }

    /**
     * 返回数据的无参构造，默认返回的状态为200
     *
     * @param data 返回的数据
     */
    public Message(Object data) {
        this(SUCCESS, StringUtils.EMPTY, data);
    }

    /**
     * 异常的无参构造
     *
     * @param retStatus  异常状态吗
     * @param retMessage 异常的信息
     */
    public Message(int retStatus, String retMessage) {
        this(retStatus, retMessage, null);
    }

    /**
     * 返回指定的特殊数据
     *
     * @param retStatus  指定的特殊代码
     * @param retMessage 指定的特殊信息
     * @param data       指定的特殊数据
     */
    public Message(int retStatus, String retMessage, Object data) {
        this.status = retStatus;
        this.message = retMessage;
        this.data = data;
    }
    
    /**
     * 返回分页的数据
     *
     * @param retStatus  指定的特殊代码
     * @param retMessage 指定的特殊信息
     * @param data       指定的特殊数据
     */
    public Message(int retStatus, String retMessage, String total, Object data) {
        this.status = retStatus;
        this.message = retMessage;
        this.data = data;
        this.total = total;
    }

    /**
     *  默认异常返回数据
     * @param message 异常信息(可为空)
     * @param e
     */
    public Message(String message, Throwable e) {
        if (e instanceof MyException) {
            MyException ex = (MyException) e;
            this.status = ex.getStatus();
            if(StringUtils.isNotBlank(message)){
                this.message = message;
            }else {
                this.message = ex.getMessage();
            }
        } else {
            this.status = ExceptionCode.INNER_EXCEPTION.getValue();
            if(StringUtils.isNotBlank(message)){
                this.message = message;
            }else {
                this.message = e.getMessage();
            }
        }
    }

    public static Message fail(String msg) {
        return new  Message(-200,msg,null);
    }
    public static Message success(String msg) {
        return new  Message(200,msg,null);
    }
    public static Message success(String msg, Object data) {
        return new  Message(200,msg,data);
    }

    /**  */
    public void addParameterDetail(String parameterName, String parameterType, String detail) {
        if (!isRelease) {
            parameterDetail.put(parameterName, "parameterType: " + parameterType + " ; detail: " + detail + " ;");
        }
    }

    /**  */
    public void setData(Object data) {
        this.data = data;
    }

    public void setDescription(String description) {
        if (!isRelease) {
            this.description = description;
        }
    }

    public void setStatus(int status) {
        this.status = status;
        if (200 == status) {
            message = "success";
        }
    }

    public void setMessage(String message) {
        if (!isRelease) {
            this.message = message;
        }
    }

    public void setRelease(boolean release) {
        isRelease = release;
    }

    public void setError(MyException myException) {
        exception = myException;
        status = myException.getStatus();
        if (!isRelease) {
            message = myException.getMessage();
        }
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Object> getParameterDetail() {
        return parameterDetail;
    }

    public void printTrack() {
        if (null != exception) {
            log.error(exception.getMessage(), exception);
        }
    }

    public boolean isTokenExist() {
        return isTokenExist;
    }

    public void setTokenExist(boolean tokenExist) {
        isTokenExist = tokenExist;
    }

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Message [isRelease=" + isRelease + ", exception=" + exception + ", message=" + message + ", status="
				+ status + ", total=" + total + ", data=" + data + ", description=" + description + ", parameterDetail="
				+ parameterDetail + ", isTokenExist=" + isTokenExist + "]";
	}


  
}
