package com.santiago.AppDisney.util;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;

public class BuildPage {
    private CustumerPage custumerPage;

    public BuildPage(){
        this.custumerPage =new CustumerPage();
    }

    public BuildPage content(List<?> content){
        this.custumerPage.setContent(content);
        return this;
    }


    public  BuildPage paginate(Page page){
        this.custumerPage.setPage(page.getTotalPages());
        this.custumerPage.setSize(page.getSize());
        this.custumerPage.setStatus(HttpStatus.OK);
        this.custumerPage.setTotalResult(page.getTotalElements());
        return this;
    }
    public CustumerPage build(){
        return this.custumerPage;
    }
}
