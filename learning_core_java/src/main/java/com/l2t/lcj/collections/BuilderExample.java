package com.l2t.lcj.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
class Appointment{
    private String name;
    private String location;
    private String drName;
    private String date;
    private String time;
}

public class BuilderExample {

    public static void main(String[] args) {

            Appointment appointment = Appointment
                    .builder()
                    .drName("Ragu")
                    .name("Charan")
                    .date("2026-01-26")
                    .time("10:30")
                    .location("BTM")
                    .build();
    }
}
