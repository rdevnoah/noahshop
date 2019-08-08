package com.cafe24.noahshop.frontend.vo;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.vo
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
public class ImageVo {
    private Long no;
    private String url;

    public ImageVo() {
    }

    public ImageVo(Long no, String url) {
        this.no = no;
        this.url = url;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImageVo{" +
                "no=" + no +
                ", url='" + url + '\'' +
                '}';
    }
}
