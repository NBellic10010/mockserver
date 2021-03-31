package com.mockserver.entity;

import java.io.Serializable;


public class Match implements Serializable {
    private String sgf;
    private Result Result;
    private String message;

    public Match(String sgf, Match.Result result, String message) {
        this.sgf = sgf;
        Result = result;
        this.message = message;
    }

    public String getSgf() {
        return sgf;
    }

    public void setSgf(String sgf) {
        this.sgf = sgf;
    }

    public Match.Result getResult() {
        return Result;
    }

    public void setResult(Match.Result result) {
        Result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Result {
        public String sgf;
        public String result;
        public int status;
        public int id;
        public int delete_flag;

        public Result(String sgf,
                      String result, int status,
                      int id, int delete_flag) {
            this.sgf = sgf;
            this.result = result;
            this.status = status;
            this.id = id;
            this.delete_flag = delete_flag;
        }

        public String getSgf() {
            return sgf;
        }

        public void setSgf(String sgf) {
            this.sgf = sgf;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getDelete_flag() {
            return delete_flag;
        }

        public void setDelete_flag(int delete_flag) {
            this.delete_flag = delete_flag;
        }
    }
}
