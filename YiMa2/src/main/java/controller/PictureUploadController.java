package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import conf.Const;
import model.HorseOnSale;
import model.Pictures;
import model.User;
import net.coobird.thumbnailator.Thumbnails;
import serviceinterface.HorseOnSaleService;
import serviceinterface.PictureService;
import serviceinterface.UserService;
import util.RandomUtil;

@RestController
@RequestMapping("/picture")
public class PictureUploadController {
	@Value("${basePath}")
	private String basePath;
	@Value("${imagePath}")
	private String imagePath;
	@Value("${projectName}")
	private String projectName;
	@Value("${port}")
	private String port;
	@Resource(name = "picturesService")
	PictureService pictureService;
	@Resource(name = "userService")
	private UserService userService;
	@Resource (name = "horseOnSaleService")
	HorseOnSaleService horseOnSaleService;
	private static final Logger logger = LoggerFactory.getLogger(PictureUploadController.class);
	
	@RequestMapping(value = "/upload")  
    public Object upload(@RequestParam(value = "file", required = false) MultipartFile file, 
    		@RequestParam(value = "type", defaultValue = "horse")String uploadtype,
    		String idOrName,
    		@RequestParam(value = "tbName", defaultValue = "horseOnSale")String tbName,
    		HttpServletRequest request, 
    		ModelMap model) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		logger.info("PictureUploadController   {}", "开始上传图片");
        String path = "/usr/local/tomcats/upload";
        String fileName = getFileName();
        
        File targetFile = new File(path, fileName);  
        if (!targetFile.getParentFile().exists()) {
        	targetFile.getParentFile().mkdirs();
        }
        Thumbnails.of(file.getInputStream()).size(200, 150).outputFormat("png").toFile(targetFile);
        String filepath = basePath + ":" + port + "/" + imagePath + "/" + targetFile.getName() + ".png";
        //将上传的图片同步到数据库连接
        picUrlToDb(uploadtype, idOrName, filepath, tbName);
        map.put("path", filepath);
        logger.info("PictureUploadController  file:path = {}", filepath);
        return map; 
    }
	
	private String getFileName() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(RandomUtil.getRandomString(5)).append(System.currentTimeMillis());
		return buffer.toString();
	}
	
	private void picUrlToDb(String type, String idOrName, String path, String tbname) throws Exception {
		if (type.equals("person") && idOrName != null) {
			User user = new User();
			user.setUsername(idOrName);
			user.setHeadimage(path);
			this.userService.updateByUserName(user);
		} else if (type.equals("horse") && idOrName != null) {
			 HorseOnSale horseOnSale = new HorseOnSale();
	         horseOnSale.setId(Integer.parseInt(idOrName));
	         horseOnSale.setPicture(path);
	         this.horseOnSaleService.updateSaleHorseByIdSelective(horseOnSale);
		} else if (type.equals("picture")) {
			Pictures picures = new Pictures();
			picures.setPicture(path);
			picures.setTbname(tbname); 
			picures.setIdhorseonsale(Integer.parseInt(idOrName));
			this.pictureService.insertPicture(picures);
		}
	}
	
	@RequestMapping(value = "/getPictures")
	public Object getPictures(@RequestParam(value = "tbName", defaultValue = "horseOnSale")String tbname,
			Integer id) {
		HashMap<String, Object> map = new HashMap<>();
		List<String> list = this.pictureService.selectPicture(tbname, id);
		map.put(Const.SIZE, list.size());
		map.put(Const.LIST, list);
		return map;
	}
}
