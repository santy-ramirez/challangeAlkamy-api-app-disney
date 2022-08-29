package com.santiago.AppDisney.util;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustumerPage {
    private HttpStatus status;
    private int page;
    private int size;
    private Long totalResult;
    private List<?> content = new ArrayList<>();
}
