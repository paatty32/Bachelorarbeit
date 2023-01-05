package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.group;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
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
public class TrainingGroupContainerComponent extends AbstractComponent  {

    private VerticalLayout componentRootLayout;

    private TabSheet groupTabSheet;

    @Override
    protected Component getRootLayout() {
        return this.getComponentRootLayout();
    }

    @Override
    protected void initializeInternalState() {

    }

    @Override
    protected void initializeComponents() {

    }

    @Override
    protected void initializeComponentsActions() {

    }
}
