package com.lqb.ss.MyShardingSphere;

//import com.alibaba.nacos.api.annotation.NacosInjected;
//import com.alibaba.nacos.api.naming.NamingService;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyShardingSphereApplication  {

//	@NacosInjected
//	private NamingService namingService;
//
//	@Value("${spring.application.name}")
//	private String applicationName;
//
//	@Value("${server.port}")
//	private Integer serverPort;


	public static void main(String[] args) {
		SpringApplication.run(MyShardingSphereApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// 通过Naming服务注册实例到注册中心
//		namingService.registerInstance(applicationName, "127.0.0.1", serverPort);
//	}
}
