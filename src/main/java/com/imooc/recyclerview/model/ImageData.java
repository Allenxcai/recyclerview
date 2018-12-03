package com.imooc.recyclerview.model;

import java.util.List;


public class ImageData {
    private int status;
    private String msg;
    private List<DataBean> data;
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public static class DataBean {
        private int id;
        private String name;
        private String picSmall;
        private String description;
        private int learner;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicSmall() {
            return picSmall;
        }

        public void setPicSmall(String picSmall) {
            this.picSmall = picSmall;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getLearner() {
            return learner;
        }

        public void setLearner(int learner) {
            this.learner = learner;
        }
    }

}
