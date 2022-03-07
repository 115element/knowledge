package com.example.jpacollege.return_custom_entity.service;


import com.example.jpacollege.return_custom_entity.model.Other;
import com.example.jpacollege.return_custom_entity.model.Other1;
import com.example.jpacollege.return_custom_entity.repo.BandAndFlowRepo;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Jpa返回自定义对象，共5种方式
 */

@Slf4j
@Service
public class BandAndFlowService {

    @Autowired
    private BandAndFlowRepo bandAndFlowRepo;


    public void tt1(){
        val byCriteria = bandAndFlowRepo.findByCriteria1();
        for (Other byCriterion : byCriteria) {
            System.out.println(byCriterion.getTimestamp());
            System.out.println(byCriterion.getFlow());
            System.out.println(byCriterion.getBandWidth());
        }
        System.out.println(byCriteria);
    }

    public void tt2(){
        val byCriteria = bandAndFlowRepo.findByCriteria2();
        for (Other1 byCriterion : byCriteria) {
            System.out.println(byCriterion.getFlow());
            System.out.println(byCriterion.getBandWidth());
        }
        System.out.println(byCriteria);
    }


    public void tt3(){
        val byCriteria = bandAndFlowRepo.findByCriteria3();
        if (!CollectionUtils.isEmpty(byCriteria)) {
            System.out.println(byCriteria.get("flow"));
            System.out.println(byCriteria.get("timestamp"));
            System.out.println(byCriteria.get("bandwidth"));
        }
        System.out.println(byCriteria);
    }

    public void tt4(){
        val byCriteria = bandAndFlowRepo.findByCriteria4();
        if (!CollectionUtils.isEmpty(byCriteria)) {
            for (Object[] byCriterion : byCriteria) {
                System.out.println(byCriterion[0]);
                System.out.println(byCriterion[1]);
                System.out.println(byCriterion[2]);
            }
        }
        System.out.println(byCriteria);
    }



    public void tt5(){
        val byCriteria = bandAndFlowRepo.findByCriteria5();
        System.out.println(byCriteria);
    }


    public void tt6(){
        val byCriteria = bandAndFlowRepo.findByCriteria6();
        System.out.println(byCriteria);
    }
}
