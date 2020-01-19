package pl.edu.pjwstk.jazapp.webapp.auctiondb.category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryController {
    @Inject
    CategoryRequest categoryRequest;
    @Inject
    CategoryRepository categoryRepository;

    public void create() {
        categoryRepository.create(categoryRequest.getName(), categoryRequest.getSection_id());
    }

    public void edit() {
        categoryRepository.edit(categoryRequest.getId(), categoryRequest.getName(), categoryRequest.getSection_id());
    }
}
