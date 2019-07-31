package com.cafe24.noahshop.repository;

import com.cafe24.noahshop.vo.CartVo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.repository
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-31       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-07-31
 */
@Repository
public interface CartRepository extends CrudRepository<CartVo, String> {
}
