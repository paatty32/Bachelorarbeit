package de.boadu.boafo.bachelorarbeit.web.club.portal.service;

import com.vaadin.flow.spring.annotation.SpringComponent;
import de.boadu.boafo.bachelorarbeit.web.club.portal.dao.person.MutablePerson;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

@SpringComponent
@Getter(AccessLevel.PRIVATE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationScopeServiceImpl implements RegistrationUiService{

    private final ApplicationFacade applicationFacade;

    @Override
    public void createUser(MutablePerson createPerson, Set<String> clickedRoles) {

        this.getApplicationFacade().createUser(createPerson, clickedRoles);

    }
}
