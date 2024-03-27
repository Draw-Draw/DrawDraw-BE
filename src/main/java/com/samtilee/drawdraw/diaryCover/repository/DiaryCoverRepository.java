package com.samtilee.drawdraw.diaryCover.repository;

import com.samtilee.drawdraw.diaryCover.entity.CoverType;
import com.samtilee.drawdraw.diaryCover.entity.DiaryCover;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiaryCoverRepository extends JpaRepository<DiaryCover, Long> {
    Optional<DiaryCover> findByCoverType(CoverType coverType);
}
