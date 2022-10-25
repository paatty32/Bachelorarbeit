package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
@Getter
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HeaderComponent extends AbstractComponent implements RouterLayout {

    private MenuBar header;
    private Button btnGroups;
    private Button btnTrainingsDiary;
    private Button btnClubDatabase;

    private Icon tfLogo;

    private Icon userIcon;

    private HorizontalLayout componentRootLayout;

    @Override
    protected Component getRootLayout() {
        return this.getComponentRootLayout();
    }

    @Override
    protected void initializeInternalState() {

    }

    @Override
    protected void initializeComponents() {

        this.initializeMenuBarContent();

    }

    private void initializeMenuBarContent(){
        this.btnGroups = new Button();
        this.btnGroups.setText("Gruppen");

        this.btnTrainingsDiary = new Button();
        this.btnTrainingsDiary.setText("Trainingsgruppe");

        this.btnClubDatabase = new Button();
        this.btnClubDatabase.setText("Vereinsdatenbank");

        this.tfLogo = new Icon(VaadinIcon.ACADEMY_CAP);

        this.header = new MenuBar();
        this.header.addItem(this.getBtnGroups());
        this.header.addItem(this.getBtnTrainingsDiary());
        this.header.addItem(this.getBtnClubDatabase());

        this.userIcon = new Icon(VaadinIcon.USER);


        this.componentRootLayout = new HorizontalLayout();
        this.componentRootLayout.setWidthFull();
        this.getComponentRootLayout().add(this.getTfLogo());
        this.getComponentRootLayout().add(this.getHeader());
        this.getComponentRootLayout().add(this.getUserIcon());
        this.getComponentRootLayout().setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);


    }

    @Override
    protected void initializeComponentsActions() {

        userIcon.addClickListener(iconClickEvent -> System.out.println("Klick"));

    }
}
