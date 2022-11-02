package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;
import de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary.DiaryTabContainerComponent;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Route(value = "Tagebuch")
@PageTitle("Tagebuch")
public class DiaryView extends Composite<Component> {

    private final DiaryTabContainerComponent diaryTabContainerComponent;

    private VerticalLayout componentRootLayout;

    @PostConstruct
    private void initialize(){
        this.setUpViewComponent();
    }

    private void setUpViewComponent(){

        this.componentRootLayout = new VerticalLayout();
        this.componentRootLayout.setSizeFull();
        this.getComponentRootLayout().add(this.getDiaryTabContainerComponent());

    }

    @Override
    protected Component initContent() {

        return this.getComponentRootLayout();

    }
}
