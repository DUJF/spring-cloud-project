package com.github.common.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * <p>Description: [用户操作日志AOP]</p>
 */
@Component
@Aspect
//@Order(1)标记切面类的处理优先级,i值越小,优先级别越高.PS:可以注解类,也能注解到方法上
public class SystemLogsAop {


//    @Resource
//    private SysLogsMapper sysLogsMapper;

  /**
   * <p>Discription:[后置通知，扫描com.xiaojukeji包及此包下的所有带有SystemLogAnnotation注解的方法]</p>
   *
   * @param joinPoint 前置参数
   */
  @After(("execution(* com.github..*.*(..)) && @annotation(systemLogs)"))
  public void doAfterAdvice(JoinPoint joinPoint, SystemLogs systemLogs) {
    String module = systemLogs.module();
    String operation = systemLogs.operation();
    addSystemLog(module, operation);
  }

  /**
   * <p>Discription:[保存操作日志]</p>
   * Created on 2017年11月20日 下午3:07:33
   *
   * @param operationContent 操作内容
   * @author:[全冉]
   */
  public void addSystemLog(String operationModule, String operationContent) {


//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        UserInfo userInfo = null;//(UserInfo) request.getSession().getAttribute(SystemConstants.CURRENT_USER);
//        SysLogs sysLogs = new SysLogs();
//        sysLogs.setCreateTime(new Date());
//        if (null != userInfo) {
//            sysLogs.setUser(userInfo.getAccount());
//        } else {
//            sysLogs.setUser("admin");
//        }
//        sysLogs.setModule(operationModule);
//        sysLogs.setOperation(operationContent);
//        sysLogsMapper.insert(sysLogs);
  }
}