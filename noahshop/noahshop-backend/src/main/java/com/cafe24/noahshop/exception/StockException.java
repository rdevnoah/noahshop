package com.cafe24.noahshop.exception;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.exception
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-07-30       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-07-30
 */
public class StockException extends Exception{
    public StockException(String message){
        super(message);
    }
}
