package com.santiago.AppDisney.util;

import org.springframework.http.HttpStatus;

import java.util.List;

public class BuildPage {
    private CustumerPage custumerPage;

    public BuildPage(){
        this.custumerPage =new CustumerPage();
    }
    public BuildPage status(HttpStatus status){
        this.custumerPage.setStatus(status);
        return this;
    }
    public BuildPage page(int page){
        this.custumerPage.setPage(page);
        return this;
    }
    public BuildPage size(int size){
        this.custumerPage.setSize(size);
        return this;
    }
    public  BuildPage totalResult(Long totalResult){
        this.custumerPage.setTotalResult(totalResult);
        return this;
    }
    public BuildPage content(List<?> content){
        this.custumerPage.setContent(content);
        return this;
    }
    public CustumerPage build(){
        return this.custumerPage;
    }
}
