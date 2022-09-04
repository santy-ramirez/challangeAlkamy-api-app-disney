package com.santiago.AppDisney.config;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorEx {
   private HttpStatus status;
   private String message;
}
