package com.example.demo.service;


import com.example.demo.jpa.entity.Banner;
import com.example.demo.jpa.repo.BannerRepository;
import com.example.demo.ruler.Rulered;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BannerService {

    private final BannerRepository bannerRepository;

    public Optional<Banner> getBanner() {
        log.info("为{}推荐Banner:", 456);
        return bannerRepository.findAll()
                .stream()
                .filter(Rulered::match)
                .max(Comparator.comparing(Banner::getPriority));//这一句相当于按照优先级排序
    }
}
