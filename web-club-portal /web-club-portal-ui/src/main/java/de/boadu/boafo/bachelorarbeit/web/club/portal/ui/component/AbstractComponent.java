package de.boadu.boafo.bachelorarbeit.web.club.portal.ui.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;

@NoArgsConstructor
public abstract class AbstractComponent extends Composite<Component> {

    @Getter(AccessLevel.PRIVATE)
    private Component componentRootLayout;

    @PostConstruct
    public void initilalizeComponent(){
        this.initialize();
    }

    private void initialize() {

        this.initializeInternalState();
        this.initializeComponents();
        this.initializeComponentsActions();
        this.initializeRootLayout();

    }

    private void initializeRootLayout(){

        this.componentRootLayout = this.getRootLayout();

    }

    @Override
    protected Component initContent() {

        return this.getComponentRootLayout();

    }

    protected abstract Component getRootLayout();

    protected abstract void initializeInternalState();

    protected abstract void initializeComponents();

    protected abstract void initializeComponentsActions();



}