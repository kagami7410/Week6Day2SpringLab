package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    ChocolateRepository chocolateRepository;
    @Autowired
    EstateRepository estateRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Estate estate1 = new Estate("Charlie_theGreat_Factory", "London");
        estateRepository.save(estate1);

        Chocolate chocolate1 = new Chocolate("Galaxy", 65,estate1);
        chocolateRepository.save(chocolate1);

        Chocolate chocolate2 = new Chocolate("MilkyBar", 1,estate1);
        chocolateRepository.save(chocolate2);

        Chocolate chocolate3 = new Chocolate("DairyMilk", 40,estate1);
        chocolateRepository.save(chocolate3);


    }
}
