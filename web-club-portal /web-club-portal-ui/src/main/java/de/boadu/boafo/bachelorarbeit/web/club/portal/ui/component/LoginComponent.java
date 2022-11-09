package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginComponent extends AbstractComponent {

    private VerticalLayout componentRootLayout;

    private LoginForm loginForm;

    private Button btnSignIn;

    @Override
    protected Component getRootLayout() {
        return this.getComponentRootLayout();
    }

    @Override
    protected void initializeInternalState() {

    }

    @Override
    protected void initializeComponents() {

        this.initializeComponentRootLayout();

    }

    private void initializeComponentRootLayout(){

        H1 clubPortal = new H1("Vereinsportal");

        this.loginForm = new LoginForm();

        this.btnSignIn = new Button();
        this.btnSignIn.setText("Anmelden");

        this.componentRootLayout = new VerticalLayout();
        this.componentRootLayout.setSizeFull();

        this.getComponentRootLayout().add(clubPortal);
        this.getComponentRootLayout().add(this.getLoginForm());
        this.getComponentRootLayout().add(this.getBtnSignIn());
        this.getComponentRootLayout().setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        this.getComponentRootLayout().setAlignItems(FlexComponent.Alignment.CENTER);

    }

    @Override
    protected void initializeComponentsActions() {

        this.getLoginForm().setAction("login");

    }
}
