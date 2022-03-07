package com.example.jpacollege;


import com.example.jpacollege.return_custom_entity.service.BandAndFlowService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaReturnCustomEntityTest {

    @Autowired
    private BandAndFlowService bandAndFlowService;


    @Test
    public void t1(){
        bandAndFlowService.tt1();
    }

    @Test
    public void t2(){
        bandAndFlowService.tt2();
    }

    @Test
    public void t3(){
        bandAndFlowService.tt3();
    }

    @Test
    public void t4(){
        bandAndFlowService.tt4();
    }

    @Test
    public void t5(){
        bandAndFlowService.tt5();
    }

    @Test
    public void t6(){
        bandAndFlowService.tt6();
    }
}
