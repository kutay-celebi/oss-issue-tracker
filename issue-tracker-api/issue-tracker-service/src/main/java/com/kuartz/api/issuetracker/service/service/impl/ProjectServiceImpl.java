package com.kuartz.api.issuetracker.service.service.impl;

import com.kuartz.api.issuetracker.service.service.ProjectService;
import com.kuartz.core.data.jpa.TransactionalRollback;
import com.kuartz.core.service.KuartzService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Kutay Çelebi
 * @since 27.06.2020
 */
@Service
@TransactionalRollback
@Transactional
public class ProjectServiceImpl extends KuartzService implements ProjectService {

}
