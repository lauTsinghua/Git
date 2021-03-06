package com.cy.pj.activity.pojo;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
/**
 * pojo
 * **/
@Data
public class Activity {
    private Long id;
    private String title;
    private String category;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime endTime;
    private Short state=1;
private String remark;
private String createdUser;
private LocalDateTime createdTime;

}
