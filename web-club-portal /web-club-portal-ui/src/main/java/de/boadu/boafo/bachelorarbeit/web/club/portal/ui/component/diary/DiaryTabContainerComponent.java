package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component.diary;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;
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
public class DiaryTabContainerComponent extends AbstractComponent {

    private VerticalLayout rootLayout;

    private Tabs diaryTab;

    @Override
    protected Component getRootLayout() {
        return this.getRootLayout();
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
