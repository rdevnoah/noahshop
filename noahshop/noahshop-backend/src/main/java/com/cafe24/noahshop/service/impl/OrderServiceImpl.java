package com.cafe24.noahshop.service.impl;

import com.cafe24.noahshop.dto.OrderDto;
import com.cafe24.noahshop.dto.ProductDto;
import com.cafe24.noahshop.repository.*;
import com.cafe24.noahshop.service.OrderService;
import com.cafe24.noahshop.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StockDao stockDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    @Override
    public OrderVo addOrder(OrderVo vo) {

        // 재고 확인을 통해 재고에서 구매량 뺀 값이 0보다 작으면 return error. (throw transaction?)

        //todo: code Generate

        vo.setOrderCode(orderCodeGenerator(vo.getBuyerTel()));
        //1. order 테이블 insert
        vo = orderDao.addOrder(vo);

        //2. order_product 테이블 insert
        vo = orderDao.addOrderProduct(vo);

        //3. delivery 테이블 insert
        DeliveryVo deliveryVo = new DeliveryVo();
        deliveryVo.setNo(vo.getNo());
        deliveryVo.setName(vo.getBuyerName());
        deliveryVo.setAddress(vo.getAddress());
        deliveryVo.setMessage(vo.getMessage());
        deliveryVo.setStatus("배송준비중");
        deliveryVo.setTel(vo.getBuyerTel());

        deliveryVo = orderDao.addDelivery(deliveryVo);

        stockDao.updateStock(vo);

        // 장바구니에서 제거
        // 먼저 기존 장바구니에서 cartInfo 가져오고

        Optional<CartVo> cartInfo = cartRepository.findById(vo.getMemberNo().toString());
        String info = cartInfo.orElse(new CartVo()).getProductInfo();



        // 문자열 자른 뒤, 0:0/ 포함되어있으면 그거 ""로 바꾸고 다시 add 해준다.
        CartVo cartVo = new CartVo();
        cartVo.setMemberNo(vo.getMemberNo());
        String orderStr = "";


        for (OrderProductVo ovo : vo.getOrderProductList()){
            String no = ovo.getProductDetailNo().toString();
            int quantity = ovo.getQuantity();
            String oneCart = no + ":" + quantity + "/";
            if (info.contains(oneCart)){
                System.out.println("contains!");
                info = info.replaceFirst(oneCart, "");
            }
        }




        cartVo.setProductInfo(info);
        cartRepository.save(cartVo);

        return vo;
    }


    @Override
    public String orderCodeGenerator(String tel) {
        String result = "GeneratedCode";
        return result;
    }

    @Override
    public Map<String, Object> getOrderForm(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        String key = memberDao.getKeyByNo((Long)params.get("memberNo"));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("no", (Long)params.get("memberNo"));
        map.put("key", key);
        MemberVo vo = memberDao.getMemberByNo(map);
        result.put("memberInfo", vo);

        List<ProductDto> productList = productDao.getProductListByOrderDtoList((List<OrderDto>) params.get("cartList"));
        result.put("productList", productList);
        int cost = 0;
        for (ProductDto pvo : productList){
            cost += pvo.getPrice() * pvo.getStock();
        }
        result.put("totalPrice", cost);

        return result;
    }
}
