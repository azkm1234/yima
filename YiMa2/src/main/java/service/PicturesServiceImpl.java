package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.PicturesMapper;
import model.Pictures;
import model.PicturesExample;
import model.PicturesExample.Criteria;
import serviceinterface.PictureService;

@Service(value = "picturesService")
public class PicturesServiceImpl implements PictureService {
	
	@Autowired
	PicturesMapper picturesMapper;
	@Override
	public void insertPicture(Pictures picures) {
		this.picturesMapper.insertSelective(picures);
	}

	@Override
	public void delelePicture(String tbname, Integer idhorseonsale) {
		PicturesExample example = new PicturesExample();
		Criteria c = example.createCriteria();
		if (tbname != null) {
			c.andTbnameEqualTo(tbname);
		}
		if(idhorseonsale != null) {
			c.andIdhorseonsaleEqualTo(idhorseonsale);
		}
		this.picturesMapper.deleteByExample(example);
	}

	@Override
	public List<String> selectPicture(String tbname, Integer idhorseonsale) {
		PicturesExample example = new PicturesExample();
		Criteria c = example.createCriteria();
		if (tbname != null) {
			c.andTbnameEqualTo(tbname);
		}
		if(idhorseonsale != null) {
			c.andIdhorseonsaleEqualTo(idhorseonsale);
		}
		List<Pictures> pictures = this.picturesMapper.selectByExample(example);
		List<String> r = new ArrayList<>();
		for (Pictures p : pictures) {
			r.add(p.getPicture());
		}
		return r;
	}

}
