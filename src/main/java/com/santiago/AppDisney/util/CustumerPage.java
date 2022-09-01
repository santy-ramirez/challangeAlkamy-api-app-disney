package com.santiago.AppDisney.util;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Data
public class CustumerPage {
    private HttpStatus status;
    private int page;
    private int size;
    private Long totalResult;
    private List<?> content = new ArrayList<>();



}
