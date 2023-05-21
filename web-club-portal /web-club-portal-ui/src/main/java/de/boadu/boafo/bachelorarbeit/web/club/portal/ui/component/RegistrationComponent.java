package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.appuser.MutableAppUser;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.appuser.AppUserDTO;
import de.boadu.boafo.bachelorarbeit.web.club.portal.service.RegistrationUiService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;


@SpringComponent
@UIScope
@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RegistrationComponent extends AbstractComponent{

    private VerticalLayout componentRootLayout;

    private VerticalLayout registrationFormLayout;

    private HorizontalLayout buttonLayout;

    private TextField tfSurname;
    private TextField tfName;

    private PasswordField tfPassword;

    private CheckboxGroup<String> roles;

    private Button btnSubmit;
    private Button btnCancel;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RegistrationUiService registrationUiService;

    @Override
    protected Component getRootLayout() {
        return this.getComponentRootLayout();
    }

    @Override
    protected void initializeInternalState() {

    }

    @Override
    protected void initializeComponents() {

        this.iniatializeButtonLayout();
        this.initalizeRegistrationFormLayout();
        this.initalizeComponentRootLayout();

    }

    private void iniatializeButtonLayout(){

        this.buttonLayout = new HorizontalLayout();

        this.btnSubmit = new Button();
        this.btnSubmit.setText("Erstellen");
        this.btnSubmit.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        this.btnSubmit.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        this.btnCancel = new Button();
        this.btnCancel.setText("Abbrechen");
        this.btnCancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
        this.btnCancel.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        this.getButtonLayout().add(this.getBtnSubmit());
        this.getButtonLayout().add(this.getBtnCancel());

    }

    private void initalizeRegistrationFormLayout(){

        this.registrationFormLayout = new VerticalLayout();

        H1 registrierenHeadline = new H1("Registrieren");

        this.tfSurname = new TextField();
        this.tfSurname.setLabel("Vorname");

        this.tfName = new TextField();
        this.tfName.setLabel("Nachname");

        this.tfPassword = new PasswordField();
        this.tfPassword.setLabel("Passwort");
        this.tfPassword.setRevealButtonVisible(true);

        this.roles = new CheckboxGroup<>();
        this.roles.setLabel("Rolle");

        this.getRoles().setItems("Athlet", "Trainer", "Eltern");

        this.getRegistrationFormLayout().add(registrierenHeadline);
        this.getRegistrationFormLayout().add(this.getTfSurname());
        this.getRegistrationFormLayout().add(this.getTfName());
        this.getRegistrationFormLayout().add(this.getTfPassword());
        this.getRegistrationFormLayout().add(this.getRoles());
        this.getRegistrationFormLayout().add(this.getButtonLayout());
        this.getRegistrationFormLayout().setAlignItems(FlexComponent.Alignment.CENTER); //Für x achse bei einem vertikalLayout
        this.getRegistrationFormLayout().setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER); //Für die y achse bei einem vertikallayout

    }

    private void initalizeComponentRootLayout(){

        this.componentRootLayout = new VerticalLayout();
        this.componentRootLayout.setSizeFull();

        this.getComponentRootLayout().add(this.getRegistrationFormLayout());

    }

    @Override
    protected void initializeComponentsActions() {

        this.getBtnSubmit().addClickListener(event -> {

            String surname = this.getTfSurname().getValue();

            String name = this.getTfName().getValue();

            String password = this.getTfPassword().getValue();
            String encodePassword = this.getBCryptPasswordEncoder().encode(password);

            Set<String> clickedRoles = this.getRoles().getValue();

            MutableAppUser createPerson = new AppUserDTO();
            createPerson.setName(name);
            createPerson.setSurname(surname);
            createPerson.setPassword(encodePassword);


            this.getRegistrationUiService().createUser(createPerson, clickedRoles);

            this.navigateTo(LoginComponent.class);


        });

        this.getBtnCancel().addClickListener(doOnClickCancel());


    }

    private ComponentEventListener<ClickEvent<Button>> doOnClickCancel() {
        return event -> {

            this.navigateTo(LoginComponent.class);

        };
    }
}
