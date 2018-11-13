package com.github.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mapper.SysLogsMapper;
import com.github.model.po.SysLogs;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dujf
 * @since 2018-11-08
 */
@Service
public class SysLogsServiceImpl extends ServiceImpl<SysLogsMapper, SysLogs> implements SysLogsService {

}
