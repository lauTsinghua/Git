package com.cy.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class ActivityPojo {
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
