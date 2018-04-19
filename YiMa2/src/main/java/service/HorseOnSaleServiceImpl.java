package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;

import conf.Const;
import domain.HorseOnSaleMapper;
import domain.SearchHorseOption;
import domain.SqlVo;
import model.HorseOnSale;
import model.HorseOnSaleExample;
import model.HorseOptions;
import model.HorseOnSaleExample.Criteria;
import serviceinterface.HorseOnSaleService;
import serviceinterface.ThreeHorseService;
import util.Utils;
@Service(value = "horseOnSaleService")
public class HorseOnSaleServiceImpl implements HorseOnSaleService{
	@Resource(name = "horseOnSaleMapper")
	HorseOnSaleMapper horseOnSaleMapper;
	@Resource(name = "threeHorseService")
	ThreeHorseService threeHorseService;
	
	@Override
	public boolean addOnSaleHorse(HorseOnSale horseOnSale) {
		try {
			this.horseOnSaleMapper.insertSelective(horseOnSale);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteHorseOnSaleById(int horseId) {
		try {
			this.threeHorseService.deleteAuctionHorse(horseId);
			this.threeHorseService.deleteFineHorse(horseId);
			this.threeHorseService.deleteRecommendHorse(horseId);
			this.horseOnSaleMapper.deleteByPrimaryKey(horseId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateSaleHorseById(HorseOnSale horseOnSale) {
		try {
			this.horseOnSaleMapper.updateByPrimaryKey(horseOnSale);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean updateSaleHorseByIdSelective(HorseOnSale horseOnSale) {
		try {
			this.horseOnSaleMapper.updateByPrimaryKeySelective(horseOnSale);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	@Override
	public List<HorseOnSale> selectHorseOnSaleByOption(HorseOptions h, int currentPage) {
		PageHelper.startPage(currentPage, Const.PAGESIZE);
		HorseOnSaleExample example = new HorseOnSaleExample();
		Criteria c = example.createCriteria();
		if (!StringUtils.isEmpty(h.getSex())) {
			c.andSexEqualTo(h.getSex());
		}
		if (!StringUtils.isEmpty(h.getBreed())) {
			c.andParentsEqualTo(h.getBreed());
		}
		if (h.getAge1() != null && h.getAge2() != null) {
			c.andAgeBetween(h.getAge1(), h.getAge2());
		}
		if (h.getHeight1() != null && h.getHeight2() != null) {
			c.andHeightBetween(h.getHeight1(), h.getHeight2());
		}
		if (!StringUtils.isEmpty(h.getColor())) {
			c.andColorEqualTo(h.getColor());
		}
		if (!StringUtils.isEmpty(h.getFromAddress())) {
			c.andAddressEqualTo(h.getFromAddress());
		}
		if (!StringUtils.isEmpty(h.getSpeciality())) {
			c.andSpecialityEqualTo(h.getSpeciality());
		}
		example.setOrderByClause("time");
		return this.horseOnSaleMapper.selectByExample(example);
	}

	@Override
	public List<HorseOnSale> selectHorseONSaleByUsername(String username, int currentPage, int pageSize) {
		if (username == null) {
			return new ArrayList<HorseOnSale>();
		}
		PageHelper.startPage(currentPage, pageSize);
		HorseOnSaleExample example = new HorseOnSaleExample();
		Criteria c = example.createCriteria();
		c.andUsernameEqualTo(username);
		example.setOrderByClause("time");
		return this.horseOnSaleMapper.selectByExample(example);
	}

	@Override
	public List<HorseOnSale> selectHorseBySearchHorseOptions(SearchHorseOption options) {
		PageHelper.startPage(options.getCurrentPage(), options.getPageSize());
		boolean flag = false;
		String part1 = "select * from horseonsale ";
		StringBuffer buffer = new StringBuffer();
		String temp = Utils.checkSQL(options.getBreed(), "horsetype");
		if (temp != null && !temp.isEmpty()) {
			if (flag) {
				buffer.append(" and ");
			}
			flag = true;
			buffer.append(temp);
		}
		temp = Utils.checkSQL(options.getColor(), "color");
		if (temp != null && !temp.isEmpty()) {
			if (flag) {
				buffer.append(" and ");
			}
			flag = true;
			buffer.append(temp);
		}
		temp = Utils.checkSQL(options.getFromAddress(), "address");
		if (temp != null && !temp.isEmpty()) {
			if (flag) {
				buffer.append(" and ");
			}
			flag = true;
			buffer.append(temp);
		}
		temp = Utils.checkSQL(options.getSex(), "sex");
		if (temp != null && !temp.isEmpty()) {
			if (flag) {
				buffer.append(" and ");
			}
			flag = true;
			buffer.append(temp);
		}
		temp = Utils.checkSQL(options.getSpeciality(), "speciality");
		if (temp != null && !temp.isEmpty()) {
			if (flag) {
				buffer.append(" and ");
			}
			flag = true;
			buffer.append(temp);
		}
		temp = Utils.checkSQL(options, flag);
		if (temp != null) {
			buffer.append(temp);
		}
		String result;
		String part2 = buffer.toString();
		if (part2.isEmpty()) {
			result = part1;
		} else {
			result = part1 + " where "  + part2;
		}
		result = result + " order by time desc, id desc";
		System.out.println("≤È—Øµƒsql”Ôæ‰ «£∫ " + result);
		return this.horseOnSaleMapper.selectByRawSQL(new SqlVo(result));
	}

}
