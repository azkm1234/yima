package controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import conf.Const;
import model.Commentlist;
import serviceinterface.CommentListService;
import vo.SessionVo;

@RestController
@RequestMapping("/comment")
public class CommentController {
	@Resource(name = "commentListService")
	CommentListService commentListService;
	
	@RequestMapping("/add")
	public Object addComment(@Valid Commentlist comment, @Valid SessionVo session, BindingResult result) {
		this.commentListService.addComment(comment);
		return Const.OK;
	}
	
	@RequestMapping("/update")
	public Object updateComment(@Valid Commentlist comment, @Valid SessionVo session) {
		this.commentListService.updateComment(comment);
		return Const.OK;
	}
	
	@RequestMapping("/all")
	public Object getComment(@RequestParam Integer page) {
		HashMap<String, Object> map = new HashMap<>();
		List<Commentlist> list = this.commentListService.serarchComment(new Commentlist(), page, Const.PAGESIZE);
		map.put(Const.SIZE, list.size());
		map.put(Const.LIST, list);
		return map;
	}
	
}
