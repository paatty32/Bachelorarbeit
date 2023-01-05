package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.config.security.SecurityService;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.HeaderComponent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;

@UIScope
@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Route(value = "Gruppe", layout = HeaderComponent.class)
@PageTitle("Trainingsgruppe")
@PermitAll
public class TrainingGroupView extends Composite<Component> implements HasUrlParameter<Long> {

    private VerticalLayout componentRootLayout;

    private Long parameter;

    private final SecurityService securityService;


    /*Dann beim navigieren das*/
    @Override
    public void setParameter(BeforeEvent event, Long parameter) {

        this.getComponentRootLayout().add(new H2("Hallo " + this.getSecurityService().getLoggedUser().getName() + " " + this.getSecurityService().getLoggedUser().getSurname()));

        this.parameter = parameter;

    }

    /*Das kommt zuerst*/
    @PostConstruct
    private void initialize(){
        this.setUpViewComponent();
    }

    private void setUpViewComponent(){

        this.componentRootLayout = new VerticalLayout();
        this.componentRootLayout.setSizeFull();


    }


    @Override
    protected Component initContent() {

        return this.getComponentRootLayout();

    }
}
