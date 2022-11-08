package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.AbstractComponent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Getter(AccessLevel.PRIVATE)
public class TrainingDiaryFormComponent extends AbstractComponent {

    private TextField tfDate;
    private TextArea taSession;
    private TextArea taFeeling;

    private Button btnUpdate;
    private Button btnClose;

    private VerticalLayout formLayout;
    private HorizontalLayout buttonLayout;

    private VerticalLayout componentRootLayout;

    @Override
    protected Component getRootLayout() {
        return this.getComponentRootLayout();
    }

    @Override
    protected void initializeInternalState() {

    }

    @Override
    protected void initializeComponents() {

        this.initializeFormLayout();
        this.initializeButtonLayout();
        this.populateFormLayout();

    }

    private void initializeFormLayout(){

        this.formLayout = new VerticalLayout();

        this.tfDate = new TextField();
        this.tfDate.setLabel("Datum");

        this.taSession = new TextArea();
        this.taSession.setLabel("Einheit");
        this.taSession.setMaxHeight("150px");
        this.taSession.setHeight("150px");
        this.taSession.setWidth("480px");

        this.taFeeling = new TextArea();
        this.taFeeling.setLabel("Gefühlszustand");
        this.taFeeling.setMaxHeight("150px");
        this.taFeeling.setHeight("150px");
        this.taFeeling.setWidth("480px");

        this.getFormLayout().add(this.getTfDate());
        this.getFormLayout().add(this.getTaSession());
        this.getFormLayout().add(this.getTaFeeling());
        this.getFormLayout().setAlignSelf(FlexComponent.Alignment.START, this.getTfDate());
        this.getFormLayout().setAlignSelf(FlexComponent.Alignment.STRETCH, this.getTaSession());
        this.getFormLayout().setAlignSelf(FlexComponent.Alignment.STRETCH, this.getTaFeeling());

    }

    private void initializeButtonLayout(){

        this.buttonLayout = new HorizontalLayout();
        this.buttonLayout.setSizeFull();

        this.btnUpdate = new Button();
        this.btnUpdate.setText("Übernehmen");
        this.btnUpdate.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        this.btnUpdate.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        this.btnClose = new Button();
        this.btnClose.setText("Schließen");
        this.btnClose.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        this.btnClose.addThemeVariants(ButtonVariant.LUMO_ERROR);

        this.getButtonLayout().setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        this.getButtonLayout().add(this.getBtnUpdate());
        this.getButtonLayout().add(this.getBtnClose());
    }

    private void populateFormLayout(){

        this.componentRootLayout = new VerticalLayout();
        this.componentRootLayout.setWidth("35%");
        this.componentRootLayout.setHeightFull();
        this.getComponentRootLayout().add(this.getFormLayout());
        this.getComponentRootLayout().add(this.getButtonLayout());
        this.getComponentRootLayout().setVisible(false);


    }

    @Override
    protected void initializeComponentsActions() {

        this.getBtnClose().addClickListener(event -> {
            this.getTaSession().clear();
            this.getTaFeeling().clear();
            this.getTfDate().clear();

            this.getComponentRootLayout().setVisible(false);
        });

    }

    public void setTextArea(String session, String feeling) {

        this.getTaFeeling().setValue(feeling);
        this.getTaSession().setValue(session);

    }
}
