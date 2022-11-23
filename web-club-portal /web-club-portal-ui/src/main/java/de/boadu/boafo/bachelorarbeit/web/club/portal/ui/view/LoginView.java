package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.LoginComponent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
@UIScope
@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@Route("Loooogin")
@PageTitle("login")
//@AnonymousAllowed
public class LoginView extends Composite<Component> {

    private final LoginComponent loginComponent;

    //private VerticalLayout componentRootLayout;

    @PostConstruct
    private void initialize(){
        this.setUpViewComponent();
    }

    private void setUpViewComponent(){

       // this.componentRootLayout = new VerticalLayout();
       // this.componentRootLayout.setSizeFull();
      //  this.getComponentRootLayout().add(this.getLoginComponent());

    }

    @Override
    protected Component initContent() {

       //return this.getComponentRootLayout();

        return this.getLoginComponent();
    }


}


/*
@Route("login")
@PageTitle("Login | Vaadin CRM")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
    private final LoginForm login = new LoginForm();
    public LoginView(){
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        login.setAction("login");
       // Button anmelden = new Button("Anmelden", buttonClickEvent -> System.out.println("Klick"));
        add(new H1("Club-Portal1"), login);
    }
    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
// inform the user about an authentication error
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}

 */
