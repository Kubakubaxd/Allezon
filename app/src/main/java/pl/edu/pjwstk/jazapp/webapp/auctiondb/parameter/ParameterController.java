package pl.edu.pjwstk.jazapp.webapp.auctiondb.parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ParameterController {
    @Inject
    ParameterRequest parameterRequest;
    @Inject
    ParameterRepository parameterRepository;

    public void create() {
        parameterRepository.create(parameterRequest.getName());
    }
    public void edit() {
        parameterRepository.edit(parameterRequest.getId(), parameterRequest.getName());
    }
}
