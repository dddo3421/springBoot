package com.spring_boot_mybatis.project;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//스프링부트 애플리케이션을 web.xml없이 톰캣을통해 실행하게 해줌
//root_context.xml등의 설정을 자동으로 진행하거나 지정되어 있는 파일을 통해서 변경
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootMybatisApplication.class);
	}

}
