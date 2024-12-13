package com.scholarsync.request;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchRequest {
    private String batchName;
    private String courseName;
    private Date startDate;
    private List<Long> trianerId;
}
