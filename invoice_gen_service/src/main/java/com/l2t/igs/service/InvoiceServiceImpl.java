package com.l2t.igs.service;

import com.l2t.igs.domain.Service;
import com.l2t.igs.domain.UsageData;
import com.l2t.igs.domain.User;
import com.l2t.igs.dto.UserServiceUsageDataDto;
import com.l2t.igs.util.JsonReaderUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InvoiceServiceImpl implements InvoiceService {

    private UserServiceUsageDataDto userServiceUsageDataDto;
    private List<User> users = new ArrayList<>();
    private List<UsageData> usageData = new ArrayList<>();
    private List<Service> services = new ArrayList<>();
    private Map<String,Service> serviceIdMap = new HashMap<>();
    private Map<String,List<UsageData>> userUsageDataMap = new HashMap<>();

    public InvoiceServiceImpl() {
        userServiceUsageDataDto = JsonReaderUtil.loadDataFromJson();
        users = userServiceUsageDataDto.getUsers();
        services = userServiceUsageDataDto.getServices();
        usageData = userServiceUsageDataDto.getUsageRecords();
        serviceIdMap = services
                .stream()
                .collect(Collectors.toMap(Service::getServiceId, service -> service));
        userUsageDataMap =
                usageData.
                        stream()
                        .collect(Collectors.groupingBy(UsageData::getUserId));
    }

    @Override
    public void generateAndSentInvoices() {
        for(User user: users){
            double totalAmount = 0;
            List<UsageData> userUsageData = userUsageDataMap.get(user.getUserId());
            if(!userUsageData.isEmpty()) {
                for (UsageData ud : userUsageData) {
                    Service service = serviceIdMap.get(ud.getServiceId());
                    if (service != null) {
                        double unitPrice = service.getUnitPrice();
                        totalAmount += ud.getUnits() * unitPrice;
                    }
                }
                sentEmail(user.getName(), user.getEmail(), totalAmount);
            }else{
                System.out.println("User :"+user.getName()+" has no usage data.");
            }
        }
    }
    private void sentEmail(String username, String email, double totalAmount) {
        System.out.printf("Dear %s,\n\t Your total invoice amount is %.2f and invoice is sent to email id: %s\n\nThank you.%n",
                username, totalAmount, email);
        System.out.println("-".repeat(100));
    }

}
