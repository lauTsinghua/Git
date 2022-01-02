package cy.activity.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Data
@Slf4j
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
