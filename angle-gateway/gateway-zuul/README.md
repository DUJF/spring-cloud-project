#spring-cloud-zuul网关

Spring Cloud Zuul路由是微服务架构的不可或缺的一部分，提供动态路由，监控，弹性，安全等的边缘服务以及鉴权、流量转发、请求统计等等都可以使用Zuul来实现。Zuul是Netflix出品的一个基于JVM路由和服务端的负载均衡器。

##为什么需要API Gateway？



##Zuul的核心
Filter是Zuul的核心，用来实现对外服务的控制。Filter的生命周期有4个，分别是“PRE”、“ROUTING”、“POST”、“ERROR”，整个生命周期可以用下图来表示。


路由熔断、路由重试
