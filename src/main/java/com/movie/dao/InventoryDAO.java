package com.movie.dao;

import java.util.List;
import com.movie.utils.Helper;
import org.hibernate.query.Query;
import com.movie.entity.Inventory;

public class InventoryDAO extends AbstractHibernateDao<Inventory> {
    public InventoryDAO(){
        super(Inventory.class);
    }

    public Inventory getFree() {
        String hql =
            "SELECT DISTINCT i.* " +
            "FROM movie.inventory i " +
            "LEFT JOIN movie.rental r ON i.inventory_id = r.inventory_id " +
            "WHERE " +
            "    NOT EXISTS(SELECT * FROM movie.rental r WHERE r.inventory_id = i.inventory_id) " +
            "    OR " +
            "    NOT EXISTS(SELECT * FROM movie.rental r WHERE r.inventory_id = i.inventory_id AND r.return_date IS NULL)";


        Query<Inventory> query = getCurrentSession().createNativeQuery(hql, Inventory.class);
        List<Inventory> list = query.list();

        return list.size() > 0 ? list.get(Helper.getRandom(0, list.size())) : null;
    }
}
