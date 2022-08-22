package com.mycompany.warehouse.repository;

import com.mycompany.warehouse.model.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.search.mapper.orm.Search;

@RequiredArgsConstructor
public class SearchRepositoryImpl implements SearchRepository {

    @NotNull
    private final EntityManager em;

    /**
     * search method returns list of the products which is associated with the search term.
     * @param searchTerm search keyword
     * @param offset page offset
     * @param limit page limit
     * @return List Product list of products associated with the given search term
     */
    @Override
    public List<Product> search(String searchTerm, Integer limit, Integer offset) {
        return Search.session(em).search(Product.class)
            .where(f -> f.match()
                .fields("name", "description")
                .matching(searchTerm))
            .sort(f -> f.field("name").asc())
            .fetchHits(offset, limit);
    }
}
