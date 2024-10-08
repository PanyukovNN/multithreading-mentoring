package ru.panyukovnn.multithreadingmentoring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KafkaResponse implements Serializable {

    private String id;
    private String payload;
}
