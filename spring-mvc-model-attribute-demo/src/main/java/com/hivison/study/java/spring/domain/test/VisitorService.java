package com.hivison.study.java.spring.domain.test;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VisitorService {

    public VisitorCount updateCount(VisitorCount visitorCount){
        visitorCount.setCount(visitorCount.getCount() + 1);

        return visitorCount;
    }

    public void registerVisitor(VisitorData sessionData, VisitorData incomingVisitor){
        List<Visitor> visitors = sessionData.getVisitors();
        sessionData.setCurrentVisitorName(incomingVisitor.getCurrentVisitorName());
        sessionData.setCurrentVisitorEmail(incomingVisitor.getCurrentVisitorEmail());
        visitors.add(new Visitor(incomingVisitor.getCurrentVisitorName(), incomingVisitor.getCurrentVisitorEmail()));
    }

    public Long computeDuration(LocalDateTime sessionStartTime){
        Duration sessionDuration = Duration.between(sessionStartTime, LocalDateTime.now());
        return sessionDuration.getSeconds();
    }

    public String describeCurrentTime(LocalDateTime currentTime){
        return new StringBuilder().append("current local time is : ")
                .append(currentTime.getHour())
                .append(":")
                .append(currentTime.getMinute())
                .append(":")
                .append(currentTime.getSecond()).toString();
    }

    public String describeCurrentDuration(Long currentDuration){
        long seconds = Long.valueOf(currentDuration);
        return new StringBuilder().append("Session duration is : ")
                .append(seconds)
                .append(" seconds !")
                .toString();
    }
}
