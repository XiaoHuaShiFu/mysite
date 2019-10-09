package top.xiaohuashifu.learn.jvm.controller;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import top.xiaohuashifu.learn.jvm.pojo.do0.UserDO;
import top.xiaohuashifu.learn.jvm.pojo.vo.UserVO;
import top.xiaohuashifu.learn.jvm.service.UserService;
import top.xiaohuashifu.learn.jvm.view.PdfExportService;
import top.xiaohuashifu.learn.jvm.view.PdfView;

import javax.servlet.http.Part;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-20 13:35
 */
@RestController
@RequestMapping("/users")
@SessionAttributes(types = Integer.class)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserVO post(@RequestBody UserVO userVO) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userVO, userDO);
        System.out.println(userVO);
        UserVO userVO1 = userService.saveUser(userVO);
        System.out.println(userVO1);
        return userVO1;
    }

    @DeleteMapping
    public Map<String, Object> delete(Integer id) {
        return userService.deleteUser(id);
    }

    @GetMapping
    public UserVO get(Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/rest")
    public UserVO postUser(UserVO userVO) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<UserVO> request = new HttpEntity<>(userVO, httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<UserVO> userVOResponseEntity = restTemplate.postForEntity(
//                "http://localhost:8080/users", request, UserVO.class);
        UserVO userVO1 = restTemplate.postForObject("http://localhost:8080/users", request, UserVO.class);
        System.out.println(userVO1);
        return userVO1;
    }

    @PostMapping("/batch")
    public Map<String, Integer> postBatch(Integer count) {
        List<UserVO> userVOList = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            UserVO userVO = new UserVO();
            userVO.setUsername("xhsf" + i);
            userVOList.add(i, userVO);
        }
        Map<String, Integer> result = new HashMap<>(3);
        result.put("count", userService.saveUsers(userVOList));

        return result;
    }

    @PostMapping("/upload/part")
    @ResponseBody
    public Map<String, Object> uploadPart(Part file) {
        String fileName = file.getSubmittedFileName();
        try {
            file.write(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "上传成功");
        return map;
    }

    @GetMapping("/model")
    public String useModel(Integer id, Model model) {
        model.addAttribute("id", "hahahhaha");
        System.out.println(model);
        return model.toString();
    }

    @GetMapping("/export/pdf")
    public ModelAndView exportPdf(String username) {
        List<UserVO> userList = userService.listUsers(username);
        View view = new PdfView(exportService());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(view);
        modelAndView.addObject("userList", userList);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        return modelAndView;
    }

    private PdfExportService exportService() {
        return ((model, document, writer, request, response) -> {
            try {
                document.setPageSize(PageSize.A4);
                document.addTitle("用户信息");
                document.add(new Chunk("\n"));

                PdfPTable table = new PdfPTable(3);

                Font f8 = new Font();
                f8.setColor(Color.BLUE);
                f8.setStyle(Font.BOLD);

                PdfPCell cell = new PdfPCell(new Paragraph("id", f8));
                cell.setHorizontalAlignment(1);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph("user_name", f8));
                cell.setHorizontalAlignment(1);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph("gender", f8));
                cell.setHorizontalAlignment(1);
                table.addCell(cell);

                List<UserVO> userVOList = (List<UserVO>) model.get("userList");
                for (UserVO userVO : userVOList) {
                    document.add(new Chunk("\n"));

                    cell = new PdfPCell(new Paragraph(userVO.getId().toString()));
                    table.addCell(cell);

                    cell = new PdfPCell(new Paragraph(userVO.getUsername()));
                    table.addCell(cell);

                }
                document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });
    }


}
