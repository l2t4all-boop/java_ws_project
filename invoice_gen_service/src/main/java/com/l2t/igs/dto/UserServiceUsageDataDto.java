package com.l2t.igs.dto;

import com.l2t.igs.domain.Service;
import com.l2t.igs.domain.UsageData;
import com.l2t.igs.domain.User;
import lombok.Data;

import java.util.List;

@Data
public class UserServiceUsageDataDto {

    private List<Service> services;
    private List<User> users;
    private List<UsageData> usageRecords;

}
