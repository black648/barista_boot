package org.barista.framework.base;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseSpecs {
    public static List<Predicate> getPredicateWithKeyword(Map<String, Object> searchKeyword, Root<?> root, CriteriaBuilder builder) {
        List<Predicate> predicate = new ArrayList<>();
        for (String key : searchKeyword.keySet()) {
            switch (key) {
                case "title" :
                    predicate.add(builder.like(root.get(key), "%"+searchKeyword.get(key)+"%"));
                    break;

                default :
                    predicate.add(builder.equal(root.get(key), searchKeyword.get(key)));
                    break;

            }
        }
        return predicate;
    }
}
