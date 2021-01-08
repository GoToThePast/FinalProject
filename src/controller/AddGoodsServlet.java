package controller;

import service.GoodsService;
import service.impl.GoodsServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.Goods;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.File;
import java.util.Iterator;
import java.util.List;



@WebServlet(name = "AddGoodsServlet",urlPatterns = "/AddGoods")
public class AddGoodsServlet extends HttpServlet {
    GoodsService goodsService = new GoodsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        Goods goods = getGoods(request);
        if (goods == null) {
            request.setAttribute("error", 1);
            request.getRequestDispatcher(request.getContextPath() + "/add_goods.jsp").forward(request, response);
        }
        goodsService.addGoods(goods);
        response.sendRedirect("goodsList");
    }

    static Goods getGoods(HttpServletRequest request) {
        boolean isMult = ServletFileUpload.isMultipartContent(request);
        int goodsID=0;
        String goodsName = "";
        String goodsType ="";
        int goodsPrice=0;
        int goodsStock=0;
        int goodsSellID=0;
        String goodsIntroduce = "";
        String goodsPicUrl ="";
        long goodspicId=System.currentTimeMillis();
        if(isMult){//是否为文件
            FileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
//            items接受所有
            try {
                List<FileItem> items = upload.parseRequest(request);
                //迭代器遍历item
                Iterator<FileItem> iter=items.iterator();
                while(iter.hasNext()){
                    FileItem item=iter.next();
                    String itemName=item.getFieldName();
                    if(item.isFormField()){//not picture
                        switch(itemName){
                            case "gid":
                                goodsID=Integer.parseInt(item.getString());
                                break;
                            case "gname":
                                goodsName=item.getString("UTF-8");
                                break;
                            case "gtype":
                                goodsType=item.getString("UTF-8");
                                break;
                            case "gprice":
                                goodsPrice=Integer.parseInt(item.getString());
                                break;
                            case "gstock":
                                goodsStock=Integer.parseInt(item.getString());
                                break;
                            case "gsellid":
                                goodsSellID=Integer.parseInt(item.getString());
                                break;
                            case "gintroduce":
                                goodsIntroduce=item.getString("UTF-8");
                                break;
                            default://??
                                break;
                        }
                    }else{//img pictuer ->file

                        String path[]=request.getSession().getServletContext().getRealPath("").split("out");
                        String fileName=item.getName();
                        File file = new File(path[0]+"web/photo/goods/",goodspicId+fileName.substring(fileName.lastIndexOf(".") ));
                        item.write(file);
                        goodsPicUrl+="/photo/goods/"+goodspicId+fileName.substring(fileName.lastIndexOf("."));
                    }
                }
            } catch (FileUploadException e) {
                //file upload error
                e.printStackTrace();
                System.out.println("file upload error");
            } catch (Exception e) {
                //file write Error
                e.printStackTrace();
                System.out.println("file write Error");
            }
        }
    Goods goods = new Goods(goodsID, goodsName, goodsType, goodsPrice, goodsStock,goodsSellID, goodsIntroduce,goodsPicUrl);
        return goods;
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
