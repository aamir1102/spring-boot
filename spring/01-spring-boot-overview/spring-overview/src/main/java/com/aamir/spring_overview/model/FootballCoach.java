package com.aamir.spring_overview.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballCoach implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Practice dribbling for 20 minutes";
    }
}
