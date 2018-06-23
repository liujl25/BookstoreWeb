package com.lingshi.bookstore.view;

import com.google.gson.Gson;
import com.lingshi.bookstore.bean.Book;
import com.lingshi.bookstore.bean.Category;
import com.lingshi.bookstore.bean.Pager;
import com.lingshi.bookstore.service.IBookService;
import com.lingshi.bookstore.service.ICategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName BookController
 * @Description
 * @Auther 暴走D红领巾
 * @Date 2018/6/17 18:34
 * @Version 1.0
 */

@Controller
@RequestMapping("/book")
public class BookController {
    private Logger logger = Logger.getRootLogger();
    //在控制层整合或调用业务逻辑层
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;

/*    @RequestMapping("/list")
    public String listBook(Model model,Pager<Book> pager,Book book) {//Model 是spring mvc封装的数据模型，用于在mvc各组件中传递数据，类似于HttpSevletRequest对象
//        Pager<Book> pager = new Pager();
    	pager.setParam(book);
        int total = this.bookService.countForPager(pager);
        pager.setTotal(total);
//        logger.info("total:"+total);
        List<Book> list = bookService.findByPager(pager);
        pager.setResults(list);
//		for (Book book : list) {
//			logger.info(book);}
        model.addAttribute("pager",pager);//类似于于request.setAttribute
        return "bookList";//返回值时页面的名称
    }*/
    @RequestMapping("/toAdd")
     public ModelAndView toAdd(){
        //查询书籍分类信息，并传递到页面显示
        List<Category> list = this.categoryService.findAll();
        ModelAndView view = new ModelAndView("addBook");
        //view.addObject("categoryList", list);
        view.getModel().put("categoryList", list);
        return view;
    }
    @RequestMapping("/doAdd")
    public String addBook(HttpServletRequest request, @Validated Book book, BindingResult vResult,
                          Model model, MultipartFile imgfile) throws IOException {
        //（网页）客户端提交数据到spring mvc后，会先进行数据的封装与转换，数据校验；完成后再进入控制器内进行处理
    	//注意：BindingResult必须要跟在被校验的数据后面
    	//可以使用校验框架进行数据的集中校验，并获取校验结果；根据校验的结果进行跳转控制
    	if(vResult.hasErrors()) {
    		//去除所有的校验错误或字段错误
    		List<ObjectError> errors = vResult.getAllErrors();
    		for (ObjectError objectError : errors) {
				logger.debug("args:"+objectError.getArguments()+",code:"+objectError.getCode()+",codes:"+objectError.getCodes()+
				        ",onjname:"+objectError.getObjectName()+",msg:"+objectError.getDefaultMessage());
			}
    		//把异常信息传回页面进行显示- 	
    		model.addAttribute("errors", errors);//使用request作用于传回页面
    		return "forward:toAdd.action";
    	}
    	//通过表单验证后，执行文件上传
        //如果文件不为空，写入文件路径
        if(!imgfile.isEmpty()){
    	    //上传路径
            String path = request.getServletContext().getRealPath("/upload");
            //上传文件名
            String filename = imgfile.getOriginalFilename();
            String filetxt = filename.substring(filename.lastIndexOf("."));
            String uuid = UUID.randomUUID().toString();//随机UUID文件名

            String newFile = uuid+filetxt;
            File filepath = new File(path,filename);
            //判断 路径是否存在，不存在就创建一个
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            imgfile.transferTo(new File(path+File.separator+newFile));
            logger.info("路径："+path+File.separator+newFile);
            //上传成功，保存上传后的路径到book对象中，在保存到数据库中
            book.setBookImage("upload/"+newFile);

    	}

    	/*boolean r = new Random().nextInt(10)%2==0?true:false;
    	if(r)
    		throw new NullPointerException("模拟空指针异常");*/
    	
    	boolean result = this.bookService.addBook(book);
        model.addAttribute("result", result);
        if (result)
//            return "redirect:list.action";
        {
        	model.addAttribute("url", "book/list.action");
        }
        else
//            return "redirect:toAdd.action";
        {
        	model.addAttribute("url", "book/toAdd.action");
        }
        return "result";
    }

    @RequestMapping("/delete")
    public String deleteBook(String isbn,Model model){
        boolean result = this.bookService.deleteBookById(isbn);
//        if(result)
//            return "redirect:list.action";
//        else
//            return "";
        model.addAttribute("result", result);
        model.addAttribute("url", "book/list.action");
        return "result";
        
    }

    @RequestMapping("/list")
    public ModelAndView search(Book book,Pager<Book> pager){
        ModelAndView view = new ModelAndView("bookList");
//        Pager<Book> pager = new Pager();
        pager.setParam(book);
        int total = this.bookService.countForPager(pager);
        pager.setTotal(total);
        List<Book> list = bookService.findByPager(pager);
        pager.setResults(list);
//      List<Book> list = this.bookService.findBookByExample(book);
        view.addObject("book",book);//回显查询条件
        view.addObject("pager",pager);
        return view;
    }
    @RequestMapping("/toedit")
    public ModelAndView toEdit(String isbn){
        Book book = this.bookService.findBookById(isbn);
        //查询书籍分类信息，并传递到页面显示
        List<Category> list = this.categoryService.findAll();
        ModelAndView view = new ModelAndView("editBook");
        view.addObject("book",book);
        view.getModel().put("categoryList", list);
        return view;
    }
    @RequestMapping("/doedit")
    public String doEdit(Book book,Model model){
    	logger.info("isbn:"+book.getIsbn());
        boolean result = this.bookService.editBook(book);
        if (result)
            model.addAttribute("url", "book/list.action");
//            return "redirect:list.action";
        else
            model.addAttribute("url", "book/toedit.action?isbn="+book.getIsbn());
//            return "redirect:toedit.action?isbn="+book.getIsbn();
        model.addAttribute("result", result);
        return "result";
    }
    @RequestMapping("/findIsbn")	
    @ResponseBody
    public String search(String isbn) {
    	logger.info("======  "+isbn);
    	Book book = this.bookService.findBookById(isbn);

    	if(book != null)
    		return "{\"result\":true}";
    	else
    		return "{\"result\":false}";
//    	new Gson().toJson();
    }
}
