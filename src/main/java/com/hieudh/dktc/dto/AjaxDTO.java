package com.hieudh.dktc.dto;

public class AjaxDTO {
    private int status;
    private Object data;
    private String example = "test";

    public AjaxDTO(int status, Object data) {
        super();
        this.status = status;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }


}
