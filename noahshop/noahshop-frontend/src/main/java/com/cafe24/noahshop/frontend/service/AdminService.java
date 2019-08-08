package com.cafe24.noahshop.frontend.service;

import com.cafe24.noahshop.frontend.dto.JSONResult;
import com.cafe24.noahshop.frontend.dto.ProductAddDto;
import com.cafe24.noahshop.frontend.vo.ImageVo;
import com.cafe24.noahshop.frontend.vo.MemberVo;
import com.cafe24.noahshop.frontend.vo.ProductImageVo;
import com.cafe24.noahshop.frontend.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @author : rdevnoah
 * @version : 1.0
 * @title Cafe24 Personal-ShoppingMall
 * @packagename : com.cafe24.noahshop.frontend.service
 * @see <pre>
 *
 * == Modification Information ==
 *
 * Date             AUTHOR           NOTE
 * -------------    -------------    --------------------------------
 * 2019-08-08       rdevnoah         Initialize
 *
 * </pre>
 * @since : 2019-08-08
 */
@Service
public class AdminService {

    private String API_URL = "http://localhost:8888/noahshop/v1";
    @Autowired
    private OAuth2RestTemplate restTemplate;

    private static final String SAVE_PATH = "/Users/noah/noahshop-uploads";


    public List<ProductVo> getProductList() {
        JSONResultProductList response = restTemplate.getForObject(API_URL + "/api/admin/product/list", JSONResultProductList.class);
        return response.getData();
    }

    public List<MemberVo> getMemberList() {
        JSONResultMemberList response = restTemplate.getForObject(API_URL + "/api/admin/user/list", JSONResultMemberList.class);
        return response.getData();
    }

    public Map<String, Object> getAddProductForm() {
        JSONResultAddForm response = restTemplate.getForObject(API_URL + "/api/admin/product/addform", JSONResultAddForm.class);
        return response.getData();
    }

    public boolean addProductService(ProductAddDto dto) {
        MultipartFile multipartFile = dto.getMultipartFile();
        String originalFilename = multipartFile.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);
        String saveFileName = generateSaveFileName(extName);
        System.out.println("======================================================");

        try {
            byte[] fileDataBuffer;
            fileDataBuffer = multipartFile.getBytes();
            OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
            os.write(fileDataBuffer);
            os.close();
            List<ProductImageVo> imageList = new ArrayList<>();
            ProductImageVo image = new ProductImageVo();
            image.setUrl(saveFileName);
            imageList.add(image);
            dto.setImage(imageList);
            dto.setMultipartFile(null);

            HttpEntity<ProductAddDto> entity = new HttpEntity<>(dto);
            ResponseEntity<JSONResult> response = restTemplate.exchange(API_URL+"/api/admin/product", HttpMethod.PUT, entity, JSONResult.class);
            System.out.println(response.getBody());
        } catch (IOException e) {
            e.printStackTrace();
        }



        return true;
    }

    private String generateSaveFileName(String extName) {
        String fileName = "";
        Calendar calendar = Calendar.getInstance();

        fileName += calendar.get(Calendar.YEAR);
        fileName += calendar.get(Calendar.MONTH);
        fileName += calendar.get(Calendar.DATE);
        fileName += calendar.get(Calendar.DATE);
        fileName += calendar.get(Calendar.HOUR);
        fileName += calendar.get(Calendar.MINUTE);
        fileName += calendar.get(Calendar.SECOND);
        fileName += calendar.get(Calendar.MILLISECOND);
        fileName += ("." + extName);
        return fileName;

    }

    public static class JSONResultProductList extends JSONResult<List<ProductVo>>{}
    public static class JSONResultMemberList extends JSONResult<List<MemberVo>>{}
    public static class JSONResultAddForm extends JSONResult<Map<String, Object>>{}
}
