package fr.cmm.controller;

import fr.cmm.controller.form.SearchForm;
import fr.cmm.domain.Recipe;
import fr.cmm.helper.Columns;
import fr.cmm.helper.PageQuery;
import fr.cmm.helper.Pagination;
import fr.cmm.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Iterator;
import java.util.List;

@Controller
public class ApiController {
    @Inject
    private RecipeService recipeService;

    @RequestMapping(value = "/api/recipes", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Iterable<Recipe> getRecettes() {
        PageQuery pageQuery = new PageQuery();
        return recipeService.findByQuery(pageQuery);
    }

    @RequestMapping(value = "/api/recipes/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Recipe getRecetteById(@PathVariable("id") String id, ModelMap model) {
        return recipeService.findById(id);
    }
}
