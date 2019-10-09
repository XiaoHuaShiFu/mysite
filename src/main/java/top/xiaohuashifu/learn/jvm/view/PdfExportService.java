package top.xiaohuashifu.learn.jvm.view;


import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 描述:
 *
 * @author xhsf
 * @email 827032783@qq.com
 * @create 2019-09-27 13:03
 */
public interface PdfExportService {

    public void make(Map<String, Object> model, Document document, PdfWriter writer,
                     HttpServletRequest request, HttpServletResponse response);
}
