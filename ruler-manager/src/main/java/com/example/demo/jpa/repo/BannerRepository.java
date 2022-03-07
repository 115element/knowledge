package com.example.demo.jpa.repo;

import com.example.demo.jpa.entity.Banner;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface BannerRepository extends JpaRepositoryImplementation<Banner, Long> {
}
