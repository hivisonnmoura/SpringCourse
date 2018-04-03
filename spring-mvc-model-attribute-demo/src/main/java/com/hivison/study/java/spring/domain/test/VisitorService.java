package com.hivison.study.java.spring.domain.test;

import org.springframework.stereotype.Service;

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
}
