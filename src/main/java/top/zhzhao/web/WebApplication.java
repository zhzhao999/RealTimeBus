package top.zhzhao.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
//扫描dao接口的包用于识别mybatis
@MapperScan(basePackages="top.zhzhao.sbm.mapper.*.*Mapper")
public class WebApplication {

	public static void main(String[] args) {
//		SpringApplication.run(WebApplication.class, args);
		SpringApplication app = new SpringApplication(WebApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
