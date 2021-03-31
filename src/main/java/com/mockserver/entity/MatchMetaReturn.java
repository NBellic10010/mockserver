package com.mockserver.entity;

import java.util.ArrayList;
import java.util.List;

public class MatchMetaReturn {
    private int code;
    private String msg;
    private Data data;

    public MatchMetaReturn(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(int status, List<MatchMeta> matchMetaList) {
        this.data = new Data(status, matchMetaList);
    }

    class Data {
        private int Status;
        private List<MatchMeta> matchMetaList = new ArrayList<>();

        public Data(int status, List<MatchMeta> matchMetaList) {
            Status = status;
            this.matchMetaList = matchMetaList;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int status) {
            Status = status;
        }

        public List<MatchMeta> getMatchMetaList() {
            return matchMetaList;
        }

        public void setMatchMetaList(List<MatchMeta> matchMetaList) {
            this.matchMetaList = matchMetaList;
        }
    }
}
