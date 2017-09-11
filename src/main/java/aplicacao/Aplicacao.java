package aplicacao;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

public class Aplicacao implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation("aplicacao.configuracoes");
//		AnnotationConfigWebApplicationContext applicationContext = buildApplicationContext();
//		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(applicationContext));
//		appServlet.setLoadOnStartup(1);
//		appServlet.addMapping("/api/*", "/app/*");
//		
//		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet(applicationContext);
//		messageDispatcherServlet.setTransformWsdlLocations(true);
		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(webApplicationContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/app/*");
		System.out.println("Construiu AppSerlet");
		
		servletContext.addListener(new  ContextLoaderListener(webApplicationContext));
		
	}

	

}






























