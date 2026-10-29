package com.egg.model;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "meetings")
public class Meeting {
    @Id
    private String meetingId;
    private String transactionId;
    private String location;
    private LocalDateTime dateTime;
    private String Status;

    public boolean scheduleMeeting(LocalDateTime time, String location){
        return false;
    }

    public boolean rescheduleMeeting(LocalDateTime newTime){
        return false;
    }

    public boolean cancelMeeting(){
        return false;
    }
}
