package com.jorge.application.views.usuarios;

import com.jorge.application.data.entity.Usuario;
import com.jorge.application.data.service.SamplePersonService;
import com.jorge.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudServiceDataProvider;

@PageTitle("Usuarios")
@Route(value = "usuarios", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class UsuariosView extends VerticalLayout {

	private  SamplePersonService samplePersonService;
	
    public UsuariosView(@Autowired  SamplePersonService samplePersonService) {
    	this.samplePersonService = samplePersonService;
        setSpacing(false);

       

        add(new H2("Usuarios"));
       
        Grid<Usuario> grid = new Grid<>(Usuario.class, false);
        
        grid.addColumn("firstName").setAutoWidth(true);
        grid.addColumn("lastName").setAutoWidth(true);
        grid.addColumn("email").setAutoWidth(true);
        grid.addColumn(u -> u.getPhonesStr().toString()).setAutoWidth(true).setHeader("Phones");

        grid.setItems(samplePersonService.getRepository().findAll());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        grid.setHeightFull();
        
        add (grid);
        
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
