package com.nberimen.hospitalmanagementsystem.gen.dto;

import lombok.Data;

import java.util.List;

@Data
public class MyMessages {

    private List<MyMessage> errorMessageList;
    private List<MyMessage> infoMessageList;
    private List<MyMessage> warningMessageList;
}
