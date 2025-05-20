package com.example.Employee.response;

public class GetResponse {
    private String message;
    private Integer code;
    private Object data;
    private Integer Page;
    private Long totalRecord;

    public GetResponse(String message, Integer code, Object data, Integer page, Long totalRecord) {
        this.message = message;
        this.code = code;
        this.data = data;
        Page = page;
        this.totalRecord = totalRecord;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getPage() {
        return Page;
    }

    public void setPage(Integer page) {
        Page = page;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }
}
