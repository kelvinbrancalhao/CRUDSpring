package aplicacao.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {

	public FornecedorController(){
		System.out.println("Controlador Criado !!!");
	}
	
	@RequestMapping("/ola/{nome}")
	@ResponseBody
	public String ola(@PathVariable String nome) {
		return "ola" + nome ;
	}
	


	public void configureViewResolvers(ViewResolverRegistry registry) {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		registry.viewResolver(viewResolver);
	}
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("cliente/index");
		registry.addViewController("/login").setViewName("cliente/login");
	}
}
	 