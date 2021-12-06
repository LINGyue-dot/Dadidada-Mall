package com.jc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jc.entity.pojo.Courtreserve;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourtReserveMapper extends BaseMapper<Courtreserve> {

    List<Courtreserve> selectByCourtId(Integer courtId);

}
