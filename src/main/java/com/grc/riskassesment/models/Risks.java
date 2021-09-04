package com.grc.riskassesment.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Document(collection = "risks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Risks implements Serializable {
    @Id
    private int id;
    private String name;
    private String description;
    private List<String> assessors;
    private Map<String,LocalDateTime> asseccedByMap;
}
